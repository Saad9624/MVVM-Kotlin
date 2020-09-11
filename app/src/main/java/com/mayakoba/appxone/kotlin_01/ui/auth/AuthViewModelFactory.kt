package com.mayakoba.appxone.kotlin_01.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
   private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}