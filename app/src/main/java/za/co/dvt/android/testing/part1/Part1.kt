package za.co.dvt.android.testing.part1

import java.util.Locale

/**
 * Part 1 - JUnit Basics
 * Get familiar with the basics of writing JUnit tests!
 */
class Part1 {

    fun toAllCaps(input: String?): String {
        if (input == null) {
            return ""
        }
        return input.toUpperCase(Locale.getDefault())
    }

    fun isEven(input: Int): Boolean {
        return input % 2 == 0
    }

    companion object {

        @JvmStatic
        fun createIfNull(input: Part1?): Part1 {
            return input ?: Part1()
        }

    }

}