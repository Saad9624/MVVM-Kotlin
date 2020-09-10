package com.mayakoba.appxone.kotlin_01.ui.interfaces

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message : String )
}