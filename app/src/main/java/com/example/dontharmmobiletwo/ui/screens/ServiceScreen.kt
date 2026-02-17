package com.example.dontharmmobiletwo.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dontharmmobiletwo.viewmodel.NewsViewModel
import com.example.dontharmmobiletwo.viewmodel.ServiceViewModel

@Composable
fun ServiceScreen() {
    val serviceViewModel: ServiceViewModel = viewModel()

    LazyColumn() {
        items(items = serviceViewModel.getService()) {
            service ->
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = service.name)
            }
        }
    }
}