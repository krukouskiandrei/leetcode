package by.krukouski.leetcode.topinterviewquestions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> numbers = IntStream.of(nums)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);
            if (value > 0) {
                break;
            }
            List<Integer> subArray = numbers.stream()
                    .skip(i + 1)
                    .collect(Collectors.toList());

            result.addAll(twoSum(value, subArray));
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

    private List<List<Integer>> twoSum(int value, List<Integer> subArray) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < subArray.size(); i++) {
            int tempValue = subArray.get(i);
            subArray.stream()
                    .skip(i + 1)
                    .filter(val -> val == - (tempValue + value))
                    .forEach(val -> {
                        List<Integer> temList = Arrays.asList(value, tempValue, val);
                        temList.sort(Comparator.naturalOrder());
                        result.add(temList);
                    });
        }

        return result;
    }

}
