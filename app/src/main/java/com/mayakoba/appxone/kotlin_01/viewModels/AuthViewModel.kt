package com.mayakoba.appxone.kotlin_01.viewModels

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener

 class AuthViewModel : ViewModel(){

      var authListener : AuthListener? = null


     fun onLoginButtonPressed(email: String? , password: String?){

       authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
         //   authListener.onSuccess()
        }
        else{
           // authListener.onSuccess()

        }

            // success
    }

    fun login(email :String? , password : String? ){

    }



}