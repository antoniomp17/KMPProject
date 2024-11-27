package org.amp.project.data

import org.amp.project.domain.JobExperienceRepository
import org.amp.project.model.JobExperience

class JobExperienceRepositoryImpl(private var jobExperienceManager: JobExperienceManager): JobExperienceRepository {

    override fun getAllJobExperiences(): List<JobExperience> {
        return jobExperienceManager.fakeJobExperienceList
    }

}