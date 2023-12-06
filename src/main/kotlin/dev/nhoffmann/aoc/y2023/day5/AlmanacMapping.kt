package dev.nhoffmann.aoc.y2023.day5

data class AlmanacMapping(private val destinationRangeStart: Long, private val sourceRangeStart: Long, private val rangeLength: Long) {

    fun get(id: Long): Long? {
        val lowerBoundary = id - sourceRangeStart
        val upperBoundary = id - (sourceRangeStart + rangeLength)

        return if (lowerBoundary >= 0 && upperBoundary < 0) {
            destinationRangeStart + lowerBoundary
        } else {
            null
        }
    }
}
