package org.amp.project.ui.components.navigationDrawer

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable

@Composable
expect fun NavigationDrawerContent(
    onContactClick: () -> Unit,
    onLanguageClick: () -> Unit,
    onSkillsClick: () -> Unit,
    drawerState: DrawerState? = null
)