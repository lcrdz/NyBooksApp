package com.lcardoso.nybooksapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookDetails(
    @Json(name = "author")
    val author: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String
)