package com.example.dynamicdashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamicdashboard.data.ListDataGenerator
import com.example.dynamicdashboard.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun fetchData(instanceId: String) {
        // Only fetch if we are in Loading state to avoid repeat calls
        if (_uiState.value !is UiState.Loading) return

        viewModelScope.launch {
            try {
                val result = ListDataGenerator.getListData(instanceId)
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Error loading $instanceId")
            }
        }
    }
}