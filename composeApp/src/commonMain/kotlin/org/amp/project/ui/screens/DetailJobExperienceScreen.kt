package org.amp.project.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.composables.core.ScrollArea
import com.composables.core.Thumb
import com.composables.core.VerticalScrollbar
import com.composables.core.rememberScrollAreaState
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.components.jobDetail.JobDescription
import org.amp.project.ui.components.jobDetail.JobDetailsRow
import org.amp.project.ui.components.jobDetail.JobDuration
import org.amp.project.ui.components.jobDetail.JobPosition
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable
import org.amp.project.ui.theme.outlineLight
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun DetailJobExperienceScreen(
    jobExperience: JobExperienceItem
) {
    val richTextState = rememberRichTextState()
    richTextState.setMarkdown(jobExperience.description)

    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    ScrollArea(
        state = state
    ) {
        Row{
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                JobPosition(jobExperience.position)
                JobDetailsRow(jobExperience.companyName, jobExperience.clientName)
                JobDuration(jobExperience.startDate, jobExperience.endDate)

                Spacer(modifier = Modifier.height(16.dp))
                CoilImageComposable(
                    modifier = Modifier
                        .clip(RoundedCornerShape(percent = 10))
                        .fillMaxWidth()
                        .aspectRatio(2f),
                    imageUrl = jobExperience.image)

                Spacer(modifier = Modifier.height(16.dp))
                JobDescription(richTextState)
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.TopEnd)
                    .fillMaxHeight()
                    .width(8.dp)
            ) {
                Thumb(Modifier.background(outlineLight, RoundedCornerShape(100)))
            }
        }
    }
}