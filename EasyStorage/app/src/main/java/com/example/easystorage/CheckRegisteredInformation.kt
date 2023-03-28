package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class CheckRegisteredInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_registered_information)

        val text_username = intent.getStringExtra("user_name")
        var p_name=findViewById<TextView>(R.id.previous_name)
        p_name.text=text_username

        val text_address = intent.getStringExtra("user_address")
        var p_address=findViewById<TextView>(R.id.previous_address)
        p_address.text=text_address

        val text_email = intent.getStringExtra("user_email")
        var p_email=findViewById<TextView>(R.id.previous_email)
        p_email.text=text_email

        val text_mobile = intent.getStringExtra("user_mobile")
        var p_mobile=findViewById<TextView>(R.id.previous_mobile)
        p_mobile.text=text_mobile

    }

    fun goToMainPage(v: View)
    {
        Toast.makeText(this,"Congrats for creating a new account", Toast.LENGTH_LONG).show()
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun goToRegisterPage(v: View)
    {
        Toast.makeText(this,"Please correct your mistakes",Toast.LENGTH_LONG).show()
        val intent= Intent(this,RegisterActivity::class.java)

        //For sending data to again to register layout
        val in_username=findViewById<TextView>(R.id.previous_name)
        val text_username=in_username.text.toString()
        intent.putExtra("user_name",text_username)

        val in_address=findViewById<TextView>(R.id.previous_address)
        val text_useraddress=in_address.text.toString()
        intent.putExtra("user_address",text_useraddress)

        val in_email=findViewById<TextView>(R.id.previous_email)
        val text_useremail=in_email.text.toString()
        intent.putExtra("user_email",text_useremail)

        val in_mobile=findViewById<TextView>(R.id.previous_mobile)
        val text_usermobile=in_mobile.text.toString()
        intent.putExtra("user_mobile",text_usermobile)


        startActivity(intent)
    }
}