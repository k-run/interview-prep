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

    public int strStr(String hs, String needle) {
        // if needle is empty, return 0
        // store the needle's length in len
        // get substrings of size len from hs
        // if the substring == needle, return i

        int n = hs.length();

        int len = needle.length();

        if(len == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            String subStr = hs.substring(i, (i+len) > n ? n : (i+len));
            if(subStr.equals(needle)) {
                return i;
            }
        }

        return (-1);
    }

    public static int searchInsertPosition(int[] arr, int k){
        // return k's position in arr, if found
        // else the suitable one if it was present

        int n = arr.length;
        int l = 0, h = n-1;

        while(l<=h) {
            int m = (l+h)/2;
            if(arr[m]==k) return m;
            if(arr[m] > k) h = m - 1;
            else l = m + 1;
        }

        return l;
    }

    public static int climbingStairs(int n){
        // every step can be climbed only by combo of 1 or 2 steps
        // step 1 from base can be climbed only in 1 way
        // step 2 from base can be climbed in 2 ways
        // rest, steps are dependent on previous steps

        int[] arr = new int[n+2];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }


    public Node deleteDuplicates(Node head) {
        // 2-pointer algorithm
        // keep one ptr at head, acc and run other till
        // both are not equal.
        // change acc's next to runn
        // increment both runn and acc

        Node ptr = head, ptr2;
        if(head == null) return null;

        while(ptr != null) {
            ptr2 = ptr.next;
            while(ptr2!=null && ptr2.val == ptr.val) ptr2 = ptr2.next;
            ptr.next = ptr2;
            ptr = ptr2;
        }

        return head;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return p's data == q's data & left and right subtree
        // are also equal
        if(p == null && q==null) return true;
        if(p==null || q==null) return false;

        return (p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }

    public static int maxDepthOfBinaryTree(TreeNode root){
        // ans would be 1 + max(left height, right height)
        // base case: root == null, return 0

        if(root == null) return 0;
        int l_h = maxDepthOfBinaryTree(root.left);
        int r_h = maxDepthOfBinaryTree(root.right);

        return 1 + Math.max(l_h ,r_h);
    }
    
    public static void twoSum2(int[] arr, int k){
        // the array is sorted
        // 2-pointer algorithm

        int n = arr.length, i = 0,j = n-1;

        while (i < j) {
            if(arr[i] + arr[j] == k) {
                System.out.println((i+1) + " " + (j+1));
                return;
            }

            else if(arr[i] + arr[j] > k) j--;
            else i++;
        }
    }

    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }
}
