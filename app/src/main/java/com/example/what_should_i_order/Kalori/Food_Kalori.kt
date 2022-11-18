package com.example.what_should_i_order.Kalori

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.what_should_i_order.BuildConfig
import com.example.what_should_i_order.Kalori.Food_Kalori.NetworkManager.api
import com.example.what_should_i_order.R
import com.google.common.graph.NetworkBuilder
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxkotlin.addTo

import kotlinx.android.synthetic.main.activity_food_kalori.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory

class Food_Kalori : AppCompatActivity() {

    val TAG = "MainActivity"


    lateinit var adapter : Food_Kalori_Adapter

    lateinit var Food_SearchView : SearchView

    var Food_list: ArrayList<data> = java.util.ArrayList<data>()

    //에딧 서치

    object NetworkManager {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.odcloud.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Kalori_Service::class.java)
        //val call_Consult = api.getInfo(700, 1, 58)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_kalori)

        //서치뷰


        //


        /*
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Kalori_Service::class.java)

         */

        //NetworkManager


        NetworkManager.api
            .getInfo(700, 1, 58)
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe { it ->
                if (it.isSuccessful) {
                    val body = it.body()
                    body?.let {
                        adapter = Food_Kalori_Adapter(mutableListOf(), this@Food_Kalori)
                        setAdapter(it.data as ArrayList<data>)
                    }
                }
            }
            .addTo(compositeDisposable = CompositeDisposable())


        /*
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Kalori_Service::class.java)
        val call_Consult = api.getInfo(700, 1, 58)


        call_Consult.enqueue(object : Callback<Food_Class> {
            override fun onResponse(call: Call<Food_Class>, response: Response<Food_Class>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        adapter = Food_Kalori_Adapter(mutableListOf(), this@Food_Kalori)
                        setAdapter(it.data as ArrayList<data>)
                    }
                }
            }

            override fun onFailure(call: Call<Food_Class>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패 : $t")
            }
        })

         */

        consult_back.setOnClickListener {
            finish()
        }


    }

    private fun getRepository(userName: String) {

    }


    private fun setAdapter(Consult_List : MutableList<data>) {
        val mAdapter = Food_Kalori_Adapter(Consult_List, this@Food_Kalori)
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(this@Food_Kalori)


    }

    //서치뷰

    //SearchView 텍스트 입력시 이벤트
    private var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            //텍스트 입력/수정시에 호출
            override fun onQueryTextChange(s: String): Boolean {
                val mAdapter = Food_Kalori_Adapter(Food_list,this@Food_Kalori)
                mAdapter.filter.filter(s)
                Log.d(TAG, "SearchVies Text is changed : $s")
                return false
            }
        }



    //에딧 서치뷰



}