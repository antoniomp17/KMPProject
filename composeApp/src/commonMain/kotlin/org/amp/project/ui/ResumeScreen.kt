package org.amp.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.certifications
import composeResources.education
import composeResources.experience
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
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.experience)
        )
        ExperienceComposable(
            jobExperienceList = uiState.jobExperiences,
            onJobExperienceClick = onJobExperienceClick
        )

        HorizontalDivider()

        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.personal_projects)
        )
        ResumeComposable(listOf("Text"))

        HorizontalDivider()

        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.education)
        )
        ResumeComposable(listOf("Text"))

        HorizontalDivider()

        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.certifications)
        )
        ResumeComposable(listOf("Text", "Text"))
    }
}