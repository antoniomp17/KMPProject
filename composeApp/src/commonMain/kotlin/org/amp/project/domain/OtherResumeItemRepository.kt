package org.amp.project.domain

import org.amp.project.model.ResumeItem

interface OtherResumeItemRepository {
    fun getAllResumeItems(): List<ResumeItem>
}