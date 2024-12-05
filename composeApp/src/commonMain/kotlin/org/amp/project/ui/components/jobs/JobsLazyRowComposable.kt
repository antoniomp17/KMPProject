package org.amp.project.ui.components.jobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.amp.project.model.JobExperienceItem


@Composable
fun JobsLazyRowComposable(jobExperienceList: List<JobExperienceItem>,
                          onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(jobExperienceList) { jobExperience ->
            JobItemComposable(jobExperience = jobExperience, onJobExperienceClick = onJobExperienceClick)
        }
    }
}