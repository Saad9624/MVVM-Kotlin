package com.mayakoba.appxone.kotlin_01.views.interfaces

import com.mayakoba.appxone.kotlin_01.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message : String )
}