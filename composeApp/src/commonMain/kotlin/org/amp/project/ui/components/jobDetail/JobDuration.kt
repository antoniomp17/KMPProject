package org.amp.project.ui.components.jobDetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import composeResources.Res
import composeResources.duration
import org.jetbrains.compose.resources.stringResource

@Composable
fun JobDuration(startDate: String, endDate: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${stringResource(Res.string.duration)}: " +
                "$startDate ${
                    if (startDate != endDate) {
                        "- $endDate"
                    } else {
                        ""
                    }
                }",
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    )
}