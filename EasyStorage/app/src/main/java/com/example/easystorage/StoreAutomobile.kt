package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class StoreAutomobile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_automobile)



        //FIRST SPINNER FOR ROOM SIZE
        val roomSizes= arrayOf("5m x 5m")      //Sizes of room array to store in spinner
        val roomListView=findViewById<Spinner>(R.id.room_spinner)
        val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,roomSizes)   //Giving values to the spinner
        roomListView.adapter=adapter

        //Setting onItemSelectedListener
        roomListView.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedRoomSize=parent?.getItemAtPosition(position).toString()
                val room_price=findViewById<TextView>(R.id.room_price)
                room_price.text=getPriceFromSelectedItem(selectedRoomSize)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        //SECOND SPINNER FOR MONTHS OR DAYS
        val period= arrayOf("Month(s)","Day(s)")
        val periodList=findViewById<Spinner>(R.id.months_or_days)
        val adapter2= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,period)
        periodList.adapter=adapter2

        periodList.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedPeriod=parent?.getItemAtPosition(position).toString()
                val m_or_d=findViewById<TextView>(R.id.enter_d_or_m)
                m_or_d.text=getMonthsOrDays(selectedPeriod)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }




    }

    fun getPriceFromSelectedItem(selectedRoomSize: String): String {
        return when (selectedRoomSize) {
            "5m x 5m" -> "₹5499"
            else -> ""
        }
    }


    fun getMonthsOrDays(selectedPeriod:String):String{
        return if(selectedPeriod=="Month(s)") {
            "Enter number of months : "
        } else {
            "Enter number of days : "
        }
    }

    fun goToCalculateCost(v: View)
    {
        val intent= Intent(this,CalculateCost::class.java)
        startActivity(intent)
    }
}