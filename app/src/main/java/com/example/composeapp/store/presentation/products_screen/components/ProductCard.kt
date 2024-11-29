package com.example.composeapp.store.presentation.products_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.composeapp.store.domain.model.Product
import com.example.composeapp.R;

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Box(
        modifier = Modifier.fillMaxWidth().aspectRatio(1f)
    ) {
        OutlinedCard (
            modifier = modifier.fillMaxSize(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.outlinedCardColors(
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
        ) {
            Column (modifier = Modifier.fillMaxHeight().padding(10.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.fillMaxWidth().weight(0.65f), contentAlignment = Alignment.TopCenter) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.icono).build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.aspectRatio(1f).fillMaxSize(),
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box( modifier = Modifier.fillMaxWidth().weight(0.35f), contentAlignment = Alignment.BottomCenter) {
                    Text(product.title, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleMedium.copy(lineHeight = 18.sp), textAlign = TextAlign.Center, maxLines = 2, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}