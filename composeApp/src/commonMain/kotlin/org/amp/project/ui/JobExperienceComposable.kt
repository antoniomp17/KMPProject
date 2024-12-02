package org.amp.project.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.coil3.CoilImage
import composeResources.Res
import composeResources.experience
import composeResources.image_loaded
import org.amp.project.model.JobExperience
import org.amp.project.ui.theme.FailureLoadingImage
import org.amp.project.ui.theme.onBackgroundLight
import org.amp.project.ui.theme.primaryLight
import org.jetbrains.compose.resources.stringResource

@Composable
fun ExperienceComposable(
    jobExperienceList: List<JobExperience>,
    onJobExperienceClick: (jobExperience: JobExperience) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.experience),
            color = onBackgroundLight
        )
        Spacer(modifier = Modifier.height(4.dp))
        ExperienceLazyRowComposable(
            jobExperienceList = jobExperienceList,
            onJobExperienceClick = onJobExperienceClick
        )
    }
}

@Composable
private fun ExperienceLazyRowComposable(jobExperienceList: List<JobExperience>,
                                onJobExperienceClick: (jobExperience: JobExperience) -> Unit){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(jobExperienceList) { jobExperience ->
            JobItem(jobExperience = jobExperience, onJobExperienceClick = onJobExperienceClick)
        }
    }
}

@Composable
private fun JobItem(jobExperience: JobExperience, onJobExperienceClick: (jobExperience: JobExperience) -> Unit){

    Column(
        modifier = Modifier
        .width(192.dp)
        .aspectRatio(1.2f)
        .clickable { onJobExperienceClick(jobExperience) }
    ){
        CoilImage(
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 10))
                .fillMaxWidth()
                .weight(1f),
            imageModel = {  jobExperience.image },
            loading = {
                Box(modifier = Modifier. matchParentSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            success = { _, painter ->
                Image(
                    painter = painter,
                    contentDescription = stringResource(Res.string.image_loaded),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            failure = {
                FailureLoadingImage()
            }
        )

        Text(
            text = jobExperience.companyName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
            color = primaryLight
        )

        Text(
            text = jobExperience.clientName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            letterSpacing = 0.5.sp
        )
    }
}