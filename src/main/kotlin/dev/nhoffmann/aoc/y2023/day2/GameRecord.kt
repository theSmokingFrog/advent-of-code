package dev.nhoffmann.aoc.y2023.day2

class GameRecord(data: String) {
    companion object {
        private val basicGame = Regex("""Game (\d{1,3}):(.*)""")
    }

    val id: Int
    private val pulls: List<String>

    init {
        val basicResult = basicGame.find(data) ?: throw RuntimeException("Could not match GameRecord")
        basicResult.destructured.let { (id: String, records: String) ->
            this.id = id.toInt()
            pulls = records.split(";").map { it.trim() }
        }
    }

    private fun groupPulls(): Map<String, List<String>> {
        return pulls
            .map { pull -> pull.split(",").map { it.trim() } }
            .flatten()
            .map { it.split(" ") }
            .groupBy({ it[1] }, { it[0] })
    }

    fun isPossible(thresholds: Thresholds): Boolean {
        return groupPulls().map { it.value.all { cubes -> cubes.toInt() <= thresholds.byString(it.key) } }.all { it }
    }

    fun getPower(): Int {
        return groupPulls()
            .mapValues { it.value.maxOf { count -> count.toInt() } }
            .values
            .reduce { acc, i -> i * acc }
    }

    override fun toString(): String {
        return "GameRecord(id=$id)"
    }


}
