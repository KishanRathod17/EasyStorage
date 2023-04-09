package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.logging.Logger

class Homescreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)


        val LogInOrOut=findViewById<Button>(R.id.logout_or_login)

        if(IsLoggedIn.getInstance().isLoggedIn)
        {
            LogInOrOut.text=getString(R.string.logout)
        }
        else
        {
            LogInOrOut.text=getString(R.string.login)
        }
    }

    fun logOut(v: View)
    {
        if(IsLoggedIn.getInstance().isLoggedIn) {
            val auth = Firebase.auth
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        else
        {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun goToStoreAutomobile(v: View)
    {
        val intent=Intent(this,StoreAutomobile::class.java)
        startActivity(intent)
    }

    fun goToStoreDocuments(v: View)
    {
        val intent=Intent(this,StoreDocuments::class.java)
        startActivity(intent)
    }

    fun goToStoreFurniture(v: View)
    {
        val intent=Intent(this,StoreFurniture::class.java)
        startActivity(intent)
    }

    fun goToOrderHistory(v:View)
    {
        if(IsLoggedIn.getInstance().isLoggedIn)
        {
            val intent = Intent(this, OrderHistory::class.java)
            startActivity(intent)

        }
        else
        {
            Toast.makeText(this,"Please login",Toast.LENGTH_SHORT).show()
        }
    }


}