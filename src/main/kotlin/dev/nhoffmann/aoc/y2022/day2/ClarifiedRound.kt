package dev.nhoffmann.aoc.y2022.day2

class ClarifiedRound(strategyGuideLine: String) : Round {
    private val opponentsMove: Shape
    private val necessaryResult: Result

    init {
        strategyGuideLine.split(" ").let {
            opponentsMove = Shape.byEncrypted(it.first())
            necessaryResult = Result.byEncrypted(it.last())
        }
    }

    override fun evaluate(): Int {
        val ownMove = opponentsMove.findCounterpart(necessaryResult)

        return necessaryResult.score + ownMove.score
    }
}
