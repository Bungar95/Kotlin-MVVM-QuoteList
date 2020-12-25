package ungar.mvvmbasics.quotes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ungar.mvvmbasics.quotes.model.QuoteRepository

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}