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
import composeResources.Res
import composeResources.certifications
import composeResources.education
import composeResources.personal_projects
import org.amp.project.model.JobExperience
import org.amp.project.presentation.JobExperienceUiState
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResumeScreen(uiState: JobExperienceUiState, onJobExperienceClick: (jobExperience: JobExperience) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        ExperienceComposable(jobExperienceList = uiState.jobExperiences, onJobExperienceClick = onJobExperienceClick)
        ResumeComposable(stringResource(Res.string.personal_projects), listOf("Text"))
        ResumeComposable(stringResource(Res.string.education), listOf("Text"))
        ResumeComposable(stringResource(Res.string.certifications), listOf("Text"))
    }
}