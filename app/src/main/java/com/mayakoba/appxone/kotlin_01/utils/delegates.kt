package com.mayakoba.appxone.kotlin_01.utils

import kotlinx.coroutines.*

/**
 * DEFFERED:
 * is a job with a result
 *
 */
fun<T> lazyDefferred(block : suspend CoroutineScope.() -> T):
        Lazy<Deferred<T>>{
    return lazy{
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}