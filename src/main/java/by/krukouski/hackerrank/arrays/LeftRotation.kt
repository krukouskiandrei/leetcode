package by.krukouski.hackerrank.arrays

import java.util.*
import kotlin.collections.ArrayList

/*
Given an array a of n integers and a number, d, perform d left rotations on the array.
Return the updated array to be printed as a single line of space-separated integers.
 */

/**
 * The method should return the resulting array of integers
 * @param a - an array of integers
 * @param d - the number of rotations
 * @return the resulting array of integers
 */
fun rotLeft(a: Array<Int>, d: Int): IntArray {

    var startIndex = d % a.size

    if (startIndex == 0) {
        return a.toIntArray()
    }

    val result = ArrayList<Int>()
    result.addAll(a.copyOfRange(startIndex, a.size))
    result.addAll(a.copyOfRange(0, startIndex))

    return result.toIntArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}