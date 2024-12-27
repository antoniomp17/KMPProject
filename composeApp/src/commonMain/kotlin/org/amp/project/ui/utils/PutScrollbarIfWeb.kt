package org.amp.project.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.composables.core.HorizontalScrollbar
import com.composables.core.ScrollArea
import com.composables.core.ScrollAreaState
import com.composables.core.Thumb
import com.composables.core.VerticalScrollbar
import org.amp.project.data.utils.isWeb
import org.amp.project.presentation.ThemeViewModel
import org.amp.project.ui.theme.outlineDark
import org.amp.project.ui.theme.outlineLight
import org.amp.project.ui.theme.outlineVariantDark
import org.amp.project.ui.theme.outlineVariantLight
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PutHorizontalScrollbarIfWeb(
    state: ScrollAreaState,
    themeViewModel: ThemeViewModel = koinViewModel<ThemeViewModel> { parametersOf() },
    composable: @Composable () -> Unit
) {
    val themeUiState by themeViewModel.uiState.collectAsStateWithLifecycle()

    if(!isWeb()){
        composable()
    } else {
        ScrollArea(
    state = state
        ) {
            Column{
                composable()
                Spacer(modifier = Modifier.height(4.dp))
                HorizontalScrollbar(
                    modifier = Modifier.align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .height(12.dp)
                        .background(
                            color = if(themeUiState.theme?.isDarkTheme == true){
                                outlineVariantDark
                            } else outlineVariantLight,
                            shape = RoundedCornerShape(100)
                        )
            ) {
                    Thumb(modifier = Modifier
                        .background(
                            color = if(themeUiState.theme?.isDarkTheme == true){
                                outlineDark
                            } else outlineLight,
                            shape = RoundedCornerShape(100)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun PutVerticalScrollbarIfWeb(
    state: ScrollAreaState,
    themeViewModel: ThemeViewModel = koinViewModel<ThemeViewModel> { parametersOf() },
    composable: @Composable () -> Unit
) {
    val themeUiState by themeViewModel.uiState.collectAsStateWithLifecycle()

    if(!isWeb()){
        composable()
    } else {
        ScrollArea(
            state = state
        ) {
            Row(modifier = Modifier.padding(end = 8.dp)){
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    composable()
                }
                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.TopEnd)
                        .fillMaxHeight()
                        .width(8.dp)
                        .background(
                            color = if(themeUiState.theme?.isDarkTheme == true){
                                outlineVariantDark
                            } else outlineVariantLight,
                            shape = RoundedCornerShape(100)
                        )
                ) {
                    Thumb(modifier = Modifier
                        .background(
                            color = if(themeUiState.theme?.isDarkTheme == true){
                                outlineDark
                            } else outlineLight,
                            shape = RoundedCornerShape(100)
                        )
                    )
                }
            }
        }
    }
}