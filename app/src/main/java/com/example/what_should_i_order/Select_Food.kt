package com.example.what_should_i_order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.what_should_i_order.Food.Food_ramen
import kotlinx.android.synthetic.main.activity_select_food.*

class Select_Food : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_food)

        go_ramen.setOnClickListener {
            startActivity(Intent(this@Select_Food, Food_ramen::class.java))
        }

    }
}