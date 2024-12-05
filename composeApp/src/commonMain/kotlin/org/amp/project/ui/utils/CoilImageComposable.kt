package org.amp.project.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun CoilImageComposable(modifier: Modifier = Modifier, imageUrl: String){
    CoilImage(
        modifier = modifier,
        imageModel = {  imageUrl },
        loading = {
            Box(modifier = Modifier. matchParentSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        failure = {
            FailureLoadingImage()
        }
    )
}