package org.amp.project.di

import org.amp.project.data.skill.SkillManager
import org.amp.project.data.skill.SkillRepositoryImpl
import org.amp.project.domain.SkillRepository
import org.amp.project.presentation.SkillViewModel
import org.koin.dsl.module

fun skillItemModule() = module {

    single { SkillManager }
    single<SkillRepository> { SkillRepositoryImpl(get()) }
    factory { SkillViewModel(get()) }

}