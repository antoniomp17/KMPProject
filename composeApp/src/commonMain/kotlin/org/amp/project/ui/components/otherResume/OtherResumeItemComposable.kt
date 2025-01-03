package org.amp.project.ui.components.otherResume

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.amp.project.model.ResumeItem
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun ResumeItemComposable(
    resumeItem: ResumeItem
){
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f)
            .sizeIn(maxHeight = 64.dp)
            .padding(2.dp)
            .clickable{
                resumeItem.link.let { url -> uriHandler.openUri(url) }
            },
        border = CardDefaults.outlinedCardBorder()
    ){

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            CoilImageComposable(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .clip(CircleShape),
                imageUrl = resumeItem.itemImageUrl)

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
                    textAlign = TextAlign.Center
                )
                Text(
                    text = resumeItem.siteName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center
                )
                if(resumeItem.location.isNotEmpty()){
                    Text(
                        text = resumeItem.location,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
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
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}