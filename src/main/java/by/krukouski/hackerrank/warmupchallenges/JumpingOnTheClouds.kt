package by.krukouski.hackerrank.warmupchallenges

import java.util.*

/*
Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus
cloud having a number that is equal to the number of the current cloud plus 1 or 2.
She must avoid the thunderheads. Determine the minimum number of jumps it will take
Emma to jump from her starting position to the last cloud. It is always possible to win the game.
For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 */

/**
 * The method should return the minimum number of jumps required, as an integer.
 * @param c - an array of binary integers
 * @return the minimum number of jumps required, as an integer.
 */
fun jumpingOnClouds(c: Array<Int>): Int {
    var result = 0
    var index = 0

    while (index < c.size) {
        if (index + 2 < c.size && c[index + 2] == 0) {
            index += 2
            result++
        } else if (index + 1 < c.size) {
            index++
            result++
        } else {
            index++
        }
    }

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
