package com.mayakoba.appxone.kotlin_01.views.quotes

import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.data.db.entities.Quote
import com.mayakoba.appxone.kotlin_01.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem


class QuoteItem(
    private val quote:Quote
) : BindableItem<ItemQuoteBinding>() {
    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
        }


}