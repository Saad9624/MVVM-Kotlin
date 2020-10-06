package com.mayakoba.appxone.kotlin_01.viewModels.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayakoba.appxone.kotlin_01.data.repository.QuoteRepository
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.viewModels.AuthViewModel
import com.mayakoba.appxone.kotlin_01.views.auth.fragments.ProfileViewModel
import com.mayakoba.appxone.kotlin_01.views.quotes.QuoteViewModel

/**
 * this factory is created because we need to pass the UserRepository in the ViewModel constructor
 */


@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(
   private val repository: QuoteRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}