package com.lcardoso.nybooksapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookResults(
    @Json(name = "book_details")
    val bookDetails: List<BookDetails>
)