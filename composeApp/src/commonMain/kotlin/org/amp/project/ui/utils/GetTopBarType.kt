package org.amp.project.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.NavigationScreens

@Composable
fun GetTopBarType(navController: NavController): TopBarTypes {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = currentBackStackEntry?.destination?.route

    return if (currentRoute?.let { NavigationScreens.JobExperience.isJobExperienceRoute(it) } == true) {
        TopBarTypes.JOB_DESCRIPTION
    } else {
        TopBarTypes.NOT_JOB_DESCRIPTION
    }
}