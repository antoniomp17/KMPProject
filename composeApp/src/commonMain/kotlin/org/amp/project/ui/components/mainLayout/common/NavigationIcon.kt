package org.amp.project.ui.components.mainLayout.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.amp.project.data.utils.Links
import org.amp.project.data.utils.TopBarTypes
import org.amp.project.ui.utils.CoilImageComposable

@Composable
fun NavigationIcon(
    topBarType: TopBarTypes,
    drawerState: DrawerState? = null,
    scope: CoroutineScope? = null,
    navigator: NavHostController
) {
    IconButton(
        modifier = Modifier.padding(start = 16.dp),
        onClick = {
            when (topBarType) {
                TopBarTypes.HOME -> {
                    scope?.launch {
                        drawerState?.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
                else -> navigator.popBackStack()
            }
        }
    ) {
        when (topBarType) {
            TopBarTypes.HOME -> {
                CoilImageComposable(
                    modifier = Modifier
                        .clip(CircleShape),
                    imageUrl = Links.AMP_IMAGE_LINK
                )
            }
            else -> {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = Icons.AutoMirrored.Default.ArrowBack.name
                )
            }
        }
    }
}