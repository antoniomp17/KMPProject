package org.amp.project.ui.components.jobs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.amp.project.model.JobExperienceItem
import org.amp.project.ui.theme.outlineVariantLight
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun JobItemComposable(jobExperience: JobExperienceItem, onJobExperienceClick: (jobExperience: JobExperienceItem) -> Unit){

    Card(
        modifier = Modifier
            .size(192.dp)
            .clickable{onJobExperienceClick(jobExperience)},
        border = CardDefaults.outlinedCardBorder()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ){
            CoilImageComposable(
                modifier = Modifier
                    .clip(RoundedCornerShape(percent = 10))
                    .fillMaxWidth()
                    .weight(3f)
                ,
                imageUrl = jobExperience.image
            )

            Text(
                modifier = Modifier.weight(0.5f),
                text = jobExperience.companyName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )

            Text(
                modifier = Modifier.weight(0.5f),
                text = jobExperience.clientName,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light,
                letterSpacing = 0.5.sp
            )
        }
    }
}