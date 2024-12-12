package org.amp.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.amp.project.presentation.ContactUiState
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.LanguageUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.presentation.SkillUiState
import org.amp.project.ui.screens.ContactScreen
import org.amp.project.ui.screens.DetailJobExperienceScreen
import org.amp.project.ui.screens.LanguageScreen
import org.amp.project.ui.screens.HomeScreen
import org.amp.project.ui.screens.SkillScreen

@Composable
fun Navigation(
    navController: NavHostController,
    jobExperienceUiState: JobExperienceUiState,
    resumeItemUiState: ResumeItemUiState,
    contactUiState: ContactUiState,
    languageUiState: LanguageUiState,
    skillUiState: SkillUiState,
    isExpanded: Boolean = false
) {

    NavHost(
        navController = navController,
        startDestination = NavigationScreens.Contact.route
    ){
        if(!isExpanded){
            composable(route = NavigationScreens.Home.route){
                HomeScreen(
                    jobExperienceUiState = jobExperienceUiState,
                    resumeItemUiState = resumeItemUiState,
                    onJobExperienceClick = { jobExperience ->
                        navController.navigate(NavigationScreens.JobExperience.createRoute(jobExperience.id))
                    },
                    onResumeItemClick = {}
                )
            }
        }

        composable(route = "${NavigationScreens.JobExperience.route}/{id}"){ backStackEntry ->
            val idFromPath = backStackEntry.arguments?.getString("id")?.toLongOrNull()!!
            val jobExperience = jobExperienceUiState.getJobExperienceById(idFromPath)
            DetailJobExperienceScreen(jobExperience = jobExperience)
        }

        composable(route = NavigationScreens.Contact.route){
            ContactScreen(contactUiState = contactUiState)
        }

        composable(route = NavigationScreens.Languages.route){
            LanguageScreen(languageUiState = languageUiState)
        }

        composable(route = NavigationScreens.Skills.route){
            SkillScreen(skillUiState = skillUiState)
        }
    }
}