package org.amp.project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import composeResources.Res
import composeResources.android
import org.jetbrains.compose.resources.painterResource

@Composable
fun FailureLoadingImage(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(Res.drawable.android),
                contentDescription = "Error al cargar imagen",
                contentScale = ContentScale.Fit
            )
        }
    }
}