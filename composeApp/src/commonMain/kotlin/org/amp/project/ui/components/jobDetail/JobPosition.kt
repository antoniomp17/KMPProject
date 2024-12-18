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
import composeResources.position
import org.jetbrains.compose.resources.stringResource

@Composable
fun JobPosition(position: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${stringResource(Res.string.position)}: $position",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    )
}