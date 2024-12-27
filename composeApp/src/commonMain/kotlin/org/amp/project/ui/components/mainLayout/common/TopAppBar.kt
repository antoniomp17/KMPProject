package org.amp.project.ui.components.mainLayout.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalUriHandler
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.amp_logo
import org.amp.project.data.utils.Links
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.data.utils.isWeb
import org.amp.project.presentation.ThemeViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    scrollBehavior: TopAppBarScrollBehavior? = null,
    topBarType: TopBarTypes? = null,
    navigator: NavHostController? = null,
    themeViewModel: ThemeViewModel = koinViewModel<ThemeViewModel> { parametersOf() }
) {
    val themeUiState by themeViewModel.uiState.collectAsStateWithLifecycle()

    val uriHandler = LocalUriHandler.current

    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(Res.drawable.amp_logo),
                contentDescription = stringResource(Res.string.amp_logo)
            )
        },
        navigationIcon = {
            if(topBarType != null){
                if(topBarType == TopBarTypes.JOB_DESCRIPTION) {
                    IconButton(onClick = {
                        navigator?.popBackStack()
                    }){
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = Icons.AutoMirrored.Default.ArrowBack.name
                        )
                    }
                }
            }
        },
        actions = {
            Row{
                if(themeUiState.theme?.isDarkTheme == true){
                    IconButton(onClick = {
                        themeViewModel.changeTheme(false)
                    }){
                        Icon(
                            imageVector = Icons.Default.LightMode,
                            contentDescription = Icons.Default.LightMode.name
                        )
                    }
                } else {
                    IconButton(onClick = {
                        themeViewModel.changeTheme(true)
                    }){
                        Icon(
                            imageVector = Icons.Default.DarkMode,
                            contentDescription = Icons.Default.DarkMode.name
                        )
                    }
                }
                if(!isWeb()){
                    IconButton(onClick = {
                        uriHandler.openUri(Links.WEB_APP)
                    }){
                        Icon(
                            imageVector = Icons.Default.Web,
                            contentDescription = Icons.Default.Web.name
                        )
                    }
                } else {
                    IconButton(onClick = {
                        uriHandler.openUri(Links.APK_LINK)
                    }){
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = Icons.Default.Download.name
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}