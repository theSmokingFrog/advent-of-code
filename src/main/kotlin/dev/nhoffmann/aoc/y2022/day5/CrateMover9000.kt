package dev.nhoffmann.aoc.y2022.day5

class CrateMover9000(override val crateStacks: CrateStacks, override val rearrangementProcedure: List<Instruction>) : Crane {
    override fun rearrangeCrates() {
        rearrangementProcedure.forEach {
            val source = crateStacks.get(it.sourceStack)
            val target = crateStacks.get(it.targetStack)
            it.crateAmount.downTo(1).forEach { _ -> target.push(source.pop()) }
        }
    }

}
