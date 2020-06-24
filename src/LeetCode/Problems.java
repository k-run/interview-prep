package LeetCode;

import java.util.HashMap;

public class Problems {
    public static void twoSum(int[] arr, int k){
        // create a map of ele vs idx
        // if map contains k - ele & it's value != current idx, then print

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        System.out.println("map = " + map);

        for (int i = 0; i < n; i++) {
            if(map.containsKey(k-arr[i]) && i != map.get(k-arr[i])) {
                System.out.println(i + " " + map.get(k-arr[i]));
                break;
            }
        }
    }
}
