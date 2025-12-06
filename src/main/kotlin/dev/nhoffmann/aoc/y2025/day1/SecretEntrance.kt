package dev.nhoffmann.aoc.y2025.day1

class SecretEntrance(var dialValue: Int = 50, val dialSize: Int = 100) {
    companion object {
        private val ROTATION_REGEX = Regex("""^([LR])(\d+)""")
    }
    val dial = Dial(dialValue, dialSize)
    var zerosInSequence = 0

    fun unlockStandard(rotations: List<String>) {
        rotations.forEach { rotation ->
            val (direction, value) = ROTATION_REGEX.find(rotation)!!.destructured
            when (direction) {
                "L" -> dial.toLeft(value.toInt())
                "R" -> dial.toRight(value.toInt())
                else -> throw RuntimeException("Invalid rotation: $rotation")
            }

            if (dial.current == 0) {
                zerosInSequence++
            }
        }
    }

    fun unlockWithCLICK(rotations: List<String>) {
        rotations.forEach { rotation ->
            val (direction, value) = ROTATION_REGEX.find(rotation)!!.destructured
            when (direction) {
                "L" -> dial.toLeft(value.toInt())
                "R" -> dial.toRight(value.toInt())
                else -> throw RuntimeException("Invalid rotation: $rotation")
            }
        }
    }


    override fun toString(): String {
        return "SecretEntrance(dialValue=$dialValue, dialSize=$dialSize)"
    }
}