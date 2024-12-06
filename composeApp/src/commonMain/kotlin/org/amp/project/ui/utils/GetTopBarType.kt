package org.amp.project.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.Navigator
import org.amp.project.data.TopBarTypes

@Composable
fun GetTopBarType(navigator: Navigator): TopBarTypes {
    var topBarType = TopBarTypes.HOME

    val currentNavigatorEntry = navigator.currentEntry.collectAsState(null).value

    val isNotHome = !currentNavigatorEntry?.route?.route.equals("/home") && currentNavigatorEntry != null

    if (isNotHome) {
        topBarType = TopBarTypes.NOT_HOME
    }

    return topBarType
}