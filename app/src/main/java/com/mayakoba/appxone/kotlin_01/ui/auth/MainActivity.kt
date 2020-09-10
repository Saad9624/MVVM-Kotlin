package com.mayakoba.appxone.kotlin_01.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.databinding.ActivityMainBinding
import com.mayakoba.appxone.kotlin_01.ui.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel

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

    override fun onSuccess() {
    }

    override fun onFailure(message: String) {
    }
}