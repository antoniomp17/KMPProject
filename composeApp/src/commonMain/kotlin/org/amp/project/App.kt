package org.amp.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import composeResources.Res
import composeResources.amp_logo
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import org.amp.project.ui.theme.AppTheme
import org.amp.project.data.Links
import org.amp.project.data.TopBarTypes
import org.amp.project.navigation.Navigation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    PreComposeApp{
        AppTheme {

            val navigator = rememberNavigator()
            val topBarType = getTopBarType(navigator)

            // Crear el scrollBehavior para el TopAppBar
            val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Image(
                                painter = painterResource(Res.drawable.amp_logo),
                                contentDescription = stringResource(Res.string.amp_logo)
                            )
                        },
                        navigationIcon = {
                            when (topBarType) {
                                TopBarTypes.HOME -> {
                                    IconButton(
                                        modifier = Modifier.padding(start = 16.dp),
                                        onClick = { /* TODO: Acción del ícono */ }
                                    ) {
                                        CoilImage(
                                            modifier = Modifier
                                                .clip(CircleShape),
                                            imageModel = { Links.AMP_IMAGE_LINK },
                                            imageOptions = ImageOptions(
                                                contentScale = ContentScale.Crop
                                            ),
                                            loading = {
                                                Box(modifier = Modifier.matchParentSize()) {
                                                    CircularProgressIndicator(
                                                        modifier = Modifier.align(Alignment.Center)
                                                    )
                                                }
                                            },
                                            failure = {
                                                /* TODO: Acción de error en CoilImages */
                                            }
                                        )
                                    }
                                }
                                TopBarTypes.DETAILED_INFO -> {
                                    IconButton(
                                        modifier = Modifier.padding(start = 16.dp),
                                        onClick = { /* TODO: Acción del ícono */ }
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                            contentDescription = Icons.AutoMirrored.Default.ArrowBack.name
                                        )
                                    }
                                }
                            }
                        },
                        scrollBehavior = scrollBehavior // Asociar el comportamiento de scroll al TopAppBar
                    )
                }
            ) { paddingValues ->
                // Contenido principal de la pantalla
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Navigation(navigator)
                }
            }
        }
    }
}

@Composable
fun getTopBarType(navigator: Navigator): TopBarTypes {
    var topBarType = TopBarTypes.HOME

    val currentNavigatorEntry = navigator.currentEntry.collectAsState(null).value

    val isOnDetailedInfo = currentNavigatorEntry?.route?.equals("/jobExperience/{id}") == true
            || currentNavigatorEntry?.route?.equals("/resumeItem/{id}") == true

    if(isOnDetailedInfo){
        topBarType = TopBarTypes.DETAILED_INFO
    }

    return topBarType
}