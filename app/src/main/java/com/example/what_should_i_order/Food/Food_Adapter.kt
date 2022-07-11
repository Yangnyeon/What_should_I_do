package com.example.what_should_i_order.Food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.what_should_i_order.R

class Food_Adapter(val context: Context, val food_list : List<Food_Model>): RecyclerView.Adapter<Food_Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Food_Adapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_ramen, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: Food_Adapter.ViewHolder, position: Int) {

        val uploadCurrent: Food_Model = food_list[position]

        holder.Food_name.text = food_list[position].Food_Name

        Glide.with(context)
            .load(uploadCurrent.Food_Image)
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .error(R.mipmap.ic_launcher_round)
            .into(holder.Food_image)
    }

    override fun getItemCount(): Int {
        return food_list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Food_name : TextView = itemView.findViewById(R.id.food_holer_name)
        val Food_image : ImageView = itemView.findViewById(R.id.food_holder_image)
    }
}