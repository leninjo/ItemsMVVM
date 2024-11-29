package com.example.composeapp.store.presentation.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String
) {
    Row(modifier = Modifier.padding( top = 16.dp, start = 16.dp, bottom = 0.dp)) {
        Text(title, color = Color.Black.copy(alpha = 0.8f), style = MaterialTheme.typography.titleLarge)
    }
}