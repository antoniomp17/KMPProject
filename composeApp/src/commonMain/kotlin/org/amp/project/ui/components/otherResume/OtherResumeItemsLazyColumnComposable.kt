package org.amp.project.ui.components.otherResume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2.8f/resumeItemList.size),
        userScrollEnabled = false
    ){
        items(resumeItemList) {
            ResumeItemComposable(resumeItem = it, onResumeItemClick)
        }
    }
}