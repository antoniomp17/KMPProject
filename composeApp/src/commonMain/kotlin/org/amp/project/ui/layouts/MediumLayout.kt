package org.amp.project.ui.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.Navigation
import org.amp.project.ui.components.mainLayout.common.TopAppBar
import org.amp.project.ui.components.mainLayout.mediumextended.CustomNavigationRail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumLayout(
    navigator: NavHostController,
    topBarType: TopBarTypes
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CustomNavigationRail(navigator)

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    scrollBehavior = null,
                    navigator = navigator,
                    topBarType = topBarType
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Navigation(navController = navigator)
            }

        }
    }
}
