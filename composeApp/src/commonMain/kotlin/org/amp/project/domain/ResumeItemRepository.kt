package org.amp.project.domain

import org.amp.project.data.ResumeItemManager
import org.amp.project.model.ResumeItem

interface ResumeItemRepository {
    fun getAllResumeItems(): List<ResumeItem>
}