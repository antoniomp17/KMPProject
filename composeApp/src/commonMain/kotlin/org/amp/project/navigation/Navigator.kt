package org.amp.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.amp.project.data.contact.ContactManager
import org.amp.project.data.contact.ContactRepositoryImpl
import org.amp.project.data.jobExperience.JobExperienceManager
import org.amp.project.data.jobExperience.JobExperienceRepositoryImpl
import org.amp.project.data.language.LanguageManager
import org.amp.project.data.language.LanguageRepositoryImpl
import org.amp.project.data.otherResume.OtherResumeItemManager
import org.amp.project.data.otherResume.OtherOtherResumeItemRepositoryImpl
import org.amp.project.data.skill.SkillManager
import org.amp.project.data.skill.SkillRepositoryImpl
import org.amp.project.presentation.ContactViewModel
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.presentation.LanguageViewModel
import org.amp.project.presentation.ResumeItemViewModel
import org.amp.project.presentation.SkillViewModel
import org.amp.project.ui.screens.ContactScreen
import org.amp.project.ui.screens.DetailJobExperienceScreen
import org.amp.project.ui.screens.LanguageScreen
import org.amp.project.ui.screens.ResumeScreen
import org.amp.project.ui.screens.SkillScreen

@Composable
fun Navigation(navController: NavHostController) {

    val jobExperienceViewModel = viewModel{ JobExperienceViewModel(JobExperienceRepositoryImpl(JobExperienceManager)) }

    val resumeItemViewModel = viewModel{ ResumeItemViewModel(OtherOtherResumeItemRepositoryImpl(OtherResumeItemManager)) }

    val contactViewModel = viewModel{ ContactViewModel(ContactRepositoryImpl(ContactManager)) }

    val languageViewModel = viewModel{ LanguageViewModel(LanguageRepositoryImpl(LanguageManager)) }

    val skillViewModel = viewModel{ SkillViewModel(SkillRepositoryImpl(SkillManager)) }

    NavHost(
        navController = navController,
        startDestination = NavigationScreens.Home.route
    ){
        composable(route = NavigationScreens.Home.route){
            val jobExperienceUiState by jobExperienceViewModel.uiState.collectAsStateWithLifecycle()
            val resumeItemUiState by resumeItemViewModel.uiState.collectAsStateWithLifecycle()

            ResumeScreen(
                jobExperienceUiState = jobExperienceUiState,
                resumeItemUiState = resumeItemUiState,
                onJobExperienceClick = { jobExperience ->
                    navController.navigate(NavigationScreens.JobExperience.createRoute(jobExperience.id))
                },
                onResumeItemClick = {}
            )
        }

        composable(route = "${NavigationScreens.JobExperience.route}/{id}"){ backStackEntry ->
            val idFromPath = backStackEntry.arguments?.getString("id")?.toLongOrNull()!!
            val jobExperience = jobExperienceViewModel.getJobExperienceById(idFromPath)

            DetailJobExperienceScreen(jobExperience = jobExperience)
        }

        composable(route = NavigationScreens.Contact.route){
            val contactUiState by contactViewModel.uiState.collectAsStateWithLifecycle()
            ContactScreen(contactUiState = contactUiState)
        }

        composable(route = NavigationScreens.Languages.route){
            val languageUiState by languageViewModel.uiState.collectAsStateWithLifecycle()
            LanguageScreen(languageUiState = languageUiState)
        }

        composable(route = NavigationScreens.Skills.route){
            val skillUiState by skillViewModel.uiState.collectAsStateWithLifecycle()
            SkillScreen(skillUiState = skillUiState)
        }
    }
}