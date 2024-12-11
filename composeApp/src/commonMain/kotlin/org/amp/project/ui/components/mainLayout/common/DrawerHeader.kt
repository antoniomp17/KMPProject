package org.amp.project.ui.components.mainLayout.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun DrawerHeader(imageUrl: String) {
    Row(
        modifier = Modifier
            .size(20.dp)
            .aspectRatio(3f),
        horizontalArrangement = Arrangement.Center
    ) {
        CoilImageComposable(
            modifier = Modifier
                .clip(CircleShape),
            imageUrl = imageUrl
        )
    }
}