    //import javafx.util.Pair;

    import java.io.*;
    import java.math.BigInteger;
    import java.util.*;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;


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

        public static void mergeKArrays(int[][] arr, int k) {
            // take every 2 arrays
            // do merge procedure of merge sort on those 2 arrays

            ArrayList<Integer> res = new ArrayList<>();

            int n = k * k;

            for (int i = 0; i < k-1; i+=2) {
                int[] a1 = arr[i];
                int[] a2 = arr[i+1];

                int j = 0, l = 0;

                while(j < k && l < k) {
                    if(a1[j] < a2[l]) res.add(a1[j++]);
                    else res.add((a2[l++]));
                }

                // copy remaining elements

                while(j < k) {
                    res.add(a1[j++]);
                }

                while(l < k) {
                    res.add(a2[l++]);
                }
            }

            res.sort(Comparator.naturalOrder());

            // in case of odd k, just add the last subarray to res
            if(k % 2 != 0) {
                int[] lastArr = arr[k-1];
                int l = 0, m = 0;

                while(l < lastArr.length && m < res.size()) {
                    if(res.get(m) > lastArr[l]) {
                        res.add(m, lastArr[l]);
                        l++;
                    }
                    else m++;
                }

                // copy back the remaining elements from lastArr
                while (l < lastArr.length) {
                    res.add(lastArr[l++]);
                }
            }

            System.out.println("res = " + res);
        }


        public static void reArrangeArrayAlternatively(int[] arr) {
            // given arr is sorted
            // keep an index at the end, r,
            // create a res array to store the result
            // for every even index, res[i] = arr[r]
            // keep an index at the start l
            // for every odd index, res[i] = arr[l]
            // do this while l < r

            int n = arr.length;
            int[] res = new int[n];

            int i = 0, l = 0, r = n - 1;

            while (l < r) {
                res[i++] = arr[r--];
                res[i++] = arr[l++];
            }

            if(n % 2 != 0) res[i] = arr[l];

            System.arraycopy(res,0,arr,0,n);

            Utils.printIntArray(arr);
        }

        public static void nearestGreaterElementToRight(int[] arr) {
            // question is to find the nearest greater element for each element on it's right
            // e.g arr[i] = 1 3 2 4, ans = 3 4 4 -1
            // Brute force solution is to use 2 loops i = 0 to n - 1 and j = i + 1 to n
            // compare a[i] and a[j]
            // But, as the brute force solution has dependent second loop,
            // we can use stack for a better solution
            // start from i = n - 1 to 0,
            // we have to check for the greater element on right part of the array
            // that right part will be stored in stack
            // if stack is empty, push -1
            // else while stack is not empty, check if top of stack > arr[i]
            // if yes, push top of stack and break
            // if no, pop it off
            // push arr[i] on stack

            int n = arr.length;
            Stack<Integer> stack = new Stack<>();

            List<Integer> res = new ArrayList<>();

            for (int i = n-1; i >= 0; i--) {
                if(stack.isEmpty()) res.add(-1);
                else if(stack.peek() > arr[i]) res.add(stack.peek());
                else {
                    while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                        stack.pop();
                    }

                    if(stack.isEmpty()) res.add(-1);
                    else res.add(stack.peek());
                }

                stack.push(arr[i]);
            }

            Collections.reverse(res);
            System.out.println("res = " + res);
        }

        public static void nearestGreaterElementToLeft(int[] arr) {
            // for every element, find the nearest greater element to the left
            // we can use stack
            // traverse the array from left to right
            // for any element, stack contains the left part of the array
            // if stack is empty, add -1
            // else if top of stack > arr[i], add top of stacl
            // else while stack is not empty and top of stack < arr[i], pop off stack
            // out of while loop, check if stack is empty, if yes add -1 , else add top of stack
            // push arr[i] to stack

            int n = arr.length;

            Stack<Integer> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if(stack.isEmpty()) res.add(-1);
                else if(stack.peek() > arr[i]) res.add(stack.peek());
                else {
                    while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                    if(stack.isEmpty()) res.add(-1);
                    else res.add(stack.peek());
                }
                stack.push(arr[i]);
            }

            System.out.println("res = " + res);
        }

        public static void nearestSmallerElementToRight(int[] arr) {
            // given an array, for each element find the nearest smaller to the right
            // e.g 1 3 2 4 -> -1 2 -1 -1
            // use stack for this
            // stack will store the right side of array for any element
            // there are 3 conditions:
            // if stack is empty, add -1
            // else if top of stack < arr[i], add top of stack
            // else, while stack is not empty and top of stack > arr[i], pop off stack
            // on coming out of loop, check if stack is empty, if yes add -1, else add top of stack
            // push arr[i] onto stack
            // reverse the list


            int n = arr.length;
            Stack<Integer> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();

            for (int i = n-1; i >= 0; i--) {
                if(stack.isEmpty()) res.add(-1);
                else if(stack.peek() < arr[i]) res.add(stack.peek());
                else {
                    while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                        stack.pop();
                    }

                    if(stack.isEmpty()) res.add(-1);
                    else res.add(stack.peek());
                }

                stack.push(arr[i]);
            }

            Collections.reverse(res);

            System.out.println("res = " + res);
        }

        public static void nearestSmallerElementToLeft(int[] arr) {
            // for every element, find the nearest smaller element on left
            // create a stack
            // for every element, the left side of array will be in stack
            // there are 3 conditions:
            // if stack is empty, add -1 to the res
            // else if top of stack < arr[i], add top of stack to res
            // else, while stack is not empty and top of stack > arr[i], pop off stack
            // out of loop, check if stack is empty, if yes, add -1 else add top of stack
            // push arr[i] onto stack

            int n = arr.length;
            Stack<Integer> stack = new Stack<>();

            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if(stack.isEmpty()) res.add(-1);
                else if(stack.peek() < arr[i]) res.add(stack.peek());
                else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();

                    if(stack.isEmpty()) res.add(-1);
                    else res.add(stack.peek());
                }

                stack.push(arr[i]);
            }

            System.out.println("res = " + res);

        }

        public static void stockSpan(int[] arr) {
            // given an array of elements, find the number of consecutive elements smaller than or equal
            // to the element before it
            // brute force, i = 0 to n
            // j = i - 1 to 0
            // there is dependency on i, so we can use stack over here
            // use stack to store the index of the nearest greater element on the left for any element
            // store the indexes of the NGL in a list
            // create another list to store the ans, this will be simply, i - index

            int n = arr.length;
            Stack<Integer> stack = new Stack<>();
            List<Integer> indexList = new ArrayList<>();
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                if(stack.isEmpty()) indexList.add(-1);
                else if(arr[stack.peek()] > arr[i]) indexList.add(stack.peek());
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
                    if(stack.isEmpty()) indexList.add(-1);
                    else indexList.add(stack.peek());
                }
                stack.push(i);
            }

            System.out.println("indexList = " + indexList);

            for (int i = 0; i < n; i++) {
                res[i] = (i - indexList.get(i));
            }

            Utils.printIntArray(res);

        }

        public static int findPeakElement(List<Integer> arr) {
            // given a list which is sorted in increasing order till it reaches a number and after
            // that it is sorted in decreasing order, find that number
            // brute force: linear search
            // use binary search as array is sorted
            // if arr[m] > arr[m-1] && arr[m] > arr[m+1], return arr[m]
            // else if arr[m] < arr[m+1], l = m + 1
            // else h = m - 1
            // do this while l < h

            int n = arr.size();
            int l = 0, h = n - 1;

            while(l < h) {
                int m = (l + h)/2;
                if(arr.get(m) > arr.get(m-1) && arr.get(m) > arr.get(m+1)) {
                    return arr.get(m);
                }
                else if(arr.get(m) < arr.get(m+1)) l = m + 1;
                else h = m - 1;

                System.out.println("l = " + l);
                System.out.println("m = " + m);
                System.out.println("h = " + h);
            }

            return arr.get(l);
        }

        public static int findPairGivenDifference(int[] arr, int k) {
            // create a set to store all arr elements
            // traverse through the arr
            // if set contains abs(k-arr[i]), return 1, else -1

            int n = arr.length;
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                set.add(arr[i]);
            }

            System.out.println("set = " + set);

            for (int i = 0; i < n; i++) {
                if(set.contains(Math.abs(k-arr[i]))) return 1;
            }

            return -1;
        }

        public static long minNumberInSortedRotatedArray(int[] arr, long l, long h) {
            // given a sorted and rotated array, find the min number
            // brute force: Linear search
            // simply check every element and update min if it's less than min
            // But as array is sorted, we can use binary search
            // as array is also rotated, at some point arr[m] will be < arr[l] or arr[m] will be > arr[h]
            // while l < h
            // if arr[m] is between arr[l] and arr[h], return arr[l], as this is the min number
            // else if arr[m] > arr[h], l = m + 1, min number is in right subarray
            // else h = m - 1, min number is in left subarray
            // return arr[l]

            // another case, if arr[m] itself is the min, so to accommodate that,
            // make h = m,

            int n = arr.length;

            while (l < h) {
                long m = (l + h)/2;
                if(arr[(int) m] > arr[(int) l] && arr[(int) m] < arr[(int) h]) return arr[(int) l];
                else if(arr[(int)m] > arr[(int) h]) l = m + 1;
                else h = m;
            }

            return arr[(int) l];
        }

        public static String arraySubsetOfAnotherArray(int[] arr1, int[] arr2) {
            // given 2 arrays, check if arr2 is a subset of arr1 or not
            // sort arr1
            // for each element of arr2, do binarysearch on arr1
            // if result is -1, return no
            // outside of loop, return yes

            int m = arr1.length, n = arr2.length;

            Arrays.sort(arr1);

            if(m < n) return "No";

            for (int i = 0; i < n; i++) {
                int index = Utils.binarySearch(arr1, arr2[i]);
                if(index == -1) return "No";
            }

            return "Yes";
        }

        public static int ternarySearch(int[] arr, int k) {
            // given a sorted array and an element, return 1 if element is present else -1
            // we've to use ternary search to find this element
            // in ternary search, there are 2 mids, m1 = l + (r-l)/3, m2 = r - (r-l)/3
            // if k > arr[m2], l = m2 + 1
            // if k < arr[m1], r = m1 - 1
            // else l = m1 + 1, r = m2 - 1
            // do this while l <= r

            int n = arr.length;

            int l = 0, h = n - 1;

            while(l <= h) {
                int m1 = l + (h-l)/3;
                int m2 = h - (h-l)/3;

                if(arr[m1] == k) return 1;

                if(arr[m2] == k) return 1;

                if(k > arr[m2]) l = m2 + 1;

                else if(k < arr[m1]) h = m1 - 1;

                else {
                    l = m1 + 1;
                    h = m2 - 1;
                }
            }

            return -1;
        }

        public static void killingSpree(long n) {
            // given an infinite pool of people, starting from i = 1
            // whose power is i * i, and given a power n
            // we can kill an opponent if n >= i * i
            // also n decreases by i2 everytime it kills an opponent
            // determine how many people can be killed

            long count = 0L;

            for (int i = 1; true; i++) {
                int opponentPower = i * i;
                n -= opponentPower;
                if(n < 0) break;
                count++;
            }

            System.out.println("count = " + count);
        }

        public static void nineDivisors(long n) {
            // given a number n, starting from 1 to n, find how many numbers have exactly 9 divisors
            // create a loop for i = 2 to sqrt(n)
            // for each i, store it's square in sq
            // init count as 2 as 1 and the number itself are the 2 divisors
            // for j = 2 to sq/2, check if sq % j == 0, count++
            // outside of this inner loop, if count == 9, ans'++

            long ans = 0L;
            long[] arr = new long[(int)Math.sqrt(n)];

    //        for (int i = 2; i <= Math.sqrt(n); i++) {
    //            int sq = i * i;
    //            int count = 2;
    //            for (int j = 2; j <= sq/2; j++) {
    //                if(sq % j == 0) count++;
    //            }
    //
    //            if(count == 9) ans++;
    //        }

            int idx = 0;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                arr[idx++] = i * i;
            }

            idx = 0;

            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();

            while (idx < arr.length) {
                int count = 2;
                for (int i = 2; i <= arr[idx]/2; i++) {
                    if(arr[idx] % i == 0) count++;
                }
                idx++;
                if(count == 9) ans++;
            }

            System.out.println("ans = " + ans);
        }

        public static void firstIndexAndLastIndexOfElement(int[] arr, int k) {
            // given a sorted array and k, determine the first index of the element
            // do binary search
            // if arr[m] == k, do not return as there's a possibility of k being on the left side
            // so store m in res, and update h = m -1
            // else if arr[m] < k, l= m + 1
            // else h = m -1

            int n = arr.length;
            int l = 0, h = n - 1, res = -1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    res = m;
                    h = m - 1;
                }

                else if(arr[m] < k) l = m + 1;
                else h = m - 1;
            }

            System.out.println("first index = " + res);

            res = -1;
            l = 0;
            h = n-1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    res = m;
                    l = m + 1;
                }

                else if(arr[m] < k) {
                    l = m + 1;
                }

                else h = m - 1;
            }

            System.out.println("last index = " + res);
        }

        public static void countOfAnElementInASortedArray(int[] arr, int k) {
            // given a sorted arr and an element k, determine the count of k in arr
            // as array is sorted, we can use binary search to get first index and last index
            // return count as last - first + 1

            int lastIndex = -1, firstIndex = -1;

            int n = arr.length;

            int l =0 , h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    firstIndex = m;
                    h = m - 1;
                }

                else if(arr[m] < k) l = m + 1;
                else h = m - 1;
            }

            l = 0;
            h  = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    lastIndex = m;
                    l = m + 1;
                }

                else if(arr[m] < k) l = m + 1;

                else h = m - 1;
            }

            System.out.println((lastIndex == -1) ? -1 : (lastIndex - firstIndex + 1));
        }

        public static int countNumberOfTimesSortedArrayIsRotated(int[] arr) {
            // given a sorted & rotated array, count number of times it is rotated
            // we can use binary search
            // generally in binary search we directly compare mid with k, if its equal we return it
            // else we check if k > mid, we move to left or right
            // number of rotations is index of min element -> observation
            // min element has a property - it will be always smaller than it's left and right neighbours
            // first check if m+1 is the min element
            // to do so, if m < l and arr[m+1] < arr[m], return m+1
            // then check if m is the min element
            // to do so, if m > h and arr[m-1] > arr[m], return m
            // check which subarray is sorted by arr[l] < arr[m],
            // if so check in right subarray, l = m + 1
            // else check in left subarray, h = m - 1

            int n = arr.length;
            int l = 0, h = n - 1, count = 0;

            while (l <= h) {
                int m = l + (h-l)/2;

                // for cases 3 4 5 1 2
                if(m < h && arr[m+1] < arr[m]){
                    count = m + 1;
                    break;
                }

                // check if mid is the min element, compare it with mid-1
                if(m > l && arr[m-1] > arr[m]) {
                    count = m;
                    break;
                }

                // check for right subarray
                if(arr[l] < arr[m]) l = m + 1;
                // check for left subarray
                else h = m - 1;
            }

            System.out.println("count = " + count);

            return (count == 0 ? 0 : n - count);
        }

        public static int findElementInSortedRotatedArray(int[] arr, int k) {
            // given a sorted rotated array and k, find it's index in arr
            // find m = l + h-l/2
            // if arr[m] == k, return m
            // else we have to check either in left or right sub array
            // check whether left or right subarray is sorted
            // to check if left is sorted, arr[l] <= arr[m]
            // to check if right is sorted, arr[m] <= arr[h]
            // if left is sorted, check if k >= arr[l] && k <= arr[m], if yes, h = m - 1 else l = m + 1
            // if right is sorted, check if k >= arr[m] && k <= arr[h], if yes, l = m + 1 else h = m - 1

            int n = arr.length;

            int l = 0, h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;
                if(arr[m] == k) return m;

                if(arr[l] <= arr[m]) {
                    if(k >= arr[l] && k <= arr[m]) h = m - 1;
                    else l = m + 1;
                }

                else if(arr[m] <= arr[h]) {
                    if(k >= arr[m] && k <= arr[h]) l = m + 1;
                    else h = m - 1;
                }
            }

            return -1;
        }

        public static int findElementInANearlySortedArray(int[] arr, int k) {
            // given a nearly sorted array and an element k, find it's index
            // a nearly sorted array is defined as an element at index i in sorted array
            // could be at i - 1th, ith or i + 1th index in a nearly sorted array
            // compare k with arr[m-1],arr[m], arr[m+1], if equal, return the indices
            // else if k > arr[m], l = m + 2
            // else h = m - 2
            // first check if m-1 >= l and m+1 <= h
            // similary check for m-2 >= l and m+2 <= h

            int n = arr.length;

            int l = 0, h = n - 1;

            while (l < h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) return m;
                if(m-1 >= l && arr[m-1] == k) return m-1;
                if(m+1 <= h && arr[m+1] == k) return m+1;

                if(k > arr[m]) {
                    if(m + 2 <= h) l = m + 2;
                }

                else {
                    if(m - 2 >= l) h = m -2;
                }
            }

            return -1;
        }

        public static int floorOfAnElement(int[] arr, int k) {
            // given a sorted array and an element k, find it's floor
            // floor of k is defined as greatest element smaller than k
            // as array is sorted, we can use binary search
            // if arr[m] == k, return arr[m] as k can be it's own floor
            // else if k > arr[m], l = m + 1
            // else h = m - 1
            // return l if element not found
            // check if l == 0, if yes return -1 else arr[l-1]

            int n = arr.length;
            int l = 0, h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) return k;

                if(k > arr[m]) l = m + 1;
                else h = m - 1;
            }

            return l;

        }

        public static int ceilOfAnElement(int[] arr, int k) {
            // given a sorted array and an element k, find it's ceil
            // ceil is defined as smallest element greater than k
            // as array is sorted we can use binary search
            // if arr[m] == k, return k as k can be it's own ceil
            // if k > arr[m], l = m + 1
            // else h = m - 1
            // return l
            // check if l == n, if yes, return -1 else arr[l]

            int n = arr.length;

            int l = 0, h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                System.out.println("arr[m] = " + arr[m]);

                if(arr[m] == k) return m;

                if(k > arr[m]) l = m + 1;

                else h = m - 1;
            }

            return l;
        }

        public static char nextLetter(char[] arr, char k) {
            // given a sorted arr and an element k, find it's next letter
            // as array is sorted we can use binary search
            // if arr[m] == k check if m + 1 < n, if yes, return arr[m+1] else -1
            // if k > arr[m], l = m + 1
            // else h = m - 1
            // return arr[l]

            int n = arr.length;

            int l = 0, h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    if(m + 1 < n) return arr[m+1];
                    return '0';
                }

                if(k > arr[m]) l = m + 1;
                else h = m - 1;
            }

            return (l == n ? '0' : arr[l]);
        }

        public static void findAnElementInInfiniteSortedArray(int[] arr, int k) {
            // given an infinitely sorted array and an element k
            // find it's index
            // as array is sorted we can apply binary search
            // but for that we need high, as of now we don't have size so we don't have high
            // init l = 0, h = 1
            // while k > arr[h], l = h and h = h * 2
            // meaning until k > arr[h], we will double the index as k is not bound between arr[l] and arr[h]
            // once while loop is terminated, we have low and high and k which will probably be in between them
            // apply binary search with l and h


            int n = arr.length;

            int l = 0, h = 1;

            while (h < n && k > arr[h]) {
                l = h;
                h = h * 2;
            }

            if(h < n) {
                int res = Utils.binarySearch(arr, k, l, h);

                System.out.println("res = " + res);
            }

            else System.out.println(-1);
        }

        public static int indexOfFirst1InBinaryInfinitelySortedArray(int[] arr) {
            // given a binary infinitely sorted array, find index of first 1
            // as array is sorted we can apply binary search
            // but we need to first get the high index
            // we can init h = 1 and till arr[h] != 1 l = h and h = h * 2
            // after the loop, we now have both l and h
            // we can apply binary search, we could've simply returned h as loop terminates
            // but h doesn't guarantee it's the first index of 1 as we're doubling h not linearly increasing it


            int n = arr.length;
            int l = 0, h = 1;

            while (h < n && arr[h] != 1) {
                l = h;
                h = h * 2;
            }

            if(h < n) {
                return Utils.binarySearch(arr, 1, l, h);
            }

            return -1;
        }

        public static void minDiffElementInSortedArray(int[] arr, int k) {
            // given a sorted array and an element k, find the element which has min diff with k
            // as array is sorted we can use bs
            // init res = -1
            // if arr[m] == k, res = arr[m]
            // else before taking left or right subarray, we need to store it in res
            // check if res == -1, if yes res = arr[m]
            // else check if arr[m] - k < res - k, if yes, res = arr[m]

            int n = arr.length;

            int l = 0, h = n - 1, res = -1;


            while (l <= h) {
                int m = l + (h-l)/2;

                if(arr[m] == k) {
                    res = arr[m];
                    break;
                }
                else {
                    if(res == -1) res = arr[m];
                    else {
                        if(Math.abs(arr[m] - k) < Math.abs(res - k)) {
                            res = arr[m];
                        }
                        else if (Math.abs(arr[m] - k) == Math.abs(res - k)) {
                           boolean isResGreater = res > arr[m];
                           if(!isResGreater) res = arr[m];
                        }
                    }

                    if(k > arr[m]) l = m + 1;
                    else h = m - 1;
                }
            }

            System.out.println("res = " + res);
        }

        public static int peakElement(int[] arr) {
            // given an array, find peak element
            // peak element is defined as element greater than both of it's neighbours
            // here although array is unsorted, we will use binary search
            // for that we need to find criteria to decide if m is the peak
            // or if m is not peak how to take left or right
            // if arr[m] > arr[m+1] and arr[m] > arr[m-1], return m
            // else if arr[m+1] > arr[m], l = m + 1
            // else h = m - 1
            // in case of boundary conditions like m = 0 or n -1
            // just check m with m-1 or m+1
            // like if m==0, return arr[m] > arr[m+1] ? m : m + 1
            // if m=n-1, return arr[m] > arr[m-1] ? m : m -1

            int n = arr.length;

            int l = 0 , h = n - 1;


            while (l <= h) {
                int m = l + (h-l)/2;

                if(m > 0 && m < n-1) {
                    if(arr[m] > arr[m+1] && arr[m] > arr[m-1]) return m;
                    else if(arr[m+1] > arr[m]) l = m + 1;
                    else h = m - 1;
                }

                else if(m == 0 && m!= n-1) {
                    return (arr[m] > arr[m+1] ? m : m + 1);
                }

                else if(m == n-1 && m!= 0) return (arr[m] > arr[m-1] ? m : m - 1);

                else if(m == 0 && m == n-1) return m;
            }

            return -1;
        }

        public static int maxElementInBitonicArray(int[] arr) {
            // given a bitonic array find the max value in it
            // a bitonic array is defined as array with monotonically increasing and then decreasing
            // this problem is same as finding peak element but here we will have only one peak
            // we're using bs on ans concept
            // if arr[m] > arr[m-1] && arr[m+1], return arr[m]
            // else if arr[m+1] > arr[m] l = m + 1
            // else h = m - 1
            // if m == 0, return arr[m] > arr[m+1]
            // else if m == n-1, return arr[m] > arr[m-1]

            int n = arr.length;

            int l = 0, h = n - 1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(m > 0 && m < n-1) {
                    if(arr[m] > arr[m-1] && arr[m] > arr[m+1]) return arr[m];
                    else if(arr[m+1] > arr[m]) l = m + 1;
                    else h = m - 1;
                }

                else if(m == 0) return Math.max(arr[m], arr[m + 1]);

                else return Math.max(arr[m], arr[m - 1]);
            }

            return -1;
        }

        public static int searchAnElementInBitonicArray(int[] arr, int k) {
            // given a bitonic array and an element k, return it's index in the arr
            // as it's a bitonic array, we will have a peak element
            // elements from 0 to peak element are sorted, also are the elements from peak to n-1 are sorted
            // so we can do binary search on each of these subarrays
            // if left subarray returns -1, do bs on right subarray

            int n = arr.length;

            int l = 0, h = n - 1;

            int peakIndex = peakElement(arr);

            int ans = Utils.binarySearch(arr, k, 0, peakIndex);

            if(ans == -1) {
                l = peakIndex + 1;
                h = n -1;

    //            System.out.println("l = " + l);
    //            System.out.println("h = " + h);

                while (l <= h) {
                    int m = l + (h-l)/2;

                    if(arr[m] == k) return m;

                    if(arr[m] > k) l = m + 1;
                    else h = m - 1;
                }
            }

            return ans;
        }

        public static List<Integer> searchInRowWiseColumnWiseSortedMatrix(int[][] arr, int k) {
            // given a row wise and column wise sorted matrix and an element k, find it's index
            // as matrix is sorted, we can use binary searh on ans
            // we will start with top right hand side corner
            // check if k == arr[i][j], if yes, return i, j
            // else if k > arr[i][j], i++
            // else j--
            // do this while i & j are in bounds
            // if while loop teeminates, return -1

            int n = arr.length, m = arr[0].length;
            int i = 0, j = m - 1;

            List<Integer> res = new ArrayList<>();

            while (i >= 0 && i < n && j>= 0 && j < m) {
                if(arr[i][j] == k) {
                    res.add(i);
                    res.add(j);
                    return res;
                }

                else if(k > arr[i][j]) i++;

                else j--;
            }

            res.add(-1);
            return res;
        }

        public static void allocateMinPagesOfBook(int[] arr, int n, int k) {
            // given an array which denotes number of pages in n books
            // and number of students which can read this book
            // assign books in such a way that max number of pages assigned to a student is min
            // constraints:
            // 1. a book cannot be divided among students, only one student can read one book
            // 2. No student can be idle, one student has to read atleast one book
            // 3. A student can only read continous books

            // we have to apply binary search on ans
            // the max number of pages a student can read is bound by max in array and sum of all array elements
            // l = max(arr)
            // h = sum(arr)
            // m = l + h-l/2;
            // now, taking m as ans, find out how many students are required to satisfy with m as the max number of pages each can read
            // if no. of students > k, meaning m cannot be ans, we've to increase the max number of pages assigned to student, l = m + 1
            // else, meaning m can be ans, we will check if we can decrease the max no. of pages, so h = m - 1

            int l = Utils.max(arr), h = Utils.sum(arr), res = -1;

            while (l <= h) {
                int m = l + (h-l)/2;

                if(isValid(arr, n, k, m)) {
                    res = m;
                    h = m - 1;
                }

                else l = m + 1;
            }

            System.out.println("res = " + res);
        }

        public static boolean isValid (int[] arr, int n, int k, int m){
          int students = 1, sum = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];

                if(sum > m) {
                    students++;
                    sum = arr[i];
                }

                if(students > k) return false;
            }

            return true;
        }

        public static int kthSmallest(int[] arr, int k) {
        // given an array and a value k, find kth smallest element
        // as it has keywords like kth and smallest, we can use heap
        // as it is smallest, we will create max heap
        // traverse the array, add arr[i] to heap
        // after adding, check the size, if size > k, remove the top of heap
        // at the end, all the elements > kth smallest will be removed and it will be at the top of heap

            int n = arr.length;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
            if(k > n) return -1;

            for (int i = 0; i < n; i++) {
                maxHeap.add(arr[i]);

                if(maxHeap.size() > k) maxHeap.poll();
            }

            return maxHeap.peek();
        }

        public static void kLargestElement(int[] arr, int k) {
            // given an array and a value k, print the k largest elements in the array
            // we can use sorting in this problem
            // sort the array and return the last k elements from sorted array
            // but here there is no use of sorting the remaining n-k elements as we didn't use them
            // in order to optimize, we can use heap
            // as we've to get largest, we will use min heap of size k
            // add the elements onto heap
            // if heap size > k, poll the elements
            // after completion of loop, whatever remains in the heap is the answer

            int n = arr.length;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int i = 0; i < n; i++) {
                minHeap.add(arr[i]);

                if(minHeap.size() > k) minHeap.poll();
            }

            while (k-- > 0) {
                System.out.print(minHeap.poll() + " ");
            }
        }

        public static void sortAKSortedArray(int[] arr, int k) {
            // given a k-sorted array, sort it
            // a k-sorted array is defined as the element in the given arr will be at most
            // k indices away on left or right in the sorted arr
            // one way is simply sort it
            // but by that we're not using the k-sorted property
            // so will we create a min heap of size k
            // add an element
            // if size > k, poll the heap
            // after completion of loop, again poll the heap

            int n = arr.length;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int i = 0; i < n; i++) {
                minHeap.add(arr[i]);

                if(minHeap.size() > k) System.out.print(minHeap.poll() + " ");
            }

            while (minHeap.size() > 0) System.out.print(minHeap.poll() + " ");

        }

        public static void kClosestNumber(int[] arr, int k, int x) {
            // given an array and a value x, find k closest numbers to x
            // we can use treemap of int vs int
            // key will be diff of arr[i] and k
            // value will be arr[i]
            // treemap will sort on basis of key
            // so least diff entries will be on top
            // now just pop top k entries

            // we can use heap
            // as we require values with max diff to be removed, we should keep them on top
            // so we need max heap
            // it will be sorted on basis of diff of arr[i] - k
            // as soon as size > k, pop
            // whatever remains in the heap is the answer
            // create priorityq on custom class pair that has key and value
            // as we need to sort on the basis of key, we need to create a custom comparator class

            int n = arr.length;
            // we need a custom comparator that compares and sorts on the basis of key
            PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(k, new DiffPairComparator());

            for (int i = 0; i < n; i++) {
                maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
                System.out.println("i = " + i);
                maxHeap.forEach(e -> System.out.println(" " + e.getKey() + " " + e.getValue()));

                if(maxHeap.size() > k) maxHeap.poll();
            }

            while (k-- > 0) {
                System.out.print(maxHeap.poll().getValue() + " ");
            }
        }

        public static void topKFrequentNumbers(int[] arr, int k) {
            // given an array and a value k, find top k frequent numbers
            // to find frequency, create a hashmap of arr[i] vs freq
            // now to find top k, create a heap
            // as we don't need min values, create min heap
            // create a priorityq with k and custom comparator in init
            // create custom comparator class which compares on the basis of freq

            int n = arr.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new FreqPairComparator());

            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }


            for (Map.Entry<Integer,Integer> e: map.entrySet()) {
                minHeap.add(new Pair(e.getValue(), e.getKey()));

                minHeap.forEach(e1 -> System.out.println(" " + e1.getKey() + " " + e1.getValue()));

                if(minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            while (minHeap.size() > 0) System.out.println(minHeap.poll().getValue());
        }

        public static void frequencySort(int[] arr) {
            // sort the array on basis of frequency of elements
            // create a hashmap of ele vs freq
            // create a max heap with custom comparator that will sort on frequency
            // in descending order
            // poll the heap and print value key times

            int n = arr.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new FreqPairDescendingComp());

            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            for(Map.Entry<Integer,Integer> e: map.entrySet()) {
                maxHeap.add(new Pair(e.getValue(), e.getKey()));
            }

            maxHeap.forEach(e -> System.out.print("key: " + e.getKey() + " value: " + e.getValue()));
            System.out.println();

            while (maxHeap.size() > 0) {
                Pair pair = maxHeap.poll();
                int key = pair.getKey();
                while(key-- > 0) {
                    System.out.print(pair.getValue() + " ");
                }
            }

        }

        public static void kClosestToOrigin(int[][] arr, int k) {
            // given an array of x-y coordinates, and a value k, find k closest points to origin
            // as we're given k, we will use heap
            // we need closest, so we need lesser distance and discard more distance, so max heap
            // calculate distance with distance formula
            // this distance will be the key to sort the heap
            // create a class which will have int distance and pair class as x-y coordinate
            // create a priorityq of type of above class, with k and inst. of a new comparator class
            // in comparator class return o2 - o1 as we need in desc. order
            // traverse the array and add in heap
            // if size > k, poll it
            // after loop completion, print xy coordinates

            int n = arr.length;
            PriorityQueue<DistancePair> maxHeap = new PriorityQueue<>(k, new DistanceComparator());

            for (int i = 0; i < n; i++) {
                int distance = (int) Math.sqrt(arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1]);
                System.out.println("arr[" + i + "]" + "[0]" + arr[i][0]);
                System.out.println("arr[" + i + "]" + "[1]" + arr[i][1]);

                Pair coordinates = new Pair(arr[i][0], arr[i][1]);

                DistancePair distancePair = new DistancePair(distance, coordinates);
                maxHeap.add(distancePair);

                if(maxHeap.size() > k) maxHeap.poll();

                maxHeap.forEach(e-> System.out.println("key = " + e.getCoordinates().getKey() + " value = " + e.getCoordinates().getValue() + " distance = " + e.getDistance()));
            }


            while (maxHeap.size() > 0) {
                DistancePair res = maxHeap.poll();
                System.out.println(res.getCoordinates().getKey() + " " + res.getCoordinates().getValue());
            }
        }

        public static void connectRopes(int[] arr) {
            // given an array of lengths of ropes, find min cost to connect them
            // cost of connecting any 2 ropes is determined as sum of their lengths
            // we will use heap
            // create min heap as we want min cost
            // traverse through the arr and populate the heap
            // init a var cost
            // run a loop till heap as atleast 2 elements
            // poll the q and store first element as f
            // poll the q and store seconcd element as s
            // update cost as sum of itself and f and s
            // again add f + s into heap

            int n = arr.length, cost = 0;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                minHeap.add(arr[i]);
            }

            while (minHeap.size() >= 2) {
                int f = minHeap.poll();
                int s = minHeap.poll();

                cost += f + s;

                minHeap.add(f + s);
            }

            System.out.println("cost = " + cost);
        }

        public static void sumOfElementsBetweenk1thSmallestAndk2thSmallest(int[] arr, int k1, int k2) {
            // given an array and 2 values, k1 and k2, find sum of all elements between them
            // find k1th smallest, k2th smallest
            // traverse the given array, check if arr[i] is in between k1 and k2, if yes, update sum with arr[i]

            int n = arr.length, sum = 0;

            int k1thSmallest = kthSmallest(arr, k1);
            int k2thSmallest = kthSmallest(arr, k2);

            for (int i = 0; i < n; i++) {
                if(arr[i] > k1thSmallest && arr[i] < k2thSmallest) sum += arr[i];
            }

            System.out.println("sum = " + sum);
        }

        public static int factorialByIBH(int n) {
            // given a number, find it's factorial
            // we will use IBH method here
            // first we will create hypothesis
            // 1. if factorial(n) works, then factorial(n-1) also works
            // next, we will create induction
            // this the main step as we will decide what to write in code
            // 2. if factorial(n) prints n!, then factorial(n-1) prints n-1!
            // only we need to multiply it with n, so it becomes factorial(n) = factorial(n-1) * n
            // next, we will create base case
            // in this step, we choose smallest valid integer
            // 1! is 1, so we will take 1 as base case

            if(n == 1) {
                //System.out.println(1);
                return 1;
            }

            return n * factorialByIBH(n-1);
        }

        public static Stack<Integer> sortAStack(Stack<Integer> stack) {
            // sort a stack using recursion
            // we will use IBH method here
            // Hypothesis: IP - Stack OP - sorted stack
            // recursive call: pop the element and store it in k, call the method with sortAStack
            // Induction: the above call with sort the stack for n-1 elements
            // now insert k in correct position in sorted stack
            // Base case: if stack.size ==1, return
            // Now inserting k in correct position can be done recursively as well as iteratively
            // we will do it iteratively
            // traverse the stack using iterator and check if itr's next > k
            // if yes, get itr's next's idx and add k at that index

            if(stack.size() == 1) return stack;

            int k = stack.pop();

            sortAStack(stack);

            return insertK(stack, k);

        }

        public static Stack<Integer> insertK(Stack<Integer> stack, int k) {
            // insert k at proper position in stack

            if(k >= stack.peek() || stack.size() == 0){
                stack.push(k);
                return stack;
            }

            int val = stack.pop();
            insertK(stack, k);
            stack.push(val);
            return stack;
        }

        public static Stack<Integer> deleteMiddleElementInStack(Stack<Integer> stack) {
            // given a stack, delete middle element of stack
            // middle element is defined as size/2 - index 0
            // we will use IBH method
            // Hypo: IP - deleteMiddle(Stack s), OP - stack with middle element deleted
            // recursive call: store the top element of stack in top and call with stack and k - 1
            // k - 1 as stack decreases in size by 1
            // Induction: push top onto stack
            // Base case: if k == 0, pop off stack and return stack

            int n = stack.size();
            if(stack.size() == 0) return stack;

            int k = n/2;

            return deleteMiddleElementInStack(stack, k);
        }

        public static Stack<Integer> deleteMiddleElementInStack(Stack<Integer> stack, int k) {
            if(k == 0) {
                stack.pop();
                return stack;
            }

            int top = stack.pop();
            deleteMiddleElementInStack(stack, k-1);
            stack.push(top);
            return stack;
        }

        public static Stack<Integer> reverseAStack(Stack<Integer> stack) {
            // given a stack, reverse it
            // we will use IBH method
            // Hypo: IP - reverseAStack OP - stack reversed
            // recursive call: pop the top of stack & store in top, recur for the stack
            // Base: if stack.size == 1, return
            // Induction: now we've stack reversed of size n - 1, now we've to push top at the bottom of stack
            // This is again another recursive problem as we've to pop all other elements and then push top

            // Hypo: IP - insert(Stack s, int top), OP - inserted top at the bottom of stack
            // recursive call: pop the top of stack & store in k, call insert of stack of size m-1
            // Base: if stack.size == 0, push top
            // Induction: push k onto stack, stack.push(k)

            if(stack.size() == 1) return stack;

            int top = stack.pop();
            reverseAStack(stack);

            return insert(stack, top);

        }

        public static Stack<Integer> insert(Stack<Integer> stack, int top) {
            if(stack.size() == 0) {
                stack.push(top);
                return stack;
            }

            int k = stack.pop();
            insert(stack, top);
            stack.push(k);
            return stack;
        }

        public static int kthSymbolInGrammar(int n , int k) {
            // given n and k, find kth symbol in grammar
            // base case is given as: n = 1, k = 1, return 0
            // for n = 2, grammar would be generated as 0 1
            // basically replace 0 with 01 and 1 with 10
            // we will use IBH method
            // Hypo: IP - kthSymbol(n, k) OP, kth symbol in grammar would be returned
            // recursive call: check on smaller input, depends on k,
            // if k <= mid, it is same as upper row in grammar, so recur for n-1, k
            // Induction: for that, find the length of grammar for given N
            // length can be found as pow(2, N-1)
            // mid would be length/2
            // now, if k <= mid, it is same as upper row in grammar, so recur for n-1, k
            // else it is ! of upper row, so recur for n-1, k-mid

            if(n==1 && k==1) return 0;
            int length = (int) Math.pow(2, n-1);
            int mid = length/2;

            if(k <= mid) return kthSymbolInGrammar(n-1,k);
            return 1 ^ kthSymbolInGrammar(n-1, k-mid);
        }

        public static void towerOfHanoi(int n, int s, int d, int h) {
            // tower of hanoi, given 3 rods, one source, 2nd helper, 3rd destination and n discs
            // print the steps it takes to move all discs from s to d
            // conditions: 1. pick only one disc at a time
            // 2. bigger disc cannot be on top of smaller disc
            // we can use IBH method
            // Hypo: IP -> towerOfHanoi(n,s,d,h), OP -> print the steps to move all disc from s to d
            // Recursive call: we will first put the top n-1 discs from s to h, so recur for n-1
            // Induction: Put the top n-1 discs from s to h
            // put the last biggest disc from s to d
            // now but the remaining n-1 discs from h to d
            // Base case: if n==1, print and return

            if(n == 1) {
                System.out.println("move disk " + n + " from rod " + s + " to " + d);
                return;
            }

            towerOfHanoi(n-1, s, h, d);
            System.out.println("move disk " + n + " from rod " + s + " to " + d);
            towerOfHanoi(n-1, h, d, s);
            return;
        }

        public static void printSubsets(String ip, String op) {
            // given a string, print it's all subsets
            // e.g "ab" -> "", "a", "b", "ab"
            // we will use recursive tree method here
            // when the ip becomes empty, we get an output
            // initially, when string is "", we've 2 choices, either we can include a or not include it
            // so we take a decision whether to take it or not
            // if we include it, op becomes a, ip becomes only b as a is removed
            // if we don't include it, op remains "", ip becomes only b as a is removed
            // similary we can recur for the remaining

            if(ip.length() == 0) {
                System.out.println("op = " + op);
                return;
            }

            String op1 = op, op2 = op;

            op2 = op2 + ip.charAt(0);

            StringBuilder sb = new StringBuilder(ip);

            ip = sb.deleteCharAt(0).toString();

            printSubsets(ip, op1);
            printSubsets(ip, op2);
        }

        public static void permutationWithSpace(String ip, String op) {
            // given a string ip, generate all permutations with spaces between the characters
            // e.g ABC -> ABC, A BC, A B C, AB C
            // 2nd param will hold the result
            // As we've to make choice to include with space or not, and as we choose one, we make a decision
            // so, we can use recursion here
            // we will create recursive tree
            // Base case: if ip is empty, print op and return
            // init op1 and op2 with op
            // now op1 will be having ip's charAt[0] with space, so add " " and ip's charAt[0]
            // op2 will be having ip's charAt[0] without so add ip's charAt[0]
            // now, make ip smaller, by deleting the first char
            // now recur for op1 and op2

            if(ip.length() == 0) {
                System.out.println("op = " + op);
                return;
            }

            String op1 = op, op2 = op;

            op1 += " " + ip.charAt(0);
            op2 += ip.charAt(0);

            StringBuilder sb = new StringBuilder(ip);


            ip = sb.deleteCharAt(0).toString();

            permutationWithSpace(ip, op1);
            permutationWithSpace(ip, op2);

        }

        public static Set<String> uniqueSubset(String ip, String op, Set<String> set) {
            // given a string ip, return all it's unique subsets
            // e.g aa -> "", a, aa

            // we can use recursive tree method
            // at each char, we've a choice whether to include the char or not
            // Base case: if ip is empty add op to set and return set
            // init op1 and op2 from op
            // add ip's first char to op1
            // delete first char from ip
            // recur for op1
            // recur for op2

            if(ip.length() == 0) {
                set.add(op);
                return set;
            }

            String op1 = op, op2 = op;
            op1 += ip.charAt(0);

            StringBuilder sb = new StringBuilder(ip);

            ip = sb.deleteCharAt(0).toString();

            uniqueSubset(ip,op1,set);
            uniqueSubset(ip,op2,set);
            return set;
        }

        public static void permutationWithCaseChange(String ip, String op) {
            // given a string ip, print all permutations with case changes
            // e.g ab -> ab, aB, Ab, AB
            // as we've choice to pick a or A, and every time we take a choice, it is a decision
            // we will recursive tree method
            // Base case: if ip is empty, print op and return
            // init op1 and op2 with op
            // append ip's 1st char in op1
            // append upper case of ip in op2
            // create a stringbuilder with ip
            // delete first char and return it in ip
            // recur for op1 and op2

            if(ip.length() == 0) {
                System.out.println("op = " + op);
                return;
            }

            String op1 = op, op2 = op;

            op1 += ip.charAt(0);
            op2 += Character.toUpperCase(ip.charAt(0));

            StringBuilder sb = new StringBuilder(ip);
            ip = sb.deleteCharAt(0).toString();

            permutationWithCaseChange(ip, op1);
            permutationWithCaseChange(ip, op2);
        }

        public static List<String> LetterCaseDigitPermutation(String ip, String op, List<String> res) {
            // given a string, print all permutations with case changes
            // e.g a1b2 OP -> a1b2, A1b2, a1B2, A1B2
            // every time we have a choice to take either lowercase or uppercase
            // once we finalise a choice, it's a decision
            // we will use recursive tree method
            // Base case: when ip is empty, print op and return
            // check if ip's first char is a digit, if yes,
            // simply add it to op1 and op2
            // delete first char from ip
            // recur for op1 and op2
            // init op1 and op2 with op
            // add op's first char with op1
            // add op's first char with uppercase with op2
            // delete first char from ip
            // recur for op1 and op2

            if(ip.length() == 0) {
                //System.out.println("op = " + op);
                res.add(op);
                return res;
            }


            StringBuilder sb = new StringBuilder(ip);

            if(!Character.isDigit(ip.charAt(0))) {
                String op1 = op, op2 = op;

                op1 += Character.toLowerCase(ip.charAt(0));
                op2 += Character.toUpperCase(ip.charAt(0));

                ip = sb.deleteCharAt(0).toString();
                LetterCaseDigitPermutation(ip, op1, res);
                LetterCaseDigitPermutation(ip, op2, res);
            }

            else {
                String op1 = op;

                op1 += ip.charAt(0);

                ip = sb.deleteCharAt(0).toString();
                LetterCaseDigitPermutation(ip, op1, res);

            }

            return res;
        }

        public static List<String> generateBalancedParantheses(int n, ArrayList<String> res, int o, int c, String op) {
            // given an int n, generate all balanced parantheses
            // e.g n=2, OP -> ()(), (())
            // at any given stage, there are 2 choices, we can choose either ( or )
            // so we can use recursion here
            // as n = 2, no. of ( that can be used is 2, and ) is 2
            // we can use ( at any time, provided it's count > 0
            // we can only use ), if it's count > ('s count
            // Base case: if ( == 0 and ) == 0, add to list and return


            if(o == 0 && c == 0) {
                res.add(op);
                return res;
            }

            if(o > 0) {
                String op1 = op;
                op1 += "(";
                generateBalancedParantheses(n, res, o-1, c, op1);
            }

            if(o < c) {
                String op2 = op;
                op2 += ")";
                generateBalancedParantheses(n, res, o, c-1, op2);
            }

            return res;
        }

        public static ArrayList<String> NDigitBinaryNumbers(int n, int ones, int zeroes,
                                                            String op, ArrayList<String> res) {
            // given n, print all n digit binary numbers whose any prefix will have #1's > #0's
            // for each digit we have choice, either to take 1 or 0
            // as we've choices, we will use recursive tree method
            // Base case: if n==0, print op and return
            // we can use ones any time
            // so create op1 as op
            // append 1 in it
            // recur for n-1 and ones+1
            // if ones > zeroes, we can use 0
            // so create op2 as op
            // append 0 in it
            // recur for n-1 and zeroes+1

            if(n == 0) {
                res.add(op);
                return res;
            }

            String op1 = op;
            op1 += '1';
            NDigitBinaryNumbers(n-1,ones+1,zeroes,op1,res);

            if(ones > zeroes) {
                String op2 = op;
                op2 += '0';
                NDigitBinaryNumbers(n-1,ones,zeroes+1,op2,res);
            }

            return res;
        }

        public static List<Integer> josephusProblem(int n, int k, List<Integer> arr, int ans, int index) {
            // given an array of people from 1 to n and k denoting kth person to be executed
            // find out the person that remains safe
            // every time one person will be killed and same execution process will be applied
            // so we can use recursion here
            // we will use IBH method here
            // index param denotes who has the sword to execute the person
            // Hypo: IP - n and k denoting array of persons from 1 to n and kth person to be executed
            // OP - Int denoting safe position
            // Recursive call: execute the first person and remove it from list and recur for remaining persons
            // Base: if there's only one person in the list, he's the safe person
            // Induction: There's nothing to do here as the person executed in the first step
            // will never be the one to survive

            if(arr.size() == 1) {
                return arr;
            }

            index = (index + k) % arr.size();
            // this will tell index of the person to be executed
            arr.remove(index);

            josephusProblem(n,k,arr,ans,index);
            return arr;
        }

        // ********** Sliding Window ************
        public static void maxSumSubArrayOfSizeK(int[] arr, int k) {
            // given an array and a number k which denotes size of window, find out max sum of all subarrays of size k
            // as this has arr, subarray, k, max, we can try to use Sliding window concept
            // every time window slides further, remove the first element and include the next element
            // i denotes start and j denotes end of the window
            // init i and j with 0
            // run a loop while j < n
            // update sum with arr[j]
            // check if j-i+1 < k, if yes do j++
            // else window is formed, then
            // remove the first element from the sum
            // update i and j
            // what effectively we're doing is, instead of directly pointing j as i + k -1
            // we're creating window from size 0 and doing sum at the same time
            // as soon as our window becomes of size k, we're doing 3 things
            // 1. update max with sum and itself
            // 2. remove start from sum
            // 3. i++ and j++

            int n = arr.length;

            int i = 0, j = 0, sum = 0, ans = 0;

            while (j < n) {
                sum += arr[j];

                if(j - i + 1 < k) j++;
                else if (j - i + 1 == k) {
                    ans = Math.max(ans, sum);
                    sum -= arr[i];
                    i++;
                    j++;
                }
            }

            System.out.println("ans = " + ans);
        }

        public static void firstNegativeInEveryWindowOfK(int[] arr, int k) {
            // given an array and k denoting size of window, determine 1st -ve in every subarray of size k
            // as there are terms like array, subarray, k, and first
            // we can use sliding window concept
            // create a list to store -ve's in every subarray
            // init i = 0 , j = 0
            // run a loop till  j < n
            // check if arr[j] < 0, add it in the list
            // now check if j-i+1 < k, if yes j++
            // else if j-i+1 == k,
            // 1. get ans from calculations
            // 2. slide the window
            // check if list' size > 0, if yes, print 1st element
            // check if arr[i] == list's 1st element, if yes, remove from list
            // i++ and j++

            int n = arr.length;

            List<Integer> res = new ArrayList<>();

            int i = 0, j = 0;

            while (j < n) {
                if(arr[j] < 0) res.add(arr[j]);

                if(j - i + 1 < k) j++;

                else if(j - i + 1 == k) {
                    if(res.isEmpty()) System.out.print(0 + " ");
                    else {
                        System.out.print(res.get(0) + " ");

                        if(arr[i] == res.get(0)) res.remove(0);
                    }
                    i++;
                    j++;
                }
            }
        }

        public static void countOccurrencesOfAnagrams(String s1, String s2) {
            // given 2 strings, s1 and s2, find count of occurrences of anagrams of s2 in s1
            // e.g s1 = aabaabaa, s2 = aaba, OP - 4
            // one solution is to create substrings of size s2.length in s1
            // for every substring of s1 check if it's an anagram of s2

            // Here as we can take substrings of fixed size s2's length
            // we can try for sliding window as it has substring, k
            // create a map of s2's char vs it's freq
            // init i = 0, j= 0, count as map's keySet's size
            // count keeps track of whether all occurrences of one char in s1's substring are present in s2
            // ans = 0
            // run a loop j < n
            // calculation -
            // check if map contains charAt j, if has then increment value
            // if map's value becomes 0, count--
            // check if j - i + 1 < k, if yes j ++
            // else check if count == 0, ans++
            // now we need to slide
            // increment map's value for charAt i
            // check if count == 0, count++
            // i++ and j++

            HashMap<Character,Integer> map1 = new HashMap<>();
            HashMap<Character,Integer> map2 = new HashMap<>();

            for (int i = 0; i < s2.length(); i++) {
                map1.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0) + 1);
            }

            int i = 0, j = 0, count = map1.keySet().size(), ans = 0;
            int n = s1.length(), k= s2.length();

            while (j < n) {
                // calculation
               map2.put(s1.charAt(j), map2.getOrDefault(s1.charAt(j), 0) + 1);

               if(j - i + 1 < k) j++;

               else if (j - i + 1 == k) {
                   if(map1.equals(map2)) ans++;

                   // slide
                   if(map2.containsKey(s1.charAt(i))) {
                       map2.put(s1.charAt(i), map2.get(s1.charAt(i)) - 1);
                       if(map2.get(s1.charAt(i)) == 0) map2.remove(s1.charAt(i));
                   }
                   i++;
                   j++;
               }
            }

            System.out.println("ans = " + ans);
        }

        public static List<Integer> maxOfAllSubArraysOfSizeK(int[] arr, int k) {
            // given an array and window size of k, find max for all subarrays of size k
            // maintain a list that maintains max in every window
            // while adding an element to list, remove all elements smaller than it from list
            // ans = list.get(0)
            // now while sliding, check if element to be removed from window is in list
            // if yes, remove it from list

            int n = arr.length;

            List<Integer> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int i = 0, j = 0;

            if(k > n) {
                res.add(Arrays.stream(arr).max().getAsInt());
                return res;
            }

            while (j < n) {
                // calculations

                while (list.size() > 0 && list.get(0) < arr[j]) list.remove(0);

                list.add(arr[j]);

                if(j - i + 1 < k) j++;
                else if(j -i + 1 == k) {
                    // get the ans
                    res.add(list.get(0));
                    // slide the window
                    if(arr[i] == list.get(0)) list.remove(0);
                    i++;
                    j++;
                }
            }

            System.out.println("res = " + res);
            return res;
        }

        public static int numberOfSubArraysOfSizeKAvgGreaterThanT(int[] arr, int k, int t) {
            // given an array and a window of size k and a threshold t,
            // find out number of subarrays having avg >= t
            // as there are terms like subarray, window size k, number
            // we can try sliding window
            // calculation: do sum with arr[j]
            // when window size is ready,
            // check if sum/k, i.e avg >= t, if yes update ans
            // now slide the window and remove i's calculations
            // sum -= arr[i]
            // i++ and j++

            int n = arr.length;
            int ans = 0, sum = 0;
            int i = 0, j = 0;

            while (j < n) {
                sum += arr[j];

                if(j - i + 1 < k) j++;
                else if(j - i + 1 == k) {
                    if((sum/k) >= t) ans++;

                    sum -= arr[i];
                    i++;
                    j++;
                }
            }

            System.out.println("ans = " + ans);
            return ans;
        }

        public static void largestSubArrayOfSumK(int[] arr, int k) {
            // given an array, find the largest subarray having sum as k
            // here as terms given are subarray, largest
            // we can think of sliding window
            // But there is one thing: here we are not given window size
            // instead we're given a sum k, we've to find window size that has a sum k

            int n = arr.length;
            int ans = 0, sum = 0;
            int i = 0, j = 0;

            while (j < n) {
                // calculation
                sum += arr[j];

                if(sum < k) j++;

                // condition satisfied
                else if(sum == k) {
                    ans = Math.max(ans, j-i+1);
                    j++;
                }

                // if sum > k,
                else {
                    while (sum > k) {
                        sum -= arr[i];
                        i++;
                    }
                    if(sum == k) {
                        ans = Math.max(ans, j-i+1);
                    }
                    j++;
                }
            }

            System.out.println("ans = " + ans);
        }

        public static LinkedListNode removeDupsFromUnsortedLL(LinkedListNode node) {
            // create a set to check whether an element is already present or not
            // create 2 ptrs, prev and curr
            // if set contains curr, prev.next = curr.next
            // else add curr's data in set
            // update curr with curr's next

            Set<Integer> set = new HashSet<>();
            LinkedListNode prev, curr;

            if(node == null) return null;

            prev = null; curr = node;

            while (curr != null) {
                if(set.contains(curr.data)) {
                    prev.next = curr.next;
                }
                else {
                    set.add(curr.data);
                    prev = curr;
                }
                curr = curr.next;
            }
            return node;

        }

        public static int getNthFromLast(LinkedListNode head, int n) {
            // given a linkedlist and int n, find nth node from the end of LL
            // keep 2 ptrs, init p1 as null and p2 as head
            // init count as 1, this is used for moving p2 n nodes from start
            // while count < k and p2 != null, inc count and update p2
            // now p2 is n nodes ahead from start
            // now till p2 is not null, one by one inc p1 and p2
            // while p2 != null, check if p1 is null, if yes p1 = head else p1 = p1.next
            // return p1.data

            if(head == null) return -1;

            LinkedListNode p1, p2;
            p1 = null; p2 = head;

            int count = 1;

            while (count < n && p2 != null) {
                count++;
                p2 = p2.next;
            }

            while (p2 != null) {
                if(p1 == null) p1 = head;
                else p1 = p1.next;
                p2 = p2.next;
            }

            return (p1 == null ? -1 : p1.data);
        }

        public static void deleteNode(LinkedListNode node) {
            // given a LL and direct access to the node, delete it
            // copy node's next's data into node
            // point node's next to node's next's next

            node.data = node.next.data;
            node.next = node.next.next;
        }

        public static LinkedListNode partition(LinkedListNode node, int x) {
            // given a LL and a value x, partition LL around x in a quicksort-esque manner
            // one way is to sort it
            // another way is to create 2 sorted subLL's and add the number of times x
            // is present and merge both of them
            // take one var eq to note count of x in LL
            // take 2 nodes, lhead, ghead to note the start of resp. sub LL
            // take 2 nodes, lptr and gptr to note the iteration of sub LL
            // iterate through the list and fill the relevant list
            // once iteration is over, add the number of times x was present to lptr
            // after that point lptr to ghead
            // return lhead

            int eq = 0;
            LinkedListNode ptr = node;
            LinkedListNode lhead = null, ghead = null, lptr = null, gptr = null;

            while (ptr != null) {
                if(ptr.data < x) {
                    LinkedListNode newNode = new LinkedListNode(ptr.data);
                    if(lhead == null) {
                        lhead = newNode;
                        lptr = newNode;
                    }
                    else {
                        lptr.next = newNode;
                        lptr = lptr.next;
                    }
                }

                else if(ptr.data == x) eq++;

                else {
                    LinkedListNode newNode = new LinkedListNode(ptr.data);
                    if(ghead == null) {
                        ghead = newNode;
                        gptr = newNode;
                    }
                    else {
                        gptr.next = newNode;
                        gptr = gptr.next;
                    }
                }

                ptr = ptr.next;
            }

            if(eq > 0) {
                while (eq-- > 0) {
                    if(lptr != null) {
                        lptr.next = new LinkedListNode(x);
                        lptr = lptr.next;
                    }
                    else {
                        LinkedListNode newN = new LinkedListNode(x);
                        newN.next = ghead;
                        ghead = newN;
                    }
                }
            }

            if(lptr != null) lptr.next = ghead;
            return (lptr != null ? lhead : ghead);
        }

        public static LinkedListNode sumLists(LinkedListNode first, LinkedListNode second) {
            // use stack as lists are reversed
            // create string to store numbers from stack
            // add both the numbers and store it back in stack
            // now create LL from stack

            Stack<Integer> stack = new Stack<>();
            LinkedListNode newHead, ptr = first;

            while (ptr != null) {
                stack.push(ptr.data);
                ptr = ptr.next;
            }

            StringBuilder s1 = new StringBuilder();

            while (!stack.isEmpty()) {
                s1.append(stack.pop());
            }

            ptr = second;

            while (ptr != null) {
                stack.push(ptr.data);
                ptr = ptr.next;
            }

            StringBuilder s2 = new StringBuilder();

            while (!stack.isEmpty()) {
                s2.append(stack.pop());
            }

            int n1 = Integer.parseInt(s1.toString());
            int n2 = Integer.parseInt(s2.toString());

            int res = n1 + n2;
            String s3 = String.valueOf(res);

            ptr = null;
            newHead = null;

            for (int i = 0; i < s3.length(); i++) {
                stack.push(Character.getNumericValue(s3.charAt(i)));
            }

            while (!stack.isEmpty()) {
                LinkedListNode node = new LinkedListNode(stack.pop());
                if(newHead == null) {
                    newHead = node;
                    ptr = newHead;
                }
                else {
                    ptr.next = node;
                    ptr = ptr.next;
                }
            }

            return newHead;
        }

        public static boolean palindromeLL(LinkedListNode head) {
            // given a LL, check if it's palindrome
            // get the mid of list using runner
            // sptr will be the mid
            // check if fptr is null, in case of odd sized, it won't be
            // else yes
            // In odd sized, assign sptr = m, update sptr with sptr.next
            // reverse the list from sptr
            // make prev_s.next = null
            // compare head with sptr

            LinkedListNode fptr = head, sptr = head;
            LinkedListNode mid = null, prev_s = null;

            while (fptr != null && fptr.next != null) {
                fptr = fptr.next.next;

                prev_s = sptr;
                sptr = sptr.next;
            }

            if(fptr != null) {
                mid = sptr;
                sptr = sptr.next;
            }

            reverseLL(sptr);
            prev_s.next = null;
            return compareLL(head, sptr);
        }

        public static int intersectPoint(LinkedListNode head1, LinkedListNode head2) {
            if(head1 == null && head2 != null) return -1;
            if(head2 == null && head1 != null) return -1;

            int len1 = 0, len2 = 0;

            LinkedListNode ptr = head1;

            while (ptr != null) {
                len1++;
                ptr = ptr.next;
            }

            ptr = head2;

            while (ptr != null) {
                len2++;
                ptr = ptr.next;
            }

            LinkedListNode ptr1 = head1 , ptr2 = head2;
            int d = Math.abs(len1 - len2);
            boolean isL1G = len1 > len2;
            int c = 0;

            if(isL1G) {
                while (c < d) {
                    ptr1 = ptr1.next;
                    c++;
                }
            }

            else {
                while (c < d) {
                    ptr2 = ptr2.next;
                    c++;
                }
            }

            while (ptr1 != null && ptr2 != null) {

                if(ptr1 == ptr2) return ptr1.data;

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            return -1;
        }

        public static int detectLoopAndGetCorrupt(LinkedListNode head) {
            if(head == null) return -1;

            LinkedListNode fptr = head, sptr = head;

            while (sptr != null && fptr != null && fptr.next != null) {
                sptr = sptr.next;
                fptr = fptr.next.next;

                if(fptr == sptr) {
                    return fptr.data;
                }
            }

            return -1;
        }

        public static Node binaryTreeToCDLL(Node root) {
            // traverse tree inorder wise and store it in a list
            // iterate through the list and create CDLL

            if(root == null) return null;

            List<Integer> res = new ArrayList<>();
            res = inOrder(root, res);

            Node head = null, ptr = null;

            for (Integer re : res) {
                Node node = new Node(re);
                if (head == null) {
                    head = node;
                    ptr = head;
                } else {
                    ptr.right = node;
                    node.left = ptr;
                    ptr = ptr.right;
                }
            }

            ptr.right = head;
            head.left = ptr;
            return head;
        }

        public static List<Integer> inOrder(Node root, List<Integer> res) {
            if(root == null) {
                return res;
            }

            inOrder(root.left, res);
            res.add(root.data);
            inOrder(root.right, res);
            return res;
        }


        public static LinkedListNode merge2SortedLL(LinkedListNode headA, LinkedListNode headB) {

            if(headA == null && headB == null) return null;
            if(headA == null && headB != null) return headB;
            if(headA != null && headB == null) return headA;

            LinkedListNode resH = null, resP = null;
            LinkedListNode ptrA = headA, ptrB = headB;


            while(ptrA != null && ptrB != null) {
                LinkedListNode newNode;

                if(ptrA.data < ptrB.data) {
                    newNode = new LinkedListNode(ptrA.data);
                    if(resH == null) {
                        resH = newNode;
                        resP = resH;
                    }
                    else {
                        resP.next = newNode;
                        resP = resP.next;
                    }
                    ptrA = ptrA.next;
                }

                else {
                    newNode = new LinkedListNode(ptrB.data);
                    if(resH == null) {
                        resH = newNode;
                        resP = resH;
                    }
                    else {
                        resP.next = newNode;
                        resP = resP.next;
                    }
                    ptrB = ptrB.next;
                }
            }

            while(ptrA != null) {
                LinkedListNode newN= new LinkedListNode(ptrA.data);

                resP.next = newN;
               resP = resP.next;
               ptrA = ptrA.next;
            }

            while(ptrB != null) {
                LinkedListNode newN= new LinkedListNode(ptrB.data);
                resP.next = newN;
                resP = resP.next;
                ptrB = ptrB.next;
            }

            return resH;
        }

        public static LinkedListNode removeAllOccurrencesOfDupsInLL(LinkedListNode head) {
            // remove all occurrences of dups in LL
            // create a dummy node and add it at the beginning of LL
            // use prev to denote the latest original value
            // use ptr to iterate through the LL
            // as LL is sorted, dups will be next to original
            // while ptr's data == ptr's next data, update ptr
            // once loop is terminated, check if prev's next is ptr
            // if yes, update prev as we've found the latest original
            // else update prev's next to ptr's next
            // finally, update head to dummy's next and return head


            LinkedListNode prev , ptr = head;
            LinkedListNode dummy = new LinkedListNode(0);

            dummy.next = head;
            prev = dummy;

            while (ptr != null) {

                while (ptr.next != null && prev.next.data == ptr.next.data)
                    ptr = ptr.next;


                if(prev.next == ptr) prev = prev.next;

                else prev.next = ptr.next;

                ptr = ptr.next;
            }

            head = dummy.next;
            return head;
        }

        public static int lengthOfLongestPalindromeInLL(LinkedListNode head) {
            // convert LL to string
    //        // there is a choice, either to consider a char & compare it with ip
    //        // or not to consider a char & compare it with ip
    //        // as there is choices and decisions, we can use recursive tree method here
    //
    //        // create another function which takes sb, op and ans as params
    //        //
    //
    //        StringBuilder sb = new StringBuilder();
    //
    //        LinkedListNode ptr = head;
    //
    //        while (ptr != null) {
    //            sb.append(ptr.data);
    //            ptr = ptr.next;
    //        }
    //
    //        return lengthOfLongestPalindromeInLL(sb.toString(), "", 0);

            LinkedListNode prev = null, next = null;
            LinkedListNode curr = head;

            int ans = 1;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;

                ans = Math.max(ans, 2 * countCommon(prev, next) + 1);
                ans = Math.max(ans, 2 * countCommon(curr, next));

                prev = curr;
                curr = next;
            }

            return ans;
        }
    //
    //    public static int lengthOfLongestPalindromeInLL(String ip, String op, int ans) {
    //        // base case: if ip is empty, return ans
    //        // init op1 and op2 with op
    //        // now add ip's first char with op2
    //        // now delete ip's first char as smaller ip
    //        // do 2 * countcommon() + 1 with op1 and ip and update ans with max of ans and this res
    //        // do 2 * countcommon() with op2 and ip, and update ans with max of ans and this res
    //        // recur for op1 and ip and ans
    //        // recur for op2 and ip and ans
    //
    //        if(ip.length() == 0) {
    //            return ans;
    //        }
    //
    //        System.out.println("ip.charAt(0) = " + ip.charAt(0));
    //
    //        if(ip.charAt(0) == ' '){
    //            StringBuilder sb = new StringBuilder(ip);
    //            ip = sb.deleteCharAt(0).toString();
    //            lengthOfLongestPalindromeInLL(ip, op, ans);
    //        }
    //
    //        String op1 = op, op2 = op;
    //
    //        op2 = ip.charAt(0) + op2;
    //
    //        StringBuilder sb = new StringBuilder(ip);
    //        ip = sb.deleteCharAt(0).toString();
    //
    //        ans = Math.max(ans, 2 * countCommon(op1, ip) + 1);
    //        ans = Math.max(ans, 2 * countCommon(op2, ip));
    //
    //        lengthOfLongestPalindromeInLL(ip, op1, ans);
    //        lengthOfLongestPalindromeInLL(ip, op2, ans);
    //        return ans;
    //    }

        public static LinkedListNode reverseInGroupsOfK(LinkedListNode head, int k) {
            int count = 0;
            LinkedListNode prev = null, curr = head, next = null;

            while (count < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if(next != null)
                head.next = reverseInGroupsOfK(next, k);

            return prev;
        }


        public static Node bToDLL(Node root) {
            // convert the binary tree to DLL
            // traverse the tree inorder wise
            // second statement gives us the node
            // create head of the DLL as null and ptr as null
            // check if head is null, head = root and ptr = head
            // else ptr's right to root, root's left to ptr, ptr to ptr's right
            // return if root is null
            // return head from the function

            Node head = null, ptr = null;

            return inOrder(root, head, ptr);
        }

        public static Node inOrder(Node root, Node head, Node ptr) {
            if(root == null) return null;

            Node local = root;

            inOrder(root.left, head, ptr);
            if(head == null) {
                head = root;
                ptr = head;
            }
            else {
                ptr.right = local;
                local.left = ptr;
                ptr = ptr.right;
            }
            inOrder(root.right, head, ptr);

            return head;
        }

        public static long[] nearestGreaterToRight(long[] arr, int n) {
            long[] res = new long[n];
            Stack<Long> stack = new Stack<>();

            int idx = 0;

            for (int i = n-1; i >= 0 ; i--) {
                if(stack.isEmpty()) res[idx++] = -1;
                else if(stack.peek() > arr[i]) res[idx++] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();

                    if(stack.isEmpty()) res[idx++] = -1;
                    else res[idx++] = stack.peek();
                }

                stack.push(arr[i]);
            }

            int l = 0, h = n-1;

            while (l < h) {
                long temp = res[h];
                res[h] = res[l];
                res[l] = temp;
                l++;
                h--;
            }

            return res;
        }

        public static int[] calculateSpan(int[] arr, int n) {
            List<Integer> nglIndexes = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                if(stack.isEmpty()) nglIndexes.add(-1);
                else if(arr[stack.peek()] > arr[i]) nglIndexes.add(stack.peek());
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();

                    if(arr[stack.peek()] > arr[i]) nglIndexes.add(stack.peek());
                    else nglIndexes.add(-1);
                }

                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                res[i] = i - nglIndexes.get(i);
            }

            Utils.printIntArray("res array: ", res);
            return res;
        }

        public static int MAH(int[] arr) {
            // given an array of heights of building and width as 1
            // determine max area of histogram

            int n = arr.length;

            int[] left = new int[n];
            int[] right = new int[n];
            int[] width = new int[n];
            int ans = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                if(stack.isEmpty()) left[i] = -1;
                else if(arr[stack.peek()] < arr[i]) left[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                    if(stack.isEmpty()) left[i] = -1;
                    else left[i] = stack.peek();
                }

                stack.push(i);
            }

            stack.clear();

            for (int i = n-1; i >= 0 ; i--) {
                if(stack.isEmpty()) right[i] = n;
                else if(arr[stack.peek()] < arr[i]) right[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                    if(stack.isEmpty()) right[i] = n;
                    else right[i] = stack.peek();
                }

                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                width[i] = right[i] - left[i] - 1;
            }

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, width[i] * arr[i]);
            }

            return ans;
        }

        public static int maxArea(int[][] arr, int m, int n) {
            int ans = 0;
            n = arr.length;
            m = arr[0].length;

            int[] marr = new int[m];

            for (int j = 0; j < m; j++) {
                marr[j] = arr[0][j];
            }

            ans = MAH(marr);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] != 0) marr[j] += 1;
                    else marr[j] = 0;
                }

                ans = Math.max(ans, MAH(marr));
            }

            return ans;
        }

        public static int trappingWater(int[] arr) {
            int n = arr.length;

            int[] maxL = new int[n];
            int[] maxR = new int[n];
            int[] min = new int[n];
            int[] bound = new int[n];

            maxL[0] = arr[0];

            for (int i = 1; i < n; i++) {
                maxL[i] = Math.max(maxL[i-1], arr[i]);
            }

            maxR[n-1] = arr[n-1];

            for (int i = n-2; i >= 0 ; i--) {
                maxR[i] = Math.max(maxR[i+1], arr[i]);
            }

            for (int i = 0; i < n; i++) {
                min[i] = Math.min(maxL[i], maxR[i]);
            }

            for (int i = 0; i < n; i++) {
                bound[i] = min[i] - arr[i];
            }

            return Arrays.stream(bound).sum();
        }

        public static boolean validParentheses(String str) {
            int n = str.length();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
                    stack.push(str.charAt(i));
                else {
                    if(stack.isEmpty()) return false;
                    if(!isAMatch(stack.pop(), str.charAt(i)))
                        return false;
                }
            }

            return stack.isEmpty();
        }

        public static Stack<Integer> sortStack(Stack<Integer> stack) {
            if(stack.size() == 1) return stack;

            int top = stack.pop();
            sortStack(stack);

            return insertTop(stack, top);
        }

        public static Stack<Integer> insertTop(Stack<Integer> stack, int top) {

            if(stack.isEmpty()) {
                stack.push(top);
                return stack;
            }

            if(stack.size() == 1 && stack.peek() > top) {
                stack.push(top);
                return stack;
            }

            int val = stack.pop();

            insertTop(stack, top);

            stack.push(val);
            return stack;
       }


        public static int celebrityProblem(int[][] arr, int n) {
            // given a binary matrix of n * n with a[i][j] as 1
            // denoting ith person knows jth person
            // find out the person, if any, that everyone knows
            // and that person doesn't know anyone

            // use stacks to store all no. from 0 to n
            // if a knows b, a can't be celebrity b can be
            // if b knows a, b can't be celebrity a can be
            // using this logic it can be deduced who cannot be the ans
            // to conclude who is, check if the pot. candidate doesn't know anyone
            // or there is someone who doesn't know pot. candidate

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                stack.push(i);
            }

            while (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();

                if(arr[a][b] == 1) stack.push(b);
                else if(arr[b][a] == 1) stack.push(a);
            }

            if(stack.isEmpty()) return -1;

            int candidate = stack.pop();

            for (int i = 0; i < n; i++) {
               if(i != candidate &&
                       arr[candidate][i] == 1
                       || arr[i][candidate] == 0)
                   return -1;
            }


            return candidate;
        }


        public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
            // reverse first k elements of q
            // put first k elements into stack
            // pop the stack into res q
            // poll the q into res q

            Queue<Integer> res = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < k; i++) {
                stack.push(q.poll());
            }

            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }

            while (!q.isEmpty()) {
                res.add(q.poll());
            }

            return res;
        }

        public static int orangesRotting(int[][] arr) {
            // given a 2d array of values 0,1,2
            // with 0 denoting empty space, 1 denoting fresh orange
            // 2 denoting rotten orange, determine min. time to rot all oranges
            // if it's not possible, return -1
            // it's not possible to rot an orange if there's a 0 in between

            // as we need to traverse first all adj and then neighbours
            // also we need to process it parallely, we've to use BFS

            int n = arr.length, m = arr[0].length;

            Queue<Orange> q = new LinkedList<>();
            int res = -1;

            Orange resNode = new Orange();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 2) {
                        q.add(new Orange(i, j, 0));
                    }
                }
            }

            while (q.size() >= 1) {
                Orange node = q.poll();
                resNode = node;

                // make all adj 1's to 2's and add to q with time as
                // node's time + 1
                boolean isDone  = rotAdj(node.i - 1, node.j, n, m, arr);
                if(isDone) {
                   addToQ(node.i - 1, node.j, node.time + 1, q);
                }

                isDone = rotAdj(node.i + 1, node.j, n, m, arr);
                if(isDone) {
                    addToQ(node.i + 1, node.j, node.time + 1, q);
                }

                isDone = rotAdj(node.i, node.j + 1, n, m, arr);
                if(isDone) {
                    addToQ(node.i, node.j + 1, node.time + 1, q);
                }

                isDone = rotAdj(node.i, node.j - 1, n, m, arr);
                if(isDone) {
                    addToQ(node.i, node.j - 1, node.time + 1, q);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1) return res;
                }
            }

            res = resNode.time;
            return res;
        }

        public static void firstNonRepeatingCharacterInStream(String s) {
            // given a stream of characters, find the first non repeating char
            // idea is to use map to keep count of chars
            // and heap to get the first non-repeating at any point

            int n = s.length();
            HashMap<Character,Integer> map = new HashMap<>();
            Queue<Character> heap = new LinkedList<>();

            StringBuilder ans = new StringBuilder();

            map.put(s.charAt(0), 1);
            heap.add(s.charAt(0));
            ans.append(s.charAt(0));

            for (int i = 1; i < n; i++) {
                Character c = s.charAt(i);

                if(map.get(c) == null) {
                    // case like b or c in aabc
                    if(heap.isEmpty()) {
                        ans.append(c);
                        heap.add(c);
                    }
                    else {
                        ans.append(heap.peek());
                        heap.add(c);
                    }

                    map.put(c, 1);
                }

                else {
                    // case like second a in aabc
                    if(heap.peek() == c) {
                        heap.poll();
                        if(heap.isEmpty()) ans.append("#");
                        else ans.append(heap.peek());
                    }

                    else {
                        if(heap.isEmpty()) ans.append("#");
                        else ans.append(heap.peek());
                        if(map.get(c) >= 1) heap.remove(c);
                    }

                    map.put(c, map.get(c) + 1);
                }
            }

            System.out.println("ans = " + ans);
        }

        public static void circularTour(int[] petrol, int[] distance) {
            // given 2 arrays of petrol and distance, find the starting
            // point from where a circular tour is possible

            // take a var deficit that determines how much more petrol is required
            // in case of p < d
            // take start to get the start of circular tour
            // take bal to store the balance petrol
            // if bal < 0, update def with bal and reset bal = 0 and start = i + 1
            // as let's say start = 0, and till i-1, bal > 0
            // on i, bal < 0, meaning even if start becomes 1, then to
            // till i-1, bal > 0 and on i it'll be < 0, so start will be i + 1
            // lastly, check if sum of deficit petrol and bal < 0, if yes, return -1
            // else return start

            int n = petrol.length;

            int start = 0, def = 0, bal = 0;

            for (int i = 0; i < n; i++) {
                bal += petrol[i] - distance[i];

                if(bal < 0) {
                    def += bal;
                    bal = 0;
                    start = i + 1;
                }
            }

            System.out.println(def + bal > 0 ? start : -1);
        }

        public static ArrayList<Integer> topViewOfBinaryTree(Node root) {
            if(root == null) return null;
            ArrayList<Integer> res = new ArrayList<>();
            List<Integer> values;
            TreeMap<Integer, Integer> map = new TreeMap<>();

            values = topViewOfBinaryTree(root, 0, map);

            res.addAll(values);

            return res;
        }

        public static List<Integer> topViewOfBinaryTree(Node root, int hd, TreeMap<Integer,Integer> map) {
            Queue<TreeNodePair> queue = new LinkedList<>();
            queue.add(new TreeNodePair(root, hd));

            while (!queue.isEmpty()) {
                TreeNodePair treeNodePair = queue.poll();
                Node tmp = treeNodePair.getRoot();
                int d = treeNodePair.getHd();

                if(map.get(d) == null) {
                    map.put(d, tmp.data);
                }

                if(tmp.left != null)
                    queue.add(new TreeNodePair(tmp.left, d - 1));
                if(tmp.right != null)
                    queue.add(new TreeNodePair(tmp.right, d + 1));
            }

            return new ArrayList<>(map.values());
        }

        // ********** Tree ************

        public static void mirrorTree(Node root) {
            if(root == null) return;
            mirrorTree(root.left);
            mirrorTree(root.right);

            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

        public static ArrayList<Integer> Kdistance(Node root, int k) {
            Queue<TreeNodePair> queue = new LinkedList<>();
            queue.add(new TreeNodePair(root, 0));
            ArrayList<Integer> res = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNodePair node = queue.poll();
                int d = node.getHd();
                if(d == k) {
                    res.add(node.getRoot().data);
                }

                if(node.getRoot().left != null) {
                    TreeNodePair treeNodePair = new TreeNodePair(node.getRoot().left, d + 1);
                    queue.add(treeNodePair);
                }
                if(node.getRoot().right != null) {
                    TreeNodePair treeNodePair = new TreeNodePair(node.getRoot().right, d + 1);
                    queue.add(treeNodePair);
                }
            }

            return res;
        }


        public static Node lca(Node root, int n1, int n2) {
            // we can use IBH here
            // Hypo: IP - root, n1, n2 OP - Node which is lca
            // Recursive call: l = root.left, n1, n2, r = root.right, n1, n2
            // Base case: if root == null, return null
            // if root.data == n1 || n2, return root
            // Induction: if l ! =null && r! = null, return root
            // return non null

            if(root == null) return null;
            if(root.data == n1 || root.data == n2) return root;

            Node l = lca(root.left, n1, n2);
            Node r = lca(root.right, n1, n2);

            if(l != null && r!= null) return root;
            return (l == null ? r : l);
        }


        public int diameter(Node root) {
          if(root == null) return 0;

          int lh = height(root.left);
          int rh = height(root.right);

          int ld = diameter(root.left);
          int rd = diameter(root.right);

          return Math.max(1 + lh + rh, Math.max(ld, rd));
        }

        public static int height(Node root) {
            if(root == null) return 0;

            return 1 + Math.max(height(root.left), height(root.right));
        }

        public static ArrayList<Integer> leftViewOfBinaryTree(Node root) {
            if(root == null) return null;
            return leftViewOfBinaryTree(root, 0);
        }

        public static ArrayList<Integer> leftViewOfBinaryTree(Node root, int level) {
            Queue<TreeNodePair> queue=  new LinkedList<>();
            queue.add(new TreeNodePair(root, 0));
            ArrayList<Integer> res = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNodePair treeNodePair = queue.poll();

                if(treeNodePair.getHd() == level) {
                    res.add(treeNodePair.getRoot().data);
                    level++;
                }

                if(treeNodePair.getRoot().left != null) {
                    queue.add(new TreeNodePair
                            (treeNodePair.getRoot().left, treeNodePair.getHd() + 1));
                }

                if(treeNodePair.getRoot().right != null) {
                    queue.add(new TreeNodePair
                            (treeNodePair.getRoot().right, treeNodePair.getHd() + 1));
                }
            }

            return res;
        }

        public static ArrayList<Integer> printBoundary(Node root) {
    //        Queue<TreeNodePair> q = new LinkedList<>();
    //        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    //        ArrayList<Integer> res = new ArrayList<>();
    //
    //        q.add(new TreeNodePair(root, 0));
    //        while (!q.isEmpty()) {
    //            TreeNodePair tmp = q.poll();
    //            ArrayList<Integer> values;
    //            if(map.get(tmp.getHd()) == null) {
    //                values = new ArrayList<>();
    //                values.add(tmp.getRoot().data);
    //            }
    //            else {
    //                values = map.get(tmp.getHd());
    //                values.add(tmp.getRoot().data);
    //            }
    //            map.put(tmp.getHd(), values);
    //
    //            if(tmp.getRoot().left != null) {
    //                q.add(new TreeNodePair(tmp.getRoot().left, tmp.getHd() + 1));
    //            }
    //
    //            if(tmp.getRoot().right != null) {
    //                q.add(new TreeNodePair(tmp.getRoot().right, tmp.getHd() + 1));
    //            }
    //        }
    //
    //        for (Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()) {
    //            res.add(e.getValue().get(0));
    //        }
    //
    //        ArrayList<Integer> revList = new ArrayList<>();
    //
    //        for (Map.Entry<Integer,ArrayList<Integer>> e: map.entrySet()){
    //            if(!res.contains(e.getValue().get(e.getValue().size()-1))) {
    //                revList.add(e.getValue().get(e.getValue().size() - 1));
    //            }
    //        }
    //
    //        Collections.reverse(revList);
    //
    //        res.addAll(revList);
    //        return res;

            ArrayList<Integer> res = new ArrayList<>();
            // add root

            if(root != null) {
                res.add(root.data);

                leftBoundary(root.left, res);

                leafNodes(root.left, res);
                leafNodes(root.right, res);

                rightBoundary(root.right, res);
            }
            return res;
        }

        public static void leftBoundary(Node root, ArrayList<Integer> res) {
            if(root == null) return;

            if(root.left != null) {
                res.add(root.data);
                leftBoundary(root.left, res);
            }
            else if(root.right != null) {
                res.add(root.data);
                leftBoundary(root.right, res);
            }
        }

        public static void leafNodes(Node root, ArrayList<Integer> res) {
            if(root == null) return;

            if(root.left == null && root.right == null) {
                res.add(root.data);
            }

            leafNodes(root.left, res);

            leafNodes(root.right, res);
        }

        public static void rightBoundary(Node root, ArrayList<Integer> res) {
            if(root == null) return;

            if(root.right != null) {
                rightBoundary(root.right, res);
                res.add(root.data);
            }

            else if(root.left != null) {
                rightBoundary(root.left, res);
                res.add(root.data);
            }
        }

        public static ArrayList<Integer> verticalTraversal(Node root) {
            Queue<TreeNodePair> q = new LinkedList<>();
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            q.add(new TreeNodePair(root, 0));
            ArrayList<Integer> res = new ArrayList<>();

            while(!q.isEmpty()) {
                TreeNodePair tmp = q.poll();
                int hd = tmp.getHd();
                ArrayList<Integer> values;

                if(map.get(hd) == null) {
                    values = new ArrayList<>();
                }

                else {
                    values = map.get(hd);
                }

                values.add(tmp.getRoot().data);
                map.put(hd, values);

                if(tmp.getRoot().left != null) {
                    q.add(new TreeNodePair(tmp.getRoot().left, hd - 1));
                }

                if(tmp.getRoot().right != null) {
                    q.add(new TreeNodePair(tmp.getRoot().right, hd + 1));
                }
            }

            map.values().forEach(res::addAll);

            return res;
        }

        public static ArrayList<Integer> bottomView(Node root) {
            Queue<TreeNodePair> q = new LinkedList<>();
            TreeMap<Integer,Integer> map = new TreeMap<>();

            q.add(new TreeNodePair(root, 0));

            while (!q.isEmpty()) {
                TreeNodePair tmp = q.poll();
                int hd = tmp.getHd();

                map.put(hd, tmp.getRoot().data);

                if(tmp.getRoot().left != null) {
                    q.add(new TreeNodePair(tmp.getRoot().left, hd - 1));
                }

                if(tmp.getRoot().right != null) {
                    q.add(new TreeNodePair(tmp.getRoot().right, hd + 1));
                }
            }

            return new ArrayList<>(map.values());
        }

        public static boolean isSubtree(Node main, Node sub){
            // traverse inorder for t and s
            // traverse preorder for t and s
            // check if s' inorder is in t
            // check if s' preorder is in t

            if(main == null) return false;
            if(sub == null) return true;

            StringBuilder inOrderMain, inOrderSub, preOrderMain, preOrderSub;
            inOrderMain = new StringBuilder();
            inOrderSub = new StringBuilder();
            preOrderMain = new StringBuilder();
            preOrderSub = new StringBuilder();

            inOrder(main, inOrderMain);
            inOrder(sub, inOrderSub);

            if(!inOrderMain.toString().contains(inOrderSub)) return false;

            preOrder(main, preOrderMain);
            preOrder(sub, preOrderSub);

            return preOrderMain.toString().contains(preOrderSub);
        }

        public static void inOrder(Node root, StringBuilder res) {
            if(root == null) return;

            inOrder(root.left, res);
            res.append(root.data);
            inOrder(root.right, res);
        }

        public static void preOrder(Node root, StringBuilder res) {
            if(root == null) return;
            res.append(root.data);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }

        public static void connectNodesAtSameLevel(Node root) {
            Queue<TreeNodePair> q = new LinkedList<>();
            q.add(new TreeNodePair(root, 0));
            root.nextRight = null;

            while(!q.isEmpty()) {
                TreeNodePair tmp = q.poll();
                int level = tmp.getHd();
                if(q.isEmpty()) tmp.getRoot().nextRight = null;
                else {
                    if(level == q.peek().getHd()) {
                        tmp.getRoot().nextRight = q.peek().root;
                    }
                    else {
                        tmp.getRoot().nextRight = null;
                    }
                }

                if(tmp.getRoot().left != null) {
                    q.add(new TreeNodePair(tmp.getRoot().left, level + 1));
                }

                if(tmp.getRoot().right != null) {
                    q.add(new TreeNodePair(tmp.getRoot().right, level + 1));
                }

            }
        }

        public static ArrayList<Integer> inOrderTraversalIteratively(Node root) {
            Stack<Node> stack = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();

            Node cur = root;

            // inorder LRoR
            while (cur != null || stack.size() > 0) {
                // traverse till left
                // L part in inorder
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                // pop the stack and add to res
                // Ro in inorder
                Node tmp = stack.pop();
                int top = tmp.data;
                res.add(top);

                // set curr to popped node's right
                // R in inorder
                cur = tmp.right;
            }

            return res;
        }

        public static int minDistanceBetween2Nodes(Node root, int a, int b) {
            if(root == null) return -1;

            Node lca = getLca(root, a, b);

            int d1 = distanceFromLca(lca, a, 0);
            int d2 = distanceFromLca(lca, b, 0);

            return d1 + d2;
        }

        public static Node getLca(Node root, int a, int b) {
            if(root == null) return null;
            if(root.data == a || root.data == b) return root;

            Node l = getLca(root.left, a, b);
            Node r = getLca(root.right, a, b);

            if(l != null && r != null) return root;

            return (l == null ? r : l);
       }

        public static int distanceFromLca(Node lca, int a, int dist) {
            if(lca == null) return -1;

            if(lca.data == a) return dist;

            int d = distanceFromLca(lca.left, a, dist + 1);
            if(d != -1) return d;
            d = distanceFromLca(lca.right, a, dist + 1);
            return d;
        }

        public static ArrayList<Integer> kDistanceNodes(Node root, int target, int k) {
         ArrayList<Integer> res  = new ArrayList<>();
         kDistanceNodes(root, target, k, res);
         res.sort(Comparator.naturalOrder());
         return res;
        }

        public static int kDistanceNodes(Node root, int target, int k,ArrayList<Integer> res) {
            // if target is not found, return -1
        if(root == null) return -1;
        // if target is root, print all nodes at k dist. from root
            //return 0
        if(root.data == target) {
                fetchFromDown(root, res, k);
                return 0;
         }

        // if not root, check in the left subtree
            // if ld != -1, meaning target is in left subtree
            // if 1 + ld == k, print root
            // here k-ld-2 is done as root's right is 2 edges away from left
            // also removing ld as whatever distance it's from root
            // else print all nodes at k-dl-2 from right subtree
            // return 1 + ld
        int ld = kDistanceNodes(root.left, target, k, res);
        if(ld != -1) {
            if(ld + 1 == k) res.add(root.data);
            else {
                fetchFromDown(root.right,  res, k-ld-2);
            }

            return 1 + ld;
        }

        // similarly, do it for right subtree
        int rd = kDistanceNodes(root.right, target, k, res);
        if(rd != -1) {
            if(rd + 1 == k) res.add(root.data);
            else {
                fetchFromDown(root.left, res, k-rd-2);
            }
            return 1 + rd;
        }

        return -1;
        }

        public static ArrayList<Integer> fetchFromDown(Node root, ArrayList<Integer> res, int k) {
            if(root == null || k < 0) return null;

            if(k == 0) {
                res.add(root.data);
                return res;
            }

            fetchFromDown(root.left, res, k - 1);
            fetchFromDown(root.right, res, k - 1);
            return res;
        }

        // pass by reference
        static class Res {
            int val;
        }

        public static int maxPathSum(Node root, Res res) {
            // given a tree, find max path sum from leaf to leaf
            // get maxPathSum from left subtree and right subtree
            // the root has 2 choices:
            // either it can take max of l and r and add it's own value and give it up top
            // or take sum of l and r and it's own data

            // Base case
            if(root == null) return 0;

            if(root.left == null && root.right == null)
                return root.data;

            // Hypo
            int l = maxPathSum(root.left, res);
            int r = maxPathSum(root.right, res);

            // Induction
            // update res with l + r + root's data & itself
            // i.e update res with the choice when root wants to be the ans
            // return the choice when root cannot be the ans
            // return max(l,r) + root.data

            if(root.left != null && root.right != null) {
                res.val = Math.max(res.val, l + r + root.data);
                return Math.max(l , r) + root.data;
            }

            // if one of the subtree's empty, return root + other subtree's data
            return (root.left == null ? r + root.data : l + root.data);
        }

        public static int[] sortedArrayToBST(int[] arr) {
            // convert a given sorted arr to bst
            // return the bst's preorder traversal
            // idea is to use binary search
            int n = arr.length;

            ArrayList<Integer> res = new ArrayList<>();
            sortedArrayToBST(arr, res, 0, n-1);

            return res.stream().mapToInt(i -> i).toArray();
        }

        public static void sortedArrayToBST(int[] arr, ArrayList<Integer>res, int l, int h) {
            // base case: if l > h return
            // Hypo: get mid and add arr[mid] to res
            // Recursive call: recur for l to mid - 1
            // recur for mid + 1 to h

            if(l > h) return;
            int mid = l + (h-l)/2;
            res.add(arr[mid]);
            sortedArrayToBST(arr, res, l, mid - 1);
            sortedArrayToBST(arr, res, mid + 1, h);
        }

        public static int kthLargestInBST(Node root, int k) {
            // given a tree and a value k, find the kth largest element in BST
            // one idea is to use min heap of size k
            // we can also do reverse inorder traversal
            // store the traversal in an array
            // return the kth element in the array

            ArrayList<Integer> list = new ArrayList<>();
            reverseInOrder(root, list, k);
            return list.get(0);
        }

        public static void reverseInOrder(Node root, ArrayList<Integer> list, int k) {
            if(root == null) return;
            reverseInOrder(root.right, list, k-1);
            if(k == 0) {
                list.add(root.data);
                return;
            }
            //list.add(root.data);
            reverseInOrder(root.left, list, k-1);
        }

        public static Node insert(Node root, int k) {

            // Base case:
            if(root == null)  {
                Node node = new Node(k);
                return node;
            };

            if(root.data == k) return root;

            // Hypo:
            if(k > root.data)  root.right = insert(root.right, k);
            else root.left = insert(root.left, k);

            return root;
        }

        public static int isPairPresent(Node root, int k) {
            ArrayList<Integer> arr = new ArrayList<>();
            inOrder(root, arr);

            int l = 0, h = arr.size()  - 1;
            while (l < h) {
                if(arr.get(l) + arr.get(h) ==  k)  return 1;
                else if(arr.get(l) + arr.get(h) < k) l++;
                else h--;
            }

            return 0;
        }

        public static Node deleteNode(Node root, int x) {
            // given a BST and a value x, delete that node with x
            // there are 3 cases:
            // 1. deletion of leaf node
            // 2. deletion of node with 1 child
            // 3. deletion of node with > 1 child
            // case 1 is simple, root as null and return it
            // case 2, make tmp as root
            // root as non null child of it
            // make tmp as null and return root
            // case 3, find min in the left subtree
            // we're taking min so as to prevent rebalancing of BST
            // find min in left subtree
            // copy it's data in root
            // now call delete with root's right and tmp's data

            if(root == null) return null;
            if(x > root.data) deleteNode(root.right, x);
            else if(x < root.data) deleteNode(root.left, x);
            else {
                // found x
                // case 1
                if(root.left == null && root.right ==  null) {
                    root = null;
                }
                // case 2
                else if(root.left == null) {
                    Node tmp = root;
                    root = root.right;
                    tmp = null;
                }

                else if(root.right == null) {
                    Node tmp = root;
                    root = root.left;
                    tmp = null;
                }

                // case 3
                else {
                    Node tmp = findMin(root.right);
                    root.data = tmp.data;
                    root.right = deleteNode(root.right, tmp.data);
                }
            }
            return root;
        }
        
        public static Node findMin(Node root) {
            while(root.left != null) root = root.left;
            return root;
        }
        
        public static boolean isBST (Node root) {
            return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public static boolean isBST (Node root, int min, int max){
                if(root == null) return true;
                if(root.data < min || root.data > max) return false;

                return isBST(root.left, min, root.data - 1)
                        && isBST(root.right, root.data  + 1, max);
        }

        public static List<Integer> merge2BST(Node root1, Node root2) {
            List<Integer> tree1 = new ArrayList<>(), tree2 = new ArrayList<>();
            inOrder(root1, tree1);
            inOrder(root2, tree2);
            List<Integer> res = new ArrayList<>();

            int i = 0, j = 0;
            int n1 = tree1.size(), n2 = tree2.size();

            while (i < n1 && j < n2) {
                if(tree1.get(i) < tree2.get(j)) {
                    res.add(tree1.get(i));
                    i++;

                }
                else {
                    res.add(tree2.get(j));
                    j++;

                }
            }

            while(i < n1) {
                res.add(tree1.get(i++));
            }

            while(j < n2) {
                res.add(tree2.get(j++));
            }

            return res;
        }

       static class Result {
            int ans;
            int i;
       }

        public static int maxDiff(Node root, int k) {
            Result result = new Result();
            result.ans = Integer.MAX_VALUE;
            maxDiff(root, k, result);
            return result.ans;
        }

        public static void maxDiff(Node root, int k, Result res) {
            if(root == null) return;
            maxDiff(root.left, k, res);
            res.ans = Math.min(res.ans, Math.abs(root.data - k));
            maxDiff(root.right, k, res);
        }

        static class BSTPair {
            int min, max, size;
            Node root;
            boolean isBST;

            public BSTPair() {
                min = Integer.MIN_VALUE;
                max = Integer.MAX_VALUE;
                root = null;
                size = 0;
                isBST = true;
            }
        }

        public static int largestBST(Node root) {
            BSTPair res = largestbst(root);
            return res.size;
        }

        public static BSTPair largestbst(Node root) {
            // given a binary tree, find the size of the largest BST which is a subtree of it
            // if the entire tree is bst, return the size of the entire tree

            if(root == null) {
                return new BSTPair();
            }

            BSTPair l = largestbst(root.left);
            BSTPair r = largestbst(root.right);
            BSTPair p = new BSTPair();

            if(!r.isBST || !l.isBST || l.max >= root.data || r.min <= root.data) {
                p.isBST = false;
                p.size = Math.max(l.size , r.size);
                return p;
            }

            p.isBST = true;
            p.size = l.size + r.size + 1;

            p.min = root.left != null ? l.min : root.data;
            p.max = root.right != null ? r.max : root.data;

            return p;
        }

        static Node last, prev, middle, first;

        public static Node correctBST(Node root) {
            // given a BST, 2 nodes are in incorrect position, swap them back to fix the BST
            // store the inorder traversal of tree in array
            // there will be at most 2 places where increasing order won't be there
            // take 3 pointers to store those elements
            // first, last and middle, prev is used for traversal and storing prev value
            // correctBSTUtil() will fill values of first, last and middle
            // first denotes first value to be swapped
            // middle/last denote second value to be swapped
            // swap either first & last or first & middle

            last = prev = middle = first  = null;

            correctBSTUtil(root);

            if(first != null && last != null) {
                int temp = first.data;
                first.data = last.data;
                last.data = temp;
            }

            else if(first != null && middle != null) {
                int temp = first.data;
                first.data = middle.data;
                middle.data = temp;
            }

            return root;
        }

        public static void correctBSTUtil(Node root) {
            // traverse LRoR
            // check if prev's data > root's data
            // if yes, check if first == null, if so,
            // first = prev and middle = root
            // else last = root
            // traverse by keeping prev = root
            // and recur for right

            if(root != null) {
                correctBSTUtil(root.left);

                if(prev != null && root.data < prev.data)
                {
                        // check for first violation
                    if(first == null) {
                        first = prev;
                        middle = root;
                    }

                    else last = root;
                }

                prev = root;

                correctBSTUtil(root.right);
            }
        }

        public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
            // given a connected undirected graph, print the dfs of it
            // create a visited arr to mark nodes as visited
            // first mark the given node as visited
            // add the node to the ans
            // traverse through the list of connections for that node
            // check the connections are unvisited, recur for that connection

            boolean[] visited = new boolean[v];
            ArrayList<Integer> res = new ArrayList<>();
            dfsOfGraph(0, adj, visited, res);

            return res;
        }

        public static void dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj,
                                      boolean[] vis, ArrayList<Integer> res) {
            vis[v] = true;
            res.add(v);
            for (int i:adj.get(v)) {
                if(!vis[i]) {
                    dfsOfGraph(i, adj, vis, res);
                }
            }
        }

        public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // given a connected graph, find the bfs of it
            // idea is to add all the connections of a node first and then add for others
            // create a q and add 0
            // mark 0 as visited
            // while q is full,
            // poll the q and add it to res
            // traverse through the tmp's conn and check if it's not visited
            // mark it as visited and
            // add them to q

            ArrayList<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[V];
            bfsOfGraph(V, adj, res, visited);
            return res;
        }

        public static void bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj,
                                      ArrayList<Integer> res, boolean[] visited)
        {
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            visited[0] = true;

            while(!q.isEmpty()) {
                int tmp = q.poll();
                res.add(tmp);
                for(int e: adj.get(tmp)) {
                    if(!visited[e]) {
                        visited[e] = true;
                        q.add(e);
                    }
                }
            }

        }

        public static boolean prerequisiteTasks(int n, int[][] prerequisite) {
            // given a 2d array of prerequisites such that
            // a[i][1] is a prerequisite for a[i][0] to be completed
            // determine whether it's possible to complete all tasks
            // detect whether there's a cycle in the graph

            // create a map of int vs set<int> as adj list
            // create a grey set to determine the visiting vertices
            // create a black set to determine the visited vertices

            HashMap<Integer, Set<Integer>> adj = new HashMap<>();
            Set<Integer> greySet = new HashSet<>();
            Set<Integer> blackSet = new HashSet<>();

            // create adj map
            for (int i = 0; i < n; i++) {
                adj.put(i, new HashSet<>());
            }

            for (int i = 0; i < prerequisite.length; i++) {
                adj.get(prerequisite[i][1]).add(prerequisite[i][0]);
            }

            // detect whether there is a cycle or not
            // iterate through all vertices
            for (int i = 0; i < n; i++) {
                boolean hasCycle = detectCycle(i, greySet, blackSet, adj);
                if(hasCycle) return false;
            }

            return true;
        }


        static boolean detectCycle(int i, Set<Integer> greySet, Set<Integer> blackSet, HashMap<Integer, Set<Integer>> adj) {
            // if vertex is already visited, return false

            if(blackSet.contains(i)) return false;

            // if vertex is already visiting, meaning some other conn. add it to
            // grey set, return true

            if(greySet.contains(i)) return true;

            // add it to visiting

            greySet.add(i);

            // iterate through all it's conn
            for (Integer e: adj.get(i)) {
                if(!blackSet.contains(e)) {
                boolean ans = detectCycle(e, greySet, blackSet, adj);
                if(ans) return true;
                }
            }

            // move from gray set to black set
            greySet.remove(i);
            blackSet.add(i);

            return false;
        }

        public static int findMaxArea(int[][] arr) {
            // given a 2d array, find area of largest region of 1's
            // largest region means 8 way connected 1's

            // will use class Result as we need to pass by reference
            // iterate through arr to find 1
            // to count only connected 1's, make result.ans = 0
            // as 1st statement after 2 loops
            // as soon as found 1, call findMAxArea(i,j,result)
            // check for out of bounds, if it is out of bounds return
            // else result.ans++
            // mark arr[i][j] = 0 to prevent recalculating it
            // recur for 8 connected neighbours

            int n = arr.length, m = arr[0].length;

            int res = -1;

            // pass result by reference
            Result result = new Result();
            result.ans = 0;


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result.ans = 0;
                    if(arr[i][j] == 1) {
                       findMaxArea(i, j, result, arr);
                       res = Math.max(res, result.ans);
                    }
                }
            }


            return res;
        }

        public static void findMaxArea(int i, int j, Result result, int[][] arr) {
            // if a[i][j] is 1, count++
            // do dfs of all 8 neighbours

            if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 || arr[i][j] == 2)
                return;

            result.ans++;

            arr[i][j] = 2;

            findMaxArea(i - 1, j - 1, result, arr);

            findMaxArea(i - 1, j, result, arr);

            findMaxArea(i - 1, j + 1, result, arr);

            findMaxArea(i, j - 1, result, arr);

            findMaxArea(i, j + 1, result, arr);

            findMaxArea(i + 1, j - 1, result, arr);

            findMaxArea(i + 1, j, result, arr);

            findMaxArea(i + 1, j + 1, result, arr);

        }


        public static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
            // given an adj list, create a min spanning tree and return the total weight
            // Kruskal's algo:
            // 1. sort the edges in asc. order
            // 2. pick the edge with min weight. check if it creates cycle
            // if not, add it to set
            // 3. repeat step 2 until we've v-1 edges
            // create classes edge and DS
            // create a list of edge from adj
            // create a list of DS
            // run a loop from 0 to v, init parent as -1 and rank as 0
            // sort the edges list
            // while i < v-1 && j < e
            // get fromP and toP using find()
            // check if fromP and toP are same, i.e check if there's a cycle
            // if yes, continue, j++
            // else union()
            // add the vertex to set

            List<Edge> edges = new ArrayList<>();
            List<DS> ds = new ArrayList<>();
            Set<Edge> mst = new HashSet<>();

            for (int i = 0; i < adj.size(); i++) {
                Edge edge = new Edge();
                edge.setSrc(i);
                for(ArrayList<Integer> l : adj.get(i)) {
                    edge.setDest(l.get(0));
                    edge.setWeight(l.get(1));
                }
                edges.add(edge);
            }

            System.out.println("edges = " + edges);

            for (int i = 0; i < v; i++) {
                DS dset = new DS();
                dset.setParent(-1);
                dset.setRank(0);
                ds.add(dset);
            }

            System.out.println("ds = " + ds);

            kruskal(edges, ds, v, mst);

            int ans = 0;
            for(Edge e : mst) {
                ans += e.getWeight();
            }
            return ans;
        }

        static void kruskal(List<Edge> edges, List<DS> ds, int v, Set<Edge> mst) {
            edges.sort(Comparator.comparingInt(Edge::getWeight));

            int i = 0, j= 0;
            int e = v;

            while(i < v-1 && j < e) {
                int fromP = DSFind(edges.get(j).getSrc(), ds);
                int toP = DSFind(edges.get(j).getDest(), ds);

                if(fromP == toP) {
                    j++;
                    continue;
                }

                else DSUnion(fromP, toP, ds);

                mst.add(edges.get(j));
                ++i;
            }
        }

        static int DSFind(int v, List<DS> ds) {
            if(ds.get(v).getParent() == -1) return v;

            int parent = DSFind(ds.get(v).getParent(), ds);
            ds.get(v).setParent(parent);
            return parent;
        }

        static void DSUnion(int fromP, int toP, List<DS> ds) {
                if(ds.get(fromP).getRank() > ds.get(toP).getRank()) {
                    ds.get(toP).setParent(fromP);
                }

                else if(ds.get(toP).getRank() > ds.get(fromP).getRank()) {
                    ds.get(fromP).setParent(toP);
                }

                else {
                    ds.get(fromP).setParent(toP);
                    int rank = ds.get(toP).getRank();
                    ds.get(toP).setRank(rank + 1);
                }
        }

        public static boolean isWordExist(char[][] arr, String word){
            // given a 2d arr of chars and a word, find whether word exists
            // word can only be created using 4 neighbours, 1 up, 1 down, 1 left, 1 right
            // use dfs here
            // traverse through the 2d array and as soon as first char is found
            // we will start applying dfs() on it
            // in dfs, we will check for bounds and special char and equal char
            // if not met, return
            // count++
            // arr[i][j] = ' ' to mark it as visited
            // recur for 4 neighbours
            // finally, if count == word.length() return true

            int n = arr.length;
            int m = arr[0].length;

            Result result = new Result();
            result.i = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //result.ans = 0;
                    result.i = 0;
                    if(arr[i][j] == word.charAt(0)) {
                        //arr[i][j] = ' ';
                        dfs(i , j, result, arr, word);
                        if(result.ans == word.length()) return true;
                        result.ans = 0;
                    }
                }
            }

            return false;
        }

        public static void dfs(int i, int j, Result result, char[][] arr, String s) {
            if(result.i == s.length()) return;
            if(i < 0 || i>= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == ' ' ||
                    arr[i][j] != s.charAt(result.i))
                return;
            result.ans++;
            arr[i][j] = ' ';
            result.i++;
            dfs(i - 1, j, result, arr, s);
            dfs(i + 1, j, result, arr, s);
            dfs(i, j - 1, result, arr,s);
            dfs(i, j + 1, result, arr, s);
        }

        public static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
            // given a directed graph, find out it's topological sorting
            // topological sort for a directed edge from u to v, u becomes before v in sort
            // sort the vertices by the number of indegrees in asc. order

            // similar to dfs
            // just add it to stack at the end
            // the vertex with the most indegree will be at the bottom of stack
            // the vertex with least indegree at the top

            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                if(!visited[i]) topoSort(i, adj, stack, visited);
            }

            Collections.reverse(stack);
            return stack.subList(0, stack.size()).stream().mapToInt(i -> i).toArray();
        }

        public static void topoSort(int v, ArrayList<ArrayList<Integer>> adj,
                                    Stack<Integer> stack, boolean[] visited) {

            visited[v] = true;
            for(int e : adj.get(v)) {
                if(!visited[e]) topoSort(e, adj, stack, visited);
            }
            stack.push(v);
        }

        public static int numIslands(char[][] arr) {
            // given a 2d array of land (1's) and water (0's)
            // find no. of islands
            // an island is land surrounded by water and is connected to 8 adj. lands

            // use dfs
            // use Result class to pass by ref
            // iterate through the arr
            // as soon as found 1, dfs
            // in dfs, check for boundary condt. or arr[i][j] == ' ' to mark visited
            // or arr[i][j] == 0 return
            // else update result's count
            // recur for 8 connected neighbours

            int n = arr.length, m = arr[0].length;
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == '1') {
                        count++;
                        numIslands(i, j, arr);
                    }
                }
            }

            return count;
        }

        public static void numIslands(int i, int j, char[][] arr) {
            if(i < 0 || i >= arr.length || j < 0 || j>= arr[0].length || arr[i][j] != '1')
                return;

            arr[i][j] = '0';
            numIslands(i-1, j-1, arr);
            numIslands(i-1, j, arr);
            numIslands(i-1, j+1, arr);

            numIslands(i, j-1, arr);
            numIslands(i, j+1, arr);

            numIslands(i+1, j-1, arr);
            numIslands(i+1, j, arr);
            numIslands(i+1, j+1, arr);
        }

        public static int nthGeekoNacci(int a, int b, int c, int n) {
            // given 4 numbers a, b, c and n find nth geekonacci number
            // a geekonacci number is sum of previous 3 numbers
            // i.e f(n) = f(n-1) + f(n-2) + f(n-3)

            if(n == 1) return a;
            if(n == 2) return b;
            if(n == 3) return c;

            int n1 = nthGeekoNacci(a, b, c, n-1);
            int n2 = nthGeekoNacci(a, b, c, n-2);
            int n3 = nthGeekoNacci(a, b, c, n-3);

            return n1 + n2+ n3;
        }

        public static String removeDups(String s) {
            // given a string remove dups from it only keep first occurrence of the dup
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
                else {
                    if(sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
                        sb.append(s.charAt(i));
                    }
                }
            }

            return sb.toString();
        }

        public static int closing(String s, int pos) {
            // given a string with '[' and ']' and the pos of [
            // find the index of the ]

            int o = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '[' && i >= pos) o++;
                else if(s.charAt(i) == ']' && o > 0) {
                    o--;
                    if(o == 0) return i;
                }
            }

            return -1;
        }

        public static int minChangesToMakeSubStringDistinct(String s) {
            // given a string, find out how many changes needs to be
            // done to make all substrings distinct

            int n = s.length();
            HashMap<Character,Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            int ans = 0;
            for (Integer r:map.values()) {
                ans += r-1;
            }

            return ans;
        }

        public static String[] wordBoggle(char[][] board, String[] dict) {
            // given a string arr of words as dict, & a 2d array
            // return the strings of dict present in the board

            int n = dict.length;
            ArrayList<String> res = new ArrayList<>();
            boolean[][] visited = new boolean[board.length][board[0].length];


            for (int i = 0; i < n; i++) {
                if(isWordPresent(new StringBuilder(dict[i]), board, new StringBuilder(dict[i]), visited)) {
                        res.add(dict[i]);
                }
            }

            return res.toArray(new String[0]);
        }

        public static boolean isWordPresent(StringBuilder sb, char[][] board,
                                            StringBuilder original, boolean[][] visited){
            int n = board.length, m = board[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == sb.charAt(0)) {
                        dfs(i, j, sb, board, visited);
                        if(sb.length() == 0) return true;
                        System.out.println("failed char = " + board[i][j]);
//                        int index = original.indexOf(String.valueOf(board[i][j]));
//                        sb = new StringBuilder(original.substring(index + 1));
                        sb = original;
                        visited[i][j] = false;
                    }
                }
            }
            return false;
        }

        public static void dfs(int i, int j, StringBuilder sb, char[][] board, boolean[][] visited) {
            if(i < 0 || i >= board.length || j < 0 || j>= board[0].length || visited[i][j]
                    || sb.length() == 0 || board[i][j] != sb.charAt(0))
                return;
            visited[i][j] = true;
            sb.deleteCharAt(0);
            dfs(i - 1, j - 1, sb, board, visited);
            dfs(i - 1, j, sb, board, visited);
            dfs(i - 1, j + 1, sb, board, visited);

            dfs(i, j - 1, sb, board, visited);
            dfs(i, j + 1, sb, board, visited);

            dfs(i + 1, j - 1, sb, board, visited);
            dfs(i + 1, j, sb, board, visited);
            dfs(i + 1, j + 1, sb, board, visited);
        }



        public static boolean rotAdj(int i, int j, int n, int m, int[][] arr) {
            if(i >= 0 && i < n && j >= 0 && j < m){
                   if(arr[i][j] == 1) {
                       arr[i][j] = 2;
                       return true;
                   }
            }
            return false;
        }

        public static void addToQ(int i, int j, int time, Queue<Orange> q) {
            Orange orange = new Orange(i, j, time);
            q.add(orange);
        }

        static class Orange {
            int i,j;
            int time;

            public Orange(int i, int j, int time) {
                this.i = i;
                this.j = j;
                this.time = time;
            }

            public Orange() {

            }
        }

        public static boolean isAMatch(Character a, Character b) {
            if(a == '(' && b == ')') return true;
            if(a == '{' && b == '}') return true;
            if(a == '[' && b == ']') return true;

            return false;
        }

        public static int countCommon(LinkedListNode a, LinkedListNode b) {
            int count = 0;

            for (; a!= null && b!= null; a = a.next, b = b.next) {
                if(a.data == b.data) count++;
                else break;
            }

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("count = " + count);

            return count;
        }

        public static void reverseLL(LinkedListNode curr) {
            LinkedListNode prev = null;
            LinkedListNode next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }

        public static boolean compareLL (LinkedListNode headA, LinkedListNode headB){
            LinkedListNode ptrA = headA, ptrB = headB;

            while (ptrA != null && ptrB != null) {
                if(ptrA.data == ptrB.data) {
                    ptrA = ptrA.next;
                    ptrB = ptrB.next;
                }
                else return false;
            }

            if(ptrA == null && ptrB == null) return true;

            return false;
        }

        static class DistanceComparator implements Comparator<DistancePair> {

            @Override
            public int compare(DistancePair o1, DistancePair o2) {
                // need desc. order so o2-o1
                return o2.getDistance() - o1.getDistance();
            }
        }

        static class DistancePair {
            int distance;
            Pair coordinates;

            public DistancePair() {
            }

            public DistancePair(int distance, Pair coordinates) {
                this.distance = distance;
                this.coordinates = coordinates;
            }

            public int getDistance() {
                return distance;
            }

            public Pair getCoordinates() {
                return coordinates;
            }
        }

        static class FreqPairDescendingComp implements Comparator<Pair> {

            @Override
            public int compare(Pair o1, Pair o2) {
                // return the descending order
                if(o1.getKey() > o2.getKey()) return -1;
                else if(o2.getKey() > o1.getKey()) return 1;
                return o1.getValue() - o2.getValue();
            }
        }

        static class FreqPairComparator implements Comparator<Pair> {

            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getKey() - o2.getKey();
            }
        }

        static class DiffPairComparator implements Comparator<Pair> {

            @Override
            public int compare(Pair o1, Pair o2) {
                // o2 - o1 for descending order of key
               return o2.getKey() - o1.getKey();
            }
        }
        static class Pair {
            int key, value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public Pair() {
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
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



