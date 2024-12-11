package org.amp.project.ui.components.mainLayout.compact

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    selected: Boolean
) {
    NavigationDrawerItem(
        icon = { Icon(icon, contentDescription = icon.name) },
        label = {
            Text(
                text = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        },
        onClick = onClick,
        selected = selected
    )
}