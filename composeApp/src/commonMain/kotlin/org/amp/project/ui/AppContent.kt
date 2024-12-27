package org.amp.project.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import org.amp.project.data.utils.WindowSizeClass
import org.amp.project.presentation.ThemeViewModel
import org.amp.project.ui.layouts.CompactLayout
import org.amp.project.ui.layouts.ExpandedLayout
import org.amp.project.ui.layouts.MediumLayout
import org.amp.project.ui.theme.AppTheme
import org.amp.project.ui.utils.GetTopBarType
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(
    themeViewModel: ThemeViewModel = koinViewModel<ThemeViewModel> { parametersOf() }
) {
    val themeUiState by themeViewModel.uiState.collectAsStateWithLifecycle()

    val navigator = rememberNavController()
    val topBarType = GetTopBarType(navigator)
    val density = LocalDensity.current

    AppTheme(darkTheme = themeUiState.theme?.isDarkTheme ?: false){
        BoxWithConstraints {

            val screenWidthDp = with(density) {  constraints.maxWidth.toDp() }
            val screenHeightDp = with(density) {  constraints.maxHeight.toDp() }

            val windowSize = when {
                screenWidthDp > screenHeightDp -> WindowSizeClass.EXPANDED
                screenWidthDp <= screenHeightDp && screenWidthDp < 600.dp -> WindowSizeClass.COMPACT
                else -> WindowSizeClass.MEDIUM
            }

            when (windowSize) {
                WindowSizeClass.COMPACT -> {
                    CompactLayout(
                        navigator = navigator,
                        topBarType = topBarType,
                        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                    )
                }
                WindowSizeClass.MEDIUM -> {
                    MediumLayout(
                        navigator = navigator,
                        topBarType = topBarType
                    )
                }
                WindowSizeClass.EXPANDED -> {
                    ExpandedLayout(
                        navigator = navigator
                    )
                }
            }
        }
    }
}