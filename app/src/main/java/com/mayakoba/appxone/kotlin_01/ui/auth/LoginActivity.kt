package com.mayakoba.appxone.kotlin_01.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.databinding.ActivityLoginBinding
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.utils.Toast
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),AuthListener  {
    lateinit var btn_next: Button

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login)

        val binding : ActivityLoginBinding =  DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this


        btn_next = findViewById(R.id.button_sign_in)

        btn_next.setOnClickListener {
           // Toast("btutton clicked")
            loginClick()
        }
    }

    override fun onStarted() {
        Log.e("under","under")
        Toast("Login Started")

    }

    override fun onSuccess() {
        Toast("Login success")

    }

    override fun onFailure(message: String) {
        Toast("Login $message")

    }

    fun login(){

        viewModel.login("","")
    }

    fun loginClick(){
        //Toast("Login clicked")
        viewModel.onLoginButtonPressed("","")
    }

}