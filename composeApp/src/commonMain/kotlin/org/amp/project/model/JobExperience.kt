package org.amp.project.model

data class JobExperience(
    val id: Long = -1,
    val companyName: String,
    val companyImageUrl: String,
    val clientName: String,
    val clientImageUrl: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val imageSmallUrl: String,
    val imageLargeUrl: String,
    val description: String
)
