package com.example.dontharmmobiletwo.ui.screens

import android.content.Context
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

@Composable
fun NewsScreen(context: Context) {
    val newsViewModel: NewsViewModel = viewModel()

    LazyColumn() {
        items(items = newsViewModel.getNews(context)) {
            news ->
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = news.title)
            }
        }
    }
}