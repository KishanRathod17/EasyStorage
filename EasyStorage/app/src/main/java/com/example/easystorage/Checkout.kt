package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Checkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val type=intent.getStringExtra("type").toString()
        val room_size=intent.getStringExtra("room_size").toString()
        val room_price=intent.getStringExtra("room_price").toString()
        val day_or_month=intent.getStringExtra("day_or_month").toString()
        val number_of_day_month=intent.getStringExtra("number_of_day_month").toString()
        val total_cost=intent.getStringExtra("total_cost").toString()


        val confirm=findViewById<Button>(R.id.last_submit)

        confirm.setOnClickListener()
        {
            val confirm=findViewById<TextView>(R.id.confirm)

            if(confirm.text.toString()=="CONFIRM")
            {
                val intent= Intent(this,Homescreen::class.java)

                storeUserInformation(type,room_size,room_price,day_or_month,number_of_day_month,total_cost)
                Toast.makeText(this,"Congrats on creating an order",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter correctly",Toast.LENGTH_LONG).show()
            }
        }


    }


    fun storeUserInformation(type:String,room_size:String,room_price:String,day_or_month:String,number_of_day_or_month:String,total_cost:String)
    {
        //Retrieving unique user id
        val reference_uid = FirebaseAuth.getInstance().currentUser?.uid.toString()


        //Creating a Database Reference
        val databaseReference= FirebaseDatabase.getInstance().reference

        // Create a new transaction ID
        val transactionId = databaseReference.child("Transaction Information").push().key

        //Store transcation id under user id
        val userTransactionReference=databaseReference.child("Transaction Information").child(reference_uid).child(transactionId!!)

        val transInfo = TranscationInformation(
            uid=reference_uid,
            tid=transactionId,
            typeOfStorage=type,
            roomSize = room_size,
            roomPrice = room_price,
            dayOrMonth = day_or_month,
            numberOfDayOrMonth = number_of_day_or_month,
            totalCost = total_cost
        )
        userTransactionReference.setValue(transInfo)
    }
}