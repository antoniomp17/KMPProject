package org.amp.project

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.amp.project.di.contactItemModule
import org.amp.project.di.jobExperienceModule
import org.amp.project.di.languageItemModule
import org.amp.project.di.resumeItemModule
import org.amp.project.di.skillItemModule
import org.amp.project.di.themeItemModule
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    ComposeViewport(document.body!!) {
        App()
    }
}

fun initKoin() {
    startKoin {
        modules(
            resumeItemModule(),
            jobExperienceModule(),
            contactItemModule(),
            languageItemModule(),
            skillItemModule(),
            themeItemModule()
        ).koin
    }
}