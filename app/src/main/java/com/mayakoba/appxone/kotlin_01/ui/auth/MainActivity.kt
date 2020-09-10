package com.mayakoba.appxone.kotlin_01.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener

class MainActivity : AppCompatActivity() , AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//        val binding : ActivityMainBinding  = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
//        binding.viewmodel = viewModel
//        viewModel.authListener = this
    }

    override fun onStarted() {
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
    }

    override fun onFailure(message: String) {
    }
}