package dev.nhoffmann.aoc.y2020.day9

class ExchangeMaskingAdditionSystem(val numberToVerify: Long, private val preamble: List<Long>) {
    fun verify(): Boolean {
        return preamble.any { preamble.contains(numberToVerify - it) }.not()
    }
}
