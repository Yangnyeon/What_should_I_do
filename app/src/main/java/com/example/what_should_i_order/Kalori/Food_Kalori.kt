package com.example.what_should_i_order.Kalori

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.what_should_i_order.R
import kotlinx.android.synthetic.main.activity_food_kalori.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Food_Kalori : AppCompatActivity() {

    lateinit var Food_List : ArrayList<data>

    lateinit var adapter : Food_Kalori_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_kalori)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Kalori_Service::class.java)
        val call_Consult = api.getInfo(1000, 1, 58)

        call_Consult.enqueue(object : Callback<Food_Class> {
            override fun onResponse(call: Call<Food_Class>, response: Response<Food_Class>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        adapter = Food_Kalori_Adapter(mutableListOf(), this@Food_Kalori)
                        var searchViewTextListener: SearchView.OnQueryTextListener =
                            object : SearchView.OnQueryTextListener {
                                //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
                                override fun onQueryTextSubmit(s: String): Boolean {
                                    return false
                                }

                                //텍스트 입력/수정시에 호출
                                override fun onQueryTextChange(s: String): Boolean {
                                    adapter?.filter?.filter(s)
                                    //Consult_Adapter.getFilter().filter(s)
                                    Toast.makeText(this@Food_Kalori,"SearchVies Text is changed : $s",Toast.LENGTH_SHORT).show()
                                    return false
                                }

                            }


                        setAdapter(it.data as ArrayList<data>)
                    }
                }
            }

            override fun onFailure(call: Call<Food_Class>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패 : $t")
            }
        })

        consult_back.setOnClickListener {
            finish()
        }

    }



    private fun setAdapter(Consult_List : MutableList<data>){
        val mAdapter = Food_Kalori_Adapter(Consult_List,this@Food_Kalori)
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(this@Food_Kalori)
    }

    fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = Food_Kalori_Adapter(Food_List, this)
        recycler_view.adapter = adapter
    }
}