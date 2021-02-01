import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> getListFromIntArray(int[] a){
        return Arrays.stream(a).boxed().collect(Collectors.toList());
    }

    public static List<String> getListFromStringArray(String[] a){
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static HashMap<Integer,Integer> getIntKeyFreqMap(int[] arr) {
        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n =arr.length;
        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i], 0) + 1);
        }

        return elementFreqMap;
    }

    public static boolean isPerfectSquare(int n){
        int s = (int) Math.sqrt(n);
        return ((s*s) == n);
    }

    public static <T> void print2DArray(T[][] a){
        for (T[] ai: a) {
            for (T x: ai) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void printInt2DArray(int[][] a){
        for(int[] aa: a) {
            for(int x: aa) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void printIntArray(int[] arr){
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public static void printIntArray(String msg, int[] arr){
        System.out.print(msg + " ");
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public static int binarySearch(int[] arr, int x){
        // generic binary search
        // given a sorted arr and an element x, find it's position
        // if element is not found, return -1

        int l = 0, n = arr.length, h = n - 1;
        while (l <= h) {
            int m = (l + h)/2;
            if(arr[m] == x) return m;
            else if(arr[m] > x) h = m - 1;
            else l = m + 1;
        }

        return -1;
    }
}
