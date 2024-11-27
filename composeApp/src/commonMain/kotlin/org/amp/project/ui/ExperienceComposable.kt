package org.amp.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExperienceComposable(text: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(text) {
            JobItem(text = it)
        }
    }
}

@Composable
fun JobItem(text: String){
    Card(
        modifier = Modifier
            .width(198.dp)
            .aspectRatio(1.2f)
            .padding(2.dp),
        shape = RoundedCornerShape(percent = 30),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)){
        Column(
            modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.1f))
            .padding(16.dp)
        ){
            Text(modifier = Modifier.weight(1f), text = text, style = MaterialTheme.typography.titleLarge)
            Text(text = text, style = MaterialTheme.typography.titleMedium)
        }
    }
}