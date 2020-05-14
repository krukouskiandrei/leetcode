package by.krukouski.hackerrank.heap;

import java.util.ArrayList;
import java.util.List;

public class RunningMedian {

    public static double[] runningMedian(int[] a) {

        double[] results = new double[a.length];
        List<Integer> sortedArray = new ArrayList<>();

        for(int i = 0; i < a.length; i++) {
            addValueToArrayOnPosition(a[i], sortedArray, 0, sortedArray.size());

            double medianOfValues = i % 2 == 0 ? getMedianOfValuesInOddArray(sortedArray) :
                    getMedianOfValuesInEvenArray(sortedArray);

            results[i] = medianOfValues;
        }

        return results;
    }

    private static double getMedianOfValuesInEvenArray(final List<Integer> array) {
        int size = array.size();
        return  ((double) (array.get(size / 2) + array.get((size / 2) - 1)) / 2);
    }

    private static double getMedianOfValuesInOddArray(final List<Integer> array) {
        int size = array.size();
        return array.get(size / 2);
    }

    private static void addValueToArrayOnPosition(final int value, final List<Integer> array,
                                                  final int start, final int finish) {
        if (finish == 0) {
            array.add(value);
            return;
        }

        int position = (finish + start) / 2;
        int count = (finish - start) / 2;
        if (count == 0 && value < array.get(start)) {
            array.add(start, value);
            return;
        } else if (count == 0 && value > array.get(finish - 1)) {
            array.add(finish, value);
            return;
        } else if (count == 0) {
            array.add(finish, value);
            return;
        }

        if (value < array.get(position)) {
            addValueToArrayOnPosition(value, array, start, position);
        } else {
            addValueToArrayOnPosition(value, array, position, finish);
        }
    }

}
