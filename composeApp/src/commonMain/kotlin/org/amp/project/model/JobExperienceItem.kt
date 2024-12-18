package org.amp.project.model

data class JobExperienceItem(
    val id: Long = -1,
    val position: String,
    val companyName: String,
    val companyImageUrl: String,
    val clientName: String,
    val clientImageUrl: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val image: String,
    val description: String
)