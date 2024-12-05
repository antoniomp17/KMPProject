package org.amp.project.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.amp.project.model.ContactItemType
import org.jetbrains.compose.resources.painterResource

@Composable
fun getIconForType(type: ContactItemType): Painter {
    return when {
        type.iconVector != null -> rememberVectorPainter(type.iconVector)
        type.iconRes != null -> painterResource(type.iconRes)
        else -> throw IllegalArgumentException("Icon resource not found for type: $type")
    }
}