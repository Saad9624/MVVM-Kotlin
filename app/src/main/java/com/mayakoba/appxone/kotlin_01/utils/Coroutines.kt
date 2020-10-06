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
    /**
     *dispatcher can confine coroutine execution to a specific thread
        dispatch it to thread pool,or let it run unconfined
     */

    /**
     * DISPATCHER.MAIN
     * use this dispatcher to run a coroutine on the main android thread.
     * this should be used only for interacting with the ui and performing quick work
     * Example are suspend functions running android ui framework operations
     *
     */

    /**
     * DISPATCHER.IO
     * this dispatcher is optimized to perform disk or network I/O
     * outside the nmain thread.Exmple are room component reading from or writing to files
     */

    fun main(work:suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main)
            .launch {
            work()
        }
    fun io(work:suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO)
            .launch {
            work()
        }
}