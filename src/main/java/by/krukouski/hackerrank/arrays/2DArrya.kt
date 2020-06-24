package by.krukouski.hackerrank.arrays

import java.util.*

/*
Given a 6x6 2D Array, arr. There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
hourglass:
a b c
  d
e f g
 */

/**
 * The method should return an integer, the maximum hourglass sum in the array
 * @param arr - an array of integers
 * @return the maximum hourglass sum in the array
 */
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxResult = -1000000000

    var i = 0
    var j = 0
    while (i < arr.size - 2) {
        if ( j >= arr[i].size - 2) {
            j = 0
            i++
            continue
        }

        val tempResult = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] +
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
        if (tempResult > maxResult) {
            maxResult = tempResult
        }
        j++
    }

    return maxResult
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}