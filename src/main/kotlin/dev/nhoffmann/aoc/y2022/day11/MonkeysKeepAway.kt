package dev.nhoffmann.aoc.y2022.day11

class MonkeysKeepAway(private val monkeys: List<Monkey>, private val rounds: Int) {
    fun play(): MonkeysKeepAway {
        (0 until rounds).forEach { _ ->
            for (monkey in monkeys) {
                monkey.takeTurn(monkeys)
            }
        }
        return this
    }

    fun playSerious(): MonkeysKeepAway {
        (0 until rounds).forEach { _ ->
            for (monkey in monkeys) {
                monkey.takeSeriousTurn(monkeys)
            }
        }
        return this
    }

    fun monkeyBusiness(): Long {
        return monkeys.asSequence()
            .map { it.inspections }
            .sortedByDescending { it }
            .take(2)
            .chunked(2) { (x, y) -> x * y }
            .first()
    }
}
