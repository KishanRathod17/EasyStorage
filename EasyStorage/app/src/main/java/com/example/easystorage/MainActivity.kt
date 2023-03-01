package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openActivityKnowAboutEasyStorage(v: View)
    {
        Toast.makeText(this,"You clicked know about EasyStorage",Toast.LENGTH_SHORT).show()
        val intent=Intent(this,KnowAboutEasyStorage::class.java)
        startActivity(intent)
    }
}