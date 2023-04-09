package com.example.easystorage

class IsLoggedIn private constructor(){

    companion object{
        @Volatile
        private var instance: IsLoggedIn?=null

        fun getInstance(): IsLoggedIn =
            instance?: synchronized(this){
                instance?: IsLoggedIn().also { instance = it }
            }

    }

    var isLoggedIn:Boolean=false


}