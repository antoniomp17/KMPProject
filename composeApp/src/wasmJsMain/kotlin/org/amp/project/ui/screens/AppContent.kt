package org.amp.project.ui.screens

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.amp.project.ui.components.topbar.WebTopBar

@Composable
actual fun AppContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        val stateVertical = rememberScrollState(0)

        WebTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f)
                .padding(12.dp),
            onContactClick = {},
            onLanguageClick = {},
            onSkillsClick = {}
        )

        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
    }
}