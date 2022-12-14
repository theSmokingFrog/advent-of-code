package dev.nhoffmann.aoc.y2022.day11

class Operation(raw: String) {
    companion object {
        private val OPERATION_STRUCTURE = Regex("""(old|\d+) ([+*]) (old|\d+)""")
    }

    private val operand1: String
    private val operand2: String
    private val operator: String

    init {
        val structure = OPERATION_STRUCTURE.find(raw)?.destructured ?: throw RuntimeException("Cannot map Operation")
        structure.let {
            operand1 = it.component1()
            operand2 = it.component3()
            operator = it.component2()
        }

    }

    fun invoke(forWorry: Long): Long {
        val x = fetchOperand(operand1) ?: forWorry
        val y = fetchOperand(operand2) ?: forWorry
        val worryFunction = functionByOperator(operator)

        return worryFunction(x, y)
    }

    private fun fetchOperand(operand: String): Long? {
        return when (operand) {
            "old" -> null
            else -> operand.toLong()
        }
    }

    private fun functionByOperator(operator: String): (Long, Long) -> Long {
        return when (operator) {
            "+" -> { x, y -> x + y }
            "*" -> { x, y -> x * y }
            else -> throw RuntimeException("Cannot fetch Operator for $operator")
        }
    }
}
