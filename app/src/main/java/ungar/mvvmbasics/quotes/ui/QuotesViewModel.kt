package ungar.mvvmbasics.quotes.ui

import androidx.lifecycle.ViewModel
import ungar.mvvmbasics.quotes.model.Quote
import ungar.mvvmbasics.quotes.model.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}