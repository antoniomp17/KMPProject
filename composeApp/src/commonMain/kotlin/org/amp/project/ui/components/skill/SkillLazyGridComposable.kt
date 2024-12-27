package org.amp.project.ui.components.skill

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.composables.core.rememberScrollAreaState
import org.amp.project.model.SkillItem
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb
import org.amp.project.ui.utils.ResponsiveLazyGrid

@Composable
fun SkillLazyGridComposable(
    skillItemList: List<SkillItem>
) {
    val lazyGridState = rememberLazyGridState()
    val state = rememberScrollAreaState(lazyGridState)

    PutVerticalScrollbarIfWeb(state = state){
        ResponsiveLazyGrid(
            items = skillItemList,
            itemMinWidth = 120.dp,
            state = lazyGridState
        ) { item ->
            SkillItemComposable(item = item)
        }
    }
}