package dev.nhoffmann.aoc.y2022.day11

class MonkeysKeepAway(private val monkeys: List<Monkey>, private val rounds: Int) {
    companion object {
        var monkeyModulus = 1L
    }

    private fun List<Monkey>.calculateMonkeyModulus(): Long {
        return fold(1L) { acc, monkey -> acc * monkey.testValue }
    }


    fun play(): MonkeysKeepAway {
        monkeyModulus = monkeys.calculateMonkeyModulus()
        repeat(rounds) { monkeys.forEach { it.takeTurn(monkeys) } }
        return this
    }

    fun playSerious(): MonkeysKeepAway {
        monkeyModulus = monkeys.calculateMonkeyModulus()
        repeat(rounds) { monkeys.forEach { it.takeSeriousTurn(monkeys) } }
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
