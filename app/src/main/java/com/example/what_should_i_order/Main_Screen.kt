package com.example.what_should_i_order

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.what_should_i_order.Worldcup.Worldcup


class Main_Screen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_main__screen, container, false)


        var World_gogo = v.findViewById<CardView>(R.id.World_gogo)

        var Select_gogo = v.findViewById<CardView>(R.id.Select_gogo)

        World_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Worldcup::class.java))
        }

        Select_gogo.setOnClickListener {
            startActivity(Intent(requireActivity(), Select_Food::class.java))
        }

        return v


    }

}