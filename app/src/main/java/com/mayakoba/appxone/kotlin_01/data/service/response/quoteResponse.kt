package com.mayakoba.appxone.kotlin_01.data.service.response

import com.mayakoba.appxone.kotlin_01.data.db.entities.Quote

data class quoteResponse(
    val isSuccessful:Boolean,
    val quotes : List<Quote>
)