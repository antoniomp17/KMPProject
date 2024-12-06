package org.amp.project.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.amp_logo
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.rememberNavigator
import org.amp.project.data.utils.Links
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.navigation.Navigation
import org.amp.project.ui.components.navigationDrawer.NavigationDrawerContent
import org.amp.project.ui.utils.CoilImageComposable
import org.amp.project.ui.utils.GetTopBarType
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val navigator = rememberNavigator()
    val topBarType = GetTopBarType(navigator)
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerContent(
                drawerState = drawerState,
                onLanguageClick = {
                    navigator.navigate("/languages")
                },
                onContactClick = {
                    navigator.navigate("/contact")
                },
                onSkillsClick = {
                    navigator.navigate("/skills")
                }
            )
        }
    ) {
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
                                    onClick = {
                                        scope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    }
                                ) {
                                    CoilImageComposable(
                                        modifier = Modifier
                                            .clip(CircleShape),
                                        imageUrl = Links.AMP_IMAGE_LINK)
                                }
                            }
                            else -> {
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
                    scrollBehavior = scrollBehavior
                )
            }
        ) { paddingValues ->
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