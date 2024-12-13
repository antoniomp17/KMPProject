package org.amp.project.ui.components.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.core.HorizontalScrollbar
import com.composables.core.ScrollArea
import com.composables.core.Thumb
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.theme.outlineLight
import org.amp.project.ui.theme.outlineVariantDark


@Composable
fun JobsLazyRowComposable(jobExperienceList: List<JobExperienceItem>,
                          onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit){

    val lazyListState = rememberLazyListState()
    val state = rememberScrollAreaState(lazyListState)

    ScrollArea(
        state = state
    ) {
        Column{
            LazyRow(
                state = lazyListState,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(jobExperienceList) { jobExperience ->
                    JobItemComposable(jobExperience = jobExperience, onJobExperienceClick = onJobExperienceClick)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalScrollbar(
                modifier = Modifier.align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(12.dp)
                    .background(outlineVariantDark, RoundedCornerShape(100))
            ) {
                Thumb(Modifier.background(outlineLight, RoundedCornerShape(100)))
            }
        }
    }
}