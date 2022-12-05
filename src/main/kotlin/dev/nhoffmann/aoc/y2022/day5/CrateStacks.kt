package dev.nhoffmann.aoc.y2022.day5

import java.util.*

class CrateStacks private constructor(private val stacksByNumber: Map<Int, Stack<String>>) {
    companion object Factory {
        fun of(drawing: String): CrateStacks {
            val drawingLines = drawing.split("\n")
            val lastStackNumber = drawingLines.last().split(" ").last().toInt()

            return CrateStacks(createStackMapping(lastStackNumber, drawingLines))
        }

        private fun String.crateByStackNumber(stackNumber: Int): String {
            return try {
                this.substring((stackNumber - 1) * 4, (stackNumber - 1) * 4 + 3)
            } catch (ex: StringIndexOutOfBoundsException) {
                ""
            }
        }

        private fun String.removeBraces(): String = this[1].toString()

        private fun List<String>.withoutLast(): List<String> = subList(0, lastIndex)

        private fun List<String>.toStack(): Stack<String> = fold(Stack<String>()) { stack, str -> stack.also { it.push(str) } }

        private fun createStackMapping(lastStackNumber: Int, drawingLines: List<String>): Map<Int, Stack<String>> {
            return (1..lastStackNumber).associateWith { stackNumber ->
                drawingLines
                    .withoutLast()
                    .map { line -> line.crateByStackNumber(stackNumber) }
                    .filter { crate -> crate.isNotBlank() }
                    .map { crate -> crate.removeBraces() }
                    .reversed()
                    .toStack()
            }
        }
    }

    fun get(stackNumber: Int): Stack<String> = stacksByNumber[stackNumber]!!

    fun getTopCrates(): String = stacksByNumber.values.joinToString(separator = "") { it.peek() }
}
