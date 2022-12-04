package dev.nhoffmann.aoc.y2022.day4

class CleaningAssignment(rawAssigment: String) {
    val sectionsToClean = rawAssigment.split("-").let { it.first().toInt()..it.last().toInt() }

    fun startsBeforeOrOnSameSection(assignment: CleaningAssignment): Boolean {
        return sectionsToClean.first <= assignment.sectionsToClean.first
    }

    fun endsAfterOrOnSameSection(assignment: CleaningAssignment): Boolean {
        return sectionsToClean.last >= assignment.sectionsToClean.last
    }

    fun overlaps(assignment: CleaningAssignment): Boolean {
        return sectionsToClean.intersect(assignment.sectionsToClean).isNotEmpty()
    }
}
