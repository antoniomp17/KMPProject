package org.amp.project.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import composeResources.Res
import composeResources.icon_resource_not_found
import org.amp.project.model.ContactItemType
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun getIconForType(type: ContactItemType): Painter {
    return when {
        type.iconVector != null -> rememberVectorPainter(type.iconVector)
        type.iconRes != null -> painterResource(type.iconRes)
        else -> throw IllegalArgumentException("${stringResource(Res.string.icon_resource_not_found)}: $type")
    }
}