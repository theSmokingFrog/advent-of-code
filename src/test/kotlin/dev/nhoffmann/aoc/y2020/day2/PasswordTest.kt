package dev.nhoffmann.aoc.y2020.day2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PasswordTest {
    companion object {
        @JvmStatic
        fun onlyPartOnePolicyValidPasswords(): List<Password> = listOf(
            Password("1", "1", "a", "a"),
            Password("1", "2", "a", "aabcde"),
            Password("3", "5", "z", "abcdezzzz")
        )

        @JvmStatic
        fun onlyPartTwoPolicyValidPasswords(): List<Password> = listOf(
            Password("1", "4", "a", "acbbcaaaaa"),
            Password("2", "3", "b", "bbabb"),
            Password("5", "2", "c", "acfffffff")
        )

        @JvmStatic
        fun passwordsNotMatchingPolicyOne(): List<Password> = listOf(
            Password("1", "2", "a", "aaa"),
            Password("3", "4", "b", "bb"),
        )

        @JvmStatic
        fun passwordsNotMatchingPolicyTwo(): List<Password> = listOf(
            Password("1", "3", "a", "aaa"),
            Password("1", "3", "a", "bbb"),
        )
    }

    @ParameterizedTest(name = "Validating {0}")
    @MethodSource("onlyPartOnePolicyValidPasswords")
    fun `Only Part One Policy Passwords are valid`(password: Password) {
        assertTrue(password.partOnePolicyValid())
        assertFalse(password.partTwoPolicyValid())
    }

    @ParameterizedTest(name = "Validating {0}")
    @MethodSource("onlyPartTwoPolicyValidPasswords")
    fun `Only Part Two Policy Passwords are valid`(password: Password) {
        assertFalse(password.partOnePolicyValid())
        assertTrue(password.partTwoPolicyValid())
    }

    @ParameterizedTest(name = "Validating {0}")
    @MethodSource("passwordsNotMatchingPolicyOne")
    fun `Expect Passwords to not match Part One Policy`(password: Password) {
        assertFalse(password.partOnePolicyValid())
    }

    @ParameterizedTest(name = "Validating {0}")
    @MethodSource("passwordsNotMatchingPolicyTwo")
    fun `Expect Passwords to not match Part Two Policy`(password: Password) {
        assertFalse(password.partTwoPolicyValid())
    }
}
