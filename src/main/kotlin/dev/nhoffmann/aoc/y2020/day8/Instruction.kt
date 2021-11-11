package dev.nhoffmann.aoc.y2020.day8

data class Instruction(var operation: Operation, val argument: Short) {
    companion object {
        private val INSTRUCTION_LINE_REGEX = Regex("""^(\w{3}) ([+-]\d+)${'$'}""")

        fun of(instructionLine: String): Instruction {
            val (operationIdentifier, argument) = INSTRUCTION_LINE_REGEX.find(instructionLine)!!.destructured
            return Instruction(Operation.ofIdentifier(operationIdentifier), argument.toShort())
        }
    }

    var executed: Boolean = false

    fun execute() {
        if (executed) {
            throw RuntimeException("Instruction already executed")
        }
        executed = true
    }

    fun changeOperation() {
        when (operation) {
            Operation.NO_OP -> operation = Operation.JUMP
            Operation.JUMP -> operation = Operation.NO_OP
            else -> { /* Nothing happens */
            }
        }
    }

    override fun toString(): String {
        return "$operation $argument"
    }
}
