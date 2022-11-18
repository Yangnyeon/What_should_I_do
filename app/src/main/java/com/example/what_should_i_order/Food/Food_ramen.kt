package com.example.what_should_i_order.Food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.what_should_i_order.Community.ListLayout
import com.example.what_should_i_order.R
import com.example.what_should_i_order.databinding.ActivityFoodRamenBinding
import com.example.what_should_i_order.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class Food_ramen : AppCompatActivity() {


    private lateinit var binding : ActivityFoodRamenBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodRamenBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_food_ramen)
        setContentView(binding.root)

        binding.RamenRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@Food_ramen)
        }

        fetchData()
    }



    private fun fetchData() {
        FirebaseFirestore.getInstance().collection("Ramen")
            .get()
            .addOnSuccessListener {
                result ->
                for(document in result) {
                    val user = result.toObjects(Food_Model::class.java)
                    binding.RamenRecyclerView.adapter = Food_Adapter(this,user)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "실패",Toast.LENGTH_SHORT).show()
            }

    }
}