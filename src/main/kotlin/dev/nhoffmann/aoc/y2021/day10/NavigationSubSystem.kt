package dev.nhoffmann.aoc.y2021.day10

class NavigationSubSystem(originalLines: List<String>) {
    private val corruptedScoring = mapOf(
        ')' to 3L,
        ']' to 57L,
        '}' to 1197L,
        '>' to 25137L
    )

    private val incompleteScoring = mapOf(
        ')' to 1L,
        ']' to 2L,
        '}' to 3L,
        '>' to 4L
    )
    private var lines: List<Line>

    init {
        lines = originalLines.map { Line(it) }
    }

    fun scoreCorruptLines(): Long {
        return lines.map { it.findCorruptCharacter() }.mapNotNull { corruptedScoring[it] }.sum()
    }

    fun scoreIncompleteLines(): Long {
        val sortedScores = lines.asSequence()
            .map { it.createAutocompleteSequence() }
            .filterNotNull()
            .map { createScoreFromSequence(it) }
            .sorted()
            .toList()

        return sortedScores[sortedScores.size / 2]
    }

    private fun createScoreFromSequence(sequence: String): Long {
        return sequence
            .mapNotNull { incompleteScoring[it] }
            .reduce { acc, value -> (acc * 5) + value }
    }
}
