package dev.nhoffmann.aoc.y2021.day6

class Lanternfish(private var spawnTimer: Int = NEW_GENERATION_TIMER) {
    companion object {
        private const val NEW_GENERATION_TIMER = 8
        private const val EXISTING_GENERATION_TIMER = 6
    }

    private val children: MutableList<Lanternfish> = emptyList<Lanternfish>().toMutableList()

    private fun hasChildren(): Boolean = children.isNotEmpty()

    fun deepCount(): Long = if (hasChildren()) children.size + children.sumOf { it.deepCount() } else 0

    fun simulateGrowthInefficient(): Lanternfish? {
        var fishie: Lanternfish? = null
        when (spawnTimer) {
            0 -> {
                spawnTimer = EXISTING_GENERATION_TIMER
                fishie = Lanternfish()
            }
            else -> spawnTimer -= 1
        }
        return fishie
    }

    fun growChildren() {
        if (hasChildren()) {
            children.forEach { it.growChildren() }
        }
        when (spawnTimer) {
            0 -> {
                spawnTimer = EXISTING_GENERATION_TIMER
                children.add(Lanternfish())
            }
            else -> spawnTimer -= 1
        }
    }

    override fun toString(): String {
        return """🐠 [T:$spawnTimer]"""
    }
}
