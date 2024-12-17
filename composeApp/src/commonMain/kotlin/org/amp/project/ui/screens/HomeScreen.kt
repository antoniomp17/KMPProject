package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.JobExperienceItem
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.presentation.ThemeUiState
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb

@Composable
fun HomeScreen(jobExperienceUiState: JobExperienceUiState,
               resumeItemUiState: ResumeItemUiState,
               themeUiState: ThemeUiState,
               onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit
) {
    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    PutVerticalScrollbarIfWeb(
        state = state,
        themeUiState = themeUiState
    ){
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(start = 16.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            JobsComposable(
                jobExperienceList = jobExperienceUiState.jobExperiences,
                themeUiState = themeUiState,
                onJobExperienceClick = onJobExperienceClick)
            ResumeItemsComposable(resumeItemList = resumeItemUiState.projectResumeItems)
            ResumeItemsComposable(resumeItemList = resumeItemUiState.educationResumeItems)
            ResumeItemsComposable(resumeItemList = resumeItemUiState.certificateResumeItems)
        }
    }
}