package org.amp.project.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.core.ScrollArea
import com.composables.core.Thumb
import com.composables.core.VerticalScrollbar
import com.composables.core.rememberScrollAreaState
import composeResources.Res
import composeResources.amp_logo
import composeResources.name
import composeResources.profile_image
import org.amp.project.presentation.ContactUiState
import org.amp.project.ui.components.contact.PhoneMailLazyColumnComposable
import org.amp.project.ui.components.contact.SocialLazyGridComposable
import org.amp.project.ui.components.jobs.JobsComposable
import org.amp.project.ui.components.otherResume.ResumeItemsComposable
import org.amp.project.ui.theme.outlineLight
import org.amp.project.ui.theme.outlineVariantDark
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ContactScreen(contactUiState: ContactUiState){

    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    PutVerticalScrollbarIfWeb(
        state = state
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.profile_image),
                contentDescription = stringResource(Res.string.amp_logo),
                modifier = Modifier.size(192.dp)
            )
            Text(
                text = stringResource(Res.string.name),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Center
            )
            PhoneMailLazyColumnComposable(phoneMailItemList = contactUiState.phoneMails)
            SocialLazyGridComposable(socialItemList = contactUiState.socials)
        }
    }
}