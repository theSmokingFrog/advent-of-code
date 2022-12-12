package dev.nhoffmann.aoc.y2022.day11

class Operation(raw: String) {
    companion object {
        private val OPERATION_STRUCTURE = Regex("""(old|\d+) ([+*]) (old|\d+)""")
    }

    val operand1: String
    val operand2: String
    val operator: String

    init {
        val structure = OPERATION_STRUCTURE.find(raw)?.destructured ?: throw RuntimeException("Cannot map Operation")
        structure.let {
            operand1 = it.component1()
            operand2 = it.component3()
            operator = it.component2()
        }

    }
}
