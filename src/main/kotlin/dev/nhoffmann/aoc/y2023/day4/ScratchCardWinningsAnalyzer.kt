package dev.nhoffmann.aoc.y2023.day4

class ScratchCardWinningsAnalyzer(private val cards: List<ScratchCard>) {
    private val mappedCards: Map<Int, ScratchCard> = cards.associateBy { it.id }

    fun determineFinalAmountOfCards(): Int {
        return analyzeCards(cards)
    }

    private fun analyzeCards(cards: List<ScratchCard>): Int {
        val wonCards = cards.map {
            val wins = it.countWins()
            if (wins > 0) {
                val wonCardIds = it.id + 1..it.id + wins
                wonCardIds.mapNotNull { id -> mappedCards[id] }
            } else {
                emptyList()
            }
        }.flatten()

        return if (wonCards.isNotEmpty()) {
            cards.size + analyzeCards(wonCards)
        } else {
            cards.size
        }
    }
}
