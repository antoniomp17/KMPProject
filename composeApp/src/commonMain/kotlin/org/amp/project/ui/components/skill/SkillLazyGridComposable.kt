package org.amp.project.ui.components.skill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.core.rememberScrollAreaState
import com.skydoves.landscapist.ImageOptions
import org.amp.project.model.SkillItem
import org.amp.project.ui.utils.CoilImageComposable
import org.amp.project.ui.utils.PutVerticalScrollbarIfWeb

@Composable
fun SkillLazyGridComposable(
    skillItemList: List<SkillItem>
) {
    val lazyListState = rememberLazyGridState()
    val state = rememberScrollAreaState(lazyListState)

    PutVerticalScrollbarIfWeb(
        state = state
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            state = lazyListState
        ) {
            items(skillItemList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.75f)
                        .padding(horizontal =  8.dp, vertical = 16.dp),
                    border = CardDefaults.outlinedCardBorder()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CoilImageComposable(
                            imageUrl = item.iconUrl,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.75f)
                                .padding(8.dp),
                            imageOptions = ImageOptions(
                                contentScale = ContentScale.Fit
                            )
                        )
                        Text(
                            text = item.skill,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = item.experience,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
        }
    }
}