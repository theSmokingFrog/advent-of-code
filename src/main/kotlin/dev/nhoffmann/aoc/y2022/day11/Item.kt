package dev.nhoffmann.aoc.y2022.day11

class Item(var worryLevel: Long) {
    companion object {
        private const val BORED_DIVISOR = 3L
    }

    fun invokeOperation(worryOperation: Operation) {
        worryOperation
            .invoke(forWorry = worryLevel)
            .also { worryLevel = it % MonkeysKeepAway.monkeyModulus }
    }

    fun loseInterest() {
        worryLevel /= BORED_DIVISOR
    }

    override fun toString(): String {
        return "Item(worryLevel=$worryLevel)"
    }


}
