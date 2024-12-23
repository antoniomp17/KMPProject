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
import org.amp.project.presentation.ThemeUiState
import org.amp.project.ui.screens.ContactScreen
import org.amp.project.ui.screens.DetailJobExperienceScreen
import org.amp.project.ui.screens.DownloadScreen
import org.amp.project.ui.screens.HomeScreen
import org.amp.project.ui.screens.LanguageScreen
import org.amp.project.ui.screens.SkillScreen

@Composable
fun Navigation(
    navController: NavHostController,
    jobExperienceUiState: JobExperienceUiState,
    resumeItemUiState: ResumeItemUiState,
    contactUiState: ContactUiState,
    languageUiState: LanguageUiState,
    skillUiState: SkillUiState,
    themeUiState: ThemeUiState,
    isExpanded: Boolean = false
) {

    NavHost(
        navController = navController,
        startDestination = if(!isExpanded) NavigationScreens.Home.route else NavigationScreens.Download.route
    ){
        if(!isExpanded){
            composable(route = NavigationScreens.Home.route){
                HomeScreen(
                    jobExperienceUiState = jobExperienceUiState,
                    resumeItemUiState = resumeItemUiState,
                    themeUiState = themeUiState,
                    onJobExperienceClick = { jobExperience ->
                        navController.navigate(NavigationScreens.JobExperience.createRoute(jobExperience.id))
                    }
                )
            }
        } else {
            composable(route = NavigationScreens.Download.route){
                DownloadScreen(themeUiState = themeUiState)
            }
        }

        composable(route = "${NavigationScreens.JobExperience.route}/{id}"){ backStackEntry ->
            val idFromPath = backStackEntry.arguments?.getString("id")?.toLongOrNull()!!
            val jobExperience = jobExperienceUiState.getJobExperienceById(idFromPath)
            DetailJobExperienceScreen(
                jobExperience = jobExperience,
                themeUiState = themeUiState
            )
        }

        composable(route = NavigationScreens.Contact.route){
            ContactScreen(
                contactUiState = contactUiState,
                themeUiState = themeUiState
            )
        }

        composable(route = NavigationScreens.Languages.route){
            LanguageScreen(languageUiState = languageUiState)
        }

        composable(route = NavigationScreens.Skills.route){
            SkillScreen(
                skillUiState = skillUiState,
                themeUiState = themeUiState
            )
        }
    }
}