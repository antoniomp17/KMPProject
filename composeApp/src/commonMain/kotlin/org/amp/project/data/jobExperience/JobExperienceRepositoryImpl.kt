package org.amp.project.data.jobExperience

import org.amp.project.domain.JobExperienceRepository
import org.amp.project.model.JobExperienceItem

class JobExperienceRepositoryImpl(private var jobExperienceManager: JobExperienceManager): JobExperienceRepository {
    override fun getAllJobExperiences(): List<JobExperienceItem> {
        return jobExperienceManager.fakeJobExperienceList
    }
}