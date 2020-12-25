package ungar.mvvmbasics.quotes.utilities

import ungar.mvvmbasics.quotes.model.FakeDatabase
import ungar.mvvmbasics.quotes.model.QuoteRepository
import ungar.mvvmbasics.quotes.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}