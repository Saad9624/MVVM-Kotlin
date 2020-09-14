package com.mayakoba.appxone.kotlin_01.views.auth

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.data.db.entities.User
import com.mayakoba.appxone.kotlin_01.databinding.ActivityMainBinding
import com.mayakoba.appxone.kotlin_01.views.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.utils.Toast
import com.mayakoba.appxone.kotlin_01.utils.hide
import com.mayakoba.appxone.kotlin_01.utils.show
import com.mayakoba.appxone.kotlin_01.utils.snackbar
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.edit_text_email
import kotlinx.android.synthetic.main.activity_main.edit_text_password
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein

class MainActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

        button_sign_up.setOnClickListener {
            signUpClickClick()
        }
    }

    override fun onStarted() {
        progress_bar1.show()
    }

    override fun onSuccess(user: User) {
        progress_bar1.hide()
        root_layout1.snackbar("${user.name} is Signup")
    }

    override fun onFailure(message: String) {
        progress_bar1.hide()
        root_layout1.snackbar(message)
    }

    fun signUpClickClick(){
        viewModel.onSignupButtonPressed(edit_text_name.text.toString(),edit_text_email.text.toString(),edit_text_password.text.toString(),edit_text_password_confirm.text.toString())
    }

}