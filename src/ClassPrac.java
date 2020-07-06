import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ClassPrac extends TemplateClass {
    static long[] a = new long[100000];
    public static void main(String args[] ) throws IOException {
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
        if(a[(int)n] != 0L) return a[(int)n];
        return factorial(n);
    }
    public static long factorial(long n) {
        for(int i=2; i<=n; i++) {
            a[i] = i * a[i-1];
        }
        return a[(int)n];
    }

    public static long modulo(long n) {
        return n % 10;
    }

    public static void powerOf(long x, long n) {
        long factorialValue = factorialUtil(n);
        long modValue = modulo(factorialValue);
        long result = (long) Math.pow(x, n);
        System.out.println(result%10);


    }

    public static void printArr(String[] arr){
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print(arr[0]);
        for (int i = arr.length-1; i >=1 ; i--) {
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

    public static void maxValue(int[] arr){
        int n = arr.length;
        int mod = Math.floorMod(n, 2);
        StringBuilder sb = new StringBuilder();
        
     String[] strArr = Arrays.
             toString(arr).
             substring(1,Arrays.toString(arr).length() - 1).
             replaceAll(" ","").
             split(",");

     System.out.println("strArr = " + Arrays.toString(strArr));


     StringBuilder stringBuilder2 = new StringBuilder();
     String max = "0";
        for (String s:strArr) {
            stringBuilder2.append(s);
        }
        System.out.println("stringBuilder2 = " + stringBuilder2);


        for (int i = 0; i < strArr.length; i++) {
            String sub;
            sub = stringBuilder2.substring(0, strArr[i].length());

            stringBuilder2.append(sub);
            System.out.println("stringBuilder2 = " + stringBuilder2);
            stringBuilder2.delete(0, sub.length());

            max = String.valueOf(Math.max(Long.valueOf(max),Long.valueOf(stringBuilder2.toString())));
            System.out.println("max = " + max);
        }

        System.out.print(max + " ");
    }


    public static void anagramOccurences(String str1, String str2) {
        int n = str1.length();
        int j=0, count = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        map.values().stream().allMatch(e -> e.equals(map.values().stream().findFirst()));

        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) + 1);
        }

        System.out.println("map = " + map);

        for(int i=0;i<=n-str2.length();i++) {
            String sub = str1.substring(i, i+str2.length());
            HashMap<Character, Integer> subMap = new HashMap<>();
            for (int k = 0; k < sub.length(); k++) {
                subMap.put(sub.charAt(k), subMap.getOrDefault(sub.charAt(k),
                        0) + 1);
            }

            if(subMap.equals(map)) count++;
        }

        System.out.println("count = " + count);
    }
    
    public static void placementTour(int[] arr, int b){
        int gCost = 0 , n = arr.length;
        int i,j=0, ans = 0;
        boolean isBroke = false;
        while(gCost < b) {
            for (i = 0; i < n; i++) {
                int lCost = 0;
                for (j = 0; j <= i; j++) {
                    lCost += (arr[j] + ((j+1) * (i+1)));
                }
                System.out.println("lCost = " + lCost);
                if(lCost > b) {
                    isBroke = true;
                    break;
                }
                else {
                    gCost = Math.max(lCost, gCost);
                    ans = gCost;
                }
            }
            if(isBroke) {
                j = j-1;
                break;
            }
        }

        System.out.println(j + " " + ans);
    }


    public static void numberOfTriplets(int[] arr, int a, int b){
        // B - number of triplets having sum <= b
        // A - number of triplets having sum < a
        // ans = B - A

        int tripletsA = getNumberOfTripletsWithSumLessThan(arr,a-1);
        int tripletsB = getNumberOfTripletsWithSumLessThan(arr,b);

        System.out.println("tripletsA = " + tripletsA);
        System.out.println("tripletsB = " + tripletsB);

        System.out.println(tripletsB - tripletsA);
    }

    public static int getNumberOfTripletsWithSumLessThan(int[] arr, int a){
       // sort the arr
       // for i = 0 to n-2, j= i + 1, k = n-1
       // if arr[i] + arr[j] + arr[k] >= k--
       // else ans += k-j // j++

       Arrays.sort(arr);
       int n = arr.length, ans = 0;
       int j, k;
        for (int i = 0; i < n-2; i++) {
            j = i + 1;
            k = n - 1;
            while(j != k) {
                if (arr[i] + arr[j] + arr[k] > a) k--;

                else {
                    ans += (k - j);
                    j++;
                }
            }
        }

        return ans;
    }
    
    public static void sumsDifference(int[] arr){

    List<Integer> sameFreqList = new ArrayList<>();
    List<Integer> diffFreqList = new ArrayList<>();
    int n = arr.length;

        for (int i = 0; i < n; i++) {
            int e = arr[i];
            String[] str = String.valueOf(e).split("");
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (String s: str) {
                countMap.put(Integer.valueOf(s),
                        countMap.getOrDefault(Integer.valueOf(s), 0) + 1);
            }
            int value = countMap.values().stream().findFirst().get();

            if(countMap.values().stream().allMatch(v-> v.equals(value))) sameFreqList.add(e);
            else diffFreqList.add(e);
        }

        System.out.println("sameFreqList = " + sameFreqList);
        System.out.println("diffFreqList = " + diffFreqList);

        System.out.println(sameFreqList.stream().reduce(0, (a,b)->(a+b)));
        System.out.println(diffFreqList.stream().reduce(0, (x,y)->(x+y)));

        int diff = sameFreqList.stream().reduce(0, (a,b)->(a+b)) -
                diffFreqList.stream().reduce(0, (x,y)->(x+y));

        System.out.println("diff = " + diff);
    }
    
    public static void kPairsWithSmallestSums(int[] a, int[] b, int k){
      int count = 0;
      int i = 0, j = 0, m = a.length, n = b.length, start = 0;
      List<Pair<Integer, Integer>> list = new ArrayList<>();

          while(i < m && j < n) {
              while(count < k) {

                  Pair<Integer, Integer> pair = new Pair<>(a[i],b[j]);
                  list.add(pair);
                  count++;

              if(i == m) {
                  System.out.println("i = " + i);
                  System.out.println("start = " + start);
                  System.out.println("list = " + list);
                  System.out.println("count = " + count);

                  if(a[i-1] > b[j]) {
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

          if(i == m) {
              System.out.println("i = " + i);
              System.out.println("start = " + start);
              System.out.println("list = " + list);
              System.out.println("count = " + count);

              if(a[i-1] > b[j]) {
                  i = start + 1;
                  j++;
              }
          }

          else {
              System.out.println("j = " + j);
              System.out.println("start = " + start);
              System.out.println("list = " + list);
              System.out.println("count = " + count);

              if(b[j-1] > a[i]) {
                  j = start + 1;
                  i++;
              }
          }
      }
        System.out.println("list = " + list);
    }

    public static void equilibriumArray(int[] arr){
        int l = 0, n = arr.length , r = n - 1;
        int l_sum = 0, r_sum = 0;
        int sum = Arrays.stream(arr).sum();

        for (int i = 1; i < n; i++) {
            r_sum = sum - l_sum - arr[i];
            if(l_sum == r_sum) {
                System.out.println("i = " + i);
                break;
            }
        }
        System.out.println(-1);
    }

    public static void countOfSubarraysWithSum(int[] arr, int x){
        HashMap<Integer,Integer> sumCountMap = new HashMap<>();
        int n = arr.length, sum = 0, result = 0;
        sumCountMap.put(0,1);

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

    public static void numberOfSubarraysWithSame0sand1s(int[] arr){
        /*First, convert all 0s to -1s,
        then number of subarrays would be number of subarrays with sum 0
        * */

        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        int n = arr.length;
        int sum = 0, result = 0;

        arr = Arrays.stream(arr).map(v -> v == 0 ? -1 : v).toArray();

        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));

        for (int value : arr) {
            sum += value;

            if (sumCountMap.containsKey(sum)) result += sumCountMap.get(sum);

            else sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }


        System.out.println("result = " + result);
    }

    public static void maxSubarrayWithEqual0sand1s(int[] a, int[] b){
     int[] c = new int[a.length];
     HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        int n = a.length;

        for (int i = 0; i < n; i++) {
            c[i] = (a[0] == 1) ? a[i] - b[i] : b[i] - a[i];
        }

        Arrays.stream(c).forEach(e-> System.out.print(e + " "));

        int len = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += c[i];

            if (sum == 0) len = i + 1;

            if(sumIndexMap.containsKey(sum)) len = Math.max(len, i-sumIndexMap.get(sum));
            else sumIndexMap.put(sum, i);
        }

        System.out.println("len = " + len);
    }
    
    public static void maxSumSubArray(int[] arr, int k){
        int n = arr.length;
        int prev_sum = 0;

        for (int i = 0; i < k ; i++) {
                prev_sum += arr[i];
        }

        // sum of k length subarray would be sum of prev sub array
        // + curr element - first element of previous sub array
        int sum = prev_sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i-k];
            prev_sum = Math.max(prev_sum, sum);
        }

        System.out.println("ans = " + prev_sum);
        
    }
    
    public static void maxSubArrayDivByK(int[] arr, int k){
        // create a mod arr
        // HashMap - key - sum at i
        // value - index i
        int n = arr.length , ans = 0;

        int[] m_arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            m_arr[i] = ((sum % k) + k) % k;
        }

        HashMap<Integer, Integer> modValueIndexMap = new HashMap<>();

        for (int i = 0; i < m_arr.length; i++) {
            if(m_arr[i] == 0) ans = i + 1;

            else {
                if(!modValueIndexMap.containsKey(m_arr[i])) modValueIndexMap.put(m_arr[i],i);

                else {
                    if(ans < i - modValueIndexMap.get(m_arr[i]))
                        ans = i - modValueIndexMap.get(m_arr[i]);
                }
            }
        }

        System.out.println("ans = " + ans);
    }
    
    
    public static void subArrayWithSum(int[] arr, int k){
        // create a hashMap with sumindex map
        // if map contains sum[i] - k, then start = map.get(sum)
        // end = i

        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0, start = 0 , end = -1, n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum - k == 0) {
                start = 0;
                end = i;
                break;
            }

            if(sumIndexMap.containsKey(sum - k)) {
                start = sumIndexMap.get(sum - k) + 1;
                end = i;
                break;
            }

            sumIndexMap.put(sum, i);
        }

        System.out.println((end == -1) ? (-1) : (start + 1) + " " + (end + 1));
    }
    
   public static void minimumCostToMakeAllElementsEqual(int[] arr, int a, int m, int r){
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
           if(entry.getValue() == freq) target = entry.getKey();
           else diffCount++;
       }

       for (int i = 0; i < n; i++) {
          if(arr[i] != target) {
              if(diffCount == 1) {
                  if(arr[i] > target) {
                      cost += (arr[i] - target) * r;
                  }
                  else cost += (target - arr[i]) * a;
              }
              else {
                  if(arr[i] > target) {
                      cost += Math.min(m,r) * (arr[i] - target);
                  }
                  else cost += Math.min(m,a) * (target - arr[i]);
              }
          }
       }

       System.out.println("cost = " + cost);
    }
    
    
    public static void primeNumberSumOfNumbers(int[] arr){
        // Create an arr of prime numbers till right limit
        // Create a csum arr from the prime arr
        // for each limit, traverse the csum arr with 2 ptr algo
        // if the curr element is prime, then f = curr and s = f.

        int l = arr[0] , r = arr[1], n = arr.length;

        int[] prime = new int[r+1];
        int j = 0;
        for (int i = 2; i <= r ; i++) {
            if(isPrime(i)) prime[j++] = i;
        }

        int[] c_sum = new int[r+1];
        int sum = 0;

        for (int i = 0; i < r+1; i++) {
            sum += prime[i];

            c_sum[i] = sum;
        }

        int first = 0;

        for (int i = 0; c_sum[i] <= l; i++) {

            if(isPrime(c_sum[i])) {
                first = c_sum[i];
                //second = first;
            }

        }

        System.out.println(first);

        first = 0;
        //second = 0;

        for (int i = 0; c_sum[i] <= r; i++) {
            if(isPrime(c_sum[i])) {
                first = c_sum[i];
                //second = first;
            }
        }

        System.out.println(first);
    }


    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public static void maxIntInRanges(int[] l, int[] r){
        // create a hashmap of freq vs list of element
        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        
        int j = 0;

        while(j < l.length) {
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
    
    public static void subArraySumPalindrome(int[] arr){
        // create a csum arr
        // create a hashmap of csum vs index
        // if csum[0] is palindrome, return no
        // if csum[i] - previous csum till i is palindrome, return yes

        int n = arr.length;
        int[] c_sum = new int[n];

        int sum=0, j;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            c_sum[i] = sum;
        }

        Arrays.stream(c_sum).forEach(e -> System.out.print(e + " "));
        System.out.println();


        if(isPalindrome(c_sum[0])){
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

                    if (( (c_sum[i] - sumIndexMap.get(j))/10  >= 1) && isPalindrome(c_sum[i] - sumIndexMap.get(j))) {
                        System.out.println("YES");
                        return;
                    }
                    j++;
            }

        }

        System.out.println("NO");
    }

    public static boolean isPalindrome(int n){
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
            if(sum > ans) {
                if(start == -1) {
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
    
    public static void xorOfSubArrays(int n, int k, int x){
        // for every index that is divisible by k, insert x at that index
        // else insert 0
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           arr[i] = ((i%k==0) ? x : 0);
        }
        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
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

    public static void playingWithArray(int[] a){
        int n = a.length;
        for (int i = 0; i < n-1; i+=2) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        Arrays.stream(a).forEach(e-> System.out.print(e + " "));
    }
    
    public static void zerosXORPairs(int[] arr){
        // create a hashmap with ele as key and freq as value
        // for each value > 1, find no of pairs using n*n-1/2

        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i],0) + 1);
        }

       // System.out.println("elementFreqMap = " + elementFreqMap);
        int ans = 0;

        ans = elementFreqMap
                .values()
                .stream()
                .filter(e -> e > 1)
                .map(e -> (e * (e-1)/2))
                .reduce(0, Integer::sum);

