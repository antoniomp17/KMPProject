package org.amp.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.amp.project.data.JobExperienceManager
import org.amp.project.model.JobExperience

@Composable
fun ExperienceComposable(onJobExperienceClick: (jobExperience: JobExperience) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(JobExperienceManager.fakeJobExperienceList) {
            JobItem(jobExperience = it, onClick = onJobExperienceClick)
        }
    }
}

@Composable
fun JobItem(jobExperience: JobExperience, onClick: (jobExperience: JobExperience) -> Unit){

    Card(
        modifier = Modifier
            .width(198.dp)
            .aspectRatio(1.2f)
            .padding(2.dp)
            .clickable { onClick(jobExperience) },
        shape = RoundedCornerShape(percent = 30),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){

        Box(modifier = Modifier.fillMaxSize()){

            CoilImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = { jobExperience.imageSmallUrl },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround
            ){
                if(jobExperience.companyImageUrl.isNotEmpty()){
                    CoilImage(
                        imageModel = {  jobExperience.companyImageUrl },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Fit
                        )
                    )
                }
                if(jobExperience.clientImageUrl.isNotEmpty()){
                    CoilImage(
                        imageModel = {  jobExperience.clientImageUrl },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Fit
                        )
                    )
                }
            }
        }
    }
}