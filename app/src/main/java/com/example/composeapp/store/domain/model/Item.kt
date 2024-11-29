package com.example.composeapp.store.domain.model

data class Item(
    val name: String,
    val icon: Int,
    val subItems: List<Item>? = null
)