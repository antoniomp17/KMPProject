package org.amp.project.ui.components.otherResume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.model.ResumeItem
import org.amp.project.ui.theme.onBackgroundLight

@Composable
fun ResumeItemsComposable(
    resumeItemList: List<ResumeItem>,
    onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = resumeItemList[0].type.title
        )
        Spacer(modifier = Modifier.height(4.dp))
        ResumeItemsLazyColumnComposable(resumeItemList, onResumeItemClick)
    }
}



