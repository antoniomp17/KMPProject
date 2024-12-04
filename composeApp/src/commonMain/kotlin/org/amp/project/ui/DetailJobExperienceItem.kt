package org.amp.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichText
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import composeResources.Res
import composeResources.client
import composeResources.company
import composeResources.duration
import composeResources.position
import org.amp.project.model.JobExperience
import org.amp.project.ui.theme.FailureLoadingImage
import org.amp.project.ui.theme.primaryLight
import org.jetbrains.compose.resources.stringResource

@Composable
fun DetailJobExperienceItem(
    jobExperience: JobExperience
){
    val richTextState = rememberRichTextState()
    richTextState.setMarkdown(jobExperience.description)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${stringResource(Res.string.position)}: ${jobExperience.position}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Text(
                text = "${stringResource(Res.string.company)}: ${jobExperience.companyName}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )

            if(jobExperience.clientName.isNotEmpty()){
                Text(
                    text = "${stringResource(Res.string.client)}: ${jobExperience.clientName}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${stringResource(Res.string.duration)}: " +
                    "${jobExperience.startDate} ${
                if(jobExperience.startDate != jobExperience.endDate){
                    "- " + jobExperience.endDate
                } else {
                    ""
                }
            }",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Light,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        CoilImage(
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 10))
                .fillMaxWidth()
                .aspectRatio(2f),
            imageModel = {  jobExperience.image },
            loading = {
                Box(modifier = Modifier. matchParentSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            failure = {
                FailureLoadingImage()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        RichText(
            state = richTextState,
            style = MaterialTheme.typography.bodyMedium,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Justify
        )
    }
}