package com.example.dynamicdashboard.data
import kotlinx.coroutines.delay

object BannerDataGenerator {
    fun getBanner(instanceId: String): List<BannerConfig> {
        return when (instanceId) {
            "pokemon" -> listOf(BannerConfig("Pikachu", "Electric"), BannerConfig("Charizard", "Fire"))
            "cars" -> listOf(BannerConfig("Tesla", "Model S"), BannerConfig("Ferrari", "SF90"))
            "bikes" -> listOf(BannerConfig("Harley", "Cruiser"), BannerConfig("Ducati", "Sport"))
            else -> listOf(BannerConfig("Hello", "World"))
        }
    }
}

object ListDataGenerator {
    suspend fun getListData(instanceId: String): List<ListWidgetConfig> {
        delay(2000) // Simulate network delay
        return when (instanceId) {
            "movies" -> listOf(ListWidgetConfig("Iron Man", "Stark"), ListWidgetConfig("Thor", "Odinson"))
            "shows" -> listOf(ListWidgetConfig("Breaking", "Bad"), ListWidgetConfig("Better Call", "Saul"))
            else -> throw Exception("Failed to load")
        }
    }
}