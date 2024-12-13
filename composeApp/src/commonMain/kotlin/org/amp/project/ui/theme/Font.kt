package org.amp.project.ui.theme

import composeResources.Res

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import composeResources.jetbrains_mono_bold
import composeResources.jetbrains_mono_regular
import composeResources.jetbrains_mono_light
import composeResources.jetbrains_mono_medium
import composeResources.jetbrains_mono_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun JetBrainsFontFamily() = FontFamily(
    Font(Res.font.jetbrains_mono_light, weight = FontWeight.Light),
    Font(Res.font.jetbrains_mono_regular, weight = FontWeight.Normal),
    Font(Res.font.jetbrains_mono_medium, weight = FontWeight.Medium),
    Font(Res.font.jetbrains_mono_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.jetbrains_mono_bold, weight = FontWeight.Bold)
)

@Composable
fun JetBrainsTypography() = Typography().run {

    val fontFamily = JetBrainsFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}