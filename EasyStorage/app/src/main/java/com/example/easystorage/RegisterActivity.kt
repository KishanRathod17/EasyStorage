package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val text_username = intent.getStringExtra("user_name")
        val p_name=findViewById<TextView>(R.id.input_username)
        p_name.text=text_username

        val text_address = intent.getStringExtra("user_address")
        val p_address=findViewById<TextView>(R.id.input_address)
        p_address.text=text_address

        val text_email = intent.getStringExtra("user_email")
        val p_email=findViewById<TextView>(R.id.input_email)
        p_email.text=text_email

        val text_mobile = intent.getStringExtra("user_mobile")
        val p_mobile=findViewById<TextView>(R.id.input_phone)
        p_mobile.text=text_mobile

    }

    fun goToCheckInfo(v: View)
    {

        val in_username = findViewById<TextView>(R.id.input_username)
        val in_address = findViewById<TextView>(R.id.input_address)
        val in_email = findViewById<TextView>(R.id.input_email)
        val in_mobile = findViewById<TextView>(R.id.input_phone)

        if(in_username.text.isEmpty() or in_address.text.isEmpty() or in_email.text.isEmpty() or in_mobile.text.isEmpty())
        {
            Toast.makeText(this,"Please enter all information",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Is all information correct?", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CheckRegisteredInformation::class.java)

            //For sending data to another layout
            val text_username = in_username.text.toString()
            intent.putExtra("user_name", text_username)

            val text_useraddress = in_address.text.toString()
            intent.putExtra("user_address", text_useraddress)

            val text_useremail = in_email.text.toString()
            intent.putExtra("user_email", text_useremail)

            val text_usermobile = in_mobile.text.toString()
            intent.putExtra("user_mobile", text_usermobile)

            startActivity(intent)
        }
    }
}

