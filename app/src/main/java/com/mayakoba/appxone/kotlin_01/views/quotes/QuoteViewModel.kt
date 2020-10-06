package com.mayakoba.appxone.kotlin_01.views.quotes

import androidx.lifecycle.ViewModel
import com.mayakoba.appxone.kotlin_01.data.repository.QuoteRepository
import com.mayakoba.appxone.kotlin_01.utils.lazyDefferred

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {
    /**
     * by lazy now it will called only when the quotes is needed
     * we cannot call suspend function directly here getQuotes() is a suspend function
     *
     */
     val quotes by lazyDefferred{
         repository.getQuotes()
     }

    /**
     * se we create custom lazy block that weill use couroutine
     * scope to make the call
     *
     */
}