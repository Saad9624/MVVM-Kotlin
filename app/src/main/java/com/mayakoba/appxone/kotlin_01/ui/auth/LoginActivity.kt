package com.mayakoba.appxone.kotlin_01.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.databinding.ActivityLoginBinding
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.utils.Toast
import com.mayakoba.appxone.kotlin_01.utils.hide
import com.mayakoba.appxone.kotlin_01.utils.show
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import kotlinx.android.synthetic.main.activity_login.*

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
        progress_bar.show()
        Log.e("under","under")
        Toast("Login Started")

    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
           progress_bar.hide()
            Toast(it)

        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()

        Toast("Login $message")

    }

    fun login(){
         viewModel.login("","")
    }

    fun loginClick(){
        //Toast("Login clicked")
        viewModel.onLoginButtonPressed(edit_text_email.text.toString(),edit_text_password.text.toString())
    }

}