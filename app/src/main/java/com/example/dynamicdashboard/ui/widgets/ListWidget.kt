package com.example.dynamicdashboard.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dynamicdashboard.data.UiState
import com.example.dynamicdashboard.viewmodel.ListViewModel

@Composable
fun ListWidget(instanceId: String) {
    // Unique key ensures separate ViewModel instance for each list
    val viewModel: ListViewModel = viewModel(key = instanceId)
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData(instanceId)
    }

    Column(Modifier.padding(16.dp)) {
        Text("List: $instanceId", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Box(Modifier.fillMaxWidth().heightIn(min = 100.dp), contentAlignment = Alignment.Center) {
            when (val s = state) {
                is UiState.Loading -> CircularProgressIndicator()
                is UiState.Success -> {
                    Column {
                        s.data.forEach { Text("${it.name} ${it.surname}", Modifier.padding(4.dp)) }
                    }
                }
                is UiState.Error -> Text(s.message)
            }
        }
    }
}