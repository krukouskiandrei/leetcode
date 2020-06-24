package by.krukouski.hackerrank.warmupchallenges

import java.util.*
import kotlin.collections.ArrayList

/*
Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 */

const val LETTER: Char = 'a'

/**
 * The method should return an integer representing the number of occurrences
 * of a in the prefix of length {@param n} in the infinitely repeating string.
 * @param s - a string to repeat
 * @param n - the number of characters to consider
 * @return an integer representing the number of occurrences of a in
 * the prefix of length n in the infinitely repeating string
 */
fun repeatedString(s: String, n: Long): Long {
    val indexesOfNeededLetter = ArrayList<Int>()

    s.toCharArray().forEachIndexed { index, c ->
        run {
            if (c == LETTER) {
                indexesOfNeededLetter.add(index)
            }
        }
    }

    val countOfFullString = n / s.length
    val lengthOfLeftSubstring = n % s.length

    var result = countOfFullString * indexesOfNeededLetter.size

    result += indexesOfNeededLetter.filter { it + 1 <= lengthOfLeftSubstring }.count()

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}