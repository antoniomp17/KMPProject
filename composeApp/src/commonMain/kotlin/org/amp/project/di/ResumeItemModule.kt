package org.amp.project.di

import org.amp.project.data.resumeItem.ResumeItemManager
import org.amp.project.data.resumeItem.ResumeItemRepositoryImpl
import org.amp.project.domain.ResumeItemRepository
import org.amp.project.presentation.ResumeItemViewModel
import org.koin.dsl.module

fun resumeItemModule() = module {

    single { ResumeItemManager }
    single<ResumeItemRepository> { ResumeItemRepositoryImpl(get())}
    factory { ResumeItemViewModel(get()) }

}