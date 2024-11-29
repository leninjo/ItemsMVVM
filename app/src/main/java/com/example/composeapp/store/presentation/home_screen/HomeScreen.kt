package com.example.composeapp.store.presentation.home_screen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composeapp.store.presentation.home_screen.components.HomeCard
import com.example.composeapp.store.presentation.util.components.MyTopAppBar
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
internal fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreenContent(state = state, onRetryConnection = { viewModel.checkConnectionAndLoadItems() })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    state: HomeViewState,
    onRetryConnection: () -> Unit
) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = "Inicio")
        }
    ) { paddingValues ->
        if (!state.isConnected) {
            ConnectionErrorDialog(
                onRetry = onRetryConnection,
                onClose = {
                    println("Cerrar app")
                }
            )
        } else {
            LazyVerticalGrid(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(state.items) { item ->
                    HomeCard(item = item)
                }
            }
        }
    }
}

@Composable
fun ConnectionErrorDialog(
    onRetry: () -> Unit,
    onClose: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Sin conexión a Internet")
        },
        text = {
            Text(text = "Parece que no tienes conexión a Internet. ¿Qué deseas hacer?")
        },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(text = "Reintentar")
            }
        },
        dismissButton = {
            TextButton(onClick = onClose) {
                Text(text = "Cerrar")
            }
        }
    )
}