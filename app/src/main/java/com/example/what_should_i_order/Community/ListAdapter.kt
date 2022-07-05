package com.example.what_should_i_order.Community

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.what_should_i_order.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ListAdapter(val itemList: ArrayList<ListLayout>,val context: Context): RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.content.text = itemList[position].number
        holder.community_date.text = itemList[position].com_date
        holder.nickname.text = itemList[position].Nickname


        val db = FirebaseFirestore.getInstance()

        db.collection("Contacts")
            .document(itemList[position].doc)
            .collection("Comment")// 작업할 컬렉션
            .orderBy("Date", Query.Direction.ASCENDING)
            .get() // 문서 가져오기
            .addOnSuccessListener { result ->
                // 성공할 경우
                holder.comment_count.text = result.size().toString()
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("TAG", "Error getting documents: $exception")
            }



        holder.itemView.setOnClickListener {

            var title = itemList[position].name
            var date = itemList[position].number
            var content = itemList[position].com_date
            var doc = itemList[position].doc

            val go_board = Intent(context, Community_holder::class.java)
            go_board.putExtra("board_title", title)
            go_board.putExtra("board_date", date)
            go_board.putExtra("board_content", content)
            go_board.putExtra("board_doc", doc)

            context.startActivity(go_board)
        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.list_tv_name)
        val content : TextView = itemView.findViewById(R.id.list_tv_content)
        val community_date : TextView = itemView.findViewById(R.id.list_tv_date)
        val comment_count = itemView.findViewById<TextView>(R.id.comment_count)
        val nickname = itemView.findViewById<TextView>(R.id.list_tv_nickname)
    }
}