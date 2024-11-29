package com.example.composeapp.store.data.remote

import com.example.composeapp.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}