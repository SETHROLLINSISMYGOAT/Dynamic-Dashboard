package com.example.dynamicdashboard.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.dynamicdashboard.data.WidgetMetadata
import com.example.dynamicdashboard.ui.widgets.BannerWidget
import com.example.dynamicdashboard.ui.widgets.ListWidget

@Composable
fun DashboardScreen() {
    val config = listOf(
        WidgetMetadata("banner", "pokemon"),
        WidgetMetadata("banner", "cars"),
        WidgetMetadata("banner", "bikes"),
        WidgetMetadata("list", "movies"),
        WidgetMetadata("list", "shows")
    )

    LazyColumn {
        items(config) { metadata ->
            when (metadata.type) {
                "banner" -> BannerWidget(metadata.instanceId)
                "list" -> ListWidget(metadata.instanceId)
            }
        }
    }
}