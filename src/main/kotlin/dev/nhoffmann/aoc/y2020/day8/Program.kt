package dev.nhoffmann.aoc.y2020.day8

class Program(private val instructions: List<Instruction>) {
    private var accumulator: Long = 0
    private var executed = false
    private var success: Boolean? = null

    fun executeWithBrokenBootLoader(): Program {
        if (!executed) {
            var index = 0

            while (!instructions[index].executed) {
                index = executeInstructionAtIndex(index)
            }
        }
        return this
    }

    fun executeFixedBoot(): Program {
        if (!executed) {
            try {
                var index = 0
                while (index <= instructions.lastIndex) {
                    index = executeInstructionAtIndex(index)
                }
                success = true
            } catch (ex: RuntimeException) {
                success = false
            }
        }

        return this
    }

    private fun executeInstructionAtIndex(pIndex: Int): Int {
        var index = pIndex
        instructions[index].execute()
        when (instructions[index].operation) {
            Operation.ACCUMULATE -> {
                accumulator += instructions[index].argument
                index += 1
            }
            Operation.JUMP -> {
                index += instructions[index].argument
            }
            Operation.NO_OP -> {
                index += 1
            }
        }
        return index
    }

    fun isSuccessful(): Boolean {
        return success ?: false
    }

    fun value(): Long {
        return accumulator
    }
}
