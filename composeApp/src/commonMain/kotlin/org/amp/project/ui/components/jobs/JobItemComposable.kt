package org.amp.project.ui.components.jobs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
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
import org.amp.project.model.JobExperience
import org.amp.project.ui.utils.FailureLoadingImage
import org.amp.project.ui.theme.primaryLight
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun JobItemComposable(jobExperience: JobExperience, onJobExperienceClick: (jobExperience: JobExperience) -> Unit){

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