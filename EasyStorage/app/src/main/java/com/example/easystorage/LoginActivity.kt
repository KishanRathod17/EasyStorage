package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun checkLoginInfo(v: View)
    {
        val in_email = findViewById<TextView>(R.id.login_input_email)
        val in_password = findViewById<TextView>(R.id.login_input_password)

        if(in_email.text.isEmpty() or in_password.text.isEmpty())
        {
            Toast.makeText(this,"Please enter all information correctly", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "You logged in successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Homescreen::class.java)

//            val text_useremail = in_email.text.toString()
//            intent.putExtra("user_email", text_useremail)
//
//            val text_usermobile = in_mobile.text.toString()
//            intent.putExtra("user_mobile", text_usermobile)

            startActivity(intent)
        }

    }
}