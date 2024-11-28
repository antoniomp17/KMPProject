package org.amp.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.amp.project.model.JobExperience
import org.amp.project.ui.theme.inverseOnSurfaceLight
import org.amp.project.ui.theme.inverseSurfaceLight
import org.amp.project.ui.theme.surfaceLight

@Composable
fun ExperienceComposable(
    jobExperienceList: List<JobExperience>,
    onJobExperienceClick: (jobExperience: JobExperience) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(jobExperienceList) { jobExperience ->
            JobItem(jobExperience = jobExperience, onClick = onJobExperienceClick)
        }
    }
}

@Composable
fun JobItem(jobExperience: JobExperience, onClick: (jobExperience: JobExperience) -> Unit){

    Card(
        modifier = Modifier
            .width(128.dp)
            .aspectRatio(1.2f)
            .padding(2.dp)
            .clickable { onClick(jobExperience) }
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(percent = 25),
                clip = true
            ),
        shape = RoundedCornerShape(percent = 30),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){

        Box(modifier = Modifier.fillMaxSize()){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                        colors = listOf(
                            surfaceLight,
                            inverseSurfaceLight
                        )
                    ))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = if (jobExperience.clientName.isEmpty()) Arrangement.Center
                else Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f),
                    contentAlignment = Alignment.Center
                ) {
                    CoilImage(
                        imageModel = {  jobExperience.companyImageUrl },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Inside
                        )
                    )
                }

                Text(
                    text = jobExperience.clientName,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 0.5.sp,
                    color = inverseOnSurfaceLight
                )
            }
        }
    }
}