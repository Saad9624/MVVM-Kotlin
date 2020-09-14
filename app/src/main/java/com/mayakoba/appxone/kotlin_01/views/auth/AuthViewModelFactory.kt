package com.mayakoba.appxone.kotlin_01.views.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel

/**
 * this factory is created because we need to pass the UserRepository in the ViewModel constructor
 */


@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
   private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}