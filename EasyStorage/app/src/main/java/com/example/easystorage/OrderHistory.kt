package com.example.easystorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.gms.common.data.DataBufferObserverSet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class OrderHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)

        val list_view=findViewById<ListView>(R.id.order_history_list_view)
        val transactionInfoList= ArrayList<String>()

        //Creating an adpater for our list view
        val transactionInfoAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,transactionInfoList)
        list_view.adapter=transactionInfoAdapter

        //Getting the uid
        val uid=FirebaseAuth.getInstance().currentUser?.uid.toString()

        //Getting reference to all the transaction of the current user
        val userOrderReference=FirebaseDatabase.getInstance().getReference("Transaction Information").child(uid)

        userOrderReference.addValueEventListener(object:ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot)
            {
                transactionInfoList.clear()
                for(transactionSpanshot in snapshot.children)
                {
                    val transactionID = transactionSpanshot.key.toString()
                    val Transaction = transactionSpanshot.getValue(TranscationInformation::class.java)

                    val order_info="Transcation ID :  $transactionID \n" +
                            " Type Of Storage : ${Transaction?.typeOfStorage}\n" +
                            " Room Size : ${Transaction?.roomSize}\n" +
                            " Room Price : ${Transaction?.roomPrice}\n" +
                            " Day(s) Or Month(s) : ${Transaction?.dayOrMonth}\n" +
                            " Number of Day(s) or Month(s) : ${Transaction?.numberOfDayOrMonth}\n" +
                            " Total Cost : ${Transaction?.totalCost}\n"
                    transactionInfoList.add(order_info)
                }
                transactionInfoAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError)
            {
                Log.w("ListView","Failed to read value",error.toException())
            }

        })




    }
}