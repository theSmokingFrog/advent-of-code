package dev.nilshoffmann.day4

import java.lang.Exception
import java.util.*

class Passport private constructor(
    val byr: String?,
    val iyr: String?,
    val eyr: String?,
    val hgt: String?,
    val hcl: String?,
    val ecl: String?,
    val pid: String?,
    val cid: String?
) {

    private fun validateNumberRange(toValidate: String?, intRange: IntRange): Boolean {
        return try {
            Integer.parseInt(toValidate) in intRange
        } catch (e: Exception) {
            false
        }
    }

    fun byrValid(): Boolean {
        return validateNumberRange(byr, 1920..2002)
    }

    fun iyrValid(): Boolean {
        return validateNumberRange(iyr, 2010..2020)
    }

    fun eyrValid(): Boolean {
        return validateNumberRange(eyr, 2020..2030)
    }

    fun hgtValid(): Boolean {
        return try {
            val hgtRegex = """^(\d{2,3})(cm|in)$""".toRegex()
            val (size, unit) = hgtRegex.find(hgt!!)!!.destructured
            when (unit) {
                "in" -> Integer.parseInt(size) in 59..76
                "cm" -> Integer.parseInt(size) in 150..193
                else -> true
            }
        } catch (e: Exception) {
            false
        }
    }

    fun hclValid(): Boolean {
        return try {
            """^#[0-9a-f]{6}$""".toRegex().matches(hcl!!)
        } catch (e: Exception) {
            false
        }
    }

    fun eclValid(): Boolean {
        return try {
            """^(amb|blu|brn|gry|grn|hzl|oth)$""".toRegex().matches(ecl!!)
        } catch (e: Exception) {
            false
        }
    }

    fun pidValid(): Boolean {
        return try {
            """^\d{9}$""".toRegex().matches(pid!!)
        } catch (e: Exception) {
            false
        }
    }

    fun isValidPartOne(): Boolean {
        return listOf(byr != null, iyr != null, eyr != null, hgt != null, hcl != null, ecl != null, pid != null).all { it }
    }

    fun isValidPartTwo(): Boolean {
        return listOf(byrValid(), iyrValid(), eyrValid(), hgtValid(), hclValid(), eclValid(), pidValid()).all { it }
    }

    override fun toString(): String {
        return "byr:$byr|iyr:$iyr|eyr:$eyr|hgt:$hgt|hcl:$hcl|ecl:$ecl|pid:$pid|cid:$cid"
    }

    class Builder {
        private val map = EnumMap<PassportBlock, String>(PassportBlock::class.java)

        fun add(block: PassportBlock, value: String) {
            map[block] = value
        }

        fun build() = Passport(
            map[PassportBlock.BYR],
            map[PassportBlock.IYR],
            map[PassportBlock.EYR],
            map[PassportBlock.HGT],
            map[PassportBlock.HCL],
            map[PassportBlock.ECL],
            map[PassportBlock.PID],
            map[PassportBlock.CID]
        )
    }
}