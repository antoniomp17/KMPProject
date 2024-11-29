package org.amp.project.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.amp.project.model.ResumeItem
import org.amp.project.ui.theme.onBackgroundLight
import org.amp.project.ui.theme.onSurfaceLight
import org.amp.project.ui.theme.primaryLight

@Composable
fun ResumeComposable(
    resumeItemList: List<ResumeItem>,
    onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = resumeItemList[0].type.title,
            color = onBackgroundLight
        )
        Spacer(modifier = Modifier.height(4.dp))
        ResumeLazyColumnComposable(resumeItemList, onResumeItemClick)
    }
}

@Composable
private fun ResumeLazyColumnComposable(
    resumeItemList: List<ResumeItem>,
    onResumeItemClick: (resumeItem: ResumeItem) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2.8f/resumeItemList.size),
        userScrollEnabled = false
    ){
        items(resumeItemList) {
            ResumeItem(resumeItem = it, onResumeItemClick)
        }
    }
}

@Composable
private fun ResumeItem(
    resumeItem: ResumeItem,
    onResumeItemClick: (resumeItem: ResumeItem) -> Unit
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f)
            .padding(2.dp)
            .clickable{onResumeItemClick(resumeItem)},
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)){

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            CoilImage(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .clip(CircleShape),
                imageModel = { resumeItem.itemImageUrl },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop
                ),
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            )

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = resumeItem.itemName,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    color = primaryLight
                )
                Text(
                    text = resumeItem.siteName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 0.5.sp
                )
                if(resumeItem.location.isNotEmpty()){
                    Text(
                        text = resumeItem.location,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light,
                        letterSpacing = 0.5.sp
                    )
                }
                Text(
                    text = "${resumeItem.startDate} ${
                        if(resumeItem.startDate != resumeItem.endDate){
                            "- " + resumeItem.endDate
                        } else {
                            ""
                        }
                    }",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 0.5.sp
                )
            }
        }

    }
}