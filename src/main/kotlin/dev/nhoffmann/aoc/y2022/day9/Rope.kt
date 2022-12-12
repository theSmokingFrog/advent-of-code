package dev.nhoffmann.aoc.y2022.day9

interface Rope {
    fun move(motion: Motion)
    fun uniqueTailPositions(): Int
}
