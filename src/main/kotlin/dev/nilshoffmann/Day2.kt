package dev.nilshoffmann

class PasswordEntry(private val lowestNumber: Int, private val highestNumber: Int, private val policyCharacter: Char, private val password: String) {
    override fun toString(): String {
        return "[$policyCharacter -> $lowestNumber..$highestNumber] $password"
    }

    fun policyQuiz1Valid(): Boolean {
        return password.count { c -> c == policyCharacter } in lowestNumber..highestNumber
    }

    fun policyQuiz2Valid(): Boolean {
        val firstIndexMatching = password[lowestNumber - 1] == policyCharacter
        val secondIndexMatching = password[highestNumber - 1] == policyCharacter
        return firstIndexMatching xor secondIndexMatching
    }
}

class Day2 {
    private fun readInputData(): List<String> {
        javaClass.getResourceAsStream("/inputs/input-day-2.txt").bufferedReader().use { reader ->
            println(">> Reading Inputs")
            val listOfPasswords = reader.readLines()
            println(">> Found ${listOfPasswords.size} passwords...")
            return listOfPasswords
        }
    }

    private fun preparePasswordEntries(): List<PasswordEntry> {
        val passwordEntries = readInputData()
        val passwordLineRegex = """^(\d+)-(\d+) (\w)\W*(\w+)""".toRegex()
        println(">> Converting Strings to Password Entries...")
        return passwordEntries.map {
            val (low, high, ch, pw) = passwordLineRegex.find(it)!!.destructured
            PasswordEntry(Integer.parseInt(low), Integer.parseInt(high), ch[0], pw)
        }
    }

    fun solveQuiz1() {
        println("Solving Day 2, Quiz 1...")
        val passwordEntries = preparePasswordEntries()
        println(">> Filtering for valid Passwords...")
        val validPasswords = passwordEntries.filter { it.policyQuiz1Valid() }
        println(">> Found ${validPasswords.size} valid passwords")
        println("###################################################")
    }

    fun solveQuiz2() {
        println("Solving Day 2, Quiz 1...")
        val passwordEntries = preparePasswordEntries()
        println(">> Filtering for valid Passwords...")
        val validPasswords = passwordEntries.filter { it.policyQuiz2Valid() }
        println(">> Found ${validPasswords.size} valid passwords")
        println("###################################################")
    }
}

fun main() {
    val day2 = Day2()
    day2.solveQuiz1()
    day2.solveQuiz2()
}