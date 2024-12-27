package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.JobExperienceItem
import org.amp.project.presentation.JobExperienceViewModel
import org.amp.project.presentation.ResumeItemViewModel
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun HomeScreen(
    onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit,
    jobExperienceViewModel: JobExperienceViewModel = koinViewModel<JobExperienceViewModel> { parametersOf() },
    resumeItemViewModel: ResumeItemViewModel = koinViewModel<ResumeItemViewModel> { parametersOf() }
) {
    val jobExperienceUiState by jobExperienceViewModel.uiState.collectAsStateWithLifecycle()
    val resumeItemUiState by resumeItemViewModel.uiState.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    PutVerticalScrollbarIfWeb(
        state = state
    ){
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(start = 16.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            JobsComposable(
                jobExperienceList = jobExperienceUiState.jobExperiences,
                onJobExperienceClick = onJobExperienceClick
            )
            ResumeItemsComposable(resumeItemList = resumeItemUiState.projectResumeItems)
            ResumeItemsComposable(resumeItemList = resumeItemUiState.educationResumeItems)
            ResumeItemsComposable(resumeItemList = resumeItemUiState.certificateResumeItems)
        }
    }
}