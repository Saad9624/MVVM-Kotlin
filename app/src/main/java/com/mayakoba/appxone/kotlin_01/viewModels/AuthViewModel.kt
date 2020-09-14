package com.mayakoba.appxone.kotlin_01.viewModels

import androidx.lifecycle.ViewModel
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.views.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.utils.ApiException
import com.mayakoba.appxone.kotlin_01.utils.Coroutines
import com.mayakoba.appxone.kotlin_01.utils.NoInternetException

class AuthViewModel(
   private val repository: UserRepository
) : ViewModel(){


    /**
     * Using instance of UserReposity make the class tightly coupled so this is not the
     * right approach
     * instead we use dependency injection by passing a reference of class into the constructor
     * using constructor injection
     */

      var authListener : AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

     fun onLoginButtonPressed(email: String? , password: String?){

       authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
             authListener?.onFailure("Invalid Email or Password")
        }
        else{
            Coroutines.main {
                try {
                    val authResponse = repository.userLogin(email!! , password!!)
                    authResponse.user?.let {
                        authListener?.onSuccess(it)
                        repository.saveUser(it)
                        return@main
                    }
                    authListener?.onFailure(authResponse.message!!)
                }
                catch (e : ApiException){
                    authListener?.onFailure(e.message!!)
                }
                catch (e : NoInternetException){
                    authListener?.onFailure(e.message!!)
                }
//                if(response.isSuccessful){
//                    authListener?.onSuccess(response.body()?.user!!)
//                }
//                else{
//                    authListener?.onFailure("Error Code: ${response.code()} " )
//
//                }
      }
             //val loginResponse = UserRepository().userLogin(email,password)
            //authListener?.onSuccess(loginResponse)
        }

            // success
    }

    fun onSignupButtonPressed(name : String?,email: String? , password: String?,confirmPassword:String?){

        authListener?.onStarted()
        if(name.isNullOrEmpty()){
            authListener?.onFailure("Name is required")
            return
        }
        if(email.isNullOrEmpty()){
            authListener?.onFailure("Email is required")
            return
        }

        if(password.isNullOrEmpty()){
            authListener?.onFailure("Password is required")
            return
        }
        if(password != confirmPassword){
            authListener?.onFailure("Password did not match!")
            return
        }
        else{
            Coroutines.main {
                try {
                    val authResponse = repository.userSignup(name, email, password)
                    authResponse.user?.let {
                        authListener?.onSuccess(it)
                        repository.saveUser(it)
                        return@main
                    }
                    authListener?.onFailure(authResponse.message!!)
                }
                catch (e : ApiException){
                    authListener?.onFailure(e.message!!)
                }
                catch (e : NoInternetException){
                    authListener?.onFailure(e.message!!)
                }
//                if(response.isSuccessful){
//                    authListener?.onSuccess(response.body()?.user!!)
//                }
//                else{
//                    authListener?.onFailure("Error Code: ${response.code()} " )
//
//                }
            }
            //val loginResponse = UserRepository().userLogin(email,password)
            //authListener?.onSuccess(loginResponse)
        }

        // success
    }



}