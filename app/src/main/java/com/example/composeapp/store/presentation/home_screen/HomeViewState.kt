package com.example.composeapp.store.presentation.home_screen

import com.example.composeapp.store.domain.model.Item

data class HomeViewState (
    val isLoading: Boolean = false,
    val items: List<Item> = emptyList(),
    val isConnected: Boolean = true
)