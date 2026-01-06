package com.example.dynamicdashboard.data

// Metadata from "Backend"
data class WidgetMetadata(val type: String, val instanceId: String)

// Data for Banners
data class BannerConfig(val title: String, val subtitle: String)

// Data for List Items
data class ListWidgetConfig(val name: String, val surname: String)

// State for the Smart List Widget
sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<ListWidgetConfig>) : UiState()
    data class Error(val message: String) : UiState()
}