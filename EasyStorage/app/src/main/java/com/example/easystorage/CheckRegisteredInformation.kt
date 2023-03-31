package com.example.easystorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class CheckRegisteredInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_registered_information)

        val text_username = intent.getStringExtra("user_name")
        val p_name=findViewById<TextView>(R.id.previous_name)
        p_name.text=text_username

        val text_address = intent.getStringExtra("user_address")
        val p_address=findViewById<TextView>(R.id.previous_address)
        p_address.text=text_address

        val text_email = intent.getStringExtra("user_email")
        val p_email=findViewById<TextView>(R.id.previous_email)
        p_email.text=text_email

        val text_mobile = intent.getStringExtra("user_mobile")
        val p_mobile=findViewById<TextView>(R.id.previous_mobile)
        p_mobile.text=text_mobile

        val text_password = intent.getStringExtra("user_password")
        val p_password=findViewById<TextView>(R.id.previous_password)
        p_password.text=text_password
    }

    fun goToMainPage(v: View)
    {
        val intent=Intent(this,MainActivity::class.java)

        val p_name=findViewById<TextView>(R.id.previous_name)
        val text_username=p_name.text.toString()

        val p_address=findViewById<TextView>(R.id.previous_address)
        val text_useraddress=p_address.text.toString()

        val p_email=findViewById<TextView>(R.id.previous_email)
        val text_useremail=p_email.text.toString()

        val p_mobile=findViewById<TextView>(R.id.previous_mobile)
        val text_usermobile=p_mobile.text.toString()

        val p_password=findViewById<TextView>(R.id.previous_password)
        val text_userpassword=p_password.text.toString()

        //Registering the email and password
        registerUser(text_useremail,text_userpassword) { flag ->
            if(flag)
            {
                //Storing the information of the user
                storeUserInformation(text_username,text_useraddress,text_useremail,text_usermobile)
                startActivity(intent)
            }
        }


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

    fun registerUser(email:String,password: String,callback:(Boolean)->Unit)
    {
        var flag=false

        val auth= Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if(task.isSuccessful)
                {
                    Toast.makeText(this,"User created successfully",Toast.LENGTH_LONG).show()
                    callback(true)
                }
                else
                {
                    Toast.makeText(this,"Unsuccessful user already registered",Toast.LENGTH_LONG).show()
                    callback(false)
                }

            }


    }

    fun storeUserInformation(reference_name:String,reference_address:String,reference_email:String,reference_mobile:String)
    {
        //Retrieving unique user id
        val reference_uid = FirebaseAuth.getInstance().currentUser?.uid.toString()

        //Creating a Database Reference
        val databaseReference= FirebaseDatabase.getInstance().getReference("User Information").child(reference_uid)
        val userInfo = UserInformation(
            uid=reference_uid,
            username = reference_name,
            address = reference_address,
            email = reference_email,
            mobile = reference_mobile,
            // password = reference_password
        )
        databaseReference.setValue(userInfo)
    }
}