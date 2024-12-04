package org.amp.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.model.JobExperience
import org.amp.project.model.ResumeItem
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.ResumeItemUiState

@Composable
fun ResumeScreen(jobExperienceUiState: JobExperienceUiState,
                 resumeItemUiState: ResumeItemUiState,
                 onJobExperienceClick: (jobExperience: JobExperience) -> Unit,
                 onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        JobExperienceComposable(jobExperienceList = jobExperienceUiState.jobExperiences, onJobExperienceClick = onJobExperienceClick)
        ResumeComposable(resumeItemList = resumeItemUiState.projectResumeItems, onResumeItemClick = onResumeItemClick)
        ResumeComposable(resumeItemList = resumeItemUiState.educationResumeItems, onResumeItemClick = onResumeItemClick)
        ResumeComposable(resumeItemList = resumeItemUiState.certificateResumeItems, onResumeItemClick = onResumeItemClick)
    }
}