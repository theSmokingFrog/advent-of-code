package dev.nhoffmann.aoc.y2021.day8

enum class SevenSegmentValue(val defaultSignalPattern: String, val numericValue: Short) {
    ZERO("abcefg", 0),
    ONE("cf", 1),
    TWO("acdeg", 2),
    THREE("acdfg", 3),
    FOUR("bcdf", 4),
    FIVE("abdfg", 5),
    SIX("abdefg", 6),
    SEVEN("acf", 7),
    EIGHT("abcdefg", 8),
    NINE("abcdfg", 9),
    UNKNOWN("", -1);

    companion object {
        fun findUniqueByActiveLines(configuration: String): SevenSegmentValue {
            val filteredValues = values().filter { it.defaultSignalPattern.length == configuration.length }
            return when (filteredValues.size) {
                1 -> filteredValues.first()
                else -> UNKNOWN
            }
        }
    }

    override fun toString(): String {
        return "SSV($name|$numericValue)"
    }


}
