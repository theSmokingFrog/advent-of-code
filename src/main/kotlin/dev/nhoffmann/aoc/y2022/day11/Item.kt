package dev.nhoffmann.aoc.y2022.day11

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.function.BiFunction

class Item(initialWorryLevel: Int) {
    companion object {
        private val BORED_DIVISOR = BigDecimal(3)
    }

    var worryLevel: BigDecimal = BigDecimal(initialWorryLevel)
    fun invokeOperation(worryOperation: Operation) {
        val x = fetchOperand(worryOperation.operand1)
        val y = fetchOperand(worryOperation.operand2)
        worryLevel = fetchOperator(worryOperation.operator).apply(x, y)
    }

    private fun fetchOperand(operand: String): BigDecimal {
        return when (operand) {
            "old" -> worryLevel
            else -> BigDecimal(operand.toInt())
        }
    }

    private fun fetchOperator(operator: String): BiFunction<BigDecimal, BigDecimal, BigDecimal> {
        return when (operator) {
            "+" -> BiFunction { x: BigDecimal, y: BigDecimal -> x.plus(y) }
            "*" -> BiFunction { x: BigDecimal, y: BigDecimal -> x.multiply(y) }
            else -> throw RuntimeException("Cannot fetch Operator for $operator")
        }
    }

    fun loseInterest() {
        worryLevel = worryLevel.divide(BORED_DIVISOR, RoundingMode.DOWN)
    }

    override fun toString(): String {
        return "Item(worryLevel=$worryLevel)"
    }


}
