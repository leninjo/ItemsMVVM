package com.example.composeapp.store.domain.repository

import arrow.core.Either
import com.example.composeapp.store.domain.model.NetworkError
import com.example.composeapp.store.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}