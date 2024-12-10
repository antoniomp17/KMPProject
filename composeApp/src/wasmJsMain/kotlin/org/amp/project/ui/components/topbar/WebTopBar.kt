package org.amp.project.ui.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composeResources.Res
import composeResources.amp_logo
import composeResources.contact
import composeResources.languages
import composeResources.skills
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WebTopBar(
    modifier: Modifier = Modifier,
    onContactClick: () -> Unit,
    onLanguageClick: () -> Unit,
    onSkillsClick: () -> Unit
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(Res.drawable.amp_logo),
            contentDescription = stringResource(Res.string.amp_logo)
        )

        Row(
            modifier = Modifier.fillMaxWidth(fraction = 0.4f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onContactClick()
                }
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector =  Icons.Filled.Call,
                        contentDescription = Icons.Filled.Call.name)
                    Text(
                        text = stringResource(Res.string.contact),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
            TextButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onLanguageClick()
                }
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Filled.Language,
                        contentDescription = Icons.Filled.Language.name
                    )
                    Text(
                        text = stringResource(Res.string.languages),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
            TextButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onSkillsClick()
                }
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Filled.Android,
                        contentDescription = Icons.Filled.Android.name
                    )
                    Text(
                        text = stringResource(Res.string.skills),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}