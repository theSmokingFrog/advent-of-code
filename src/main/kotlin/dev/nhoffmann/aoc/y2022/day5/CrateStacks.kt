package dev.nhoffmann.aoc.y2022.day5

import java.util.*

class CrateStacks private constructor(private val stacksByNumber: Map<Int, Stack<String>>) {
    companion object Factory {
        fun of(drawing: String): CrateStacks {
            val drawingLines = drawing.split("\n")
            val lastStackNumber = drawingLines.last().split(" ").last().toInt()

            return CrateStacks(createStackMapping(lastStackNumber, drawingLines))
        }

        private fun getCrateFromString(it: String, stackNumber: Int): String {
            return try {
                it.substring((stackNumber - 1) * 4, (stackNumber - 1) * 4 + 3)
            } catch (ex: StringIndexOutOfBoundsException) {
                ""
            }
        }

        private fun createStackMapping(lastStackNumber: Int, drawingLines: List<String>): Map<Int, Stack<String>> {
            return (1..lastStackNumber).associateWith { stackNumber ->
                drawingLines
                    .subList(0, drawingLines.lastIndex)
                    .map { getCrateFromString(it, stackNumber) }
                    .filter { it.isNotBlank() }
                    .map { it.substring(1..1) }
                    .reversed()
                    .fold(Stack<String>()) { stack, s -> stack.also { it.push(s) } }
            }
        }
    }

    fun get(stackNumber: Int): Stack<String> = stacksByNumber[stackNumber]!!

    fun getTopCrates(): String = stacksByNumber.values.joinToString(separator = "") { it.peek() }
}
