package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

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
            "5m x 5m" -> "₹5499/month"
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
        val number=findViewById<TextView>(R.id.enter)

        if(number.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please enter number of days and month properly", Toast.LENGTH_SHORT).show()
        }
        else {
            //Creating intent
            val intent = Intent(this, CalculateCost::class.java)


            //Passing type of storage
            intent.putExtra("type", "Automobile")


            //Passing room size
            val room_size = findViewById<Spinner>(R.id.room_spinner)
            val selected_room_size = room_size.selectedItem.toString()
            intent.putExtra("room_size", selected_room_size)


            //Passing price
            val room_price = findViewById<TextView>(R.id.room_price)
            val selected_room_price = room_price.text.toString()
            intent.putExtra("room_price", selected_room_price)


            //Passing days or month
            val day_or_month = findViewById<Spinner>(R.id.months_or_days)
            val select_month_or_day = day_or_month.selectedItem.toString()
            intent.putExtra("day_or_month", select_month_or_day)


            //Passing number of days or month
            val num_of_day_or_month = number.text.toString()
            intent.putExtra("number_of_day_month", num_of_day_or_month)

            startActivity(intent)
        }
    }
}