package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun continueWithoutLogin(v:View)
    {
        val intent=Intent(this,Homescreen::class.java)

        val auth= Firebase.auth
        auth.signOut()

        IsLoggedIn.getInstance().isLoggedIn=false

        startActivity(intent)



    }
    fun loginUser(v:View)
    {
        val in_email = findViewById<TextView>(R.id.login_input_email)
        val in_password = findViewById<TextView>(R.id.login_input_password)

        val email=in_email.text.toString()
        val password=in_password.text.toString()

        if(email.isEmpty() or password.isEmpty())
        {
            Toast.makeText(this,"Incorrect Information",Toast.LENGTH_LONG).show()
        }
        else {
            val auth = Firebase.auth

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        IsLoggedIn.getInstance().isLoggedIn=true

                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Homescreen::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this, "Incorrect information", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

}