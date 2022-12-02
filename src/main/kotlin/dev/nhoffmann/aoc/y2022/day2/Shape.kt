package dev.nhoffmann.aoc.y2022.day2

enum class Shape(val score: Int, vararg val encryptedAs: String) {
    ROCK(1, "A", "X") {
        override val winsAgainst: Shape
            get() = SCISSORS
    },
    PAPER(2, "B", "Y") {
        override val winsAgainst: Shape
            get() = ROCK
    },
    SCISSORS(3, "C", "Z") {
        override val winsAgainst: Shape
            get() = PAPER
    };

    abstract val winsAgainst: Shape

    companion object {
        fun byEncrypted(encryptedShape: String): Shape {
            return Shape.values().find { it.encryptedAs.contains(encryptedShape) } ?: throw RuntimeException("Shape cannot be found!")
        }
    }

    fun versus(shape: Shape): Result {
        return when {
            shape == this -> Result.DRAW
            this.winsAgainst == shape -> Result.WIN
            else -> Result.LOSE
        }
    }

    fun findCounterpart(desiredOutcome: Result): Shape {
        return when (desiredOutcome) {
            Result.DRAW -> this
            Result.LOSE -> winsAgainst
            Result.WIN -> Shape.values().find { it.winsAgainst == this } ?: throw RuntimeException("Find against not matching")
        }
    }
}
