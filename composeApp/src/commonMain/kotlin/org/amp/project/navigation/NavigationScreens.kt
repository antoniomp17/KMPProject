package org.amp.project.navigation

sealed class NavigationScreens(val route: String) {
    // Pantallas estáticas
    data object Home : NavigationScreens(route = "/home")
    data object Contact : NavigationScreens(route = "/contact")
    data object Languages : NavigationScreens(route = "/languages")
    data object Skills : NavigationScreens(route = "/skills")

    // Pantallas dinámicas
    data object JobExperience : NavigationScreens(route = "/jobExperience") {
        fun createRoute(id: Long): String = "$route/$id"
    }
}