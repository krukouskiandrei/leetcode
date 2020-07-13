package by.krukouski.hackerrank.arrays;

import java.io.IOException;
import java.util.Scanner;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array
 * in ascending order.
 */
public class MinimumSwaps2 {

    /**
     * Calculating an integer representing the minimum number of swaps to sort the array.
     * @param arr an unordered array of integers
     * @return an integer representing the minimum number of swaps to sort the array
     */
    static int minimumSwaps(int[] arr) {
        int minimumSwaps = 0;

        for(int i = 0; i < arr.length - 1;) {
            if (arr[i] == i + 1) {
                i++;
                continue;
            }
            int tempValue = arr[i];
            arr[i] = arr[tempValue - 1];
            arr[tempValue - 1] = tempValue;
            minimumSwaps++;
        }

        return minimumSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println("Result: " + res);

        scanner.close();
    }

}
