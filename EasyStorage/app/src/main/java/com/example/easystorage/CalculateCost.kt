package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CalculateCost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_cost)

        val type=intent.getStringExtra("type")
        val room_size=intent.getStringExtra("room_size")
        val room_price=intent.getStringExtra("room_price")
        val day_or_month=intent.getStringExtra("day_or_month")
        val number_of_day_month=intent.getStringExtra("number_of_day_month")


        val answer=findViewById<TextView>(R.id.answer)
        val priceToInt=priceInt(room_price.toString())
        val final_cost=findViewById<TextView>(R.id.final_cost)
        val numbDayMonthToInt=number_of_day_month.toString().toInt()

        if(day_or_month=="Month(s)")
        {
            answer.text="You are storing $type with room size $room_size whose price per month is $room_price for  $number_of_day_month month(s)"
            val calc = priceToInt*numbDayMonthToInt
            final_cost.text="₹"+calc.toString()
        }
        else
        {
            answer.text="You are storing $type with room size $room_size whose price per month is $room_price for  $number_of_day_month of day(s)"
            val calc= (priceToInt * numbDayMonthToInt) / 30
            final_cost.text="₹"+calc.toString()
        }

    }

    fun priceInt(str:String): Int
    {
        return str.substring(1,str.length-6).toInt()
    }

    fun goBack(v:View)
    {
        val type=intent.getStringExtra("type")

        if(type=="Furniture")
        {
            val intent=Intent(this,StoreFurniture::class.java)
            startActivity(intent)
        }
        else if(type=="Documents")
        {
            val intent=Intent(this,StoreDocuments::class.java)
            startActivity(intent)
        }
        else if(type=="Automobile")
        {
            val intent=Intent(this,StoreAutomobile::class.java)
            startActivity(intent)
        }
    }

    fun doNothing(v:View)
    {

    }

    fun goToCheckout(v:View)
    {
        val intent=Intent(this,Checkout::class.java)
        startActivity(intent)
    }




}