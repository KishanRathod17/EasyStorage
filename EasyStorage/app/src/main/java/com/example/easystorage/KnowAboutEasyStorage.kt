package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class KnowAboutEasyStorage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_about_easy_storage)
    }

    fun openActivityHowItWorks(v: View)
    {
        Toast.makeText(this,"You will get to know how Easy Storage works!", Toast.LENGTH_SHORT).show()
        val intent= Intent(this,HowItWorks::class.java)
        startActivity(intent)
    }
}