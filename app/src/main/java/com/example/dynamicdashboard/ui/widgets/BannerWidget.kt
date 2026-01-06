package com.example.dynamicdashboard.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dynamicdashboard.data.BannerDataGenerator

@Composable
fun BannerWidget(instanceId: String) {
    val banners = BannerDataGenerator.getBanner(instanceId)
    Column {
        Text("Banner: $instanceId", Modifier.padding(start = 16.dp, top = 8.dp), fontWeight = FontWeight.Bold)
        LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(banners) { banner ->
                Card(Modifier.padding(end = 8.dp).width(150.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Text(banner.title, fontWeight = FontWeight.ExtraBold)
                        Text(banner.subtitle)
                    }
                }
            }
        }
    }
}