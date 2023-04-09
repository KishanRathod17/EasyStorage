package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    fun makeProfileChanges(v: View)
    {
        val in_username = findViewById<TextView>(R.id.input_username)
        val in_address = findViewById<TextView>(R.id.input_address)
        val in_mobile = findViewById<TextView>(R.id.input_phone)


        //Check if empty or not
        if(in_username.text.isEmpty() or in_address.text.isEmpty() or in_mobile.text.isEmpty())
        {
            Toast.makeText(this,"Please enter all information",Toast.LENGTH_SHORT).show()
        }
        else if( in_mobile.text.length != 10)
        {
            Toast.makeText(this,"Mobile number should be of 10 digits",Toast.LENGTH_SHORT).show()
        }
        else
        {
            storeEditedInformation(in_username.text.toString(),in_address.text.toString(),in_mobile.text.toString())
            Toast.makeText(this,"Information changed successfully",Toast.LENGTH_SHORT).show()
        }

    }


    fun storeEditedInformation(reference_name:String,reference_address:String,reference_mobile:String)
    {
        //Retrieving unique user id
        val reference_uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
        val reference_email = FirebaseAuth.getInstance().currentUser?.email.toString()

        //Creating a Database Reference
        val databaseReference= FirebaseDatabase.getInstance().getReference("User Information").child(reference_uid)
        val userInfo = UserInformation(
            uid=reference_uid,
            username = reference_name,
            address = reference_address,
            mobile = reference_mobile,
            email = reference_email
        )
        databaseReference.setValue(userInfo)
    }



    fun ForgotPassword(v: View) {

        //Creating a alert box
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Forgot Password")
        builder.setMessage("Enter your email address to receive a password reset link (Check spam if not received in inbox) ")

        val input = EditText(this)
        builder.setView(input)

        builder.setPositiveButton("Send") { dialog, _ ->
            val email = input.text.toString()

            if (email.isEmpty())
            {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_LONG).show()
            }
            else
            {
                val auth = Firebase.auth

                //This will send the reset email
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Email sent successfully $email",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this,
                                "Failed to send password reset email as ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }



}