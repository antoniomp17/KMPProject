package org.amp.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel
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
fun Navigation(navigator: Navigator) {

    val jobExperienceViewModel = viewModel(modelClass = JobExperienceViewModel::class) {
        JobExperienceViewModel(repo = JobExperienceRepositoryImpl(JobExperienceManager))
    }
    val resumeItemViewModel = viewModel(modelClass = ResumeItemViewModel::class) {
        ResumeItemViewModel(repo = OtherOtherResumeItemRepositoryImpl(OtherResumeItemManager))
    }
    val contactViewModel = viewModel(modelClass = ContactViewModel::class) {
        ContactViewModel(repo = ContactRepositoryImpl(ContactManager))
    }
    val languageViewModel = viewModel(modelClass = LanguageViewModel::class) {
        LanguageViewModel(repo = LanguageRepositoryImpl(LanguageManager))
    }
    val skillViewModel = viewModel(modelClass = SkillViewModel::class) {
        SkillViewModel(repo = SkillRepositoryImpl(SkillManager))
    }

    NavHost(
         navigator = navigator, initialRoute = "/home"
    ){
        scene(route = "/home"){
            val jobExperienceUiState by jobExperienceViewModel.uiState.collectAsStateWithLifecycle()
            val resumeItemUiState by resumeItemViewModel.uiState.collectAsStateWithLifecycle()

            ResumeScreen(
                jobExperienceUiState = jobExperienceUiState,
                resumeItemUiState = resumeItemUiState,
                onJobExperienceClick = { jobExperience ->
                    navigator.navigate("/jobExperience/${jobExperience.id}")
                },
                onResumeItemClick = { resumeItem ->
                    navigator.navigate("/resumeItem/${resumeItem.id}")
                }
            )
        }

        scene(route = "/jobExperience/{id}"){ backStackEntry ->
            val idFromPath = backStackEntry.path<Long>("id")!!
            val jobExperience = jobExperienceViewModel.getJobExperienceById(idFromPath)

            DetailJobExperienceScreen(jobExperience = jobExperience)
        }

        scene(route = "/contact"){
            val contactUiState by contactViewModel.uiState.collectAsStateWithLifecycle()
            ContactScreen(contactUiState = contactUiState)
        }

        scene(route = "/languages"){
            val languageUiState by languageViewModel.uiState.collectAsStateWithLifecycle()
            LanguageScreen(languageUiState = languageUiState)
        }

        scene(route = "/skills"){
            val skillUiState by skillViewModel.uiState.collectAsStateWithLifecycle()
            SkillScreen(skillUiState = skillUiState)
        }
    }
}