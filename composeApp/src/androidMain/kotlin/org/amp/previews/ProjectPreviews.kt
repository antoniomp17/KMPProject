package org.amp.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.akkodis_svg_url
import composeResources.bmed_image_url
import composeResources.ntt_svg_url
import org.amp.project.model.JobExperience
import org.amp.project.ui.ExperienceComposable
import org.amp.project.ui.ResumeItem
import org.amp.project.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Preview(showBackground = true)
@Composable
fun JobsCarouselPreview() {

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

    AppTheme {
        Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
            ExperienceComposable(listOf(jobExperience))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumeItemPreview() {
    AppTheme {
        Box(modifier = Modifier.padding(8.dp).fillMaxSize()) {
            ResumeItem("Text")
        }
    }
}