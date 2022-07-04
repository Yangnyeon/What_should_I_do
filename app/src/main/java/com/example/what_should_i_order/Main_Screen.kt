package com.example.what_should_i_order

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.what_should_i_order.Worldcup.Food_Data
import com.example.what_should_i_order.Worldcup.Worldcup
import kotlin.random.Random


class Main_Screen : Fragment() {

    var Today_food_list : ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_main__screen, container, false)

        Today_Food_LIST()

        
        var Today_food = v.findViewById<TextView>(R.id.Today_food)

        var World_gogo = v.findViewById<CardView>(R.id.World_gogo)

        var Select_gogo = v.findViewById<CardView>(R.id.Select_gogo)

        val range = (0..3)


        Today_food.text = Today_food_list[range.random()]
        


        World_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Worldcup::class.java))
        }

        Select_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Select_Food::class.java))
        }

        return v


    }

    fun Today_Food_LIST() {

        Today_food_list.add("짜장면 입니다.")
        Today_food_list.add("짬뽕 입니다.")
        Today_food_list.add("마라탕 입니다.")
        Today_food_list.add("삼겹살 입니다.")
    }

}