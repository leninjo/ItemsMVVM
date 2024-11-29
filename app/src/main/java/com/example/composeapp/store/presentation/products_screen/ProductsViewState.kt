package com.example.composeapp.store.presentation.products_screen

import com.example.composeapp.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
