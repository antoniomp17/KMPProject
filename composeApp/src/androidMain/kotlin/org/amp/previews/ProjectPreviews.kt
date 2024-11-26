package org.amp.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.amp.project.ui.ExperienceComposable
import org.amp.project.ui.JobItem

@Preview(showBackground = true)
@Composable
fun JobItemPreview() {
    Box(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        JobItem(text = "Text")
    }
}

@Preview(showBackground = true)
@Composable
fun JobsCarouselPreview() {
    Box(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        ExperienceComposable(listOf("Text", "Text", "Text"))
    }
}