package ungar.mvvmbasics.quotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ungar.mvvmbasics.R
import ungar.mvvmbasics.quotes.model.Quote
import ungar.mvvmbasics.quotes.utilities.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi(){
        val textView: TextView = findViewById(R.id.tv_quotes)
        val button: Button = findViewById(R.id.button_add_quote)
        val editTextAuthor: TextView = findViewById(R.id.editText_author)
        val editTextQuote: TextView = findViewById(R.id.editText_quote)
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView.text = stringBuilder.toString()
        })

        button.setOnClickListener {
            val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editTextQuote.setText("")
            editTextAuthor.setText("")
        }
    }
}