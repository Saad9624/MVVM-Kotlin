package com.mayakoba.appxone.kotlin_01.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mayakoba.appxone.kotlin_01.data.db.AppDatabase
import com.mayakoba.appxone.kotlin_01.data.db.entities.Quote
import com.mayakoba.appxone.kotlin_01.data.preferences.PreferenceProvider
import com.mayakoba.appxone.kotlin_01.data.service.Api
import com.mayakoba.appxone.kotlin_01.data.service.ApiRequest
import com.mayakoba.appxone.kotlin_01.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class QuoteRepository(
    private val api :Api,
    private val db : AppDatabase,
    private val prefs : PreferenceProvider
): ApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init{
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes() : LiveData<List<Quote>>{
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes(){
        val lastSavedAt = prefs.getLastSavedAt()
        if(lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))){
            val response = apiRequest {
                api.getQuotes()
            }
            quotes.postValue(response.quotes)
        }
    }
    private fun isFetchNeeded(savedAt: LocalDateTime):Boolean{
        return  ChronoUnit.HOURS.between(savedAt,LocalDateTime.now()) > 6
    }

    private fun saveQuotes(quotes:List<Quote>){
        Coroutines.io {
            prefs.saveLastSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}