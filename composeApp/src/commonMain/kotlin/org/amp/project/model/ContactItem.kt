package org.amp.project.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector
import composeResources.Res
import composeResources.linkedin
import org.jetbrains.compose.resources.DrawableResource

data class ContactItem(
    val id: Long = -1,
    val type: ContactItemType,
    val data: String
)

enum class ContactItemType(val iconVector: ImageVector? = null, val iconRes: DrawableResource? = null) {
    MAIL(iconVector = Icons.Filled.Mail),
    PHONE(iconVector = Icons.Filled.Phone),
    LINKEDIN(iconRes = Res.drawable.linkedin)
}