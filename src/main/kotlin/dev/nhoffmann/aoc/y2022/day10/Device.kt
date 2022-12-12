package dev.nhoffmann.aoc.y2022.day10

class Device(program: List<Instruction>, private var cycles: Int = 0) {
    private val crt = mutableListOf<String>()
    private val cyclesToLookup = arrayOf(20, 60, 100, 140, 180, 220)
    private var registerX = 1

    private val cycleChecks = mutableListOf<Int>()

    init {
        for (instruction in program) {
            when (instruction.representation) {
                "addx" -> handleAddx(instruction.value!!)
                "noop" -> handleNoop()
            }
        }
    }

    private fun handleNoop() {
        doCycleIncrease()
    }

    private fun handleAddx(value: Int) {
        doCycleIncrease()
        doCycleIncrease()
        registerX += value
    }

    private fun doCycleIncrease() {
        cycles += 1
        if (cycles in cyclesToLookup) {
            cycleChecks.add(cycles * registerX)
        }

        val pixel = if (cycles % 40 in registerX - 1..registerX + 1) {
            "#"
        } else {
            "."
        }

        crt.add(pixel)
    }

    fun summarizeSignalChecks(): Int {
        return cycleChecks.sum()
    }

    fun generateScreen(): String {
        return crt.chunked(40).joinToString(separator = "\n") { it.joinToString(separator = "") }
    }
}


