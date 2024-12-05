package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import moe.tlaster.precompose.navigation.rememberNavigator
import org.amp.project.navigation.Navigation
import org.amp.project.ui.utils.GetTopBarType
import org.amp.project.ui.components.topBar.AppTopBar
import org.amp.project.ui.components.navigationDrawer.NavigationDrawerContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val navigator = rememberNavigator()
    val topBarType = GetTopBarType(navigator)
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { NavigationDrawerContent(drawerState) }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { AppTopBar(topBarType, drawerState, scope, navigator) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Navigation(navigator)
            }
        }
    }
}