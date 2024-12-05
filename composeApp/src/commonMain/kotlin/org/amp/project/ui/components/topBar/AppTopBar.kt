package org.amp.project.ui.components.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import composeResources.Res
import composeResources.amp_logo
import composeResources.image_loaded
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import org.amp.project.data.Links
import org.amp.project.data.TopBarTypes
import org.amp.project.ui.theme.FailureLoadingImage
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    topBarType: TopBarTypes,
    drawerState: DrawerState,
    scope: CoroutineScope,
    navigator: Navigator
) {
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
                        onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
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
                            success = { _, painter ->
                                Image(
                                    painter = painter,
                                    contentDescription = stringResource(Res.string.image_loaded),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            },
                            failure = {
                                FailureLoadingImage()
                            }
                        )
                    }
                }
                TopBarTypes.DETAILED_INFO -> {
                    IconButton(
                        modifier = Modifier.padding(start = 16.dp),
                        onClick = { navigator.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = Icons.AutoMirrored.Default.ArrowBack.name
                        )
                    }
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}