package dev.nhoffmann.aoc.y2022.day11

import java.math.BigDecimal

class Monkey(
    val id: Int,
    val items: MutableList<Item>,
    val worryOperation: Operation,
    val testValue: BigDecimal,
    val testSuccessMonkeyId: Int,
    val testFailMonkeyId: Int
) {
    var inspections = 0L
    fun takeTurn(monkeys: List<Monkey>) {
        items.forEach { item ->
            inspect(item)
            loseInterest(item)
            throwItem(item, monkeys)
        }
        items.clear()
    }

    fun takeSeriousTurn(monkeys: List<Monkey>) {
        items.forEach { item ->
            inspect(item)
            throwItem(item, monkeys)
        }
        items.clear()
    }

    private fun throwItem(item: Item, monkeys: List<Monkey>) {
        val monkey = if (item.worryLevel.toLong() % testValue.toLong() == 0L) {
            monkeys.first { it.id == testSuccessMonkeyId }
        } else {
            monkeys.first { it.id == testFailMonkeyId }
        }
        monkey.items.add(item)

    }

    private fun loseInterest(item: Item) = item.loseInterest()

    private fun inspect(item: Item) {
        inspections += 1
        item.invokeOperation(worryOperation)
    }

    override fun toString(): String {
        return "Monkey(id=$id, items=$items, inspections=$inspections)"
    }


}
