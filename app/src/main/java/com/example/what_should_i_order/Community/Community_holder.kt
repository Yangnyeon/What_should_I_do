package com.example.what_should_i_order.Community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.what_should_i_order.Community.Comment.Comment_ListAdapter
import com.example.what_should_i_order.Community.Comment.Comment_ListLayout
import com.example.what_should_i_order.R
import com.example.what_should_i_order.databinding.ActivityCommunityHolderBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_community_holder.*
import java.text.SimpleDateFormat
import java.util.*

class Community_holder : AppCompatActivity() {

    private lateinit var binding: ActivityCommunityHolderBinding

    val db = FirebaseFirestore.getInstance()

    val itemList2 = arrayListOf<Comment_ListLayout>()

    var adapter = Comment_ListAdapter(itemList2, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_holder)

        binding = ActivityCommunityHolderBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_cloud_firestore)
        setContentView(view)


        binding.recyclerViewCommunityComment.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCommunityComment.adapter = adapter

        //

        back.setOnClickListener(View.OnClickListener { finish() })

        intent = intent // 인텐트 받아오기

        val title = intent.getStringExtra("board_title") //Adapter에서 받은 키값 연결
        val date = intent.getStringExtra("board_date")
        val content = intent.getStringExtra("board_content")
        val holder_doc = intent.getStringExtra("board_doc")
        val password = intent.getStringExtra("board_password")

        board_title.setText(title)
        board_date.setText(content)
        board_content.setText(date)


        //댓글출력
        db.collection("Contacts")
            .document(holder_doc.toString())
            .collection("Comment")// 작업할 컬렉션
            .orderBy("Date", Query.Direction.ASCENDING)
            .get() // 문서 가져오기
            .addOnSuccessListener { result ->
                // 성공할 경우
                itemList2.clear()
                for (document in result) {  // 가져온 문서들은 result에 들어감
                    val item2 =
                        Comment_ListLayout(
                            document["Comment"] as String,
                            document["Date"] as String,
                            document["Doc"] as String)
                    itemList2.add(item2)
                }
                adapter.notifyDataSetChanged()// 리사이클러 뷰 갱신
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("TAG", "Error getting documents: $exception")
            }

        //

        //댓글입력

        commnet_button.setOnClickListener {

            var comment_edit = comment_edit.text.toString()

            val currentTime : Long = System.currentTimeMillis()
            val simpleDate = SimpleDateFormat("yyyy-MM-dd k:mm:ss")
            val mDate: Date = Date(currentTime)
            val getTime = simpleDate.format(mDate)

            val doc = UUID.randomUUID().toString()


            val data = hashMapOf(
                "Comment" to comment_edit,
                "Date" to getTime.toString(),
                "Doc" to doc
            )

            db.collection("Contacts")
                .document(holder_doc.toString())
                .collection("Comment")
                .document(doc.toString())
                .set(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()

                    update()
                    //go_board2.putExtra("board_doc", it.toString())
                    // startActivity(go_board2)
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우

                    Log.w("MainActivity", "Error getting documents: $exception")
                }

        }
    }

    fun update() {

        val content_doc = intent.getStringExtra("board_doc")

        db.collection("Contacts")
            .document(content_doc.toString())
            .collection("Comment")// 작업할 컬렉션
            .orderBy("Date", Query.Direction.ASCENDING)
            .get() // 문서 가져오기
            .addOnSuccessListener { result ->
                // 성공할 경우
                itemList2.clear()
                for (document in result) {  // 가져온 문서들은 result에 들어감
                    val item2 =
                        Comment_ListLayout(
                            document["Comment"] as String,
                            document["Date"] as String,
                            document["Doc"] as String)
                    itemList2.add(item2)
                }
                adapter.notifyDataSetChanged()// 리사이클러 뷰 갱신
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("TAG", "Error getting documents: $exception")
            }
    }
}