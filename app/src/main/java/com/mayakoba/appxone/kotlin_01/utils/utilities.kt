package com.mayakoba.appxone.kotlin_01.utils

import android.content.Context
import android.widget.Toast

fun Context.Toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}