package dev.nhoffmann.aoc.y2022.day2

enum class Result(val score: Int, val encryptedAs: String) {
    LOSE(0, "X"),
    DRAW(3, "Y"),
    WIN(6, "Z");

    companion object {
        fun byEncrypted(encryptedResult: String): Result {
            return Result.values().find { it.encryptedAs == encryptedResult } ?: throw RuntimeException("Result cannot be decoded.")
        }
    }
}
