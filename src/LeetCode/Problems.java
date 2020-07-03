package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class Problems {
    public static void twoSum(int[] arr, int k) {
        // create a map of ele vs idx
        // if map contains k - ele & it's value != current idx, then print

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        System.out.println("map = " + map);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i]) && i != map.get(k - arr[i])) {
                System.out.println(i + " " + map.get(k - arr[i]));
                break;
            }
        }
    }

    public static void reverseInteger(int n) {
        // if an integer is -ve, remove the sign
        // if an integer ends with 0, remove the 0
        // if an integer is out of bounds, return 0


        boolean isNegative = false;

        if (n < 0) {
            n = -n;
            isNegative = true;
        }


        System.out.println("n = " + n);
        int toParse;
        if (n % 10 == 0) {
            toParse = n / 10;
        } else {
            toParse = n;
        }

        try {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(toParse));
            String reversed = stringBuilder.reverse().toString();
            System.out.println("reversed = " + reversed);

            System.out.println(isNegative ? "-" + reversed : reversed);
        } catch (Exception e) {
            System.out.println(0);
        }


    }

    public static boolean isPalindrome(int n){
        // if a number is negative, return false
        // else do 2-pointer algo

        if(n < 0) return false;

        String init = String.valueOf(n);

        StringBuilder stringBuilder = new StringBuilder(init);

        String reversed = stringBuilder.reverse().toString();

        return reversed.equals(init);
    }

    public static void romanToInteger(String str) {
        // check for 6 subtraction cases
        // if not then create a map of roman to int value
        // if the roman value is made up of combo of 2-length & single length,
        // then choose 2-length

        int n = str.length();

        HashMap<String, Integer> romanToIntValueMap = new HashMap<>();

        romanToIntValueMap.put("I", 1);
        romanToIntValueMap.put("V", 5);
        romanToIntValueMap.put("X", 10);
        romanToIntValueMap.put("L", 50);

        romanToIntValueMap.put("C", 100);
        romanToIntValueMap.put("D", 500);
        romanToIntValueMap.put("M", 1000);

        romanToIntValueMap.put("IV", 4);

        romanToIntValueMap.put("IX", 9);
        romanToIntValueMap.put("XL", 40);

        romanToIntValueMap.put("XC", 90);
        romanToIntValueMap.put("CD", 400);
        romanToIntValueMap.put("CM", 900);

        int ans = 0;

        for (int i = 0; i < n; ) {
            String s1 = ((i+1) < n) ? str.substring(i,i+1) : str.substring(i, n);
            String s2 = ((i+2) < n) ? str.substring(i,i+2) : str.substring(i, n);

            int value1 = romanToIntValueMap.get(s1);
            int value2 = romanToIntValueMap.getOrDefault(s2, 0);

            if(value2 != 0) {
                if(value1 > value2) {
                    ans += value1;
                    i++;
                }
                else {
                    ans += value2;
                    i+=2;
                }

            }
            else {
                ans+= value1;
                i++;
            }
        }

        System.out.println("ans = " + ans);
    }

    public static boolean validParentheses(String string){
        // push it to stack if an opening brace is found
        // as soon as a closing is found, match the top
        // of the stack with the closing one.

        Stack<Character> openingStack = new Stack<>();
        int n = string.length();

        int i;
        for (i = 0; i < n; i++) {
            if(string.charAt(i) == '{' || string.charAt(i) == '('
                    || string.charAt(i) == '[') openingStack.push(string.charAt(i));

            else {
                if(openingStack.isEmpty()) return false;
                if(string.charAt(i) == '}') {
                    if(openingStack.pop() != '{') break;
                }

                else if(string.charAt(i) == ')') {
                    if(openingStack.pop() != '(') break;
                }

                else if(string.charAt(i) == ']') {
                    if(openingStack.pop() != '[') break;
                }
            }
        }

        return openingStack.isEmpty() && i >= n;
    }
}
