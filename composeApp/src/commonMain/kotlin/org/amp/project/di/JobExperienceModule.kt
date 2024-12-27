package org.amp.project.di

import org.amp.project.data.jobExperience.JobExperienceManager
import org.amp.project.data.jobExperience.JobExperienceRepositoryImpl
import org.amp.project.domain.JobExperienceRepository
import org.amp.project.presentation.JobExperienceViewModel
import org.koin.dsl.module

fun jobExperienceModule() = module {

    single { JobExperienceManager }
    single<JobExperienceRepository> { JobExperienceRepositoryImpl(get())}
    factory { JobExperienceViewModel(get()) }

}