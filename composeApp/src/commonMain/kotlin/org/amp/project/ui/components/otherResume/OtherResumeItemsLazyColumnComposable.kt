package org.amp.project.ui.components.otherResume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.model.ResumeItem

@Composable
fun ResumeItemsLazyColumnComposable(
    resumeItemList: List<ResumeItem>,
    onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val width = maxWidth

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .sizeIn(
                    maxHeight = (resumeItemList.size * width.value / 2.8f).dp
                )
                .fillMaxWidth()
                .aspectRatio(2.8f / resumeItemList.size),
            userScrollEnabled = false
        ) {
            items(resumeItemList) {
                ResumeItemComposable(resumeItem = it, onResumeItemClick)
            }
        }
    }
}