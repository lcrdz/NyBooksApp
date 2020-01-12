package com.lcardoso.nybooksapp.data

import com.lcardoso.nybooksapp.data.response.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "WjkNKFwFXifLv0dDlAUU8Fbo1glEfZPd",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookResponse>
}