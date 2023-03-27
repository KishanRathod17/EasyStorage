package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Homescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
    }

    fun goToMainPage(v: View)
    {
        Toast.makeText(this,"Going to Main Menu", Toast.LENGTH_SHORT).show()
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}