package org.amp.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import composeResources.Res
import composeResources.driguard_image_url
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResumeLazyColumn(text: List<String>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(text) {
            ResumeItem(text = it)
        }
    }
}

@Composable
fun ResumeItem(text: String){

    val urlString = stringResource(Res.string.driguard_image_url)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2.5f)
            .padding(2.dp),
        shape = RoundedCornerShape(percent = 30),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)){
        Row(
            modifier = Modifier
                .fillMaxSize()
        ){
            CoilImage(
                imageModel = {  urlString },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Fit
                )
            )
            Column(
                modifier = Modifier
                    .padding(16.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
                Text(text = text,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}