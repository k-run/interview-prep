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
    
    public static void reverseInteger(int n){
        // if an integer is -ve, remove the sign
        // if an integer ends with 0, remove the 0
        // if an integer is out of bounds, return 0


        boolean isNegative = false;

        if(n < 0) {
            n = -n;
            isNegative = true;}


            System.out.println("n = " + n);
            int toParse;
            if (n % 10 == 0) {
                toParse = n / 10;
            }
            else {
                toParse = n;
            }

            try{
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(toParse));
                String reversed = stringBuilder.reverse().toString();
                System.out.println("reversed = " + reversed);

                System.out.println(isNegative ? "-" + reversed : reversed);
            }

            catch (Exception e) {
                System.out.println(0);
            }


    }
}
