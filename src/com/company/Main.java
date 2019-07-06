package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] arr = {657, 123, 454, 600, 189, 661, 989, 899, 998};
        int[] arr2 = {2, 4, -1, 0, 1, 1, 1, 2};
        int number = 325558796;
        System.out.println(solution(arr));
        System.out.println(solution1(number));
        System.out.println(solution2(arr2));
    }

    private static int solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i] / 100 + (arr[i] % 100) / 10 + arr[i] % 10;
            if (sum == temp) {
                result.add(arr[i]);
            }
            if (sum > temp) {
                temp = sum;
                result.clear();
                result.add(arr[i]);
            }
        }
        result.sort(Integer::compareTo);
        return result.get(0);
    }

    private static int solution1(int number) {
        List<Integer> res = new ArrayList<>();
        while (number > 0) {
            res.add(number % 10);
            number = number / 10;
        }
        Collections.sort(res);
        int result = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result = result * 10 + res.get(i);
        }
        return result;
    }

    private static int solution2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = 1;
            if (map.get(arr[i]) == null) {
                map.put(arr[i], value);
            } else {
                value = map.get(arr[i]);
                map.put(arr[i], ++value);
            }
        }
        List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        int result = 0;
        for (int j = 1; j < keys.size() - 1; j++) {
            if (keys.get(j) - keys.get(j - 1) == 1 && keys.get(j + 1) - keys.get(j) == 1) {
                result = result + map.get(keys.get(j));
            }
        }
        return result;
    }
}
