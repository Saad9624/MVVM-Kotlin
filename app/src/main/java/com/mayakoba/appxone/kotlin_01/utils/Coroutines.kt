package com.mayakoba.appxone.kotlin_01.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * this object class is similar to static keyword in java
 * we can call any function under object by calling from the class name
 */

/**
 Uni keyword is equivalent to VOID in java
 */


object Coroutines{

    fun main(work:suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}