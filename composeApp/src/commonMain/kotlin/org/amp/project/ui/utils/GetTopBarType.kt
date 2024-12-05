package org.amp.project.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.Navigator
import org.amp.project.data.TopBarTypes

@Composable
fun GetTopBarType(navigator: Navigator): TopBarTypes {
    var topBarType = TopBarTypes.HOME

    val currentNavigatorEntry = navigator.currentEntry.collectAsState(null).value

    val isOnDetailedInfo = currentNavigatorEntry?.route?.route.equals("/jobExperience/{id}") ||
            currentNavigatorEntry?.route?.route.equals("/resumeItem/{id}")

    if (isOnDetailedInfo) {
        topBarType = TopBarTypes.DETAILED_INFO
    }

    return topBarType
}