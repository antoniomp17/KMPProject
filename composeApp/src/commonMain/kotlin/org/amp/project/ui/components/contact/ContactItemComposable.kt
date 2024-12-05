package org.amp.project.ui.components.contact

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.amp.project.model.ContactItem
import org.amp.project.ui.theme.primaryLight
import org.amp.project.ui.utils.getIconForType

@Composable
fun ContactComposable(contactItem: ContactItem){

    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f)
            .padding(2.dp)
            .clickable(enabled = contactItem.url != null){
                contactItem.url?.let { uriHandler.openUri(it) }
            },
        border = CardDefaults.outlinedCardBorder(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)){

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .clip(CircleShape),
                painter = getIconForType(contactItem.type),
                contentDescription = contactItem.type.name
            )

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = contactItem.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    color = primaryLight
                )
                if(contactItem.data != null){
                    Text(
                        text = contactItem.data,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Light,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}