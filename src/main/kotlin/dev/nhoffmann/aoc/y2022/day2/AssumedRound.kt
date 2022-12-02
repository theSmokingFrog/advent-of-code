package dev.nhoffmann.aoc.y2022.day2

class AssumedRound(strategyGuideLine: String) : Round {
    private val opponentsMove: Shape
    private val ownMove: Shape

    init {
        strategyGuideLine.split(" ").let {
            opponentsMove = Shape.byEncrypted(it.first())
            ownMove = Shape.byEncrypted(it.last())
        }
    }

    override fun evaluate(): Int {
        val matchScore = ownMove.versus(opponentsMove).score
        val moveScore = ownMove.score

        return matchScore + moveScore
    }
}
