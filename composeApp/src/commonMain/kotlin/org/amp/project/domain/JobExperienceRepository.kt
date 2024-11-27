package org.amp.project.domain

import org.amp.project.model.JobExperience

interface JobExperienceRepository {
    fun getAllJobExperiences(): List<JobExperience>
}