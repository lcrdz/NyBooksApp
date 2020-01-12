package com.lcardoso.nybooksapp.view.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lcardoso.nybooksapp.data.ApiService
import com.lcardoso.nybooksapp.data.model.Book
import com.lcardoso.nybooksapp.data.response.BookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val bookLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookResponse ->
                        for (results in bookResponse.bookResults) {
                            val book = Book(
                                title = results.bookDetails[0].title,
                                author = results.bookDetails[0].author,
                                description = results.bookDetails[0].description
                            )
                            books.add(book)
                        }
                    }
                    bookLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {

            }

        })
    }
}