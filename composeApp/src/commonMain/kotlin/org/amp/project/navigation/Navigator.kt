package org.amp.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.ui.screens.ContactScreen
import org.amp.project.ui.screens.DetailJobExperienceScreen
import org.amp.project.ui.screens.DownloadScreen
import org.amp.project.ui.screens.HomeScreen
import org.amp.project.ui.screens.LanguageScreen
import org.amp.project.ui.screens.SkillScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navigation(
    navController: NavHostController,
    isExpanded: Boolean = false,
    jobExperienceViewModel: JobExperienceViewModel = koinViewModel<JobExperienceViewModel> { parametersOf() }
) {
    val jobExperienceUiState by jobExperienceViewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = if(!isExpanded) NavigationScreens.Home.route else NavigationScreens.Download.route
    ){
        if(!isExpanded){
            composable(route = NavigationScreens.Home.route){
                HomeScreen(
                    onJobExperienceClick = { jobExperience ->
                        navController.navigate(NavigationScreens.JobExperience.createRoute(jobExperience.id))
                    }
                )
            }
        } else {
            composable(route = NavigationScreens.Download.route){
                DownloadScreen()
            }
        }

        composable(route = "${NavigationScreens.JobExperience.route}/{id}"){ backStackEntry ->
            val idFromPath = backStackEntry.arguments?.getString("id")?.toLongOrNull()!!
            val jobExperience = jobExperienceUiState.getJobExperienceById(idFromPath)
            DetailJobExperienceScreen(jobExperience = jobExperience)
        }

        composable(route = NavigationScreens.Contact.route){
            ContactScreen()
        }

        composable(route = NavigationScreens.Languages.route){
            LanguageScreen()
        }

        composable(route = NavigationScreens.Skills.route){
            SkillScreen()
        }
    }
}