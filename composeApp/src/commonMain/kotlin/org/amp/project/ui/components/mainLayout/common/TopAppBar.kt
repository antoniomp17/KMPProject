package org.amp.project.ui.components.mainLayout.common

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import composeResources.Res
import composeResources.amp_logo
import org.amp.project.data.utils.TopBarTypes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    scrollBehavior: TopAppBarScrollBehavior? = null,
    topBarType: TopBarTypes? = null,
    navigator: NavHostController? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(Res.drawable.amp_logo),
                contentDescription = stringResource(Res.string.amp_logo)
            )
        },
        navigationIcon = {
            if(topBarType != null){
                if(topBarType == TopBarTypes.NOT_HOME) {
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
        scrollBehavior = scrollBehavior
    )
}