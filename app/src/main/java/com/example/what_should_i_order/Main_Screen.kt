package com.example.what_should_i_order

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.what_should_i_order.Kalori.Food_Kalori
import com.example.what_should_i_order.Storage.Storage_Main_Screen
import com.example.what_should_i_order.Storage.Storage_Write

import com.example.what_should_i_order.Worldcup.Worldcup
import kotlinx.android.synthetic.main.fragment_main__screen.*


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

        var gogoApp_Introduce = v.findViewById<CardView>(R.id.gogo_introduce)

        var gogo_Kalori = v.findViewById<CardView>(R.id.gogo_Kalori)

        var gogo_storage = v.findViewById<TextView>(R.id.storage_gogo)

        //var Ranking_gogo = v.findViewById<CardView>(R.id.Ranking_gogo)

        val range = (0..32)


        Today_food.text = Today_food_list[range.random()]

        gogo_storage.setOnClickListener {
            startActivity(Intent(requireActivity(), Storage_Main_Screen::class.java))
        }

        World_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Worldcup::class.java))
        }

        Select_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Select_Food::class.java))
        }

        gogoApp_Introduce.setOnClickListener {
            startActivity(Intent(requireActivity(), App_Introduce::class.java))
        }

        gogo_Kalori.setOnClickListener {
            startActivity(Intent(requireActivity(), Food_Kalori::class.java))
        }







        return v


    }

    fun Today_Food_LIST() {

        Today_food_list.add("짜장면 입니다.")
        Today_food_list.add("짬뽕 입니다.")
        Today_food_list.add("마라탕 입니다.")
        Today_food_list.add("삼겹살 입니다.")
        Today_food_list.add("떡볶이 입니다.")
        Today_food_list.add("라면 입니다.")
        Today_food_list.add("찜닭 입니다.")
        Today_food_list.add("닭볶음탕 입니다.")
        Today_food_list.add("수육 입니다.")
        Today_food_list.add("곰창 입니다.")
        Today_food_list.add("부대찌개 입니다.")
        Today_food_list.add("치킨 입니다.")
        Today_food_list.add("카레 입니다.")
        Today_food_list.add("순댓국 입니다.")
        Today_food_list.add("파스타 입니다.")
        Today_food_list.add("스파게티 입니다.")
        Today_food_list.add("냉면 입니다.")
        Today_food_list.add("콩국수 입니다.")
        Today_food_list.add("초밥 입니다.")
        Today_food_list.add("육회 입니다.")
        Today_food_list.add("햄버거 입니다.")
        Today_food_list.add("피자 입니다.")
        Today_food_list.add("토스트 입니다.")
        Today_food_list.add("스테이크 입니다.")
        Today_food_list.add("핫도그 입니다.")
        Today_food_list.add("만두 입니다.")
        Today_food_list.add("돈까스 입니다.")
        Today_food_list.add("짬뽕 입니다.")
        Today_food_list.add("족발 입니다.")
        Today_food_list.add("삼계탕 입니다.")
        Today_food_list.add("닭발 입니다.")
        Today_food_list.add("삼겹살 입니다.")
        Today_food_list.add("탕수육 입니다.")
        Today_food_list.add("양념치킨 입니다.")
        Today_food_list.add("물 입니다.")
    }

}