//        elementFreqMap
//                .values()
//                .stream()
//                .filter(e -> e > 1)
//                .map(e -> (e * (e-1)/2))
//                .forEach(e-> System.out.println(e + " "));

        System.out.println("ans = " + ans);
    }

    public static void count012(int[] arr){
        // create three variables to store count of
        // 0, 1 and 2. Replace the arr accordingly

        int count0 = 0, count1 = 0, count2 = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else count2++;
        }

        int i = 0;
        while(count0-- > 0) {
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

    public static void kthSmallestElement(int[] arr, int k){
        // create a priority queue
        // poll the queue k times

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>
                (IntStream.of(arr).boxed().collect(Collectors.toList()));

        Integer ans = 0;
        while(--k > 0) {
            priorityQueue.poll();
        }
        ans = priorityQueue.peek();
        System.out.println("ans = " + ans);
    }

    public static void rotateClockWise(int[] arr,int d){
        // from 0 to d, store the ele in temp
        // from 1 to n-1, shift the ele to left
        // arr[n-1] = temp

        int n = arr.length;
        int[] aux = Arrays.copyOf(arr, n+d);
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


    public static void binaryArraySorting(int[] arr){
        // while left side contains 0, accelerate
        // if a[r] == 0, swap a[l] & a[r], r--

        int n = arr.length;
        int l = 0, r = n-1;

        while(l<r) {
            while(arr[l] == 0) l++;

                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                r--;
                //l++; // controversial statement

            while(arr[l] == 0) l++;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
    
    public static void reverseInGroups(List<Integer> arr, int k){
        // create a reverse method which reverses the arr from start to end
        // if k > n, reverse the entire array
        // else till n-k reverse in groups of k,
        // after that, reverse from k+1 to n

        int n = arr.size(), i = 0;
        List<Integer> resultList = new ArrayList<>();

        if(k>=n) {
            resultList.addAll(reverse(arr, 0, n));
        }

        else {
            for (; i <= n-k; i+=k) {
              resultList.addAll(reverse(arr, i, i + k));
            }

            //arr.forEach(e-> System.out.print(e + " "));

            //System.out.println();

           resultList.addAll(reverse(arr, i, n));
        }

        System.out.println("resultList = " + resultList);
    }

    public static ArrayList<Integer> reverse(List<Integer> arr, int start, int end){
        System.out.println("arr sublist: " + arr.subList(start, end));

        Stack<Integer> integerStack = new Stack<>();
        integerStack.addAll(arr.subList(start, end));

        ArrayList<Integer> resultList = new ArrayList<>();

        while (!integerStack.isEmpty()) resultList.add(integerStack.pop());

        return resultList;
        //Collections.reverse(arr.subList(start, end));
        //System.out.println("after reversing arr = " + arr);
    }
    
    public static void maxInStructArray(Height[] arr){
        // convert the feet to inches for every even index
        // after that calculate sum of every 2 indices and compare with max
        for (Height he:arr) {
            he.feet = 12 * he.feet;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e.feet + " "));
        System.out.println();
        Height max = (Arrays.stream(arr).max(Comparator.comparing(e -> e.inches + e.feet)).get());
        System.out.println(max.feet + max.inches);
    }
    
    public static void inversePermutation(int[] arr){
        // find the max in the given array
        // create a new arr of max size
        // fill the new arr

        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] new_arr = new int[max+1];

        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            System.out.println("ele = " + ele);
            new_arr[ele] = i + 1;
        }

        Arrays.stream(Arrays.copyOfRange(new_arr,1, new_arr.length)).forEach(e -> System.out.print(e + " "));
    }
    
    public static void matrixInterchange(int[][] arr){
        // swap the first column with the last one
        int n = arr.length, j = 0 , col = arr[0].length-1;
        for (int i = 0; i < n; i++) {
            int temp = arr[i][j];
            arr[i][j] = arr[i][col];
            arr[i][col] = temp;
        }

        System.out.println(Arrays.deepToString(arr));
    }
    
    public static void distinctAbsoluteValues(int[] arr){
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

    public static void sumOfAFunction(int[] arr){
        // if diff between the ele is > 1,
        // then add the diff between them
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(Math.abs(arr[j] - arr[i]) > 1) sum += arr[j] - arr[i];
            }
        }

        System.out.println("sum = " + sum);
    }
    
    public static void ishanLovesChocolates(int[] arr){
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if(arr[i] > arr[j]) i++;
            else j--;
        }

        System.out.println("ans = " + arr[i]);
    }

    public static void maxAfterMIncrementsDriver(int n, int m) throws IOException {
        // increment all values from a to b by k
        // after all operations return max
        int[] arr = new int[n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(m-- > 0) {
            String[] abk = (br.readLine()).split(" ");
            int a = Integer.parseInt(abk[0]);
            int b = Integer.parseInt(abk[1]);
            int k = Integer.parseInt(abk[2]);

            for (int i = a; i <= b ; i++) {
                arr[i] += k;
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("max = " + max);

    }

    public static void maximizeToys(int[] arr, int x){
        // if a toy's cost is less than x, deduct x and increment count
        Arrays.sort(arr);
        int n = arr.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= x && x > 0) {
                x -= arr[i];
                ans++;
            }
        }

        System.out.println("ans = " + ans);
    }
    
    public static void sumOfBitDiff(int[] arr){
        //create pairs from arr elements
        // for each pair do xor of these
        // count number of 1s in the xor result
        // update ans with count

        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xor = arr[i] ^ arr[j];
                int count = count1s(xor);
                ans += count;
            }
        }

        System.out.println("ans = " + (2*ans));
    }
    
    public static void longestSubArray(int[] arr){
        // Have 2 pointers i & j, j will be the runner and i accumulator
        // if a[j] > 0 & j== 1 j++, else if j != 1 i = j
        // if a[j] < 0 ans would be max of ans & j-i+1
        int n = arr.length;

        int ans = 0, len = 0, dummuVat = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] >= 0) len++;
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
    
    public static int countZeros(int[] arr){
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
            if(arr[i] == 0) return n-i;
        }
        return 0;
    }



    public static int count1s(int n){
        // count no of 1s in a number
        // on subtracting 1 from the decimal rep of a number,
        // the value after the rightmost 1 flips
        // if we do & of the number and number - 1,
        // the number of times it takes to become 0
        int count = 0;
        while(n != 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }

    public static Integer[] convertIntToInteger(int[] arr){
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }
    
    public static void rotate2DArray(int n, String[] str){
        int[][] arr = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[k++]);
            }
        }

        int count = 0;
        while(count != n) {
            int temp = arr[n-1][0];
            arr[n-1][0] = arr[n-1][n-1];
            arr[n-1][n-1] = temp;

            temp = arr[0][0];
            arr[0][0] = arr[n-1][n-1];
            arr[n-1][n-1] = temp;

            temp = arr[n-1][n-1];
            arr[n-1][n-1] = arr[0][n-1];
            arr[0][n-1] = temp;

            count++;
        }

        for (int[] a:arr) {
            for (int aa: a) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }
    }
    
    public static void greaterOnRight(int[] arr){
        // create a new arr
        // init new arr's last index as -1
        // init max as 0
        // from n-1 to 1, update max

        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = -1;

        int max = 0;

        for (int i = n-1; i > 0; i--) {
            max = Math.max(max, arr[i]);
            ans[i-1] = max;
        }

        Arrays.stream(ans).forEach(e-> System.out.print(e + " "));
    }
    
    public static void flattenKSortedArrays(int[][] arr, int k){
        // recursively merge 2 arrays
        // for k > 4
        // merge first 2 arrays into a
        // merge second 2 arrays into b
        // merge a & b, then proceed ahead similarly

        ArrayList<Integer> resultList = new ArrayList<>();
        int i = 0, j= 1;

        int n = arr.length;
        System.out.println("n = " + n);

        while (i< n && j < n) {
            int[] mergeFirst = merge(arr[i], arr[j]);

            int[] mergeSecond = new int[n];
            if(i<n-2 && j<n-2) {
                mergeSecond = merge(arr[i+2], arr[j+2]);

            }

            if(i == n-2) Collections.addAll(resultList, Arrays.stream(merge(arr[n-1], mergeSecond)).boxed().toArray(Integer[]::new));

            else if(j == n -2) Collections.addAll(resultList, Arrays.stream(merge(mergeFirst, arr[n-1])).boxed().toArray(Integer[]::new));
            else Collections.addAll(resultList, Arrays.stream(merge(mergeFirst, mergeSecond)).boxed().toArray(Integer[]::new));


            System.out.println("resultList = " + resultList);

            i+=4;
            j+=4;
        }

        System.out.println("resultList = " + resultList);
    }

    public static int[] merge(int[] a, int[] b){
        // merge 2 arrays into one
        int m = a.length, n = b.length;
        int[] res = new int[m+n];

        int i=0,j=0,k=0;
        while(i<m && j<n) {
            if(a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            }
            else if(a[i] > b[j]) {
                res[k] = b[j];
                j++;
            }
            k++;
        }

        if(i<m) {
            while(i < m) res[k++] = a[i++];
        }

        if(j<n) {
            while(j < n) res[k++] = b[j++];
        }

        System.out.println("merge process");
        Utils.printIntArray(res);

        return res;
    }


    public static void detective(int[] arr, int n){
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
            if(result == -1) System.out.print(i + " ");
        }
    }
    
    public static void balancedArray(int[] arr){
        // calculate entire array's sum in sum
        // calculate left sum as running sum
        // and right sum = sum -leftsum
        // diff would be r - l sum
        // ans would be min positive diff

        int n = arr.length;
        int sum = 0, diff = 0, ans = Integer.MAX_VALUE, l_sum = 0, r_sum = 0;
        for (int a:arr) {
            sum += a;
        }

        for (int i = 0; i < n; i++) {
            l_sum += arr[i];
            r_sum = sum - l_sum;

            System.out.println("l_sum = " + l_sum);
            System.out.println("r_sum = " + r_sum);

            if(l_sum > r_sum) {
                diff = Math.abs(r_sum - l_sum);

                ans = Math.min(ans, diff);

                System.out.println("diff = " + diff);
                System.out.println("ans = " + ans);
            }
        }

        System.out.println("ans = " + ans);
    }

    public static void addingOnes(int n, int[] K){
        // for all elements of new arr & for every ele of K
        // add ones to arr if i+1 >= j
        // where i is new arr's iterator & j is K's

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K.length; j++) {
                if((i+1) >= K[j]) {
                    arr[i]++;
                }
            }
        }

        Utils.printIntArray(arr);
    }
    
    public static void countPairsWithSum(int[] arr, int k){
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
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }

        int twice_count = 0;
        for (int i = 0; i < n; i++) {
            if(hashMap.containsKey(k-arr[i])) {
                twice_count += hashMap.get(k-arr[i]);
            }

            if(k-arr[i] == arr[i]) twice_count--;
        }

        System.out.println("twice_count = " + twice_count/2);
    }
    
    public static void mrModulo(int[] arr, int k){
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
            if(arr[i] > k) gtK++;
            int j = i + 1;

            while(j<n){
                if(Math.abs(arr[j] - arr[i]) == k) elementDiffMap.put(arr[i],arr[j]);
                j++;
            }
        }

        System.out.println("gtK = " + gtK);
        System.out.println("elementDiffMap = " + elementDiffMap);

        int diffCount = 0;
        for (Map.Entry<Integer, Integer> entry: elementDiffMap.entrySet()) {
            int a = Math.max(entry.getKey(), entry.getValue());
            int b = Math.min(entry.getKey(), entry.getValue());

            if(a % b == k) diffCount++;
        }

        System.out.println("answer = " + (diffCount + gtK));
    }
    
    public static void reArrange(int[] arr){
        // for 0 to n, store all -1s in a list
        // if a[i] != -1, store in a new result arr

        int n = arr.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            if(arr[i] != -1)  {
                int value = arr[i];
                res[value] = value;
            }
        }

        Utils.printIntArray(res);
    }
    
    
    public static void quickSort(int[] arr, int l, int h){
        // create a partition around the pivot element
        // all elements on left of pivot should be less and
        // all elements on right should be greater than pivot
        // keep an index that tracks elements smaller than pivot
        // if the runner element is smaller than pivot, increment
        // accumulator and swap acc & runner
        //finally, swap pivot and acc + 1, return acc + 1

        int n = arr.length;

        if(l < h) {
            int pivot = partition(arr, l, h);
            System.out.println("pivot = " + pivot);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot +1,  h);
        }

    }

    public static int partition(int[] arr, int l, int h){
        // select the last element as pivot element
        // keep track of elements lesser than pivot by i
        // use j to traverse the entire array
        // if an element is < pivot, swap a[i] & a[j]
        // after loop, swap pivot and a[i+1]
        // return i+1

        int i = -1;
        int pivot = arr[h];
        for (int j = l; j < h; j++) {
            if(arr[j] < pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = pivot;
        pivot = arr[i+1];

        return i+1;
    }

    public static void activitySelection(){
        // sort the activities according to their finish times
        // add the 1st activity
        // from next onwards, if start time of activity > finish time of
        // activity in the list, then add it to the result list

        List<Activity> activityList = new ArrayList<>();


        Activity activity = new Activity(75250, 112960);
        activityList.add(activity);

        Activity activity1 = new Activity(50074, 114515);
        activityList.add(activity1);

        Activity activity2 = new Activity(43659, 81825);
        activityList.add(activity2);

        Activity activity3 = new Activity(8931, 93424);
        activityList.add(activity3);

        Activity activity4 = new Activity(11273, 54316);
        activityList.add(activity4);

        Activity activity5 = new Activity(27545, 35533);
        activityList.add(activity5);

        Activity activity6 = new Activity(50879, 73383);
        activityList.add(activity6);

        Activity activity7 = new Activity(77924, 160252);
        activityList.add(activity7);

        activityList.sort(Comparator.comparing(act-> act.finish_time));

        activityList.forEach(a -> System.out.print(a.start_time + " " + a.finish_time + "\n"));

        int n = activityList.size();
        //Arrays.sort(finish);

        //System.out.print(0 + " ");

        int j = 0;

        for (int k=1; k<n; k++) {
            if(activityList.get(k).start_time >= activityList.get(j).finish_time) {
                System.out.print((k + 1) + " ");
                j = k;
            }
        }

//        for (int i = 1; i < n; i++) {
//            if(start[i] >= finish[j]) {
//                System.out.print(i + " ");
//                j = i;
//            }
//        }

    }
    
    public static void multiplyLeftAndRight(int[] arr){
        // get length of the array
        // divide the array into 2 parts
        // do sum of both parts and then multiply the result of both

        int n = arr.length;

        int k = n/2;

        int l_sum = 0, r_sum =0;

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
                if(Character.getNumericValue(c) == k) count++;
            }

        }

        System.out.println("count = " + count);
    }
    
    public static void minSumFormedByDigits(int[] arr){
        // sort the arr
        // take all even indexed numbers & concat them into one var
        // take all odd indexed numbers & concat them into another var
        // sum of these 2 vars
        int n = arr.length;

        Arrays.sort(arr);

        int a = 0, b = 0;

        StringBuilder stringBuilder1 = new StringBuilder(), stringBuilder2 = new StringBuilder();

        for (int i = 0; i < n; i+=2) {
            stringBuilder1.append(arr[i]);
        }

        a = Integer.parseInt(stringBuilder1.toString());

        for (int i = 1; i < n; i+=2) {
            stringBuilder2.append(arr[i]);
        }

        b = Integer.parseInt(stringBuilder2.toString());

        System.out.println("a + b = " + (a + b));
        System.out.println();
    }

    public static void countOfSubarraysWithKPrime(int[] arr, int k){
        // traverse through the arr and replace the primes with 1 and others
        // with 0.
        // now, problem is same as finding count of subarrays with sum as k

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                arr[i] = 0;
            }

            else {
                arr[i] = isPrime(arr[i]) ? 1 : 0;
            }
        }

        countSubArraysWithSumK(arr, k);
    }

    public static void countSubArraysWithSumK(int[] arr, int k){
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
            if(c_sum[i]==k) count++;

            if(sumCountMap.containsKey(c_sum[i] - k)){
                count += sumCountMap.get(c_sum[i] - k);
            }

            else sumCountMap.put(c_sum[i], sumCountMap.getOrDefault(c_sum[i],0) + 1);
        }

        System.out.println("count = " + count);
    }
    
    public static void countPairsOddXor(int[] arr){
        // count of odd numbers * count of even numbers

        int n = arr.length, eCount = 0, oCount = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i]%2 == 0) eCount++;
            else oCount++;
        }

        System.out.println("ans = " + (eCount * oCount));
    }
    
    public static void gameWithNos(int[] arr){
        // do xor of all elements
        // copy the last element as it is
         int n = arr.length;
         int[] arr2 = new int[n];

        for (int i = 0; i < n-1; i++) {
            arr2[i] = arr[i] ^ arr[i+1];
        }

        arr2[n-1] = arr[n-1];
        Utils.printIntArray(arr2);
    }
    
    public static void countOccurencesOfAnagrams(String a, String b){
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
        String sub = a.substring(i, i+n2);
        int k = 0;
        HashMap<Character, Integer> characterIntegerHashMap2 = new HashMap<>();
        while (k < sub.length()) {
            characterIntegerHashMap2.put(sub.charAt(k),
                    characterIntegerHashMap2.getOrDefault(sub.charAt(k), 0) + 1);
            k++;
        }
        if(characterIntegerHashMap1.equals(characterIntegerHashMap2)) {
            count++;
            System.out.println("characterIntegerHashMap2 = " + characterIntegerHashMap2);
        }
    }

        System.out.println("count = " + count);

    }
    
    public static void rodCutting(int[] arr){
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

    public static void pendulumPrinting(int[] arr){
        // create a new int[] arr
        // get min of arr
        // put min at centre of new arr
        // for even indexed elements, put them from centre to right
        // for odd indexed, put them left to centre

        int n = arr.length;
        int[] new_arr = new int[n];
        
        int mid = 0;
        int min = Arrays.stream(arr).min().getAsInt();

        if(n%2 == 0) {
            // even
            mid = (n-1)/2;
        }
        
        else {
            mid = n/2;
        }
        
        new_arr[mid] = min;
        System.out.println("min element is set");
        Utils.printIntArray(new_arr);

        // left side
        int k =1;
        for (int i = mid-1; i >= 0; i--) {
            new_arr[i] = arr[k];
            k+=2;
        }

        System.out.println("left side");
        Utils.printIntArray(new_arr);

        k = n-1;
        for (int i = n-1; i > mid ; i--) {
            new_arr[i] = arr[k];
            k-=2;
        }

        System.out.println("right side");
        Utils.printIntArray(new_arr);

    }
    
    public static void missingAndRepeating(int[] arr, int n){
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
        for (int i = 0; i < n-1; i++) {
            if((i+1) != arr[i]) {
                missing = Math.min(missing, (i+1));
            }

            if(arr[i] == arr[i+1]){
                repeat = Math.min(repeat, arr[i]);
            }
        }

        System.out.println("missing = " + missing);
        System.out.println("repeat = " + repeat);
    }
    
    public static void countPairsInArray(int[] arr){
        // for i = 0 to n
        // for j =i to n
        // if i*arr[i] < j* arr[j] count++

        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if( (i * arr[i]) > (j * arr[j]) ) count++;
            }
        }

        System.out.println("count = " + count);
    }
    
    public static void sumOfDistinctElements(int[] arr, int n){
        // create a set
        // sum it
        Set<Integer> set = new HashSet<>(Utils.getListFromIntArray(arr));

        System.out.println(set.stream().reduce(Integer::sum).get());
    }

    public static void convertArrayToReducedForm(int[] arr){
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
    
    public static void firstNegativeNumber(int[] arr, int k){
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

        for (int i = k-1; i < n-1; i++) {
            shift(new_arr, arr[i+1]);
            findMin(new_arr);
        }
    }


    public static void shift(int[] a, int ele){
        int n = a.length;

        for (int i = 1; i < n; i++) {
            a[i-1] = a[i];
        }

        a[n-1] = ele;

    }

    public static void findMin(int[] a){
        int i;
        for (i = 0; i < a.length; i++) {
            if(a[i] < 0) {
                System.out.print(a[i] + " ");
                break;
            }
        }

        if (i == a.length) System.out.print(0 + " ");

    }


    public static void countOfSubArraysWithKPrimes(int[] a, int k){
        // if a number is prime, mark it as 1 else 0
        // now, problem reduces to countof subarrays with sum as k

        int n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i] == 1) a[i] = 0;
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
            if(c_sum[i] == k) count++;
            else {
                if(map.containsKey(c_sum[i] - k)) {
                    count += map.get(c_sum[i] - k);
                }
                else map.put(c_sum[i], map.getOrDefault(c_sum[i],0) + 1);
            }
        }

        System.out.println("count = " + count);
    }
    
    public static void largestFibonacciSubsequence(int[] a){
        // check if every number of this arr
        // is a fibonacci number using the property
        // 5n2 +_ 4 is a perfect square

        int n = a.length;

        for (int i = 0; i < n; i++) {
            int x = a[i];

            if(Utils.isPerfectSquare((5 * x * x + 4)) || Utils.isPerfectSquare((5 * x * x - 4)))
                System.out.print(a[i] + " ");
        }
    }

    public static void maxValueInBitonicArray(int[] arr, int l, int h){
        // if l == h, return l
        // if middle element is > middle + 1, search from l to m
        // else search from m+1 to h

        while(l<h) {
            int m = (l+h)/2;
            if(arr[m] > arr[m+1]) h = m;
            else l = m+1;
        }

        System.out.println(arr[l]);
    }
    
    public static void minProductSubset(int[] arr){
        // keep count of -ve and +ve elements
        // if -veCount is even, select the max -ve and multiply with +ve product
        // else if -veCount is odd, product of all elements
        // if all elements are +ve, min +ve
        // if all elements are -ve, then depending on count

        int n = arr.length;

        int product = 1, maxNegative = Integer.MAX_VALUE;
        int minNegative = Integer.MAX_VALUE, countP = 0, countN =0;
        int minPositive = Integer.MAX_VALUE, ans = 0;

        boolean isZero = false;

        for (int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                countN++;
                minNegative = Math.min(minNegative, arr[i]);
                maxNegative = Math.max(maxNegative, arr[i]);
            }

            else {
                if(arr[i] == 0)
                {
                    isZero = true;
                    countP++;
                    minPositive = Math.min(minPositive, arr[i]);
                }
            }

            if(arr[i] !=0) product *= arr[i];
        }


        if(countN % 2 !=0) ans = product;

        else if(countN == 0) ans = minPositive;

        else if(countN %2 ==0){
            if(!isZero) ans = product/minNegative;
            else ans = maxNegative;
        }

        System.out.println("ans = " + ans);
    }

    public static void xorQuery(int l, int r){
        // create the xor arr according to the formula
        // find the sum between the ranges

        int[] arr = new int[(int)Math.pow(10, 8)];
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
        for (int i = l; i <= r ; i++) {
            ans ^= i;
            sum += ans;
        }

        System.out.println("sum = " + sum);
    }

    public static void isFibonacci(int n){
    // if a number follows 5n2 +_ 4 should be a perfect sq law
        // then yes,else no

        int x = 5*n*n + 4;
        int y = 5*n*n - 4;

        int s = (int) Math.sqrt(x);
        boolean isX = (s*s) == x;

        s = (int) Math.sqrt(y);
        boolean isY = (s*s) == y;

        System.out.println((isX || isY) ? "Yes": "No");
    }

    public static void countSetBits(int n){
        // on subtracting 1 from n, all the bits from rightmost flip
        // if we do n & n-1 a times, then a is the answer
        int count = 0;
        while(n!=0) {
            n &= (n-1);
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

    public static void candies(int n, int k){
        // create an empty result arr
        // for every index till k distribute

        int[] arr = new int[k];

        int remaining = n , j =0 ,i =1;

        while(remaining > 0) {
            System.out.println("remaining = " + remaining);
            System.out.println("i = " + i);
            if(j == arr.length) j = 0;

            arr[j] += ((remaining - i) > 0 ? i : remaining);
            remaining -= i;
            j++;
            i++;
        }

        Utils.printIntArray(arr);
    }
    
    public static void pairsWithASum(int[] arr, int k){
        // create a map of ele vs freq
        // if k- arr[i] exists update count
        // if k-arr[i] = arr[i] count--
        // lastly, count/2

        HashMap<Integer, Integer> elementFreqMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i],0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(k - arr[i] == arr[i]) count--;
            if(elementFreqMap.containsKey(k-arr[i])) count += elementFreqMap.get(k-arr[i]);
            else elementFreqMap.put(k-arr[i], elementFreqMap.getOrDefault(k-arr[i],0) + 1);
        }
        System.out.println("count = " + (count/2));
    }
    
    public static void caseSort(String str){
        // store all lower case chars into one string
        // store all upper ones into another
        // sort both
        // while traversing the string,
        // if char's case is upper, take from one
        // else take from other

        StringBuilder upper = new StringBuilder(), lower = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) upper.append(str.charAt(i));
            else lower.append(str.charAt(i));
        }

        char[] upperC = upper.toString().toCharArray();
        Arrays.sort(upperC);


        char[] lowerC = lower.toString().toCharArray();
        Arrays.sort(lowerC);

        StringBuilder ans = new StringBuilder();

        int j = 0,k =0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) ans.append(upperC[j++]);
            else ans.append(lowerC[k++]);
        }

        System.out.println("ans = " + ans);
    }
    
    public static void minChangesToMakeSubstringsDistinct(String str){
        // remove all dupes
        // create a map of char vs freq
        // while at the time of adding, if freq is not null
        // count++

        int n = str.length();
        int count = 0;
        HashMap<Character, Integer> map =new HashMap<>();
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
    
    public static void karatsuba(String a, String b){
        Integer n1 = Integer.parseInt(a, 2);
        Integer n2 = Integer.parseInt(b,2);

        System.out.println(n1 * n2);
    }

    public static void pangramChecking(String str){
        // check str length, if>=26,
        // create a string containing all chars from a to z
        // if given str's every char's index is > -1, then 1 else 0

        int n = str.length();

        str = str.replaceAll(", ", "").toLowerCase();
        System.out.println("str = " + str);


        if(n < 26) {
            System.out.println(0);
            return;
        }

        else {
            String aToZ = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < aToZ.length(); i++) {
                if(str.indexOf(aToZ.charAt(i)) == -1) {
                    System.out.println("char not present: " + aToZ.charAt(i));
                    System.out.println(0);
                    return;
                }
            }

            System.out.println(1);
        }
    }
    
    public static void orderingOfStrings(String str){
        // two-pointer algo
        // keep i at 0 & j at n-1
        // whoever's value is less,inc/dec accordingly

        int n = str.length();
        str = str.toLowerCase();

        String[] strArr = str.split(" ");

        Arrays.sort(strArr);

        System.out.println("start = " + strArr[0]);
        System.out.println("end = " + strArr[strArr.length-1]);
    }

    public static void minIndexedString(String str, String pat){
        // traverse through the pat to find index in str
        // update the min
        
        int n = pat.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int b = str.indexOf(pat.charAt(i));
            if(b != -1) min = Math.min(min, b);
        }

        System.out.println((min==Integer.MAX_VALUE) ? "no character present" : min);
    }

    public static void maximumDifference(int[] arr){
        // keep track of max diff and the min ele so far
        // init max diff as a[1]-a[0]
        // and min ele as a[0]

        int n = arr.length;
        int minEle = arr[0];
        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i] - minEle > maxDiff) maxDiff = arr[i] - minEle;
            if(arr[i] < minEle) minEle = arr[i];
        }

        System.out.println("maxDiff = " + maxDiff);
    }

    public static void firstNonRepeatingCharacter(String str){
        // if a char's first and last index is same, return that

        int n = str.length();

        for (int i = 0; i < n; i++) {
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                System.out.println(str.charAt(i));
                return;
            }
        }

        System.out.println(-1);
    }
    

    public static void leftView(RightNode root){
        // print only the first element of a level
        // create a q of pair of node & level
        // maintain a var for level
        // if q's ele's level equals level then print


        int level = 0;
        Queue<Pair<RightNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while(!q.isEmpty()) {
           Pair<RightNode, Integer> ele = q.poll();
           if(ele.getValue() == level) {
               System.out.print(ele.getKey() + " ");
               level++;
           }

           if(ele.getKey().left != null) {
               q.add(new Pair<>(ele.getKey().left, level+1));
           }

           if(ele.getKey().right != null) {
               q.add(new Pair<>(ele.getKey().right,level+1));
           }
        }
    }
    
    public static void reverseWordsInAString(String str){
        // split on basis of dot
        // store the ele in stack
        // print the stack

        int n = str.length();
        String regex = "[.]";

        String[] arr = str.split(regex);

        StringBuilder res = new StringBuilder();

        for (int i = arr.length-1; i > 0 ; i--) {
            res.append(arr[i]).append(".");
        }

        res.append(arr[0]);

        System.out.println("res = " + res);
    }

    public static void countAllWaysFromTopLeftToBottomRight(int n, int m){
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
                numberOfWays[i][j] = numberOfWays[i-1][j] + numberOfWays[i][j-1];
            }
        }

        System.out.println(numberOfWays[n-1][m-1]);
    }

    public static void searchInAMatrix(int[][] arr, int k){
        // all the rows and cols are sorted
        // binary search row times


        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int[] s = arr[i];

            List<Integer> list = Utils.getListFromIntArray(s);
            int res = Collections.binarySearch(list, k);
            if(res >= 0) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static void closestToK(int[] arr, int k){
        // init diff as max value
        // if n > 2, as arr is sorted, apply 2-pointer algo
        // if k-arr[i]-arr[j] < diff, update diff
        // if arr[i] + arr[j] < k, i++
        // else j--

        int n = arr.length;

        int diff = Integer.MAX_VALUE;

        int resI = arr[0], resJ = arr[n-1];

        if(n > 2) {
            int i = 0 , j = n-1;
            while(i<j) {
                if(Math.abs(k - (arr[i] + arr[j])) < diff) {
                        diff = Math.abs(k - (arr[i] + arr[j]));
                        resI = arr[i];
                        resJ = arr[j];
                }

                if(arr[i] + arr[j] < k) i++;
                else j--;
            }
        }

        System.out.println("diff = " + diff);
        System.out.println("resI = " + resI);
        System.out.println("resJ = " + resJ);
    }

    public static boolean isIsogram(String str){
        // done
        // if any char's last index & first index is not same, return false
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if(str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) return false;
        }

        return true;
    }

    public static void largeNumberDivision(String a, String b){
        // divide a by b, convert a to bigint
        // done
        BigInteger  bigInteger = new BigInteger(a);
        BigInteger bigInteger1 = new BigInteger(b);
        System.out.print(bigInteger.divide(bigInteger1));
    }

    public static void theCountingGame(String str){
        // Done
        // if a char is uppercase, count++
        int count = 1;

        int n = str.length();
        for (int i = 0; i < n; i++) {
            if(Character.isUpperCase(str.charAt(i))) count++;
        }

        System.out.println("count = " + count);
    }
    
    public static void closingBracketIndex(String str, int opening){
        // start from opening index, the first closing brace's index is the answer
        int n = str.length();
        Stack<Character> stack = new Stack<>();

        int res = -1;

        for (int i = opening; i < n; i++) {


            if(str.charAt(i) == '[') stack.push(str.charAt(i));

            if(str.charAt(i) == ']') {
                    if(!stack.isEmpty()) {
                        res = i;
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                    else {
                        res = i;
                        break;
                    }
            }

        }

        System.out.println("res = " + res);
    }

    static class Height {
        int feet;
        int inches;
        public Height(int ft, int inc)
        {
            feet = ft;
            inches = inc;
        }
    }

    static class MyPair{
        RightNode rightNode;
        Integer level;

        public MyPair(RightNode rightNode, Integer level) {
            this.rightNode = rightNode;
            this.level = level;
        }
    }

    class RightNode {
        int data;
        RightNode left;
        RightNode right;
        RightNode nextRight;
        RightNode(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
}



