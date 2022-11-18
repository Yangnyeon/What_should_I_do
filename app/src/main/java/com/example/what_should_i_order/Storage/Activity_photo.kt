package com.example.what_should_i_order.Storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.what_should_i_order.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_community_holder.*
import kotlinx.android.synthetic.main.activity_photo.*
import kotlinx.android.synthetic.main.activity_storage_write.*

class Activity_photo : AppCompatActivity() {


    lateinit var firestore:FirebaseFirestore

    lateinit var imageIv: ImageView
    lateinit var descriptionTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        var id = intent.getStringExtra("id")

        firestore = FirebaseFirestore.getInstance()

        imageIv=findViewById(R.id.holder_image)
        descriptionTv=findViewById(R.id.description_tv)


        if (id != null) {
            firestore.collection("photo").document(id).get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var photo = task.result?.toObject(Photo::class.java)
                    Glide.with(this).load(photo?.imageUrl).into(real_holder_image)
                    //imageIv.setImageURI(photo?.imageUrl)
                    description_tv.text = photo?.description
                }
            }
        }

    }
}