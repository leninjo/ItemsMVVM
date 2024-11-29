package com.example.composeapp.store.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.store.domain.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.composeapp.R;
import com.example.composeapp.util.NetworkHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkHelper: NetworkHelper
): ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        checkConnectionAndLoadItems()
    }

    fun checkConnectionAndLoadItems() {
        if (networkHelper.isInternetAvailable()) {
            _state.value = _state.value.copy(isConnected = true)
            loadItems()
        } else {
            _state.value = _state.value.copy(isConnected = false)
        }
    }

    fun loadItems() {
        _state.value = _state.value.copy(isLoading = true)

        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = false,
                items = listOf(
                    Item("Item 1", R.drawable.shape_1),
                    Item("Item 2", R.drawable.shape_2),
                    Item("Item 3", R.drawable.shape_3),
                    Item("Item 4", R.drawable.shape_4),
                    Item("Item 5", R.drawable.shape_5),
                    Item("Item 6", R.drawable.shape_6),
                    Item("Item 7", R.drawable.shape_7),
                    Item("Item 8", R.drawable.shape_8),
                    Item("Item 9", R.drawable.shape_9),
                    Item("Item 10", R.drawable.shape_10),

                )
            )
        }
    }
}