package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class FireStoreActivity : AppCompatActivity() {
    private lateinit var edtName:EditText
    private lateinit var edtPhone:EditText
    private lateinit var btnAdd:Button
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_store)
        edtName=findViewById(R.id.name)
        edtPhone=findViewById(R.id.phone)
        btnAdd=findViewById(R.id.btn_add)

        db= FirebaseFirestore.getInstance()

        btnAdd.setOnClickListener {
            val user = hashMapOf(
                "first" to "Alan",
                "middle" to "Mathison",
                "last" to "Turing",
                "born" to 1912
            )
            db.collection("user")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,"Successfully",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
                }
        }
    }
}