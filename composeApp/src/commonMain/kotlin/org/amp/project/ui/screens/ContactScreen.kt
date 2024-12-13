package org.amp.project.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composeResources.Res
import composeResources.contact
import org.amp.project.presentation.ContactUiState
import org.amp.project.ui.components.contact.PhoneMailLazyColumnComposable
import org.amp.project.ui.components.contact.SocialLazyGridComposable
import org.jetbrains.compose.resources.stringResource

@Composable
fun ContactScreen(contactUiState: ContactUiState){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PhoneMailLazyColumnComposable(phoneMailItemList = contactUiState.phoneMails)
        SocialLazyGridComposable(socialItemList = contactUiState.socials)
    }
}