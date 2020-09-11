package com.mayakoba.appxone.kotlin_01.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

    fun Context.Toast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun ProgressBar.show(){
        visibility = View.VISIBLE
    }
    fun ProgressBar.hide(){
        visibility = View.GONE
    }

    fun View.snackbar(message :String){
        Snackbar.make(this,message,Snackbar.LENGTH_LONG).also { snackbar ->
            snackbar.setAction("ok"){
                snackbar.dismiss()
            }
        }.show()
    }

