package dev.nhoffmann.aoc.y2023.day4

import kotlin.math.pow

class ScratchCard(data: String) {
    val id: Int
    private val winningNumbers: List<Int>
    private val scratchedNumbers: List<Int>

    companion object {
        val cardStructure = Regex("""Card\s+(\d+):(.*)\|(.*)""")
    }

    init {
        val result = cardStructure.find(data)
        if (result != null) {
            result.destructured
                .let { (rawId, winningNumsRaw, actualNumsRaw) ->
                    id = rawId.toInt()
                    winningNumbers = winningNumsRaw.toIntList()
                    scratchedNumbers = actualNumsRaw.toIntList()
                }
        } else {
            throw RuntimeException("Could not Match Card Structure for '$data'")
        }
    }

    private fun String.toIntList(): List<Int> = this.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

    fun countWins(): Int = scratchedNumbers.count { it in winningNumbers }

    fun getPoints(): Int {
        return when (val amountOfMatches = countWins()) {
            0 -> 0
            1 -> 1
            else -> (2.0).pow(amountOfMatches - 1).toInt()
        }
    }

    override fun toString(): String {
        return "ScratchCard(id=$id)"
    }
}
