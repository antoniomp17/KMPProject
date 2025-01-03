package org.amp.project.ui.components.download

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.core.rememberScrollAreaState
import composeResources.Res
import composeResources.amp_logo
import composeResources.download_app
import composeResources.download_app_apk
import composeResources.download_app_description
import composeResources.go_to_webapp
import composeResources.visit_webapp
import composeResources.visit_webapp_description
import org.amp.project.data.utils.Links
import org.amp.project.presentation.ThemeUiState
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DownloadContent(
    isWeb: Boolean,
    themeUiState: ThemeUiState,
){

    val uriHandler = LocalUriHandler.current

    val scrollState = rememberScrollState()
    val state = rememberScrollAreaState(scrollState)

    PutVerticalScrollbarIfWeb(
        state = state,
        themeUiState = themeUiState
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(Res.drawable.amp_logo),
                contentDescription = stringResource(Res.string.amp_logo),
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = if(isWeb){
                    stringResource(Res.string.download_app)
                } else stringResource(Res.string.visit_webapp),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text =  if(isWeb){
                    stringResource(Res.string.download_app_description)
                } else stringResource(Res.string.visit_webapp_description),
                style = MaterialTheme.typography.bodyLarge,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            FilledTonalButton(
                onClick = {
                    if(isWeb){
                        uriHandler.openUri(Links.APK_LINK)
                    } else uriHandler.openUri(Links.WEB_APP)

                }
            ){
                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Icon(
                        imageVector = if(isWeb){
                            Icons.Default.Download
                        } else Icons.Default.Web,
                        contentDescription = Icons.Default.Web.name
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text =  if(isWeb){
                            stringResource(Res.string.download_app_apk)
                        } else stringResource(Res.string.go_to_webapp),
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}