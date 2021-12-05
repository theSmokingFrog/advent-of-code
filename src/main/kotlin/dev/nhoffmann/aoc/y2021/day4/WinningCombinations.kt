package dev.nhoffmann.aoc.y2021.day4

enum class WinningCombinations(val winningIndices: List<Int>) {
    // ROWS
    FIRST_ROW(listOf(0, 1, 2, 3, 4)),
    SECOND_ROW(listOf(5, 6, 7, 8, 9)),
    THIRD_ROW(listOf(10, 11, 12, 13, 14)),
    FOURTH_ROW(listOf(15, 16, 17, 18, 19)),
    FIFTH_ROW(listOf(20, 21, 22, 23, 24)),

    // COLs
    FIRST_COL(listOf(0, 5, 10, 15, 20)),
    SECOND_COL(listOf(1, 6, 11, 16, 21)),
    THIRD_COL(listOf(2, 7, 12, 17, 22)),
    FOURTH_COL(listOf(3, 8, 13, 18, 23)),
    FIFTH_COL(listOf(4, 9, 14, 19, 24)),

}
