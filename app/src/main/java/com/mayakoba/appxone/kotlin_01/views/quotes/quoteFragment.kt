package com.mayakoba.appxone.kotlin_01.views.quotes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayakoba.appxone.kotlin_01.R
import com.mayakoba.appxone.kotlin_01.data.db.entities.Quote
import com.mayakoba.appxone.kotlin_01.utils.Coroutines
import com.mayakoba.appxone.kotlin_01.utils.Toast
import com.mayakoba.appxone.kotlin_01.utils.hide
import com.mayakoba.appxone.kotlin_01.utils.show
import com.mayakoba.appxone.kotlin_01.viewModels.viewModelFactory.QuotesViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.quote_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class quoteFragment : Fragment() ,KodeinAware{


            private lateinit var viewModel: QuoteViewModel
override val kodein by kodein()

private val factory:QuotesViewModelFactory by instance()


override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.quote_fragment, container, false)
}

override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this,factory).get(QuoteViewModel::class.java)
    bindUI()
    //        Coroutines.main {
    //          val quotes =   viewModel.quotes.await()
    //            quotes.observe(this, Observer {
    //                context?.Toast(it.size.toString())
    //            })
    ////            quotes.observer(this,
    ////            Observer{
    ////                context?.Toast(it.size.toString())
    ////            })
    //
    //        }
}
        private fun bindUI() = Coroutines.main{
            pbar.show()
            val quotes = viewModel.quotes.await().observe(this,Observer{
                pbar.hide()
                    initRecyclerView(it.toQuoteItem())
            })

        }

    private fun initRecyclerView(toQuoteItem: List<QuoteItem>) {
            val madapter = GroupAdapter<ViewHolder>().apply{
                addAll(toQuoteItem)
            }

        rv.apply{
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = madapter
        }
    }

    private fun List<Quote>.toQuoteItem() : List<QuoteItem>{
        return this.map{
            QuoteItem(it)
        }
    }

}