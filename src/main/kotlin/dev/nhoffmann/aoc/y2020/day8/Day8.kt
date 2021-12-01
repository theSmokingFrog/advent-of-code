package dev.nhoffmann.aoc.y2020.day8

import dev.nhoffmann.aoc.load

fun solveDay8PartOne(lines: List<String>): Long {
    return Program(linesAsInstructions(lines)).executeWithBrokenBootLoader().value()
}

fun solveDay8PartTwo(lines: List<String>): Long {
    val instructions = linesAsInstructions(lines)
    for ((index, instruction) in instructions.withIndex()) {
        if (instruction.operation == Operation.JUMP || instruction.operation == Operation.NO_OP) {

            val copiedInstructions = ArrayList(instructions.map { it.copy() })
            copiedInstructions[index].changeOperation()

            val program = Program(copiedInstructions).executeFixedBoot()
            if (program.isSuccessful()) {
                return program.value()
            }
        }
    }

    return -1
}

fun linesAsInstructions(lines: List<String>): List<Instruction> {
    return lines.map { Instruction.of(it) }
}

fun main() {
    val lines = load("/inputs/2020/day-8.txt")
    println("Solution to Day 8, Part 1 is '${solveDay8PartOne(lines)}'")
    println("Solution to Day 8, Part 2 is '${solveDay8PartTwo(lines)}'")
}
