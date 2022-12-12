package dev.nhoffmann.aoc.y2022.day11

import java.math.BigDecimal

private val monkeyDefinition = Regex(
    """Monkey (\d+):
\s*Starting items: (.*)$
\s*Operation: new = (.*)$
\s*Test: divisible by (\d+)
\s*If true: throw to monkey (\d+)
\s*If false: throw to monkey (\d+)""", RegexOption.MULTILINE
)

fun monkeyFromDefinition(definition: String): Monkey {
    return monkeyDefinition.find(definition)!!.destructured.let { match ->
        val id = match.component1().toInt()
        val startingItems = match.component2().split(", ").map { Item(it.toInt()) }.toMutableList()
        val operation = Operation(match.component3())
        val testValue = match.component4().toInt()
        val testSuccessTarget = match.component5().toInt()
        val testFailTarget = match.component6().toInt()

        Monkey(
            id = id,
            items = startingItems,
            worryOperation = operation,
            testValue = BigDecimal(testValue),
            testSuccessMonkeyId = testSuccessTarget,
            testFailMonkeyId = testFailTarget
        )
    }
}
