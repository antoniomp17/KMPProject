package org.amp.project.ui.components.mainLayout.compact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.contact
import composeResources.languages
import composeResources.skills
import kotlinx.coroutines.launch
import org.amp.project.data.utils.Links
import org.amp.project.ui.components.mainLayout.common.DrawerHeader
import org.jetbrains.compose.resources.stringResource

@Composable
fun NavigationDrawerContent(
    onContactClick: () -> Unit,
    onLanguageClick: () -> Unit,
    onSkillsClick: () -> Unit,
    drawerState: DrawerState?
) {
    val scope = rememberCoroutineScope()

    if (drawerState != null) {
        ModalDrawerSheet(drawerState) {
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(Modifier.height(16.dp))

                DrawerHeader(imageUrl = Links.AMP_IMAGE_LINK)

                Spacer(Modifier.height(32.dp))

                DrawerItem(
                    icon = Icons.Default.ContactMail,
                    label = stringResource(Res.string.contact),
                    onClick = {
                        onContactClick()
                        scope.launch { drawerState.close() }
                    },
                    selected = false
                )
                DrawerItem(
                    icon = Icons.Default.Translate,
                    label = stringResource(Res.string.skills),
                    onClick = {
                        onSkillsClick()
                        scope.launch { drawerState.close() }
                    },
                    selected = false
                )
                DrawerItem(
                    icon = Icons.Default.School,
                    label = stringResource(Res.string.languages),
                    onClick = {
                        onLanguageClick()
                        scope.launch { drawerState.close() }
                    },
                    selected = false
                )
            }
        }
    }
}