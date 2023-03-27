package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class HowItWorks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_it_works)
    }

    fun goToMainPage(v: View)
    {
        Toast.makeText(this,"Going to Main Menu", Toast.LENGTH_SHORT).show()
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}