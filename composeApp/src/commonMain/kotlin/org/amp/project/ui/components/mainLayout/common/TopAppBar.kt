package org.amp.project.ui.components.mainLayout.common

import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.amp_logo
import kotlinx.coroutines.CoroutineScope
import org.amp.project.data.utils.TopBarTypes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    topBarType: TopBarTypes,
    drawerState: DrawerState? = null,
    scope: CoroutineScope? = null,
    navigator: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    showNavigationIcon: Boolean = true
) {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(Res.drawable.amp_logo),
                contentDescription = stringResource(Res.string.amp_logo)
            )
        },
        navigationIcon = {
            if(showNavigationIcon){
                NavigationIcon(
                    topBarType = topBarType,
                    drawerState = drawerState,
                    scope = scope,
                    navigator = navigator
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}