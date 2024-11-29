package com.example.composeapp.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun isInternetAvailable(): Boolean {
        return isInternetAvailable(context)
    }
}