package com.lcardoso.nybooksapp.view.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lcardoso.nybooksapp.R
import com.lcardoso.nybooksapp.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.tvBookTitle
        private val author = view.tvBookAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
        }
    }
}