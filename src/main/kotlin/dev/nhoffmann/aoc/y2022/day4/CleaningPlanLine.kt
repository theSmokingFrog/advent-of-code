package dev.nhoffmann.aoc.y2022.day4

class CleaningPlanLine(line: String) {
    private val firstAssignment: CleaningAssignment
    private val secondAssignment: CleaningAssignment

    init {
        line.split(",").let {
            firstAssignment = CleaningAssignment(it.first())
            secondAssignment = CleaningAssignment(it.last())
        }
    }

    fun areAssignmentsFullyOverlapping(): Boolean {
        val firstInSecond = firstAssignment.startsBeforeOrOnSameSection(secondAssignment) && firstAssignment.endsAfterOrOnSameSection(secondAssignment)
        val secondInFirst = secondAssignment.startsBeforeOrOnSameSection(firstAssignment) && secondAssignment.endsAfterOrOnSameSection(firstAssignment)

        return firstInSecond || secondInFirst
    }

    fun overlapsAtAll(): Boolean {
        return firstAssignment.overlaps(secondAssignment)
    }
}
