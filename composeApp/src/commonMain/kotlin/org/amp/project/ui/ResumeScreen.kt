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
import composeResources.akkodis_svg_url
import composeResources.bmed_image_url
import composeResources.certifications
import composeResources.education
import composeResources.experience
import composeResources.ntt_svg_url
import composeResources.personal_projects
import org.amp.project.model.JobExperience
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResumeScreen() {
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
        val jobExperience = JobExperience(
            id = -1,
            companyName = "Akkodis",
            companyImageUrl = stringResource(Res.string.akkodis_svg_url),
            clientName = "NTT Data",
            clientImageUrl = stringResource(Res.string.ntt_svg_url),
            location = "Remote",
            startDate = "2023-07-01",
            endDate= "2024-10-01",
            imageSmallUrl = stringResource(Res.string.bmed_image_url),
            imageLargeUrl = stringResource(Res.string.bmed_image_url),
            description = ""
        )
        ExperienceComposable(listOf(jobExperience))

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