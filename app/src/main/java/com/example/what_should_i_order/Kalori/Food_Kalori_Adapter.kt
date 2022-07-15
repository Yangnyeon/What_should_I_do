package com.example.what_should_i_order.Kalori

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
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

    //서치뷰

    var TAG = "PhoneBookListAdapter"

    var filteredPersons = ArrayList<data>()
    var itemFilter = ItemFilter()


    //



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Food_Kalori_Adapter.ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.food_holder, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Food_Kalori_Adapter.ViewHolder, position: Int) {
        holder.Food_holder_name!!.text = datalist[position].Food_name
        holder.Food_holder_kalori!!.text = "칼로리 : " + datalist[position].Food_kalori + "kcal"
        holder.Food_holder_salt!!.text = "나트륨 : " + datalist[position].Food_salt + "m"
        holder.Food_holder_protein!!.text = "단백질 : " + datalist[position].Food_protein + "g"



        holder.itemView.setOnClickListener {

        }
    }
    class ViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Food_holder_name = itemView?.findViewById<TextView>(R.id.Food_holder_name)
        val Food_holder_kalori = itemView?.findViewById<TextView>(R.id.Food_holder_kalori)
        val Food_holder_salt = itemView?.findViewById<TextView>(R.id.Food_holder_salt)
        val Food_holder_protein = itemView?.findViewById<TextView>(R.id.Food_holder_protein)
    }

    init {
        filteredPersons.addAll(datalist)
    }


    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<data> = ArrayList<data>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = datalist
                results.count = datalist.size

                return results
                //공백제외 2글자 이인 경우 -> 이름으로만 검색
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (person in datalist) {
                    if (person.Food_name.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과) -> 이름/전화번호로 검색
            } else {
                for (person in datalist) {
                    if (person.Food_name.contains(filterString) || person.Food_kalori.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredPersons.clear()
            filteredPersons.addAll(filterResults.values as ArrayList<data>)
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int {
        return filteredPersons.size
        //return filteredPersons.size
    }


}