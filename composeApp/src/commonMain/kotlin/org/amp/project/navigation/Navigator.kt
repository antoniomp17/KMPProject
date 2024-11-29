package org.amp.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel
import org.amp.project.data.JobExperienceManager
import org.amp.project.data.JobExperienceRepositoryImpl
import org.amp.project.data.ResumeItemManager
import org.amp.project.data.ResumeItemRepositoryImpl
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.presentation.ResumeItemViewModel
import org.amp.project.ui.ResumeScreen

@Composable
fun Navigation(navigator: Navigator) {

    val jobExperienceViewModel = viewModel(modelClass = JobExperienceViewModel::class) {
        JobExperienceViewModel(repo = JobExperienceRepositoryImpl(JobExperienceManager))
    }
    val resumeItemViewModel = viewModel(modelClass = ResumeItemViewModel::class) {
        ResumeItemViewModel(repo = ResumeItemRepositoryImpl(ResumeItemManager))
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
            val idFromPath = backStackEntry.path<Long>("id")
        }

        scene(route = "/resumeItem/{id}"){

        }

    }

}