package dev.nhoffmann.aoc.y2023.day1

class CalibrationValues {
    private val mappedDigits = mapOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )

    private val allPossibleValues = mappedDigits.keys + mappedDigits.values;

    fun analyze(calibration: String): Int {
        val first = fetchDigit(calibration.findAnyOf(allPossibleValues)!!.second)
        val last = fetchDigit(calibration.findLastAnyOf(allPossibleValues)!!.second)

        return (first + last).toInt()
    }

    fun analyzeDigitsOnly(calibration: String): Int {
        val firstNum = calibration.first { Character.isDigit(it) }
        val lastNum = calibration.last { Character.isDigit(it) }

        return (firstNum.toString() + lastNum.toString()).toInt()
    }

    private fun fetchDigit(raw: String): String {
        return if (raw.length > 1) {
            mappedDigits[raw] ?: throw RuntimeException("This should never happen; all found values must be found...")
        } else {
            raw
        }
    }
}
