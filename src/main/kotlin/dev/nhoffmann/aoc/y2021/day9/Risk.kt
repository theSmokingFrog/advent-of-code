package dev.nhoffmann.aoc.y2021.day9

class Risk(currentNum: Char, top: Char?, bottom: Char?, right: Char?, left: Char?) {
    private val numericValue: Int = currentNum.toString().toInt()
    private val adjacentValues: List<Int> = listOfNotNull(top, bottom, right, left).map { it.toString().toInt() }

    fun isLowPoint(): Boolean {
        return adjacentValues.all { numericValue < it }
    }

    fun value(): Int {
        return numericValue + 1
    }
}
