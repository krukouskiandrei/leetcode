package by.krukouski.hackerrank.warmupchallenges

import java.util.*

/*
Gary is an avid hiker. He tracks his hikes meticulously,
paying close attention to small details like topography.
During his last hike he took exactly n steps.
For every step he took, he noted if it was an uphill, U, or a downhill, D step.
Gary's hikes start and end at sea level and each step up or down represents
a 1 unit change in altitude. We define the following terms:
  - A mountain is a sequence of consecutive steps above sea level,
    starting with a step up from sea level and ending with a step down to sea level.
  - A valley is a sequence of consecutive steps below sea level, starting with a step down
    from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 */

const val UP: Char = 'U'
const val DOWN: Char = 'D'

/**
 * @param n - the number of steps Gary takes
 * @param s - a string describing his path
 * @return an integer that denotes the number of valleys Gary traversed
 */
fun countingValleys(n: Int, s: String): Int {

    var countOfValues = 0
    val stack: Deque<Char> = LinkedList()

    s.toCharArray().forEach() { el -> run {
        if (stack.size > n/2) {
            return@forEach
        }
        if (stack.isEmpty()) {
            stack.add(el)
            return@run
        }
        if (stack.last == DOWN && el == UP) {
            stack.removeLast()
            if (stack.isEmpty()) {
                countOfValues++
            }
            return@run
        } else if (stack.last == UP && el == DOWN) {
            stack.removeLast()
            return@run
        }
        stack.addLast(el)
    } }

    return countOfValues
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}