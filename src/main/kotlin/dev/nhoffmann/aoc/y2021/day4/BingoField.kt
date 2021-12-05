package dev.nhoffmann.aoc.y2021.day4

class BingoField(rawData: List<String>) {
    companion object {
        private val NUMBER_REGEX = Regex("""(\d{1,2})""")
    }

    private var numbers: List<Int>
    var wonWith: Int = -1

    init {
        numbers = rawData
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { line -> NUMBER_REGEX.findAll(line).map { it.destructured.component1().toInt() }.toList() }
            .flatten()
    }

    fun isWon(drawnNumbers: List<Int>): Boolean {
        return (wonWith >= 0) || determineBoardWon(drawnNumbers)
    }


    private fun determineBoardWon(drawnNumbers: List<Int>): Boolean {
        val boardWon = WinningCombinations.values()
            .asSequence()
            .map { it.winningIndices }
            .map { numbers.filterIndexed { index, _ -> index in it } }
            .map { drawnNumbers.containsAll(it) }
            .any { it }
        if (boardWon) {
            wonWith = drawnNumbers.last()
        }
        return boardWon
    }

    fun unmarkedNumbers(drawnNumbers: List<Int>): List<Int> {
        return numbers.filter { drawnNumbers.contains(it).not() }
    }

}
