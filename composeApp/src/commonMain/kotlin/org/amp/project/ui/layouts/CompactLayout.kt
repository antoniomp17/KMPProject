package org.amp.project.ui.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.Navigation
import org.amp.project.ui.components.mainLayout.common.TopAppBar
import org.amp.project.ui.components.mainLayout.compact.CustomBottomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactLayout(
    navigator: NavHostController,
    topBarType: TopBarTypes,
    scrollBehavior: TopAppBarScrollBehavior
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                topBarType = topBarType,
                navigator = navigator
            )
        },
        bottomBar = {
            CustomBottomAppBar( navigator = navigator )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Navigation(
                navController = navigator
            )
        }
    }
}