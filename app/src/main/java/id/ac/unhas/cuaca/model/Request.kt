package id.ac.unhas.cuaca.model

data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)