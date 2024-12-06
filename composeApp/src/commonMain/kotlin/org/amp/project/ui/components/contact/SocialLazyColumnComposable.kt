package org.amp.project.ui.components.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import org.amp.project.model.ContactItem
import org.amp.project.ui.utils.getIconForType

@Composable
fun SocialLazyColumnComposable(
    socialItemList: List<ContactItem>
) {

    val uriHandler = LocalUriHandler.current

    LazyVerticalGrid(
        columns = if(socialItemList.size > 1){
            GridCells.Fixed(2)
        }
        else{
            GridCells.Fixed(1)
        },
        state = rememberLazyGridState()
    ){
        items(socialItemList) {
            IconButton(
                onClick = {
                    it.url?.let { url -> uriHandler.openUri(url) }
                }
            ){
                Icon(
                    painter = getIconForType(it.type),
                    contentDescription = it.type.name
                )
            }
        }
    }
}