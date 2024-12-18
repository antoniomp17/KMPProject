package org.amp.project.domain

import org.amp.project.model.JobExperienceItem

interface JobExperienceRepository {
    fun getAllJobExperiences(): List<JobExperienceItem>
}