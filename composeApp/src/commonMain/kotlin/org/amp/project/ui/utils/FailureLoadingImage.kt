package org.amp.project.ui.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import composeResources.Res
import composeResources.image_failed_to_load
import org.jetbrains.compose.resources.stringResource

@Composable
fun FailureLoadingImage() {
    Text(text = stringResource(Res.string.image_failed_to_load))
}