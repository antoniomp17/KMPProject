package org.amp.project.ui.components.jobs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.theme.primaryLight
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun JobItemComposable(jobExperience: JobExperienceItem, onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit){

    Column(
        modifier = Modifier
        .width(192.dp)
        .aspectRatio(1.2f)
        .clickable { onJobExperienceClick(jobExperience) }
    ){
        CoilImageComposable(
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 10))
                .fillMaxWidth()
                .weight(1f),
            imageUrl = jobExperience.image)

        Text(
            text = jobExperience.companyName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )

        Text(
            text = jobExperience.clientName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            letterSpacing = 0.5.sp
        )
    }
}