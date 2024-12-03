package dev.nhoffmann.aoc.y2024.day2

class Report(data: String) {
    companion object {
        fun create(line: String): Report {
            return Report(line)
        }
    }

    private val levels: List<Int> = data.split(" ").map { it.toInt() }

    fun isSafe(): Boolean {
        return areLevelsSafe(levels)
    }

    private fun areLevelsSafe(levels: List<Int>): Boolean {
        val levelChanges = levels.windowed(2).map { (left, right) -> left - right }

        val allIncreasingOrDecreasing = levelChanges.all { it > 0 } || levelChanges.all { it < 0 }
        val levelsWithinBoundaries = levelChanges.all { it in 1..3 } || levelChanges.all { it in -3..-1 }

        return allIncreasingOrDecreasing && levelsWithinBoundaries;
    }


    fun isSafeWhenDampened(): Boolean {
        return if (isSafe()) {
            true
        } else {
            evaluateDampenedLevels()
        }
    }

    private fun evaluateDampenedLevels(): Boolean {
        val levelVariants = levels.indices.map { levels.filterIndexed { index, _ -> index != it } }

        return levelVariants.stream().anyMatch { areLevelsSafe(it) }
    }

    override fun toString(): String {
        return "Report(levels=$levels)"
    }


}