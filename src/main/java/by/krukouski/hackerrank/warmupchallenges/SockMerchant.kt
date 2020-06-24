package by.krukouski.hackerrank.warmupchallenges

import java.util.*

/*
John works at a clothing store.
He has a large pile of socks that he must pair by color for sale.
Given an array of integers representing the color of each sock,
determine how many pairs of socks with matching colors there are.
 */

/**
 * @param n - the number of socks in the pile
 * @param ar - the colors of each sock
 * @return an integer representing the number of matching pairs of socks that are available
 */
fun sockMerchant(n: Int, ar: Array<Int>): Int {

    var result = 0
    val list = arrayListOf<Int>()

    ar.forEach { el ->
        run {
            if (result >= n/2) {
                return@forEach
            }
            if (list.contains(el)) {
                result++
                list.remove(el)
                return@run
            }
            list.add(el)
        }
    }

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}