package com.mayakoba.appxone.kotlin_01.data.service.response

import com.mayakoba.appxone.kotlin_01.data.db.entities.User

data class AuthResponse (
    val isSuccessful : Boolean?,
    val message : String?,
    val user:User?

    )