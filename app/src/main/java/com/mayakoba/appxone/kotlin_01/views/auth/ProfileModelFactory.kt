package com.mayakoba.appxone.kotlin_01.views.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import com.mayakoba.appxone.kotlin_01.views.auth.fragments.ProfileViewModel

/**
 * this factory is created because we need to pass the UserRepository in the ViewModel constructor
 */


@Suppress("UNCHECKED_CAST")
class ProfileModelFactory(
   private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}