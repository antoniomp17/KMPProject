package org.amp.project.ui.components.navigationDrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.contact
import composeResources.languages
import composeResources.skills
import org.amp.project.data.utils.Links
import org.amp.project.ui.utils.CoilImageComposable
import org.jetbrains.compose.resources.stringResource


@Composable
actual fun NavigationDrawerContent(
    onContactClick: () -> Unit,
    onLanguageClick: () -> Unit,
    onSkillsClick: () -> Unit,
    drawerState: DrawerState?
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f),
            horizontalArrangement = Arrangement.Center
        ) {
            CoilImageComposable(
                modifier = Modifier
                    .clip(CircleShape),
                imageUrl = Links.AMP_IMAGE_LINK
            )
        }

        Spacer(Modifier.height(32.dp))

        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Call, contentDescription = null) },
            label = {
                Text(
                    text = stringResource(Res.string.contact),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            },
            onClick = onContactClick,
            selected = false
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Language, contentDescription = null) },
            label = {
                Text(
                    text = stringResource(Res.string.languages),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            },
            onClick = onLanguageClick,
            selected = false
        )

        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Android, contentDescription = null) },
            label = {
                Text(
                    text = stringResource(Res.string.skills),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            },
            onClick = onSkillsClick,
            selected = false
        )
    }
}