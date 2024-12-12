package org.amp.project.ui.components.mainLayout.compact

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.resume
import composeResources.contact
import composeResources.languages
import composeResources.skills
import org.amp.project.navigation.NavigationScreens
import org.jetbrains.compose.resources.stringResource

@Composable
fun CustomBottomAppBar(
    navigator: NavHostController
) {
    val currentRoute = navigator.currentBackStackEntryFlow.collectAsState(initial = navigator.currentBackStackEntry).value?.destination?.route
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        Pair(stringResource(Res.string.resume), NavigationScreens.Home.route),
        Pair(stringResource(Res.string.contact), NavigationScreens.Contact.route),
        Pair(stringResource(Res.string.skills), NavigationScreens.Skills.route),
        Pair(stringResource(Res.string.languages), NavigationScreens.Languages.route)
    )

    BottomAppBar {
        NavigationBar{
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected =
                    if(items.any { it.second == currentRoute }){
                        selectedItem == index
                    } else false,
                    onClick = {
                        selectedItem = index
                        navigator.navigate(item.second)
                    },
                    icon = {
                        when (item.first) {
                            stringResource(Res.string.resume) -> {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = Icons.Default.Person.name
                                )
                            }
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
    }
}