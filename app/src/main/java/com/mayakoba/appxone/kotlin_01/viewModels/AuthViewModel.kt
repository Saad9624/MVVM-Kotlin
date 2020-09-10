package com.mayakoba.appxone.kotlin_01.viewModels

import androidx.lifecycle.ViewModel
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener

 class AuthViewModel : ViewModel(){

      var authListener : AuthListener? = null


     fun onLoginButtonPressed(email: String? , password: String?){

       authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){

            authListener?.onFailure("Invalid Email or Password")
        }
        else{
             val loginResponse = UserRepository().userLogin(email,password)
            authListener?.onSuccess(loginResponse)
        }

            // success
    }

    fun login(email :String? , password : String? ){

    }



}