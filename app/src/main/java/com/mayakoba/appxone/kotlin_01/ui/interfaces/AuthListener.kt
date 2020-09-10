package com.mayakoba.appxone.kotlin_01.ui.interfaces

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message : String )
}