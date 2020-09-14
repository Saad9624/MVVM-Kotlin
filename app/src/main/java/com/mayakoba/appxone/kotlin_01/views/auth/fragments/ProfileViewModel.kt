package com.mayakoba.appxone.kotlin_01.views.auth.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mayakoba.appxone.kotlin_01.data.db.entities.User
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository

class ProfileViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    val user = repository.getUser()


}