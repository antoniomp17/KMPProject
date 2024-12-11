package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.model.JobExperienceItem
import org.amp.project.model.ResumeItem
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable

@Composable
fun ResumeScreen(jobExperienceUiState: JobExperienceUiState,
                 resumeItemUiState: ResumeItemUiState,
                 onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit,
                 onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        JobsComposable(jobExperienceList = jobExperienceUiState.jobExperiences, onJobExperienceClick = onJobExperienceClick)
        ResumeItemsComposable(resumeItemList = resumeItemUiState.projectResumeItems, onResumeItemClick = onResumeItemClick)
        ResumeItemsComposable(resumeItemList = resumeItemUiState.educationResumeItems, onResumeItemClick = onResumeItemClick)
        ResumeItemsComposable(resumeItemList = resumeItemUiState.certificateResumeItems, onResumeItemClick = onResumeItemClick)
    }
}