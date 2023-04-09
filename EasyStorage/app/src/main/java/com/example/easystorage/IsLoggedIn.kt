package com.example.easystorage

class IsLoggedIn private constructor(){

    //Companion object create only one instance just like static in Java
    companion object{

        //Volatile ensures that changes are made immediately
        @Volatile
        private var instance: IsLoggedIn?=null

        fun getInstance(): IsLoggedIn =
            instance?: synchronized(this){
                instance?: IsLoggedIn().also { instance = it }
            }

    }

    var isLoggedIn:Boolean=false


}