package com.example.what_should_i_order.Community

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.what_should_i_order.Community.Comment.Comment_ListLayout
import com.example.what_should_i_order.R
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_comunity_write.*
import java.text.SimpleDateFormat
import java.util.*

class Comunity_Write : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()    // Firestore 인스턴스 선언

    val itemList2 = arrayListOf<ListLayout>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunity_write)

        input.setOnClickListener(View.OnClickListener {
            saveNote()
            finish()
        })
    }

    private fun saveNote() {
        val title: String = edit_text_title2.text.toString()
        val description: String = edit_text_description2.text.toString()
        val nickname : String = write_nickname.text.toString()
        val now = System.currentTimeMillis()
        val simpleDate = SimpleDateFormat("yyyy-MM-dd k:mm:ss")
        val mDate = Date(now)
        val getTime = simpleDate.format(mDate)
        val password = comment_password.text.toString()

        val doc = UUID.randomUUID().toString()

        if (title.trim { it <= ' ' }.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "입력하세요", Toast.LENGTH_SHORT).show()
        }else {
            val data = hashMapOf(
                "name" to title.toString(),
                "number" to description.toString(),
                "com_date" to getTime.toString(),
                "password" to password.toString(),
                "doc" to doc,
                "nickname" to nickname.toString(),
                "liked" to 0.toLong()
            )
            // Contacts 컬렉션에 data를 자동 이름으로 저장
            db.collection("Contacts")
                .document(doc)
                .set(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this@Comunity_Write, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()

                    finish()

                    //go_board2.putExtra("board_doc", it.toString())
                    // startActivity(go_board2)
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Toast.makeText(this@Comunity_Write, "실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }







}