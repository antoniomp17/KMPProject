package org.amp.project

import android.app.Application
import org.amp.project.di.contactItemModule
import org.amp.project.di.jobExperienceModule
import org.amp.project.di.languageItemModule
import org.amp.project.di.resumeItemModule
import org.amp.project.di.skillItemModule
import org.amp.project.di.themeItemModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                resumeItemModule(),
                jobExperienceModule(),
                contactItemModule(),
                languageItemModule(),
                skillItemModule(),
                themeItemModule()
            )
        }
    }
}