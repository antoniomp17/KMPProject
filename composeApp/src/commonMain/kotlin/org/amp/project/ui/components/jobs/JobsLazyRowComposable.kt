package org.amp.project.ui.components.jobs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.utils.PutHorizontalScrollbarIfWeb


@Composable
fun JobsLazyRowComposable(jobExperienceList: List<JobExperienceItem>,
                          onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit){

    val lazyListState = rememberLazyListState()
    val state = rememberScrollAreaState(lazyListState)

    PutHorizontalScrollbarIfWeb(state = state){
        LazyRow(
            state = lazyListState,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(jobExperienceList) { jobExperience ->
                JobItemComposable(
                    jobExperience = jobExperience,
                    onJobExperienceClick = onJobExperienceClick
                )
            }
        }
    }
}