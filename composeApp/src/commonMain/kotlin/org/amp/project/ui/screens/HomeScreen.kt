package org.amp.project.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.core.ScrollArea
import com.composables.core.Thumb
import com.composables.core.VerticalScrollbar
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.JobExperienceItem
import org.amp.project.model.ResumeItem
import org.amp.project.presentation.JobExperienceUiState
import org.amp.project.presentation.ResumeItemUiState
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable
import org.amp.project.ui.theme.outlineLight
import org.amp.project.ui.theme.outlineVariantDark

@Composable
fun HomeScreen(jobExperienceUiState: JobExperienceUiState,
               resumeItemUiState: ResumeItemUiState,
               onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit
) {
    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    ScrollArea(
        state = state
    ) {
        Row(modifier = Modifier.padding(end = 8.dp)){
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .weight(1f)
                    .padding(start = 16.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                JobsComposable(jobExperienceList = jobExperienceUiState.jobExperiences, onJobExperienceClick = onJobExperienceClick)
                ResumeItemsComposable(resumeItemList = resumeItemUiState.projectResumeItems)
                ResumeItemsComposable(resumeItemList = resumeItemUiState.educationResumeItems)
                ResumeItemsComposable(resumeItemList = resumeItemUiState.certificateResumeItems)
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.TopEnd)
                    .fillMaxHeight()
                    .width(8.dp)
                    .background(outlineVariantDark, RoundedCornerShape(100))
            ) {
                Thumb(Modifier.background(outlineLight, RoundedCornerShape(100)))
            }
        }
    }
}