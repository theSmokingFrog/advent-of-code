package dev.nhoffmann.aoc.y2022.day5

interface Crane {
    val crateStacks: CrateStacks
    val rearrangementProcedure: List<Instruction>
    fun rearrangeCrates()
}
