package ungar.mvvmbasics.quotes.model

//data because its only purpose is to hold data
data class Quote(val quoteText: String,
                 val author: String,)
{
    override fun toString(): String{
        return "$quoteText - $author"
    }
}