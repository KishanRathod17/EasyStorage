package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Homescreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

    }

    fun logOut(v: View)
    {
        val auth= Firebase.auth
        auth.signOut()
        val intent= Intent(this,MainActivity::class.java)
        Toast.makeText(this,"Logout successful",Toast.LENGTH_SHORT).show()
        startActivity(intent)
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