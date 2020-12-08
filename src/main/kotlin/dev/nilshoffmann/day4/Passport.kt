package dev.nilshoffmann.day4

import java.util.*

class Passport private constructor(
    val byr: String?, val iyr: String?, val eyr: String?, val hgt: String?, val hcl: String?, val ecl: String?, val pid: String?, val cid: String?
) {

    override fun toString(): String {
        return "byr:$byr|iyr:$iyr|eyr:$eyr|hgt:$hgt|hcl:$hcl|ecl:$ecl|pid:$pid|cid:$cid"
    }

    fun isValid(): Boolean {
        return byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null
    }

    class Builder {
        private val map = EnumMap<PassportBlock, String>(PassportBlock::class.java)

        fun add(block: PassportBlock, value: String) {
            map[block] = value
        }

        fun build() = Passport(
            map[PassportBlock.byr],
            map[PassportBlock.iyr],
            map[PassportBlock.eyr],
            map[PassportBlock.hgt],
            map[PassportBlock.hcl],
            map[PassportBlock.ecl],
            map[PassportBlock.pid],
            map[PassportBlock.cid]
        )
    }
}