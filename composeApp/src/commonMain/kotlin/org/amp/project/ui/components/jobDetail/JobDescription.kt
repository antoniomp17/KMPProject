package org.amp.project.ui.components.jobDetail

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichText

@Composable
fun JobDescription(richTextState: RichTextState) {
    RichText(
        state = richTextState,
        style = MaterialTheme.typography.bodyMedium,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Justify
    )
}