package dev.nhoffmann.aoc.y2020.day4

import java.util.function.Predicate

enum class PassportBlock(private val validator: Predicate<String>) {
    BYR(Predicate { Integer.parseInt(it) in 1920..2002 }),
    IYR(Predicate { Integer.parseInt(it) in 2010..2020 }),
    EYR(Predicate { Integer.parseInt(it) in 2020..2030 }),
    HGT(Predicate {
        val (size, unit) = """^(\d{2,3})(cm|in)$""".toRegex().find(it)!!.destructured
        when (unit) {
            "in" -> Integer.parseInt(size) in 59..76
            "cm" -> Integer.parseInt(size) in 150..193
            else -> false
        }
    }),
    HCL(Predicate { """^#[0-9a-f]{6}$""".toRegex().matches(it) }),
    ECL(Predicate { """^(amb|blu|brn|gry|grn|hzl|oth)$""".toRegex().matches(it) }),
    PID(Predicate { """^\d{9}$""".toRegex().matches(it) }),
    CID(Predicate { true });

    fun validate(value: String): Boolean {
        return try {
            this.validator.test(value)
        } catch (e: Exception) {
            false
        }
    }
}
