package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Checkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
    }

    fun goToHomescreen(v: View)
    {
        val confirm=findViewById<TextView>(R.id.confirm)

        if(confirm.text.toString()=="CONFIRM")
        {
            val intent= Intent(this,Homescreen::class.java)
            Toast.makeText(this,"Congrats on creating an order",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Enter correctly",Toast.LENGTH_LONG).show()
        }
    }
}