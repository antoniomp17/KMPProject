package org.amp.project.domain

import org.amp.project.model.SkillItem

interface SkillRepository {
    fun getAllSkills(): List<SkillItem>
}