package dev.nhoffmann.aoc.y2022.day5

import java.util.*

class CrateMover9001(override val crateStacks: CrateStacks, override val rearrangementProcedure: List<Instruction>) : Crane {
    private val pickedUpCrates = Stack<String>()

    override fun rearrangeCrates() {
        rearrangementProcedure.forEach {
            val source = crateStacks.get(it.sourceStack)
            val target = crateStacks.get(it.targetStack)
            val crateRange = it.crateAmount.downTo(1)

            crateRange.forEach { _ -> pickedUpCrates.push(source.pop()) }
            crateRange.forEach { _ -> target.push(pickedUpCrates.pop()) }
        }
    }
}
