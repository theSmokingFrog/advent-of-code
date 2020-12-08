package dev.nilshoffmann.day2

class Password(lowNumber: String, highNumber: String, policyCharacter: String, private val password: String) {
    private val lowNumber: Int = Integer.parseInt(lowNumber)
    private val highNumber: Int = Integer.parseInt(highNumber)
    private val policyChar: Char = policyCharacter[0]

    override fun toString(): String {
        return "[$policyChar -> $lowNumber..$highNumber] $password"
    }

    fun partOnePolicyValid(): Boolean {
        return password.count { c -> c == policyChar } in lowNumber..highNumber
    }

    fun partTwoPolicyValid(): Boolean {
        val firstIndexMatching = password[lowNumber - 1] == policyChar
        val secondIndexMatching = password[highNumber - 1] == policyChar
        return firstIndexMatching xor secondIndexMatching
    }
}