package com.example.dev.myapplication.model

data class CurrencyEntity constructor(
    val table: String,
    val currency: String,
    val code: String,
    val rates: List<Rate>
)
