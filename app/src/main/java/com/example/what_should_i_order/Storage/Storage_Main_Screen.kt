package com.example.what_should_i_order.Storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.what_should_i_order.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_storage_main_screen.*

class Storage_Main_Screen : AppCompatActivity(), PhotoAdapter.OnItemClickListener {


    lateinit var photoAdapter:PhotoAdapter
    lateinit var photoList:ArrayList<Photo>

    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_main_screen)

        email.text = "이메일"

        firestore= FirebaseFirestore.getInstance()

        photoList= ArrayList()
        photoAdapter=PhotoAdapter(this,photoList)

        listRv.layoutManager= GridLayoutManager(this, 3)
        listRv.adapter=photoAdapter

        photoAdapter.onItemClickListener=this@Storage_Main_Screen

        firestore.collection("photo").addSnapshotListener {
                querySnapshot, FirebaseFIrestoreException ->
            if(querySnapshot!=null){
                for(dc in querySnapshot.documentChanges){
                    if(dc.type == DocumentChange.Type.ADDED){
                        var photo=dc.document.toObject(Photo::class.java)
                        photo.id=dc.document.id
                        photoList.add(photo)
                    }
                }
                photoAdapter.notifyDataSetChanged()
            }
        }

        addPhotoBtn.setOnClickListener {
            var intent= Intent(this,Storage_Write::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClick(photo: Photo) {
        var intent= Intent(this,Activity_photo::class.java)
        intent.putExtra("id",photo.id)
        startActivity(intent)
    }
}