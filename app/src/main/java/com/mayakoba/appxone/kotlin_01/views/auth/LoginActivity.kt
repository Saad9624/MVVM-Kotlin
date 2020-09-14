package com.mayakoba.appxone.kotlin_01.views.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.data.db.entities.User
import com.mayakoba.appxone.kotlin_01.databinding.ActivityLoginBinding
import com.mayakoba.appxone.kotlin_01.views.interfaces.AuthListener
import com.mayakoba.appxone.kotlin_01.utils.Toast
import com.mayakoba.appxone.kotlin_01.utils.hide
import com.mayakoba.appxone.kotlin_01.utils.show
import com.mayakoba.appxone.kotlin_01.utils.snackbar
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),AuthListener , KodeinAware {
    override val kodein by kodein()

    private val factory : AuthViewModelFactory by instance()

    lateinit var btn_next: Button

    private lateinit var viewModel: AuthViewModel

    /**
     * Dependency Injection
     * 1)Injecting Dependency
     * 2)Dependency injection is a design pattern that is independent of android
     * 3)passing the reference of class in contructor call constructor injection
     * 4)lossly coupled
     * 5)testing is easy in di
     * 6)At some point we have to create instance of classes that we are doing in loginActivity
     *      at line o 50,51 to avoid this instance creation we user di services for this project
     *       we use kotlin depency injection that is => "Kodein"
     * 7)so we are using kodein to inject required dependencies from outside
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login)

        //creating instances of all required classes
//        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
//        val api = Api(networkConnectionInterceptor)
//        val db = AppDatabase(this)
//        val repository = UserRepository(api , db)
//        val factory = AuthViewModelFactory(repository)

        val binding : ActivityLoginBinding =  DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer {user ->
                if(user != null){
//                        Intent(this,MainActivity::class.java).also{
//                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                            startActivity(it)
//                        }
                }
        })


       // AppDatabase(this)


        btn_next = findViewById(R.id.button_sign_in)

        btn_next.setOnClickListener {
           // Toast("btutton clicked")
            loginClick()
        }

        text_view_sign_up.setOnClickListener{
                                    Intent(this,HomeActivity::class.java).also{
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
        }
    }

    override fun onStarted() {
        progress_bar.show()
        //Log.e("under","under")
        //Toast("Login Started")

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        root_layout.snackbar("${user.name} is Logged In")
        Intent(this,HomeActivity::class.java).also{
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
//        loginResponse.observe(this, Observer {
////           progress_bar.hide()
////            Toast(it)
////
////        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()

        Toast("Login $message")

    }

//    fun login(){
//         viewModel.login("","")
//    }

    fun loginClick(){
        //Toast("Login clicked")
        viewModel.onLoginButtonPressed(edit_text_email.text.toString(),edit_text_password.text.toString())
    }


}