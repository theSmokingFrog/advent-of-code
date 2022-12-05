package dev.nhoffmann.aoc.y2022.day5

class Crane(val crateStacks: CrateStacks, val rearrangementProcedure: List<Instruction>) {
    fun rearrangeCrates() {
        rearrangementProcedure.forEach {
            val source = crateStacks.get(it.sourceStack)
            val target = crateStacks.get(it.targetStack)
            it.crateAmount.downTo(1).forEach { target.push(source.pop()) }
        }
    }

}
