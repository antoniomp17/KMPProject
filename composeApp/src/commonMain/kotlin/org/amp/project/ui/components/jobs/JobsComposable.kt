package org.amp.project.ui.components.jobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.experience
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.theme.onBackgroundLight
import org.jetbrains.compose.resources.stringResource

@Composable
fun JobsComposable(
    jobExperienceList: List<JobExperienceItem>,
    onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit
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
        JobsLazyRowComposable(
            jobExperienceList = jobExperienceList,
            onJobExperienceClick = onJobExperienceClick
        )
    }
}

