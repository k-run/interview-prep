//import javafx.util.Pair;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.tree.TreeNode;


public class ClassPrac extends TemplateClass {
    static long[] a = new long[100000];


    public static void main(String args[]) throws IOException {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] arr = br.readLine().split(" ");
//        long x = Long.parseLong(arr[0]);
//        long n = Long.parseLong(arr[1]);


        //System.out.println(Arrays.stream(Arrays.copyOfRange(a, 37, 42)).sum());
//        int[] arr = {0,10,20,30};
//        numberOfNumbers(arr, 0);
        TemplateClass.inputAsTcNKArray();
    }

    public static void lastDigitUtil(long x, long n) {
        powerOf(x, n);
    }

    // equation: x^(n! mod 10)
    /*
        first - calculate n!
        second - calculate result 1 mod 10
        third - calculate pow(x, result 2)
        fourth - return last digit of result 3
    */

    public static long factorialUtil(long n) {
        a[0] = 1;
        a[1] = 1;
        if (a[(int) n] != 0L) return a[(int) n];
        return factorial(n);
    }

    public static long factorial(long n) {
        for (int i = 2; i <= n; i++) {
            a[i] = i * a[i - 1];
        }
        return a[(int) n];
    }

    public static long modulo(long n) {
        return n % 10;
    }

    public static void powerOf(long x, long n) {
        long factorialValue = factorialUtil(n);
        long modValue = modulo(factorialValue);
        long result = (long) Math.pow(x, n);
        System.out.println(result % 10);


    }

    public static void printArr(String[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print(arr[0]);
        for (int i = arr.length - 1; i >= 1; i--) {
            System.out.print(arr[i]);
        }
    }

    // Create a treemap of List<Integer> as list of data of trailing d days
    // and Integer as value of arr on dth day
    // Now, find median from the key and compare it with value
//    public static void fraudActivities(int[] arr, int d){
//        TreeMap<List<Integer>, Integer> map = new TreeMap<>();
//        int j = 0, c=0;
//        for (int i = d; i< arr.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            int pos = j;
//            while (j < i) list.add(j++);
//            j = pos + 1;
//            map.put(list, arr[i]);
//        }
//
//        System.out.println("map = " + map);
//
//        for (Map.Entry<List<Integer>,Integer> entry: map.entrySet()) {
//            int median = 0;
//            if((entry.getKey().size() - 1) % 2 == 0) {
//                median = entry.getKey().get((entry.getKey().size() - 1)/2);
//            }
//            else {
//                List<Integer> key = entry.getKey();
//                int n = key.size();
//                int leftValue = key.get(n/2);
//                int righValue =key.get((n+1)/2);
//
//                System.out.println("leftValue = " + leftValue);
//                System.out.println("righValue = " + righValue);
//
//                median = (leftValue + righValue)/2;
//            }
//            if(entry.getValue() >= 2 * median) c++;
//        }
//
//        System.out.println("c = " + c);
//    }

    public static void maxValue(int[] arr) {
        int n = arr.length;
        int mod = Math.floorMod(n, 2);
        StringBuilder sb = new StringBuilder();

        String[] strArr = Arrays.
                toString(arr).
                substring(1, Arrays.toString(arr).length() - 1).
                replaceAll(" ", "").
                split(",");

        System.out.println("strArr = " + Arrays.toString(strArr));


        StringBuilder stringBuilder2 = new StringBuilder();
        String max = "0";
        for (String s : strArr) {
            stringBuilder2.append(s);
        }
        System.out.println("stringBuilder2 = " + stringBuilder2);


        for (int i = 0; i < strArr.length; i++) {
            String sub;
            sub = stringBuilder2.substring(0, strArr[i].length());

            stringBuilder2.append(sub);
            System.out.println("stringBuilder2 = " + stringBuilder2);
            stringBuilder2.delete(0, sub.length());

            max = String.valueOf(Math.max(Long.valueOf(max), Long.valueOf(stringBuilder2.toString())));
            System.out.println("max = " + max);
        }

        System.out.print(max + " ");
    }


    public static void anagramOccurences(String str1, String str2) {
        int n = str1.length();
        int j = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        map.values().stream().allMatch(e -> e.equals(map.values().stream().findFirst()));

        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) + 1);
        }

        System.out.println("map = " + map);

        for (int i = 0; i <= n - str2.length(); i++) {
            String sub = str1.substring(i, i + str2.length());
            HashMap<Character, Integer> subMap = new HashMap<>();
            for (int k = 0; k < sub.length(); k++) {
                subMap.put(sub.charAt(k), subMap.getOrDefault(sub.charAt(k),
                        0) + 1);
            }

            if (subMap.equals(map)) count++;
        }

        System.out.println("count = " + count);
    }

    public static void placementTour(int[] arr, int b) {
        int gCost = 0, n = arr.length;
        int i, j = 0, ans = 0;
        boolean isBroke = false;
        while (gCost < b) {
            for (i = 0; i < n; i++) {
                int lCost = 0;
                for (j = 0; j <= i; j++) {
                    lCost += (arr[j] + ((j + 1) * (i + 1)));
                }
                System.out.println("lCost = " + lCost);
                if (lCost > b) {
                    isBroke = true;
                    break;
                } else {
                    gCost = Math.max(lCost, gCost);
                    ans = gCost;
                }
            }
            if (isBroke) {
                j = j - 1;
                break;
            }
        }

        System.out.println(j + " " + ans);
    }


    public static void numberOfTriplets(int[] arr, int a, int b) {
        // B - number of triplets having sum <= b
        // A - number of triplets having sum < a
        // ans = B - A

        int tripletsA = getNumberOfTripletsWithSumLessThan(arr, a - 1);
        int tripletsB = getNumberOfTripletsWithSumLessThan(arr, b);

        System.out.println("tripletsA = " + tripletsA);
        System.out.println("tripletsB = " + tripletsB);

        System.out.println(tripletsB - tripletsA);
    }

    public static int getNumberOfTripletsWithSumLessThan(int[] arr, int a) {
        // sort the arr
        // for i = 0 to n-2, j= i + 1, k = n-1
        // if arr[i] + arr[j] + arr[k] >= k--
        // else ans += k-j // j++

        Arrays.sort(arr);
        int n = arr.length, ans = 0;
        int j, k;
        for (int i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j != k) {
                if (arr[i] + arr[j] + arr[k] > a) k--;

                else {
                    ans += (k - j);
                    j++;
                }
            }
        }

        return ans;
    }

    public static void sumsDifference(int[] arr) {

        List<Integer> sameFreqList = new ArrayList<>();
        List<Integer> diffFreqList = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int e = arr[i];
            String[] str = String.valueOf(e).split("");
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (String s : str) {
                countMap.put(Integer.valueOf(s),
                        countMap.getOrDefault(Integer.valueOf(s), 0) + 1);
            }
            int value = countMap.values().stream().findFirst().get();

            if (countMap.values().stream().allMatch(v -> v.equals(value))) sameFreqList.add(e);
            else diffFreqList.add(e);
        }

        System.out.println("sameFreqList = " + sameFreqList);
        System.out.println("diffFreqList = " + diffFreqList);

        System.out.println(sameFreqList.stream().reduce(0, (a, b) -> (a + b)));
        System.out.println(diffFreqList.stream().reduce(0, (x, y) -> (x + y)));

        int diff = sameFreqList.stream().reduce(0, (a, b) -> (a + b)) -
                diffFreqList.stream().reduce(0, (x, y) -> (x + y));

        System.out.println("diff = " + diff);
    }

    public static void kPairsWithSmallestSums(int[] a, int[] b, int k) {
        int count = 0;
        int i = 0, j = 0, m = a.length, n = b.length, start = 0;
        //List<Pair<Integer, Integer>> list = new ArrayList<>();

        while (i < m && j < n) {
            while (count < k) {

                //Pair<Integer, Integer> pair = new Pair<>(a[i],b[j]);
                //list.add(pair);
                count++;

                if (i == m) {
                    System.out.println("i = " + i);
                    System.out.println("start = " + start);
                    //System.out.println("list = " + list);
                    System.out.println("count = " + count);

                    if (a[i - 1] > b[j]) {
                        i = start + 1;
                        j++;
                    }
                }


                if (a[i] > b[j]) {
                    start = (start == 0 ? i : start);
                    i++;
                } else {
                    start = (start == 0 ? j : start);
                    j++;
                }

            }

            if (i == m) {
                System.out.println("i = " + i);
                System.out.println("start = " + start);
                //System.out.println("list = " + list);
                System.out.println("count = " + count);

                if (a[i - 1] > b[j]) {
                    i = start + 1;
                    j++;
                }
            } else {
                System.out.println("j = " + j);
                System.out.println("start = " + start);
                //System.out.println("list = " + list);
                System.out.println("count = " + count);

                if (b[j - 1] > a[i]) {
                    j = start + 1;
                    i++;
                }
            }
        }
        //System.out.println("list = " + list);
    }

    public static void equilibriumArray(int[] arr) {
        int l = 0, n = arr.length, r = n - 1;
        int l_sum = 0, r_sum = 0;
        int sum = Arrays.stream(arr).sum();

        for (int i = 1; i < n; i++) {
            r_sum = sum - l_sum - arr[i];
            if (l_sum == r_sum) {
                System.out.println("i = " + i);
                break;
            }
        }
        System.out.println(-1);
    }

    public static void countOfSubarraysWithSum(int[] arr, int x) {
        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        int n = arr.length, sum = 0, result = 0;
        sumCountMap.put(0, 1);

        for (int value : arr) {
            sum += value;

            if (sumCountMap.containsKey(sum - x)) {
                result += sumCountMap.get(sum - x);
            }

            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }

        System.out.println("sumCountMap = " + sumCountMap);
        System.out.println("result = " + result);
    }

    public static void numberOfSubarraysWithSame0sand1s(int[] arr) {
        /*First, convert all 0s to -1s,
        then number of subarrays would be number of subarrays with sum 0
        * */

        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        int n = arr.length;
        int sum = 0, result = 0;

        arr = Arrays.stream(arr).map(v -> v == 0 ? -1 : v).toArray();

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        for (int value : arr) {
            sum += value;

            if (sumCountMap.containsKey(sum)) result += sumCountMap.get(sum);

            else sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }


        System.out.println("result = " + result);
    }

    public static void maxSubarrayWithEqual0sand1s(int[] a, int[] b) {
        int[] c = new int[a.length];
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        int n = a.length;

        for (int i = 0; i < n; i++) {
            c[i] = (a[0] == 1) ? a[i] - b[i] : b[i] - a[i];
        }

        Arrays.stream(c).forEach(e -> System.out.print(e + " "));

        int len = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += c[i];

            if (sum == 0) len = i + 1;

            if (sumIndexMap.containsKey(sum)) len = Math.max(len, i - sumIndexMap.get(sum));
            else sumIndexMap.put(sum, i);
        }

        System.out.println("len = " + len);
    }

    public static void maxSumSubArray(int[] arr, int k) {
        int n = arr.length;
        int prev_sum = 0;

        for (int i = 0; i < k; i++) {
            prev_sum += arr[i];
        }

        // sum of k length subarray would be sum of prev sub array
        // + curr element - first element of previous sub array
        int sum = prev_sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            prev_sum = Math.max(prev_sum, sum);
        }

        System.out.println("ans = " + prev_sum);

    }

    public static void maxSubArrayDivByK(int[] arr, int k) {
        // create a mod arr
        // HashMap - key - sum at i
        // value - index i
        int n = arr.length, ans = 0;

        int[] m_arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            m_arr[i] = ((sum % k) + k) % k;
        }

        HashMap<Integer, Integer> modValueIndexMap = new HashMap<>();

        for (int i = 0; i < m_arr.length; i++) {
            if (m_arr[i] == 0) ans = i + 1;

            else {
                if (!modValueIndexMap.containsKey(m_arr[i])) modValueIndexMap.put(m_arr[i], i);

                else {
                    if (ans < i - modValueIndexMap.get(m_arr[i]))
                        ans = i - modValueIndexMap.get(m_arr[i]);
                }
            }
        }

        System.out.println("ans = " + ans);
    }


    public static void subArrayWithSum(int[] arr, int k) {
        // create a hashMap with sumindex map
        // if map contains sum[i] - k, then start = map.get(sum)
        // end = i

        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0, start = 0, end = -1, n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum - k == 0) {
                start = 0;
                end = i;
                break;
            }

            if (sumIndexMap.containsKey(sum - k)) {
                start = sumIndexMap.get(sum - k) + 1;
                end = i;
                break;
            }

            sumIndexMap.put(sum, i);
        }

        System.out.println((end == -1) ? (-1) : (start + 1) + " " + (end + 1));
    }

    public static void minimumCostToMakeAllElementsEqual(int[] arr, int a, int m, int r) {
        /// create a map to know the target element
        // key - element, value- freq in the arr
        // how many elements are there which require operations?
        // if they are == 1, check if they are > or < than target,
        // and cost += a or r
        // else if they are multiple,
        // traverse through the arr and check for the element
        // if the ele > target, cost += min(m,r)
        // if the ele < target, cost += min(a,r)

        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i], 0) + 1);
        }

        int freq = elementFreqMap.values().stream().max(Comparator.naturalOrder()).get();
        int target = 0;
        int diffCount = 0, cost = 0;

        for (Map.Entry<Integer, Integer> entry : elementFreqMap.entrySet()) {
            if (entry.getValue() == freq) target = entry.getKey();
            else diffCount++;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != target) {
                if (diffCount == 1) {
                    if (arr[i] > target) {
                        cost += (arr[i] - target) * r;
                    } else cost += (target - arr[i]) * a;
                } else {
                    if (arr[i] > target) {
                        cost += Math.min(m, r) * (arr[i] - target);
                    } else cost += Math.min(m, a) * (target - arr[i]);
                }
            }
        }

        System.out.println("cost = " + cost);
    }


    public static void primeNumberSumOfNumbers(int[] arr) {
        // Create an arr of prime numbers till right limit
        // Create a csum arr from the prime arr
        // for each limit, traverse the csum arr with 2 ptr algo
        // if the curr element is prime, then f = curr and s = f.

        int l = arr[0], r = arr[1], n = arr.length;

        int[] prime = new int[r + 1];
        int j = 0;
        for (int i = 2; i <= r; i++) {
            if (isPrime(i)) prime[j++] = i;
        }

        int[] c_sum = new int[r + 1];
        int sum = 0;

        for (int i = 0; i < r + 1; i++) {
            sum += prime[i];

            c_sum[i] = sum;
        }

        int first = 0;

        for (int i = 0; c_sum[i] <= l; i++) {

            if (isPrime(c_sum[i])) {
                first = c_sum[i];
                //second = first;
            }

        }

        System.out.println(first);

        first = 0;
        //second = 0;

        for (int i = 0; c_sum[i] <= r; i++) {
            if (isPrime(c_sum[i])) {
                first = c_sum[i];
                //second = first;
            }
        }

        System.out.println(first);
    }


    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void maxIntInRanges(int[] l, int[] r) {
        // create a hashmap of freq vs list of element
        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();

        int j = 0;

        while (j < l.length) {
            for (int i = l[j]; i <= r[j]; i++) {
                elementFreqMap.put(i, elementFreqMap.getOrDefault(i, 0) + 1);
            }

            j++;
        }

        System.out.println("elementFreqMap = " + elementFreqMap);

        int ans = Collections.max(elementFreqMap.entrySet(),
                Comparator.comparing(Map.Entry::getValue)).getKey();

        System.out.println("ans = " + ans);

    }

    public static void subArraySumPalindrome(int[] arr) {
        // create a csum arr
        // create a hashmap of csum vs index
        // if csum[0] is palindrome, return no
        // if csum[i] - previous csum till i is palindrome, return yes

        int n = arr.length;
        int[] c_sum = new int[n];

        int sum = 0, j;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            c_sum[i] = sum;
        }

        Arrays.stream(c_sum).forEach(e -> System.out.print(e + " "));
        System.out.println();


        if (isPalindrome(c_sum[0])) {
            System.out.println("NO");
            return;
        }

        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, c_sum[0]);

        for (int i = 1; i < n; i++) {

            if (isPalindrome(c_sum[i])) {
                System.out.println("YES");
                return;
            }

            sumIndexMap.put(i, c_sum[i]);

            j = 0;
            while (j < i) {
                System.out.println("sumIndexMap[j] = " + sumIndexMap.get(j));
                System.out.println("c_sum[i] = " + c_sum[i]);

                if (((c_sum[i] - sumIndexMap.get(j)) / 10 >= 1) && isPalindrome(c_sum[i] - sumIndexMap.get(j))) {
                    System.out.println("YES");
                    return;
                }
                j++;
            }

        }

        System.out.println("NO");
    }

    public static boolean isPalindrome(int n) {
        String oStr = String.valueOf(n);

        StringBuilder originalStr = new StringBuilder(oStr);

        String revStr = originalStr.reverse().toString();

        return oStr.equals(revStr);
    }

    public static void subArrayWithLargestSum(int[] arr) {
        // take ans & sum as 0,
        // sum would be the running sum
        // if sum > ans
        // update start if start is 0, update end anyways
        // after start and end, remove the max element from the range

        int ans = 0, sum = 0, start = -1, end = -1;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > ans) {
                if (start == -1) {
                    start = i;
                }
                end = i;
                ans = sum;
            }
        }

        Arrays.stream(Arrays.copyOfRange(arr, start, end + 1))
                .forEach(e -> System.out.print(e + " "));

        System.out.println();

        int max = Arrays.stream(Arrays.copyOfRange(arr, start, end + 1)).max().getAsInt();

        System.out.println(ans - max);

        System.out.println((start + 1) + " " + (end + 1));
    }

    public static void xorOfSubArrays(int n, int k, int x) {
        // for every index that is divisible by k, insert x at that index
        // else insert 0
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((i % k == 0) ? x : 0);
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public static void countOfSubArraysWithNumKTimes(int[] arr, int num, int k) {
        // for i = 0 to n
        // for j = i+k to n
        // create a map inside the 2nd loop, for each ele from i to j with
        // ele as key and freq as value
        // if freq of num is k, update ans
        int n = arr.length, ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+k; j < n; j++) {
//                HashMap<Integer, Integer> map = new HashMap<>();
//                for (int l = i; l <= j; l++) {
//                    map.put(arr[l], map.getOrDefault(arr[l], 0) + 1);
//                }
//                if(map.get(num) == k) {
//                    ans++;
//                }
//            }
//        }
//
//        System.out.println("ans = " + ans);

        List<Integer> indicesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) indicesList.add(i);
        }

        // prev stores the previous index of num
        // ctr stores number of subarrays
        int prev = -1, ctr = 0;

        for (int i = 0; i <= indicesList.size() - k; i++) {

            ctr = indicesList.get(i) - prev;

            if (i < indicesList.size() - k) {
                ctr *= (indicesList.get(i + k) - indicesList.get(i + k - 1));
            } else {
                ctr *= ((n - 1) - indicesList.get(i + k - 1) + 1);
            }

            ans += ctr;

            prev = indicesList.get(i);
        }
    }

    public static void playingWithArray(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
    }

    public static void zerosXORPairs(int[] arr) {
        // create a hashmap with ele as key and freq as value
        // for each value > 1, find no of pairs using n*n-1/2

        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i], 0) + 1);
        }

        // System.out.println("elementFreqMap = " + elementFreqMap);
        int ans = 0;

        ans = elementFreqMap
                .values()
                .stream()
                .filter(e -> e > 1)
                .map(e -> (e * (e - 1) / 2))
                .reduce(0, Integer::sum);

