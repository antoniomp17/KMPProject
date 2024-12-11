package org.amp.project.ui.components.mainLayout.medium

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.contact
import composeResources.languages
import composeResources.skills
import org.jetbrains.compose.resources.stringResource

@Composable
fun CustomNavigationRail(
    navigator: NavHostController
) {
    NavigationRail(
        content = {
            NavigationRailItem(
                selected = false,
                onClick = { navigator.navigate("/contact") },
                icon = {
                    Icon(
                        imageVector = Icons.Default.ContactMail,
                        contentDescription = Icons.Default.ContactMail.name
                    )
                },
                label = { Text(text = stringResource(Res.string.contact)) }
            )
            NavigationRailItem(
                selected = false,
                onClick = { navigator.navigate("/skills") },
                icon = {
                    Icon(
                        imageVector =  Icons.Default.School,
                        contentDescription = Icons.Default.School.name
                    )
                },
                label = { Text(text = stringResource(Res.string.skills)) }
            )
            NavigationRailItem(
                selected = false,
                onClick = { navigator.navigate("/languages") },
                icon = {
                    Icon(
                        imageVector =  Icons.Default.Translate,
                        contentDescription = Icons.Default.Translate.name
                    )
                },
                label = { Text(text = stringResource(Res.string.languages)) }
            )
        }
    )
}