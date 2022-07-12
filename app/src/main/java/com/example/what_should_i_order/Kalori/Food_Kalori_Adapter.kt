package com.example.what_should_i_order.Kalori

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.what_should_i_order.R

class Food_Kalori_Adapter(var datalist : MutableList<data>, val context: Context)
    : RecyclerView.Adapter<Food_Kalori_Adapter.ViewHolder>(), Filterable {


    var filteredPersons = ArrayList<data>()
    //var itemFilter = ItemFilter()


    init {
        filteredPersons.addAll(datalist)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Food_Kalori_Adapter.ViewHolder {
        return Food_Kalori_Adapter.ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.food_holder,parent ,false))

    }

    override fun onBindViewHolder(holder: Food_Kalori_Adapter.ViewHolder, position: Int) {
        holder.Food_holder_name!!.text = datalist[position].Food_name
        holder.Food_holder_kalori!!.text = "칼로리 : " + datalist[position].Food_kalori + "kcal"
        holder.Food_holder_salt!!.text = "나트륨 : " + datalist[position].Food_salt + "m"
        holder.Food_holder_protein!!.text = "단백질 : " + datalist[position].Food_protein + "g"



        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    class ViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Food_holder_name = itemView?.findViewById<TextView>(R.id.Food_holder_name)
        val Food_holder_kalori = itemView?.findViewById<TextView>(R.id.Food_holder_kalori)
        val Food_holder_salt = itemView?.findViewById<TextView>(R.id.Food_holder_salt)
        val Food_holder_protein = itemView?.findViewById<TextView>(R.id.Food_holder_protein)
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

}