//        elementFreqMap
//                .values()
//                .stream()
//                .filter(e -> e > 1)
//                .map(e -> (e * (e-1)/2))
//                .forEach(e-> System.out.println(e + " "));

        System.out.println("ans = " + ans);
    }

    public static void count012(int[] arr) {
        // create three variables to store count of
        // 0, 1 and 2. Replace the arr accordingly

        int count0 = 0, count1 = 0, count2 = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count0++;
            else if (arr[i] == 1) count1++;
            else count2++;
        }

        int i = 0;
        while (count0-- > 0) {
            arr[i++] = 0;
        }
        while (count1-- > 0) {
            arr[i++] = 1;
        }
        while (count2-- > 0) {
            arr[i++] = 2;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public static void kthSmallestElement(int[] arr, int k) {
        // create a priority queue
        // poll the queue k times

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>
                (IntStream.of(arr).boxed().collect(Collectors.toList()));

        Integer ans = 0;
        while (--k > 0) {
            priorityQueue.poll();
        }
        ans = priorityQueue.peek();
        System.out.println("ans = " + ans);
    }

    public static void rotateClockWise(int[] arr, int d) {
        // from 0 to d, store the ele in temp
        // from 1 to n-1, shift the ele to left
        // arr[n-1] = temp

        int n = arr.length;
        int[] aux = Arrays.copyOf(arr, n + d);
        int j = 0;

        for (int i = n; i < aux.length; i++) {
            aux[i] = arr[j++];
        }

        Arrays.stream(Arrays.copyOfRange(aux, d, aux.length)).forEach(e -> System.out.print(e + " "));

//        for (int i = 0; i < d; i++) {
//            int temp = arr[0];
//            for (int j = 1; j < n; j++) {
//                arr[j-1] = arr[j];
//            }
//            arr[n-1] = temp;
//
//        }

        //Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }


    public static void binaryArraySorting(int[] arr) {
        // while left side contains 0, accelerate
        // if a[r] == 0, swap a[l] & a[r], r--

        int n = arr.length;
        int l = 0, r = n - 1;

        while (l < r) {
            while (arr[l] == 0) l++;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            r--;
            //l++; // controversial statement

            while (arr[l] == 0) l++;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public static void reverseInGroups(List<Integer> arr, int k) {
        // create a reverse method which reverses the arr from start to end
        // if k > n, reverse the entire array
        // else till n-k reverse in groups of k,
        // after that, reverse from k+1 to n

        int n = arr.size(), i = 0;
        List<Integer> resultList = new ArrayList<>();

        if (k >= n) {
            resultList.addAll(reverse(arr, 0, n));
        } else {
            for (; i <= n - k; i += k) {
                resultList.addAll(reverse(arr, i, i + k));
            }

            //arr.forEach(e-> System.out.print(e + " "));

            //System.out.println();

            resultList.addAll(reverse(arr, i, n));
        }

        System.out.println("resultList = " + resultList);
    }

    public static ArrayList<Integer> reverse(List<Integer> arr, int start, int end) {
        System.out.println("arr sublist: " + arr.subList(start, end));

        Stack<Integer> integerStack = new Stack<>();
        integerStack.addAll(arr.subList(start, end));

        ArrayList<Integer> resultList = new ArrayList<>();

        while (!integerStack.isEmpty()) resultList.add(integerStack.pop());

        return resultList;
        //Collections.reverse(arr.subList(start, end));
        //System.out.println("after reversing arr = " + arr);
    }

    public static void maxInStructArray(Height[] arr) {
        // convert the feet to inches for every even index
        // after that calculate sum of every 2 indices and compare with max
        for (Height he : arr) {
            he.feet = 12 * he.feet;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e.feet + " "));
        System.out.println();
        Height max = (Arrays.stream(arr).max(Comparator.comparing(e -> e.inches + e.feet)).get());
        System.out.println(max.feet + max.inches);
    }

    public static void inversePermutation(int[] arr) {
        // find the max in the given array
        // create a new arr of max size
        // fill the new arr

        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] new_arr = new int[max + 1];

        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            System.out.println("ele = " + ele);
            new_arr[ele] = i + 1;
        }

        Arrays.stream(Arrays.copyOfRange(new_arr, 1, new_arr.length)).forEach(e -> System.out.print(e + " "));
    }

    public static void matrixInterchange(int[][] arr) {
        // swap the first column with the last one
        int n = arr.length, j = 0, col = arr[0].length - 1;
        for (int i = 0; i < n; i++) {
            int temp = arr[i][j];
            arr[i][j] = arr[i][col];
            arr[i][col] = temp;
        }

        System.out.println(Arrays.deepToString(arr));
    }

    public static void distinctAbsoluteValues(int[] arr) {
        // store the absolute values in a set
        // return the size of the set

        Set<Integer> absValueSet = new HashSet<>();
        int n = arr.length;

        for (int value : arr) {
            absValueSet.add(Math.abs(value));
        }

        System.out.println("absValueSet = " + absValueSet);
        System.out.println(absValueSet.size());

    }

    public static void sumOfAFunction(int[] arr) {
        // if diff between the ele is > 1,
        // then add the diff between them
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[j] - arr[i]) > 1) sum += arr[j] - arr[i];
            }
        }

        System.out.println("sum = " + sum);
    }

    public static void ishanLovesChocolates(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] > arr[j]) i++;
            else j--;
        }

        System.out.println("ans = " + arr[i]);
    }

    public static void maxAfterMIncrementsDriver(int n, int m) throws IOException {
        // increment all values from a to b by k
        // after all operations return max
        int[] arr = new int[n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (m-- > 0) {
            String[] abk = (br.readLine()).split(" ");
            int a = Integer.parseInt(abk[0]);
            int b = Integer.parseInt(abk[1]);
            int k = Integer.parseInt(abk[2]);

            for (int i = a; i <= b; i++) {
                arr[i] += k;
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("max = " + max);

    }

    public static void maximizeToys(int[] arr, int x) {
        // if a toy's cost is less than x, deduct x and increment count
        Arrays.sort(arr);
        int n = arr.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x && x > 0) {
                x -= arr[i];
                ans++;
            }
        }

        System.out.println("ans = " + ans);
    }

    public static void sumOfBitDiff(int[] arr) {
        //create pairs from arr elements
        // for each pair do xor of these
        // count number of 1s in the xor result
        // update ans with count

        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = arr[i] ^ arr[j];
                int count = count1s(xor);
                ans += count;
            }
        }

        System.out.println("ans = " + (2 * ans));
    }

    public static void longestSubArray(int[] arr) {
        // Have 2 pointers i & j, j will be the runner and i accumulator
        // if a[j] > 0 & j== 1 j++, else if j != 1 i = j
        // if a[j] < 0 ans would be max of ans & j-i+1
        int n = arr.length;

        int ans = 0, len = 0, dummuVat = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) len++;
            else {
                dummuVat = len;
                len = 0;
            }

            ans = Math.max(ans, len);
            System.out.println("ans = " + ans);
        }

        ans = Math.max(ans, dummuVat);
        System.out.println("ans = " + ans);
    }

    public static int countZeros(int[] arr) {
        // use binary search to find the first point of contact
        // if a[l] is 0, then remaining part is also 0,
        // if not,then find middle till l<=h

        int n = arr.length;
//        int l = 0, h = n -1;
//
//        while (l<=h) {
//            if(arr[l] == 0) return n - l;
//            int m = (l+h)/2;
//            if(arr[m] != 0) {
//                l = m + 1;
//            }
//        }
//
//        return 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) return n - i;
        }
        return 0;
    }


    public static int count1s(int n) {
        // count no of 1s in a number
        // on subtracting 1 from the decimal rep of a number,
        // the value after the rightmost 1 flips
        // if we do & of the number and number - 1,
        // the number of times it takes to become 0
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static Integer[] convertIntToInteger(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

    public static void rotate2DArray(int n, String[] str) {
        int[][] arr = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[k++]);
            }
        }

        int count = 0;
        while (count != n) {
            int temp = arr[n - 1][0];
            arr[n - 1][0] = arr[n - 1][n - 1];
            arr[n - 1][n - 1] = temp;

            temp = arr[0][0];
            arr[0][0] = arr[n - 1][n - 1];
            arr[n - 1][n - 1] = temp;

            temp = arr[n - 1][n - 1];
            arr[n - 1][n - 1] = arr[0][n - 1];
            arr[0][n - 1] = temp;

            count++;
        }

        for (int[] a : arr) {
            for (int aa : a) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }
    }

    public static void greaterOnRight(int[] arr) {
        // create a new arr
        // init new arr's last index as -1
        // init max as 0
        // from n-1 to 1, update max

        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;

        int max = 0;

        for (int i = n - 1; i > 0; i--) {
            max = Math.max(max, arr[i]);
            ans[i - 1] = max;
        }

        Arrays.stream(ans).forEach(e -> System.out.print(e + " "));
    }

    public static void flattenKSortedArrays(int[][] arr, int k) {
        // recursively merge 2 arrays
        // for k > 4
        // merge first 2 arrays into a
        // merge second 2 arrays into b
        // merge a & b, then proceed ahead similarly

        ArrayList<Integer> resultList = new ArrayList<>();
        int i = 0, j = 1;

        int n = arr.length;
        System.out.println("n = " + n);

        while (i < n && j < n) {
            int[] mergeFirst = merge(arr[i], arr[j]);

            int[] mergeSecond = new int[n];
            if (i < n - 2 && j < n - 2) {
                mergeSecond = merge(arr[i + 2], arr[j + 2]);

            }

            if (i == n - 2)
                Collections.addAll(resultList, Arrays.stream(merge(arr[n - 1], mergeSecond)).boxed().toArray(Integer[]::new));

            else if (j == n - 2)
                Collections.addAll(resultList, Arrays.stream(merge(mergeFirst, arr[n - 1])).boxed().toArray(Integer[]::new));
            else
                Collections.addAll(resultList, Arrays.stream(merge(mergeFirst, mergeSecond)).boxed().toArray(Integer[]::new));


            System.out.println("resultList = " + resultList);

            i += 4;
            j += 4;
        }

        System.out.println("resultList = " + resultList);
    }

    public static int[] merge(int[] a, int[] b) {
        // merge 2 arrays into one
        int m = a.length, n = b.length;
        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                res[k] = b[j];
                j++;
            }
            k++;
        }

        if (i < m) {
            while (i < m) res[k++] = a[i++];
        }

        if (j < n) {
            while (j < n) res[k++] = b[j++];
        }

        System.out.println("merge process");
        Utils.printIntArray(res);

        return res;
    }


    public static void detective(int[] arr, int n) {
//        // init a map with key 0 and value as list from 1 to n
//        // create a map of keys as freq and values as list of elements
//        // the values with 0 key will be the result
//
//        HashMap<Integer, Integer> freqElementMap = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//                freqElementMap.put(arr[i], freqElementMap.getOrDefault(arr[i],0) + 1);
//        }
//
//        System.out.println("freqElementMap = " + freqElementMap);
//
//        List<Integer> total = IntStream.rangeClosed(0, n)
//                .boxed()
//                .collect(Collectors.toList());
//
//        total.removeIf(v -> freqElementMap.keySet().contains(v));
//
////        Arrays.stream(arr)
////                .boxed().forEach(e -> System.out.println(e+ " "));
//       // System.out.println("freqElementMap = " + freqElementMap.keySet());
//
//        System.out.println("total = " + total);

        // Sort the array
        // for i=1 to n, do binary search for every i
        // whenever the result is -1, print that i

        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            int result = ClassA.binarySearch(convertIntToInteger(arr), i);
            if (result == -1) System.out.print(i + " ");
        }
    }

    public static void balancedArray(int[] arr) {
        // calculate entire array's sum in sum
        // calculate left sum as running sum
        // and right sum = sum -leftsum
        // diff would be r - l sum
        // ans would be min positive diff

        int n = arr.length;
        int sum = 0, diff = 0, ans = Integer.MAX_VALUE, l_sum = 0, r_sum = 0;
        for (int a : arr) {
            sum += a;
        }

        for (int i = 0; i < n; i++) {
            l_sum += arr[i];
            r_sum = sum - l_sum;

            System.out.println("l_sum = " + l_sum);
            System.out.println("r_sum = " + r_sum);

            if (l_sum > r_sum) {
                diff = Math.abs(r_sum - l_sum);

                ans = Math.min(ans, diff);

                System.out.println("diff = " + diff);
                System.out.println("ans = " + ans);
            }
        }

        System.out.println("ans = " + ans);
    }

    public static void addingOnes(int n, int[] K) {
        // for all elements of new arr & for every ele of K
        // add ones to arr if i+1 >= j
        // where i is new arr's iterator & j is K's

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K.length; j++) {
                if ((i + 1) >= K[j]) {
                    arr[i]++;
                }
            }
        }

        Utils.printIntArray(arr);
    }

    public static void countPairsWithSum(int[] arr, int k) {
        // create a map with arr ele as keys and
        // freq as values
        // ans would be (n * n-1)/2
        // where n is freq of k - arr[i]
        int n = arr.length;
//
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            freqMap.put(arr[i], freqMap.getOrDefault(arr[i],0) + 1);
//        }
//
//        System.out.println("freqMap = " + freqMap);
//
        int ans = 0;
//        for (int i=0;i<n;i++) {
//            int j = i + 1;
//
//            if(freqMap.containsKey(k - arr[i])) {
//                System.out.println("key: " + (k - arr[i]));
//                System.out.println("value: " + (freqMap.get(k - arr[i])));
//
//                int value = freqMap.get(k - arr[i]);
//                ans += (value == 1 ? 1 : value * (value - 1)/2);
//            }
//        }
//
//        System.out.println("ans = " + ans);

//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if(arr[i] + arr[j] == k) ans++;
//            }
//        }

        // create a hashmap of element vs freq
        // if map contains k-arr[i], count++
        // finally, divide count by 2, as every pair is counted twice
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        int twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(k - arr[i])) {
                twice_count += hashMap.get(k - arr[i]);
            }

            if (k - arr[i] == arr[i]) twice_count--;
        }

        System.out.println("twice_count = " + twice_count / 2);
    }

    public static void mrModulo(int[] arr, int k) {
        // run 2 loops and if mod of either of 2 permutation is k, count++
//        int n = arr.length;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                int a = arr[i];
//                int b = arr[j];
//                if((a % b) == k || (b%a) == k) count++;
//            }
//        }
//
//        System.out.println("count = " + count);
        // create a hashmap of elements vs their diff with other elements
        // the total number of pairs would be no. of numbers > k +
        // elements whose diff is k & mod is also k
        int n = arr.length;
        HashMap<Integer, Integer> elementDiffMap = new HashMap<>();

        int gtK = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) gtK++;
            int j = i + 1;

            while (j < n) {
                if (Math.abs(arr[j] - arr[i]) == k) elementDiffMap.put(arr[i], arr[j]);
                j++;
            }
        }

        System.out.println("gtK = " + gtK);
        System.out.println("elementDiffMap = " + elementDiffMap);

        int diffCount = 0;
        for (Map.Entry<Integer, Integer> entry : elementDiffMap.entrySet()) {
            int a = Math.max(entry.getKey(), entry.getValue());
            int b = Math.min(entry.getKey(), entry.getValue());

            if (a % b == k) diffCount++;
        }

        System.out.println("answer = " + (diffCount + gtK));
    }

    public static void reArrange(int[] arr) {
        // for 0 to n, store all -1s in a list
        // if a[i] != -1, store in a new result arr

        int n = arr.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int value = arr[i];
                res[value] = value;
            }
        }

        Utils.printIntArray(res);
    }


    public static void quickSort(int[] arr, int l, int h) {
        // create a partition around the pivot element
        // all elements on left of pivot should be less and
        // all elements on right should be greater than pivot
        // keep an index that tracks elements smaller than pivot
        // if the runner element is smaller than pivot, increment
        // accumulator and swap acc & runner
        //finally, swap pivot and acc + 1, return acc + 1

        int n = arr.length;

        if (l < h) {
            int pivot = partition(arr, l, h);
            System.out.println("pivot = " + pivot);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }

    }

    public static int partition(int[] arr, int l, int h) {
        // select the last element as pivot element
        // keep track of elements lesser than pivot by i
        // use j to traverse the entire array
        // if an element is < pivot, swap a[i] & a[j]
        // after loop, swap pivot and a[i+1]
        // return i+1

        int i = -1;
        int pivot = arr[h];
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        pivot = arr[i + 1];

        return i + 1;
    }


    public static void multiplyLeftAndRight(int[] arr) {
        // get length of the array
        // divide the array into 2 parts
        // do sum of both parts and then multiply the result of both

        int n = arr.length;

        int k = n / 2;

        int l_sum = 0, r_sum = 0;

        for (int i = 0; i < k; i++) {
            l_sum += arr[i];
        }

        for (int i = k; i < n; i++) {
            r_sum += arr[i];
        }

        System.out.println("l_sum = " + l_sum);
        System.out.println("r_sum = " + r_sum);


        int ans = l_sum * r_sum;

        System.out.println("ans = " + ans);
    }


    public static void numberOfNumbers(int[] arr, int k) throws IOException {


        // count number of times k appears in every element of arr

        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = String.valueOf(arr[i]);
            for (Character c : str.toCharArray()) {
                if (Character.getNumericValue(c) == k) count++;
            }

        }

        System.out.println("count = " + count);
    }

    public static void minSumFormedByDigits(int[] arr) {
        // sort the arr
        // take all even indexed numbers & concat them into one var
        // take all odd indexed numbers & concat them into another var
        // sum of these 2 vars
        int n = arr.length;

        Arrays.sort(arr);

        int a = 0, b = 0;

        StringBuilder stringBuilder1 = new StringBuilder(), stringBuilder2 = new StringBuilder();

        for (int i = 0; i < n; i += 2) {
            stringBuilder1.append(arr[i]);
        }

        a = Integer.parseInt(stringBuilder1.toString());

        for (int i = 1; i < n; i += 2) {
            stringBuilder2.append(arr[i]);
        }

        b = Integer.parseInt(stringBuilder2.toString());

        System.out.println("a + b = " + (a + b));
        System.out.println();
    }

    public static void countOfSubarraysWithKPrime(int[] arr, int k) {
        // traverse through the arr and replace the primes with 1 and others
        // with 0.
        // now, problem is same as finding count of subarrays with sum as k

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = isPrime(arr[i]) ? 1 : 0;
            }
        }

        countSubArraysWithSumK(arr, k);
    }

    public static void countSubArraysWithSumK(int[] arr, int k) {
        // create curr_sum arr from arr
        // create a hashmap with sum as key and freq and value
        // for i = 0 to n, if a[i] == k, then count++
        // if k - a[i] exists in map, update count

        int n = arr.length;
        int[] c_sum = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            c_sum[i] = sum;
        }

        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (c_sum[i] == k) count++;

            if (sumCountMap.containsKey(c_sum[i] - k)) {
                count += sumCountMap.get(c_sum[i] - k);
            } else sumCountMap.put(c_sum[i], sumCountMap.getOrDefault(c_sum[i], 0) + 1);
        }

        System.out.println("count = " + count);
    }

    public static void countPairsOddXor(int[] arr) {
        // count of odd numbers * count of even numbers

        int n = arr.length, eCount = 0, oCount = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) eCount++;
            else oCount++;
        }

        System.out.println("ans = " + (eCount * oCount));
    }

    public static void gameWithNos(int[] arr) {
        // do xor of all elements
        // copy the last element as it is
        int n = arr.length;
        int[] arr2 = new int[n];

        for (int i = 0; i < n - 1; i++) {
            arr2[i] = arr[i] ^ arr[i + 1];
        }

        arr2[n - 1] = arr[n - 1];
        Utils.printIntArray(arr2);
    }

    public static void countOccurencesOfAnagrams(String a, String b) {
        // create a hashmap of char vs freq for string b
        // for each substring of b.length, create a hashmap of char vs freq
        // if both maps are equal, count++

        int n1 = a.length(), n2 = b.length(), count = 0;
        HashMap<Character, Integer> characterIntegerHashMap1 = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            characterIntegerHashMap1.put(b.charAt(i),
                    characterIntegerHashMap1.getOrDefault(b.charAt(i), 0) + 1);
        }


        for (int i = 0; i <= n1 - n2; i++) {
            String sub = a.substring(i, i + n2);
            int k = 0;
            HashMap<Character, Integer> characterIntegerHashMap2 = new HashMap<>();
            while (k < sub.length()) {
                characterIntegerHashMap2.put(sub.charAt(k),
                        characterIntegerHashMap2.getOrDefault(sub.charAt(k), 0) + 1);
                k++;
            }
            if (characterIntegerHashMap1.equals(characterIntegerHashMap2)) {
                count++;
                System.out.println("characterIntegerHashMap2 = " + characterIntegerHashMap2);
            }
        }

        System.out.println("count = " + count);

    }

    public static void rodCutting(int[] arr) {
        // for i = 0 to n,
        // consider all probabilites of cut & maximize the profit

        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println("max = " + max);
    }

    public static void pendulumPrinting(int[] arr) {
        // create a new int[] arr
        // get min of arr
        // put min at centre of new arr
        // for even indexed elements, put them from centre to right
        // for odd indexed, put them left to centre

        int n = arr.length;
        int[] new_arr = new int[n];

        int mid = 0;
        int min = Arrays.stream(arr).min().getAsInt();

        if (n % 2 == 0) {
            // even
            mid = (n - 1) / 2;
        } else {
            mid = n / 2;
        }

        new_arr[mid] = min;
        System.out.println("min element is set");
        Utils.printIntArray(new_arr);

        // left side
        int k = 1;
        for (int i = mid - 1; i >= 0; i--) {
            new_arr[i] = arr[k];
            k += 2;
        }

        System.out.println("left side");
        Utils.printIntArray(new_arr);

        k = n - 1;
        for (int i = n - 1; i > mid; i--) {
            new_arr[i] = arr[k];
            k -= 2;
        }

        System.out.println("right side");
        Utils.printIntArray(new_arr);

    }

    public static void missingAndRepeating(int[] arr, int n) {
        // create a hashmap of given numbers vs freq
        // if freq > 1, the number is repeating
        // create a list of numbers from 1..n
        // retain all elements present in list not in map
//        int repeat = Integer.MAX_VALUE;
//
//        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if(elementFreqMap.get(arr[i]) == null) elementFreqMap.put(arr[i], 1);
//            else {
//                elementFreqMap.put(arr[i], elementFreqMap.get(arr[i]) + 1);
//                repeat = Math.min(repeat, arr[i]);
//            }
//        }
//
//       int missing = Integer.MAX_VALUE;
//       List<Integer> intStreamList = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
//
//       //O(n)
//       intStreamList.removeAll(elementFreqMap.keySet());
//
//       System.out.print("repeat = " + repeat);
//
//       //O(n)
//       missing = Math.min(missing, intStreamList.stream().min(Comparator.naturalOrder()).get());
//
//       System.out.print("missing = " + missing);

        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.reverseOrder());

        Arrays.sort(arr);

        int missing = Integer.MAX_VALUE, repeat = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if ((i + 1) != arr[i]) {
                missing = Math.min(missing, (i + 1));
            }

            if (arr[i] == arr[i + 1]) {
                repeat = Math.min(repeat, arr[i]);
            }
        }

        System.out.println("missing = " + missing);
        System.out.println("repeat = " + repeat);
    }

    public static void countPairsInArray(int[] arr) {
        // for i = 0 to n
        // for j =i to n
        // if i*arr[i] < j* arr[j] count++

        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i * arr[i]) > (j * arr[j])) count++;
            }
        }

        System.out.println("count = " + count);
    }

    public static void sumOfDistinctElements(int[] arr, int n) {
        // create a set
        // sum it
        Set<Integer> set = new HashSet<>(Utils.getListFromIntArray(arr));

        System.out.println(set.stream().reduce(Integer::sum).get());
    }

    public static void convertArrayToReducedForm(int[] arr) {
        // sort the given arr
        // store the element vs idx in the map
        // for every element, print it's idx

        int n = arr.length;
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(arr);

        HashMap<Integer, Integer> elementIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            elementIdxMap.put(arr[i], i);
        }


        for (int i = 0; i < n; i++) {
            System.out.print(elementIdxMap.get(copy[i]) + " ");
        }
    }

    public static void firstNegativeNumber(int[] arr, int k) {
        // create a new arr of size k
        // init the new arr
        // shift the new arr on left by removing the 1st element
        // and adding the last element as arr[i]
        // find the first -ve number

        int n = arr.length;

        int[] new_arr = new int[k];

        for (int i = 0; i < k; i++) {
            new_arr[i] = arr[i];
        }

        findMin(new_arr);

        for (int i = k - 1; i < n - 1; i++) {
            shift(new_arr, arr[i + 1]);
            findMin(new_arr);
        }
    }


    public static void shift(int[] a, int ele) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            a[i - 1] = a[i];
        }

        a[n - 1] = ele;

    }

    public static void findMin(int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                System.out.print(a[i] + " ");
                break;
            }
        }

        if (i == a.length) System.out.print(0 + " ");

    }


    public static void countOfSubArraysWithKPrimes(int[] a, int k) {
        // if a number is prime, mark it as 1 else 0
        // now, problem reduces to countof subarrays with sum as k

        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) a[i] = 0;
            else {
                a[i] = (isPrime(a[i]) ? 1 : 0);
            }
        }

        int[] c_sum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            c_sum[i] = sum;
        }

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (c_sum[i] == k) count++;
            else {
                if (map.containsKey(c_sum[i] - k)) {
                    count += map.get(c_sum[i] - k);
                } else map.put(c_sum[i], map.getOrDefault(c_sum[i], 0) + 1);
            }
        }

        System.out.println("count = " + count);
    }

    public static void largestFibonacciSubsequence(int[] a) {
        // check if every number of this arr
        // is a fibonacci number using the property
        // 5n2 +_ 4 is a perfect square

        int n = a.length;

        for (int i = 0; i < n; i++) {
            int x = a[i];

            if (Utils.isPerfectSquare((5 * x * x + 4)) || Utils.isPerfectSquare((5 * x * x - 4)))
                System.out.print(a[i] + " ");
        }
    }

    public static void maxValueInBitonicArray(int[] arr, int l, int h) {
        // if l == h, return l
        // if middle element is > middle + 1, search from l to m
        // else search from m+1 to h

        while (l < h) {
            int m = (l + h) / 2;
            if (arr[m] > arr[m + 1]) h = m;
            else l = m + 1;
        }

        System.out.println(arr[l]);
    }

    public static void minProductSubset(int[] arr) {
        // keep count of -ve and +ve elements
        // if -veCount is even, select the max -ve and multiply with +ve product
        // else if -veCount is odd, product of all elements
        // if all elements are +ve, min +ve
        // if all elements are -ve, then depending on count

        int n = arr.length;

        int product = 1, maxNegative = Integer.MAX_VALUE;
        int minNegative = Integer.MAX_VALUE, countP = 0, countN = 0;
        int minPositive = Integer.MAX_VALUE, ans = 0;

        boolean isZero = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                countN++;
                minNegative = Math.min(minNegative, arr[i]);
                maxNegative = Math.max(maxNegative, arr[i]);
            } else {
                if (arr[i] == 0) {
                    isZero = true;
                    countP++;
                    minPositive = Math.min(minPositive, arr[i]);
                }
            }

            if (arr[i] != 0) product *= arr[i];
        }


        if (countN % 2 != 0) ans = product;

        else if (countN == 0) ans = minPositive;

        else if (countN % 2 == 0) {
            if (!isZero) ans = product / minNegative;
            else ans = maxNegative;
        }

        System.out.println("ans = " + ans);
    }

    public static void xorQuery(int l, int r) {
        // create the xor arr according to the formula
        // find the sum between the ranges

        int[] arr = new int[(int) Math.pow(10, 8)];
        arr[0] = 1;

//        int n = arr.length;
//        for (int i = 1; i < n; i++) {
//            arr[i] = (arr[i-1] ^ (i+1));
//        }

        int ans = 0;
        for (int i = 1; i < l; i++) {
            ans ^= i;
        }

        int sum = 0;
        for (int i = l; i <= r; i++) {
            ans ^= i;
            sum += ans;
        }

        System.out.println("sum = " + sum);
    }

    public static void isFibonacci(int n) {
        // if a number follows 5n2 +_ 4 should be a perfect sq law
        // then yes,else no

        int x = 5 * n * n + 4;
        int y = 5 * n * n - 4;

        int s = (int) Math.sqrt(x);
        boolean isX = (s * s) == x;

        s = (int) Math.sqrt(y);
        boolean isY = (s * s) == y;

        System.out.println((isX || isY) ? "Yes" : "No");
    }

    public static void countSetBits(int n) {
        // on subtracting 1 from n, all the bits from rightmost flip
        // if we do n & n-1 a times, then a is the answer
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        System.out.println("count = " + count);
    }

    public static void maxValueAfterMRange(int n, int k) throws IOException {
        // incr arr[a] to arr[b] by k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[n];

        for (int j = 0; j < k; j++) {
            String[] abk = br.readLine().split(" ");
            int a = Integer.parseInt(abk[0]);
            int b = Integer.parseInt(abk[1]);
            int c = Integer.parseInt(abk[2]);

            for (int i = a; i <= b; i++) {
                arr[i] += c;
            }

        }

        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

    public static void candies(int n, int k) {
        // create an empty result arr
        // for every index till k distribute

        int[] arr = new int[k];

        int remaining = n, j = 0, i = 1;

        while (remaining > 0) {
            System.out.println("remaining = " + remaining);
            System.out.println("i = " + i);
            if (j == arr.length) j = 0;

            arr[j] += ((remaining - i) > 0 ? i : remaining);
            remaining -= i;
            j++;
            i++;
        }

        Utils.printIntArray(arr);
    }

    public static void pairsWithASum(int[] arr, int k) {
        // create a map of ele vs freq
        // if k- arr[i] exists update count
        // if k-arr[i] = arr[i] count--
        // lastly, count/2

        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (k - arr[i] == arr[i]) count--;
            if (elementFreqMap.containsKey(k - arr[i])) count += elementFreqMap.get(k - arr[i]);
            else elementFreqMap.put(k - arr[i], elementFreqMap.getOrDefault(k - arr[i], 0) + 1);
        }
        System.out.println("count = " + (count / 2));
    }

    public static void caseSort(String str) {
        // store all lower case chars into one string
        // store all upper ones into another
        // sort both
        // while traversing the string,
        // if char's case is upper, take from one
        // else take from other

        StringBuilder upper = new StringBuilder(), lower = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) upper.append(str.charAt(i));
            else lower.append(str.charAt(i));
        }

        char[] upperC = upper.toString().toCharArray();
        Arrays.sort(upperC);


        char[] lowerC = lower.toString().toCharArray();
        Arrays.sort(lowerC);

        StringBuilder ans = new StringBuilder();

        int j = 0, k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) ans.append(upperC[j++]);
            else ans.append(lowerC[k++]);
        }

        System.out.println("ans = " + ans);
    }

    public static void minChangesToMakeSubstringsDistinct(String str) {
        // remove all dupes
        // create a map of char vs freq
        // while at the time of adding, if freq is not null
        // count++

        int n = str.length();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(str.charAt(i)) == null) map.put(str.charAt(i), 1);
            else {
                count++;
                map.put(str.charAt(i), 1 + map.get(str.charAt(i)));
            }
        }

        System.out.println("map = " + map);
        System.out.println("count = " + count);
    }

    public static void karatsuba(String a, String b) {
        Integer n1 = Integer.parseInt(a, 2);
        Integer n2 = Integer.parseInt(b, 2);

        System.out.println(n1 * n2);
    }

    public static void pangramChecking(String str) {
        // check str length, if>=26,
        // create a string containing all chars from a to z
        // if given str's every char's index is > -1, then 1 else 0

        int n = str.length();

        str = str.replaceAll(", ", "").toLowerCase();
        System.out.println("str = " + str);


        if (n < 26) {
            System.out.println(0);
            return;
        } else {
            String aToZ = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < aToZ.length(); i++) {
                if (str.indexOf(aToZ.charAt(i)) == -1) {
                    System.out.println("char not present: " + aToZ.charAt(i));
                    System.out.println(0);
                    return;
                }
            }

            System.out.println(1);
        }
    }

    public static void orderingOfStrings(String str) {
        // two-pointer algo
        // keep i at 0 & j at n-1
        // whoever's value is less,inc/dec accordingly

        int n = str.length();
        str = str.toLowerCase();

        String[] strArr = str.split(" ");

        Arrays.sort(strArr);

        System.out.println("start = " + strArr[0]);
        System.out.println("end = " + strArr[strArr.length - 1]);
    }

    public static void minIndexedString(String str, String pat) {
        // traverse through the pat to find index in str
        // update the min

        int n = pat.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int b = str.indexOf(pat.charAt(i));
            if (b != -1) min = Math.min(min, b);
        }

        System.out.println((min == Integer.MAX_VALUE) ? "no character present" : min);
    }

    public static void maximumDifference(int[] arr) {
        // keep track of max diff and the min ele so far
        // init max diff as a[1]-a[0]
        // and min ele as a[0]

        int n = arr.length;
        int minEle = arr[0];
        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - minEle > maxDiff) maxDiff = arr[i] - minEle;
            if (arr[i] < minEle) minEle = arr[i];
        }

        System.out.println("maxDiff = " + maxDiff);
    }

    public static void firstNonRepeatingCharacter(String str) {
        // if a char's first and last index is same, return that

        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                System.out.println(str.charAt(i));
                return;
            }
        }

        System.out.println(-1);
    }


    public static void leftView(RightNode root) {
        // print only the first element of a level
        // create a q of pair of node & level
        // maintain a var for level
        // if q's ele's level equals level then print


        int level = 0;
        //Queue<Pair<RightNode, Integer>> q = new LinkedList<>();
//        q.add(new Pair<>(root, 0));
//
//        while(!q.isEmpty()) {
//           //Pair<RightNode, Integer> ele = q.poll();
//           if(ele.getValue() == level) {
//               System.out.print(ele.getKey() + " ");
//               level++;
//           }
//
//           if(ele.getKey().left != null) {
//               q.add(new Pair<>(ele.getKey().left, level+1));
//           }
//
//           if(ele.getKey().right != null) {
//               q.add(new Pair<>(ele.getKey().right,level+1));
//           }
//        }
    }

    public static void reverseWordsInAString(String str) {
        // split on basis of dot
        // store the ele in stack
        // print the stack

        int n = str.length();
        String regex = "[.]";

        String[] arr = str.split(regex);

        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i > 0; i--) {
            res.append(arr[i]).append(".");
        }

        res.append(arr[0]);

        System.out.println("res = " + res);
    }

    public static void countAllWaysFromTopLeftToBottomRight(int n, int m) {
        // reach from top left to bottom right by either down or right
        // number of ways to reach immediate right from origin is 1,take right
        // number of ways to reach immediate down from origin is 1, take down
        // rest, number of ways to reach any cell can only be from its immediate left
        // taking right or immediate up taking down.


        int[][] numberOfWays = new int[n][m];

        for (int i = 0; i < n; i++) {
            numberOfWays[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            numberOfWays[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                numberOfWays[i][j] = numberOfWays[i - 1][j] + numberOfWays[i][j - 1];
            }
        }

        System.out.println(numberOfWays[n - 1][m - 1]);
    }

    public static void searchInAMatrix(int[][] arr, int k) {
        // all the rows and cols are sorted
        // binary search row times


        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int[] s = arr[i];

            List<Integer> list = Utils.getListFromIntArray(s);
            int res = Collections.binarySearch(list, k);
            if (res >= 0) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static void closestToK(int[] arr, int k) {
        // init diff as max value
        // if n > 2, as arr is sorted, apply 2-pointer algo
        // if k-arr[i]-arr[j] < diff, update diff
        // if arr[i] + arr[j] < k, i++
        // else j--

        int n = arr.length;

        int diff = Integer.MAX_VALUE;

        int resI = arr[0], resJ = arr[n - 1];

        if (n > 2) {
            int i = 0, j = n - 1;
            while (i < j) {
                if (Math.abs(k - (arr[i] + arr[j])) < diff) {
                    diff = Math.abs(k - (arr[i] + arr[j]));
                    resI = arr[i];
                    resJ = arr[j];
                }

                if (arr[i] + arr[j] < k) i++;
                else j--;
            }
        }

        System.out.println("diff = " + diff);
        System.out.println("resI = " + resI);
        System.out.println("resJ = " + resJ);
    }

    public static boolean isIsogram(String str) {
        // done
        // if any char's last index & first index is not same, return false
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) return false;
        }

        return true;
    }

    public static void largeNumberDivision(String a, String b) {
        // divide a by b, convert a to bigint
        // done
        BigInteger bigInteger = new BigInteger(a);
        BigInteger bigInteger1 = new BigInteger(b);
        System.out.print(bigInteger.divide(bigInteger1));
    }

    public static void theCountingGame(String str) {
        // Done
        // if a char is uppercase, count++
        int count = 1;

        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(str.charAt(i))) count++;
        }

        System.out.println("count = " + count);
    }

    public static void closingBracketIndex(String str, int opening) {
        // start from opening index, the first closing brace's index is the answer
        int n = str.length();
        Stack<Character> stack = new Stack<>();

        int res = -1;

        for (int i = opening; i < n; i++) {


            if (str.charAt(i) == '[') stack.push(str.charAt(i));

            if (str.charAt(i) == ']') {
                if (!stack.isEmpty()) {
                    res = i;
                    stack.pop();
                    if (stack.isEmpty()) break;
                } else {
                    res = i;
                    break;
                }
            }

        }

        System.out.println("res = " + res);
    }

    public static int maxAndMinDivideAndConquer(int[] arr, int l, int h) {
        // break the arr into 2 halves
        // if l > h, return the max and min of them

        if (l < h) {
//          Divide
            int m = (l + h) / 2;
            int maxLeft = maxAndMinDivideAndConquer(arr, l, m);
            int maxRight = maxAndMinDivideAndConquer(arr, m + 1, h);
//          Combine
            return Math.min(maxLeft, maxRight);
        }

//      Conquer
        int max = Math.min(arr[l], arr[h]);
        return max;
    }

    public static int inversionCount(int[] arr, int l, int r) {
        // count from left subarr + right subarr + merging count
        // during merge, if left's ele > right ele, all elements between them
        // will also follow the same property. Hence, the number of counts
        // will be mid - i

        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            count += inversionCount(arr, l, m);
            count += inversionCount(arr, m + 1, r);

            count += mergeCount(arr, l, m, r);
        }

        return count;
    }

    public static int mergeCount(int[] arr, int l, int m, int r) {
        // if left subarr's ele > right ele, update count as m - i

        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);

        int n1 = L.length;
        int n2 = R.length;

        int count = 0;

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {

            if (L[i] > R[j]) {
                arr[k++] = R[j++];
                count += (m + 1) - (l + i);
            } else {
                arr[k++] = L[i++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        return count;
    }

    public static void countOccurrencesOfAnagram(String a, String b) {
        // create a hashmap for b's char vs freq
        // take substrings of a of b's len
        // create a hashmap of these substrings' char vs freq
        // if both maps are equal, then count++

        int n = a.length();
        int len = b.length();
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            String sub = a.substring(i, (i + len) > n ? n : (i + len));
            int j;
            HashMap<Character, Integer> map1 = new HashMap<>();

            for (j = 0; j < sub.length(); j++) {
                map1.put(sub.charAt(j), map1.getOrDefault(sub.charAt(j), 0) + 1);
            }

            System.out.println("map1 = " + map1);

            if (map.equals(map1)) count++;
        }

        System.out.println("count = " + count);
    }

    static class Height {
        int feet;
        int inches;

        public Height(int ft, int inc) {
            feet = ft;
            inches = inc;
        }
    }

    static class MyPair {
        RightNode rightNode;
        Integer level;

        public MyPair(RightNode rightNode, Integer level) {
            this.rightNode = rightNode;
            this.level = level;
        }
    }

    public static void kadanesAlgo(int[] arr) {
        // ans will be global sum
        // sum will be local sum
        // if sum > ans, update ans
        // reset sum if sum < 0
        // Q: What if all ele are -ve

        int n = arr.length;
        int sum = 0, ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > ans) ans = sum;
            if (sum < 0) sum = 0;
        }

        System.out.println("ans = " + ans);
    }

    public static void maxDistanceBetweenSameElements(int[] arr) {
        // create a hasmap of arr ele vs list of indices
        // scan through the map, if list's size > 1,
        // update ans with diff of list's first and last ele

        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list;
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
            }

            map.put(arr[i], list);
        }

        int ans = 0;

        System.out.println("map = " + map);

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                ans = Math.max(ans, list.get(list.size() - 1) - list.get(0));
            }
        }

        System.out.println("ans = " + ans);
    }

    public static void additionOfSubMatrix(int[][] arr, MyPoint start, MyPoint end) {
        // run a loop from start to end and all the elements

        int sum = 0;

        int n = arr.length;
        int m = arr[0].length;

        System.out.println("x1 " + start.x1 + " y1 " + start.y1);
        System.out.println("x2 " + end.x1 + " y2 " + end.y1);

        for (int i = start.x1 - 1; i < end.x1; i++) {
            for (int j = start.y1 - 1; j < end.y1; j++) {
                System.out.println(arr[i][j]);
                sum += arr[i][j];
            }
        }

        System.out.println("sum = " + sum);
    }


    public static void nutsAndBolts(String[] a, String[] b) {
        // create 2 maps, one for symbol -> num and
        // other for num -> sym
        // sort one array and create a map for other
        // with key as ele and val as true

        // traverse the sorted array and if it's ele
        // is present in map, print

        int n = a.length;
        LinkedHashMap<String, Integer> orderStringToIntMap = new LinkedHashMap<>();
        orderStringToIntMap.put("!", 1);
        orderStringToIntMap.put("#", 2);
        orderStringToIntMap.put("$", 3);
        orderStringToIntMap.put("%", 4);
        orderStringToIntMap.put("&", 5);
        orderStringToIntMap.put("*", 6);
        orderStringToIntMap.put("@", 7);
        orderStringToIntMap.put("^", 8);
        orderStringToIntMap.put("~", 9);

        LinkedHashMap<Integer, String> orderIntToStringMap = new LinkedHashMap<>();

        orderIntToStringMap.put(1, "!");
        orderIntToStringMap.put(2, "#");
        orderIntToStringMap.put(3, "$");
        orderIntToStringMap.put(4, "%");
        orderIntToStringMap.put(5, "&");
        orderIntToStringMap.put(6, "*");
        orderIntToStringMap.put(7, "@");
        orderIntToStringMap.put(8, "^");
        orderIntToStringMap.put(9, "~");

        int[] a1 = new int[a.length];
        int[] a2 = new int[b.length];

        for (int i = 0; i < n; i++) {
            a1[i] = orderStringToIntMap.get(a[i]);
            a2[i] = orderStringToIntMap.get(b[i]);
        }

        Arrays.sort(a1);
        TreeMap<Integer, Boolean> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(a2[i], true);
        }

        StringBuilder res1 = new StringBuilder(), res2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(a1[i])) {
                res1.append(orderIntToStringMap.get(a1[i])).append(" ");
                res2.append(orderIntToStringMap.get(a1[i])).append(" ");
            }
        }

        System.out.println(res1);
        System.out.println(res2);
    }

    public static void minSwaps(int[] arr) {
        // insertion sort
        // first element is always sorted
        // keep track of the sorted elements via j, init j as 0
        // from next one onwards,
        // if a[j] > a[i], move j's value to j+1, till j>0 && arr[j] > arr[i]
        // put arr[i] in a[j+1]

        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int k = arr[i];
            boolean hasEntered = false;

            while (j >= 0 && arr[j] > k) {
                if (!hasEntered) {
                    count++;
                    hasEntered = true;
                }
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = k;

        }

        Utils.printIntArray(arr);
        System.out.println("count = " + count);
    }

    public static boolean isSorted(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        return Arrays.equals(arr, copy);
    }

    public static void firstComeFirstServe(int[] arr, int k) {
        // create a linked hashmap of arr ele as key vs their freq
        // return the first entry that has a value as k
        //

        int n = arr.length;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("map = " + map);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == k) {
                System.out.println(e.getKey());
                return;
            }
        }

        System.out.println(-1);
    }

    public static void reArrangeCharacters(String str) {
        // create a map of char vs freq
        // if max element in values < n/2, return true
        // else return false

        int n = str.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        System.out.println("map = " + map);

        int value = map.values().stream().max(Comparator.naturalOrder()).get();
        System.out.println("value = " + value);


        if (value > n / 2) System.out.println(false);
        else System.out.println(true);
    }

    public static void findNumberOfUniquePaths(int[][] arr) {
        // fill 1st rol and 1st col with 1 as from origin 1st row can be reached only in 1 way
        // 1st col as 1 as from origin there's only 1 way
        // rest of the cells, either can be traversed by immediate left taking right or immediate up
        // taking down

        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]);
            }
        }

        Utils.printInt2DArray(arr);
    }

    public static int josephusProblem(int n, int k) {
        // in every iteration, one person is killed so n decreases by 1
        // every kth person is killed, so (k+1)th person holds the sword to kill
        // but here doing k-1 for 1-based indexing
        // modulo it by n to prevent it going out of bounds
        // base case if n == 1, return 1

        if (n == 1) return 1;

        return (josephusProblem(n - 1, k) + k - 1) % n + 1;
    }

    public static void findLargestWordInDictionary(String[] arr, String str) {
        // create a map of string vs diff count
        // diff count is number of chars of str not present in arr's ele
        // once map is created, get the entry which has the least value

        int n = arr.length;

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int c = 0;
            String s = arr[i];
            for (int j = 0; j < s.length(); j++) {
                if (str.indexOf(s.charAt(j)) != -1) c++;
            }

            map.put(s, str.length() - c);
        }

        System.out.println("map = " + map);

        System.out.println(map.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey());
    }

    public void toSumTree(Node root) {
        //add code here.
        // store the old value
        // recur for the left and right subtree
        // return sum of these 2 + old value

        SumTree(root);
    }

    public int SumTree(Node root) {
        if (root == null) return 0;

        int oldValue = root.data;

        root.data = SumTree(root.left) + SumTree(root.right);

        return root.data + oldValue;
    }

    public static void zigZagLevelOrderTraversal(Node root) {
        // use 2 stacks
        // 1 for pushing left & right
        // 2 for pushing right & left

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.println(tmp.data + " ");
                list.add(tmp.data);

                s2.push(tmp.left);
                s2.push(tmp.right);
            }

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.println("tmp = " + tmp.data);
                list.add(tmp.data);

                s1.push(tmp.right);
                s1.push(tmp.left);
            }
        }
    }

    public static void winnerOfElection(String[] arr) {
        // create a treemap of string vs freq
        // select the string with max value

        int n = arr.length;

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("map = " + map);

        System.out.println(map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get().toString().replaceAll("=", " "));
    }

    public static LinkedListNode deleteNode(LinkedListNode head, int pos) {
        int c = 1;

        if (pos == 1) {
            head = head.next;
            return head;
        }
        LinkedListNode ptr = head;
        while (c < pos - 1) {
            c++;
            ptr = ptr.next;
        }

        if (ptr.next.next != null) {
            ptr.next = ptr.next.next;
            LinkedListNode ptr2 = ptr;
            ptr = ptr.next;
            ptr.prev = ptr2;
        } else {
            ptr.next = null;
        }

        return head;
    }


    public static void kLargestElements(int[] arr, int k) {
        // create a max heap
        // retrieve first k elements

        int n = arr.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }

        System.out.println("maxHeap = " + maxHeap);

        while (k-- > 0) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

    public static LinkedListNode reverseLinkedListInK(LinkedListNode head, int k) {
        // reverse for k elements using the std reverse algo
        // connect prev's next to the return value of the recursive call
        // return head as base case

        if (head == null) return null;

        int count = 1;
        LinkedListNode ptr = head;

        while (ptr != null && count <= k) {
            ptr = ptr.next;
            count++;
        }

        LinkedListNode prev = null, curr = head, next;

        while (curr != ptr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseLinkedListInK(ptr, k);

        return prev;
    }

    public static void sortedSubsequenceOfSize3(int[] arr) {
        // create a map of indices vs arr ele
        // iterate through the values and maintain increasing order by max and count
        // if values' ele > max, add it to list

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, arr[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int v : map.values()) {
            if (v > max) {
                list.add(v);
                max = v;
            }
        }


        System.out.println(list);
    }

    public static void kthLargestInStream(int[] arr, int k) {
        // ignore the first k-1 elements
        // from kth onwards, maintain a heap of size k
        // if the new element is > heap.peek(),
        // poll the heap and add the new elements
        // else ignore

        int n = arr.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                System.out.print(-1 + " ");
                continue;
            }

            if (i == k - 1) minHeap.add(arr[i]);
            else {
                if (minHeap.peek() != null && arr[i] > (minHeap.peek())) {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
            }
            System.out.print(arr[i] + " ");
        }

    }

    public static void metaStrings(String s1, String s2) {
        // check for unequal lengths
        // maintain a flag isSet
        // if a char's idx is diff and flag is not set, set it
        // if flag is set return false

        int n1 = s1.length();
        int n2 = s2.length();
        int c = 0;

        if (n1 != n2) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }

        }
        System.out.println("c = " + c);

        System.out.println(c == 2 ? 1 : 0);
    }

    public static void wildCardPatternMatching(String patt, String str) {
        // convert strings to char arrays
        // init 0,0 as true
        // only way null string is true if pat is '*', so set r=0, all cols to true
        // if pat[i] == str[i] or pat[i] = '?', take the value from the diagonal
        // as it is equivalent of removing one char from both pat and str
        // if pat[i] = '*', 0 or more chars, do left side || up side
        // left side meaning * represents 0 chars
        // up side meaning * represents multi chars

        char[] pat = patt.toCharArray();
        char[] chars = str.toCharArray();

        int n = str.length(), m = patt.length();
        boolean[][] arr = new boolean[n + 1][m + 1];

        arr[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (patt.charAt(j - 1) == '*') arr[0][j] = arr[0][j - 1];
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pat[j - 1] == '?' || pat[j - 1] == chars[i - 1]) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else if (pat[j - 1] == '*') {
                    arr[i][j] = arr[i - 1][j] || arr[i][j - 1];
                } else arr[i][j] = false;
            }
        }

        System.out.println(arr[n][m]);
    }

    public static void maxSumWithoutAdjacents(int[] arr) {
        // maintain 2 vars
        // considering the case for including current ele
        // incl: including the curr ele, so skipping prev ele
        // excl: max of prev incl and excl

        int n = arr.length;

        int incl = arr[0];
        int excl = 0;
        int excl_new = 0;


        for (int i = 1; i < n; i++) {
            // doing this as incl will change later,
            // so storing the max of previous incl and excl
            excl_new = Math.max(incl, excl);

            // update incl with curr element, skip prev and add ele before that
            incl = arr[i] + excl;

            //update excl with new val
            excl = excl_new;
        }

        System.out.println(Math.max(excl, incl));
    }

    public static void maximumHeightTree(int n) {
        // create a csum arr by adding prev csum element with i+1
        // find index of n in csum arr

        int[] csum = new int[n];

        csum[0] = 1;

        for (int i = 1; i < n; i++) {
            csum[i] = csum[i - 1] + i + 1;
        }

        //Utils.printIntArray(csum);
        Arrays.stream(csum).forEach(e -> System.out.print(e + " "));
        System.out.println();

        int height = Utils.binarySearch(csum, n);
        System.out.println("height = " + (height + 1));

    }

    public static void nthUglyNumber(int n) {
        // an ugly number is one who has only 2,3, 5 as prime factors
        // the seq is 1,2,3,4,5,6,8,9..
        // It is subseq of 2, 3 and 5 with i iterating
        // create an arr for ugly numbers
        // store the next multiples of 2, 3 and 5 in n2, n3 and n5
        // store the iterators in i2, i3 and i5
        // init arr with 1 and ans with 1
        // from 1 to n, update ans with min of next multiples of 2,3,5
        // now check whose was min to update iterators and next multiple
        // update next multiple by multiplying i with ugly[resp. iterator]

        int[] ugly = new int[n];
        int n2 = 2, n3 = 3, n5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        int ans = 1;
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ans = Math.min(n2, Math.min(n3, n5));

            ugly[i] = ans;

            if (ans == n2) {
                i2++;
                n2 = 2 * ugly[i2];
            }

            if (ans == n3) {
                i3++;
                n3 = 3 * ugly[i3];
            }

            if (ans == n5) {
                i5++;
                n5 = 5 * ugly[i5];
            }
        }

        System.out.println(ans % Math.pow(10, 7) + 7);
    }

    public static void countSubStrings(String s) {
        int n = s.length();
        int ones = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '1') ones++;
        }

        System.out.println((ones) * (ones - 1) / 2);
    }

    public static void lengthOfTheLongestSubString(String str) {
        int n = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (stringBuilder.indexOf(str.substring(i, i + 1)) == -1) {
                stringBuilder.append(str, i, i + 1);
            } else {
                ans = Math.max(ans, stringBuilder.length());
                if (stringBuilder.charAt(stringBuilder.length() - 1) == str.charAt(i)) {
                    stringBuilder.delete(0, stringBuilder.length());
                } else {
                    stringBuilder.delete(0, 1 + stringBuilder.indexOf(str.substring(i, i + 1)));
                }

                stringBuilder.append(str, i, i + 1);
            }

            System.out.println("stringBuilder = " + stringBuilder);
        }

        ans = Math.max(ans, stringBuilder.length());

        System.out.println("ans = " + ans);
    }

    public static void powerOfNumbers(BigInteger n) {
        // reverse n to get r
        // do pow(n,r)

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);

        //System.out.println("stringBuilder = " + stringBuilder);

        BigInteger r = new BigInteger(stringBuilder.reverse().toString());
        System.out.println("r = " + r);

        BigInteger mod = new BigInteger("1000000007");

        System.out.println((n.modPow(r, mod)));
    }

    public static boolean tripletSumInArray(int[] arr, int x) {
        // sort the arr
        // keep i at 0, j at 1, k = n - 1
        // if sum of i, j& k > k, k--
        // else if sum < k, j++

        int n = arr.length;
        Arrays.sort(arr);

        Utils.printIntArray(arr);
        System.out.println();

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j <= k) {
                if (arr[i] + arr[j] + arr[k] > x) k--;
                else if (arr[i] + arr[j] + arr[k] < x) j++;
                else {
                    if (arr[i] != arr[j] && arr[i] != arr[k] && arr[j] != arr[k]) return true;
                    j++;
                    k--;
                }

                System.out.print("arr[i] = " + arr[i]);
                System.out.print("arr[j] = " + arr[j]);
                System.out.print("arr[k] = " + arr[k]);
                System.out.println();
            }
        }

        return false;
    }

    public static void minNumberOfFlips(String string) {
        // get the string's length
        // create the alternate bit string starting from 1 and 0
        // do an XOR twice, once between given string and starting with 1
        // another with 0
        // res is min of no of set bits in the result

        int n = string.length();

        StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str1.append(1);
                str2.append(0);
            } else {
                str1.append(0);
                str2.append(1);
            }
        }

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        System.out.println("string = " + Long.parseLong(string, 2));

        long res1 = Long.parseLong(string, 2) ^ Long.parseLong(str1.toString(), 2);

        long res2 = Long.parseLong(string, 2) ^ Long.parseLong(str2.toString(), 2);

        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);


        int count1 = 0, count2 = 0;

        while (res1 != 0) {
            res1 &= (res1 - 1);
            count1++;
        }

        while (res2 != 0) {
            res2 &= (res2 - 1);
            count2++;
        }

        System.out.println(Math.min(count1, count2));
    }

    public static void minimumNumberOfJumps(int[] arr) {
        // create an array jumps to indicate
        // the min steps it takes to reach that index
        // store the next coming steps in j
        // store the acc in i
        // for every index, the min steps to reach there
        // would be min steps it takes to reach the current index + 1 ,
        // previously computed value in case of multiple ways to reach
        int n = arr.length;
        int[] jumps = new int[n];

        jumps[0] = 0;

        if (arr[0] == 0) return;

        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
                    break;
                }
            }
        }

        System.out.println("jumps = " + jumps[n - 1]);
    }

    public static void changeBits(int n) {
        // count the number of bits present in n
        // init count= 1 and i =0
        // loop till pow(2,i) <= n, do i++
        // new value will be pow(2,c) - 1
        // diff will be new - old

        int count = 0, i = 0;
        int val = 1;

        while (val <= n) {
            i++;
            val = (int) Math.pow(2, i);
            count++;
        }

        System.out.println("count = " + count);

        int newVal = (int) Math.pow(2, count) - 1;
        System.out.println("newVal = " + newVal);

        int diff = newVal - n;
        System.out.println("diff = " + diff);
    }

    public static void xorAfterMaking2NumbersSameInLength(int a, int b) {
        // left shift the smaller number by 1 and return the xor

        if (a > b) {
            int diff = getNumberOfBits(a) - getNumberOfBits(b);
            b = b << diff;
        } else {
            int diff = getNumberOfBits(b) - getNumberOfBits(a);
            System.out.println("diff = " + diff);
            a = a << diff;
        }

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println(a ^ b);
    }

    public static int getNumberOfBits(int x) {
        int count = 0, i = 0;
        int val = 1;

        while (val <= x) {
            i++;
            val = (int) Math.pow(2, i);
            count++;
        }

        return count;
    }

    public static void printAllPermutations(String s, int l, int r) {
        // swap the char with itself
        // after permutation, move one step ahead
        // back track to the original str to look for other permutations

        int n = s.length();

        if (l == r) {
            System.out.print(s + " ");
            System.out.println();
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                System.out.println("swapped string = " + s);
                printAllPermutations(s, l + 1, r);
                s = swap(s, l, i);
                System.out.println("backtracking = " + s);
            }
        }
    }

    public static String swap(String str, int l, int i) {
        char tmp;
        char[] chars = str.toCharArray();

        tmp = chars[l];
        chars[l] = chars[i];
        chars[i] = tmp;

        return String.valueOf(chars);
    }

    public static void facingTheSun(int[] arr) {
        //count the number of times a value increases

        int n = arr.length;
        int count = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }

        System.out.println("count = " + count);
    }

    public static void removeLoopFromLinkedList(LinkedListNode head) {
        // create 2 ptrs one slow and one fast
        // run while both are not null, inc s by 1 and f by 2 and check if s == f break
        // now, loop has been detected, move s to head and
        // while f.next != s.next inc f and s
        // update f next by null

        LinkedListNode s = head, f = head;

        while (s != null && f != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) break;
        }

        if (s == f) {
            s = head;
            while (s.next != f.next) {
                f = f.next;
                s = s.next;
            }

            f.next = null;
        }
    }

    public static void productArrayPuzzle(int[] arr) {
        // store the product in p
        // create a res arr
        // make res[i] = p/arr[i]

        int n = arr.length;
        int p = 1;
        int[] res = new int[n];

        int j = 0;
        p = Arrays.stream(Arrays.copyOfRange(arr, 1, n)).reduce(1, (a, b) -> a * b);
        res[0] = p;


        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1] / arr[i];
        }

        Utils.printIntArray(res);
    }

    public static void stringModification(String string) {
        // create a treemap of char vs their freq

        int n = string.length();

        TreeMap<Character, Integer> map = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> stringBuilder.append(e.getKey()));


        System.out.println("list = " + stringBuilder);

        //System.out.println("map = " + map);
    }

    public static void numberOfSubArraysWithEvenSum(int[] arr) {
        // create a csum arr
        // if csum[i] is even, count++
        // create a map to store even elements as key vs their freq

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        int[] csum = new int[n];

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            csum[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            if (csum[i] % 2 == 0) count++;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if ((csum[j] - csum[i]) % 2 == 0) {
                        map.put(csum[j] - csum[i],
                                map.getOrDefault(csum[j] - csum[i], 0) + 1);
                    }
                }
            }
        }

        int mapAns = map.values().stream().reduce(0, Integer::sum);
        System.out.println("mapAns = " + mapAns);

        System.out.println("count = " + count);

    }

    public static void buyAndSellStocks(int[] arr) {
        // store the ans in gMax, init it with 0
        // store the running max in lMax, init it with 0
        // run a loop,i from 0 to n
        // run a nested loop , j from i+1 to n
        // if a[j] > a[i], update lMax
        // update gMax on completion of nested loop

        int n = arr.length;
        int gMax = 0, lMax = 0;
        for (int i = 0; i < n; i++) {
            lMax = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) lMax = Math.max(lMax, arr[j] - arr[i]);
            }
            gMax = Math.max(gMax, lMax);
        }

        System.out.println("gMax = " + gMax);
    }

    public static long singleNumberII(int[] arr) {
        // create a set of elements
        // store the sum of set
        //store the sum of original arr
        // ans is 3*sumset - osum/2

        int n = arr.length;
        long res = 0L;

        long sum = Arrays.stream(arr).sum();
        Set<Integer> set = new HashSet<>();
        for (int v : arr) set.add(v);


        long setSum = set.stream().reduce(0, Integer::sum);

        res = (3 * (setSum) - sum) / 2;
        return res;
    }

    public static void subtractProductAndSum(int n) {
        // get the digits of the number in arr
        // store the product and sum diff

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            int d = n % 10;
            list.add(d);
            n /= 10;
        }

        int p = list.stream().reduce(1, (a, b) -> a * b);
        int s = list.stream().reduce(0, Integer::sum);

        System.out.println("s = " + s);
        System.out.println("p = " + p);

        System.out.println(p - s);
    }

    public static int[] decompress(int[] arr) {
        // take 2 elements from arr as l and r
        // fill res arr with r present l times

        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int freq = arr[2 * i];
            int val = arr[2 * i + 1];

            while (freq-- > 0) {
                ans.add(val);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void thirdMax(int[] arr) {
        // create a max heap
        // poll till 3rd element
        // if n < 3 return top of heap
        // if there are dups 2nd or 1st, return next uniq

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int e : arr) {
            if (!maxHeap.contains(e)) maxHeap.add(e);
        }

        if (maxHeap.size() < 3) System.out.println(maxHeap.poll());
        else {
            for (int i = 0; i < 2; i++) {
                maxHeap.poll();
            }
            System.out.println(maxHeap.poll());
        }
    }

    public static int maxDepth(Node root) {
        // max depth of a tree is nothing but the height of binary tree
        // base case if root is null, return 0
        // if root's left and right is null, return 1
        // else max(1+left, 1+right)

        if (root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return Math.max(1 + lh, 1 + rh);
    }

    public static boolean isSameTree(Node p, Node q) {
        // if p and q both are null, return true
        // if p or q are null, return false
        // return result of p.data == q.data & recur for left subtrees and right subtrees

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return p.data == q.data && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void mirror(Node root) {
        if(root == null) return;

        if(root.left == null && root.right == null) return;

        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void minElementInBST(Node root) {
        // do the inorder traversal of tree
        // store the inorder in a list
        // list will be sorted
        // return the 1st element of the list

        List<Integer> list = new ArrayList<>();

        minElementInBST(root, list);

        System.out.println("list = " + list.get(0));
    }

    public static void minElementInBST(Node root, List<Integer> list) {
        minElementInBST(root.left, list);
        list.add(root.data);
        minElementInBST(root.right, list);
    }

    public static void readFromFile(String filePath) throws IOException {
        // create a fileInputStream instance that takes filepath as args
        // create a scanner instance that takes fileinputstream instance as args
        // while sc has nextLine, print sc.nextLine

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void writeIntoFile() throws IOException {
        // create a file instance with args as arbitary file path as args
        // create a fileoutputstream instance with file instance as args
        // create a bufferedwriter instance as fileoutputstream instance as args

        // do bufferedwriter's instance .write

        File file = new File("writeFile.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for (int i = 0; i < 10; i++) {
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    public static void littleElephantAndCandies(int totalCandies, int totalNumberElephants, int[] arr) {
        // sum of arr should be <= total number of candies

        int sum = Arrays.stream(arr).sum();

        if(sum <= totalCandies) System.out.println("Yes");
        else System.out.println("No");
    }

    public static void helpJarvis(String str) {
        // convert the string to int arr
        // calculate the sum into aSum
        // get the min number from the arr
        // create another arr of size same as first arr starting from min number
        // calculate the sum into eSum
        // if aSum == eSum, return true else false

        String[] strArr = str.split("");

        int n = strArr.length;

        int[] arr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int min = Arrays.stream(arr).min().getAsInt();

        int aSum = Arrays.stream(arr).sum();

        int[] aux = new int[n];

        for (int i = 0; i < n; i++) {
            aux[i] = min++;
        }

        int eSum = Arrays.stream(aux).sum();

        if(eSum == aSum) System.out.println(true);
        else System.out.println(false);
    }

    public static void countTheElements(int[] a, int[] b, int i) {
        // find the element k as a[i]
        // traverse through b and find count of elements <= k

        int k = a[i];
        int count = 0;

        for (int j = 0; j < b.length; j++) {
            if(b[j] <= k) count++;
        }

        System.out.println("count = " + count);
    }

    public static void greedyFox(int[] arr) {
        // store the return value in ans
        // if a[i] > a[i-1], update sum with a[i-1]
        // else, update ans with max of ans and sum
        // and make sum as a[i-1]
        // on coming out of loop,update ans with max of ans and sum
        // return ans

        int n = arr.length;

        int ans = Integer.MIN_VALUE, sum = arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) sum += arr[i];
            else {
                ans = Math.max(ans, sum);
                sum = arr[i];
            }
        }

        ans = Math.max(ans, sum);

        System.out.println("ans = " + ans);
    }

    public static void chocolateStation(int[] arr, int p) {
        // to travel to first station, we need to buy arr[0] chocs
        // if arr[i+1] > arr[i], our balance increases by diff
        // else, if bal is 0, bought count increases by diff
        // if bal is not 0, bal decreases by diff

        int n = arr.length;
        int bought = arr[0];
        int balance = 0;

        for (int i = 0; i < n-1; i++) {
            if(arr[i] - arr[i+1] > 0) {
                balance += arr[i] - arr[i + 1];
            }
            else {
                if(balance > 0) {
                    balance -= arr[i+1] - arr[i];
                    if(balance < 0) {
                        bought += Math.abs(balance);
                        balance = 0;
                    }
                }
                else {
                    bought += arr[i+1] - arr[i];
                }
            }
        }

        System.out.println("bought = " + bought);
        System.out.println(p * bought);
    }


    public static void nearlySortedAlgorithm(int[] arr, int k) {
        // create a min heap
        // store the first k+1 elements into heap
        // poll the heap and store it into array
        // also from k+1 to n add elements from array to heap
        // now poll the heap and store it into array

        int n = arr.length;
        int limit = Math.min(k+1, n);
        int[] res = new int[n];
        int idx = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < limit; i++) {
            q.add(arr[i]);
        }

        for (int i = k+1; i < n; i++) {
            int ele = q.peek();
            res[idx++] = ele;
            q.poll();
            q.add(arr[i]);
        }

        while(!q.isEmpty()) {
            res[idx++] = q.poll();
        }

        Utils.printIntArray(res);
    }

    public static void inFirstButSecond(long[] a, long[] b) {
        // create a hashmap of int ele vs true for arr b
        // traverse through a and if map.get(a[i]) is null, print a[i]

        HashMap<Long, Boolean> map = new HashMap<>();
        int n = b.length;

        for (int i = 0; i < n; i++) {
            map.put(b[i], true);
        }

        int m = a.length;

        for (int i = 0; i < m; i++) {
            if(map.get(a[i]) == null) System.out.print(a[i] + " ");
        }
    }

    public static void queriesForCountsInMultiples(int[] arr, int ele) {
        // for each ele, check if arr[i] is divisible by ele, if yes, count++
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i] % ele == 0) {
                count++;

            }
        }

        System.out.print(count + " ");
    }


    public static void nutsAndBoltsProblem(char[] nuts, char[] bolts, int n) {
        // the order is as follows: ! # $ % & * @ ^ ~
        // store the order in an array
        // store the nuts or bolts array in a map of char vs boolean
        // traverse through order array and check if map contains order arr[i]
        // if yes, store the order array element in a list

        char[] orderArray = {'!', '#', '$' ,'%', '&' ,'*' , '@', '^' ,'~'};
        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nuts[i], true);
        }

        List<Character> res = new ArrayList<>();
        System.out.println("map = " + map);

        for (int i = 0; i < orderArray.length; i++) {
            System.out.println("orderArray[" + i + "]= " + orderArray[i]);
            if(map.containsKey(orderArray[i])) res.add(orderArray[i]);
        }

        for (int i = 0; i < nuts.length; i++) {
            nuts[i] = res.get(i);
            bolts[i] = res.get(i);
        }
    }

    class RightNode {
        int data;
        RightNode left;
        RightNode right;
        RightNode nextRight;

        RightNode(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }
}



