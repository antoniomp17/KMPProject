package org.amp.project.ui.components.mainLayout.medium

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.contact
import composeResources.languages
import composeResources.skills
import org.amp.project.data.utils.Links
import org.amp.project.navigation.NavigationScreens
import org.amp.project.ui.utils.CoilImageComposable
import org.jetbrains.compose.resources.stringResource

@Composable
fun CustomNavigationRail(
    navigator: NavHostController
) {
    val currentRoute = navigator.currentBackStackEntryFlow.collectAsState(initial = navigator.currentBackStackEntry).value?.destination?.route
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        Pair(stringResource(Res.string.contact), NavigationScreens.Contact.route),
        Pair(stringResource(Res.string.skills), NavigationScreens.Skills.route),
        Pair(stringResource(Res.string.languages), NavigationScreens.Languages.route)
    )

    NavigationRail(
        header = {
            Spacer(modifier = Modifier.height(16.dp))
            CoilImageComposable(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                imageUrl = Links.AMP_IMAGE_LINK
            )
        },
        content = {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected =
                    if(
                        currentRoute != NavigationScreens.Home.route &&
                        currentRoute != NavigationScreens.JobExperience.route
                    ){
                        selectedItem == index
                    } else false,
                    onClick = {
                        selectedItem = index
                        navigator.navigate(item.second)
                    },
                    icon = {
                        when (item.first) {
                            stringResource(Res.string.contact) -> {
                                Icon(
                                    imageVector = Icons.Default.ContactMail,
                                    contentDescription = Icons.Default.ContactMail.name
                                )
                            }
                            stringResource(Res.string.skills) -> {
                                Icon(
                                    imageVector =  Icons.Default.School,
                                    contentDescription = Icons.Default.School.name
                                )
                            }
                            stringResource(Res.string.languages) -> {
                                Icon(
                                    imageVector =  Icons.Default.Translate,
                                    contentDescription = Icons.Default.Translate.name
                                )
                            }
                        }
                    },
                    label = { Text(item.first) }
                )
            }
        }
    )
}