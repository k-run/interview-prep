import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ClassA {
    static int[] a;
    static String s = "lmno";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] strArr = bufferedReader.readLine().split(" ");
//        Integer[] arr = new Integer[strArr.length];
//
//        for (int i = 0; i < strArr.length; i++) {
//            arr[i] = Integer.parseInt(strArr[i]);
//        }
//
//        int p = Integer.parseInt(bufferedReader.readLine());
//        List<String> coldWarsList = new ArrayList<>();
//
//        while(p-- > 0) {
//            String[] pArr = bufferedReader.readLine().split(" ");
//            int member1 = Integer.parseInt(pArr[0]) - 1;
//            int member2 = Integer.parseInt(pArr[1]) - 1;
//            coldWarsList.add(String.valueOf(member1) + String.valueOf(member2));
//        }
//
//        tripToGoa(arr, coldWarsList);
      int[] type = new int[]{0,1,0,1};
      int[] left = new int[]{1,1,0,3};
      int[] right = new int[]{3,2,4,4};
      arrayQueries(5,type,left, right);
    }

    public static int readInt(BufferedReader bufferedReader) throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void maxNumber(int[] arr) {
        int divisor = 10, n = arr.length;
        Stack<Integer> maxNumberStack = new Stack<>();
        //maxNumberStack.push(arr[0]);

        String res = "";
        String stackres = "";
        while (arr[0] / divisor != 0) {
            arr[0] = arr[0] / divisor;
            divisor = divisor * 10;

        }
        System.out.println("divisor: " + divisor);

        maxNumberStack.push(arr[0] / divisor);

        for (int i = 1; i < n; i++) {
            if (!maxNumberStack.contains(Math.max(maxNumberStack.peek(), arr[i] % divisor)))
                maxNumberStack.push(Math.max(maxNumberStack.peek(), arr[i] % divisor));
            else {
                res += String.valueOf(arr[i]);
            }

        }

        System.out.println(maxNumberStack);

        while (!maxNumberStack.empty()) {
            stackres += String.valueOf(maxNumberStack.pop());
        }
        System.out.println("Stack seqList: " + stackres);

        System.out.println(stackres + res);
    }


    public static void top3(HashMap<String, Integer> nameHoursMap) {
        nameHoursMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
    }


    public static void nextNumberOf2n(double n) {
        List<Double> twoNList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            double t = Math.round(Math.pow(2, i));

            if (!twoNList.contains(t)) twoNList.add(t);
            double t1 = Math.round(Math.pow(2, i) + 1);

            if (!twoNList.contains(t1)) twoNList.add(t1);
        }

        System.out.println(twoNList);

        List<Double> onesList = new ArrayList<>();
        onesList.add(1D);
        for (double i = 3; i <= n; i *= 2) {
            onesList.add(i);
        }
        System.out.println(onesList);

        //2n and 2n+1 numbers
        if (twoNList.contains(n) && !onesList.contains(n)) System.out.println((int) n);
        else {
            // Numbers like 3
            System.out.println(twoNList.stream().filter(e -> e > n).findFirst().get().intValue());
        }


    }

    public static void sumitAndMaths(long n, long a, long b, long c) {
        long gcdAB = getGCD(a, b);
        long gcdBC = getGCD(b, c);
        long gcdAC = getGCD(a, c);

        long lcmAB = (a * b) / gcdAB;
        long lcmBC = (b * c) / gcdBC;
        long lcmAC = (a * c) / gcdAC;

        // lcmABC = a * b * c/ getGCD(a,b
        long lcmABC = (a * lcmBC) / getGCD(a, lcmBC);


        long ans = (n / a) + (n / b) + (n / c) - (n / lcmAB) - (n / lcmBC) - (n / lcmAC) + (n / lcmABC);
        System.out.println(ans);
    }

    public static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
//
//    public static void testingStrings(int m, int k, int l, int r, int z) {
//        int[] res = new int[m];
//
//        for (int i = 0; i <= l - 1; i++) {
//            res[i] = k;
//        }
//
//        for (int i = r - 1; i < res.length; i++) {
//            res[i] = k;
//        }
//
//        //Middle operation
//        for (int i = l - 1; i <= r - 1; i++) {
//            res[i] = (k - z);
//        }
//
//        //Arrays.stream(seqList).forEach(value -> System.out.print(value + " "));
//        value += Arrays.stream(res).reduce(1, (a, b) -> (a * b));
//
//    }
//
//    public static void printTestingStringRes(){
//        System.out.println(value % (Math.pow(10, 6) + 3));
//
//    }

    public static boolean permuteArray(int[] arr, int K) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = arr.length, z = n / K;
        for (int i = 0; i < n; i++) {
            freqMap.merge(arr[i], 1, Integer::sum);
        }

        System.out.println(freqMap);

        return freqMap.values().stream().allMatch(e -> e % z == 0);
    }


    public static void LAL(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n - 1, ans = 0;

        while (i < j) {
            if (arr[i] + arr[j] == k) {

                if (arr[i] == arr[j]) {
                    int c = (j - i);
                    ans += (c) * (c + 1) / 2;
                    break;
                } else {
                    int ci = 1, cj = 1;
                    int i2 = i + 1, j2 = j - 1;

                    while (arr[i] == arr[i2] && i2 < j) {
                        i2++;
                        ci++;
                    }

                    while (arr[j] == arr[j2] && j2 > i) {
                        j2--;
                        cj++;
                    }

                    ans += ci * cj;

                    i++;
                    j--;
                }
            } else if (arr[i] + arr[j] < k) i++;
            else j--;
        }

        System.out.println(ans);
    }

    public static void goodString(String s) {
        String res = "";
        String aeiou = "aeiou";

        for (int i = 0; i < s.length(); i++) {
            if (aeiou.indexOf(s.charAt(i)) != -1) {
                String sub = s.substring(i, i + 1);
                int j = i + 1;
                while (j < s.length() && aeiou.indexOf(s.charAt(j)) != -1) {
                    sub += String.valueOf(s.charAt(j));
                    j++;
                }


                if (j < s.length()) {
                    i = j + 1;
                    res = (res.length() > sub.length()) ? res : sub;
                } else res = sub;
            }

        }

        System.out.println("seqList = " + res);
    }


    public static void elementsDriver(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        a = new int[max + 1];
        elements(arr, 0, 1, n);
        //Arrays.stream(a).forEach(e-> System.out.print(e + " "));
    }

    public static void elements(int[] arr, int i, int j, int n) {
        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
        System.out.println();
        if (i == n - 1) return;

        if (Math.abs(arr[i] - arr[j]) <= 1) {
            j = i + 1;

            if (Math.abs(arr[i] - arr[i + 1]) == 0) {
                while (arr[i] == arr[j]) j++;
                elements(arr, j, j + 1, n);
            } else if (Math.abs(arr[i] - arr[j]) == 1) {
                if (a[arr[i]] == 0 && a[arr[j]] == 0) {
                    a[arr[i]] = 1;
                    a[arr[j]] = 1;
                } else if (a[arr[j]] != 0) {
                    a[arr[j]] = 2;
                    a[arr[i]] = 0;
                } else {
                    a[arr[i]] = 2;
                    a[arr[j]] = 0;
                }

                elements(arr, i, j + 1, n);
            } else elements(arr, i + 1, j + 1, n);
        } else elements(arr, i + 1, j, n);
    }


    public static void dynamicArray(int n, List<List<Integer>> query) {
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAsnwer = 0;

        for (int i = 0; i < query.size(); i++) {
            int operation = query.get(i).get(0);
            int x = query.get(i).get(1);
            int y = query.get(i).get(2);

            //System.out.println("last ans: " + lastAsnwer);
            //System.out.println("x: " + x);

            int seq = (x ^ lastAsnwer) % n;
            //System.out.println("seq: " + seq);


            if (operation == 1) {
                List<Integer> value = new ArrayList<>();
                value.add(y);
                if (seqList.size() > seq) seqList.get(seq).add(y);
                else seqList.add(seq, value);
                //System.out.println(seqList);
            } else {
                int index = y;
                lastAsnwer = seqList.get(seq).get(index % seqList.get(seq).size());
                //lastAsnwer = seqList.get(seq).get(y%seqList.get(seq).size());
                System.out.println(lastAsnwer);
            }
        }

    }


    public static void maxValueForEx(int[] arr, int n) {
        int max = 0;
        int i = 0, j = n - 1;

        while (i <= j) {
            int sum = Math.abs(arr[i] - arr[j]) + Math.abs(i - j);
            max = Math.max(sum, max);
            if (arr[j - 1] > arr[j]) j--;
            else i++;
        }
        System.out.println(max);
    }

    public static void urlify(String str) {
        String res = str.replaceAll(" ", "%20");
        System.out.println("res: " + res);
        str = res;
        str = "radra, aabbaa";
        System.out.println("str: " + str);
    }

    public static void paliPermutation(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        if (n % 2 == 0) {
            System.out.println(map.values().stream().noneMatch(e -> e % 2 != 0));
        } else {
            System.out.println(map.values().stream().filter(e -> e % 2 != 0).count() == 1);
        }
    }

    public static void oneAway(String a, String b) {
        int m = a.length(), n = b.length();
        int editCount = 0;

        for (int i = 0; i < Math.min(m, n); i++) {
            if (editCount > 1) break;

            if (m <= n) {
                if (b.indexOf(a.charAt(i)) == -1) editCount++;
            } else {
                if (a.indexOf(b.charAt(i)) == -1) editCount++;
            }
        }

        if (editCount <= 1) System.out.println("True");
        else System.out.println("False");
    }

    public static void stringCompression(String str) {
        StringBuilder res = new StringBuilder();
        int i = 0, n = str.length(), j = 1, count;

        for (i = 0; i < n && j < n; ) {
            count = 1;
            while (j < n && str.charAt(i) == str.charAt(j)) {
                count++;
                j++;
            }
            res.append(str.charAt(i));
            res.append(count);

            i = j;
            j = j + 1;
        }

        System.out.println(res.length() > str.length() ? str : res);
    }

    public static void zeroMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        List<Pair> positionsList = new ArrayList<>();

        System.out.println("m: " + m);
        System.out.println("n: " + n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    positionsList.add(pair);
                }
            }
        }
        System.out.println(positionsList);
        zeroFi(arr, positionsList, m, n);
    }


    public static void zeroFi(int[][] arr, List<Pair> positionsList,int m, int n) {
        for (Pair pair : positionsList) {
            int i = (int) pair.getKey();
            int j = (int) pair.getValue();

                int row = i, k = 0;
                while (k < n) {
                    arr[row][k++] = 0;
                }

                System.out.println(Arrays.deepToString(arr));
                k = 0;

                System.out.println("i: " + i);
                System.out.println("j: " + j);

                while (k < m) {
                    arr[k++][j] = 0;
                }
            }

        System.out.println(Arrays.deepToString(arr));
        }


    public static boolean stringRotation(String str1, String str2){
        int m = str1.length(), n = str2.length();
        if(m!=n) return false;
        else {
            for (int i = 0; i < m; i++) {
                if(str1.indexOf(str2.charAt(i)) == -1 || str2.indexOf(str1.charAt(i)) == -1) return false;
            }
        }
        return true;
    }

    public static int magicIndexDriver(int[] arr){
        int n = arr.length;
        int l = 0 , h = n - 1;
        return magicIndex(arr, l, h);
    }

    public static int magicIndex(int[] arr, int l, int h){
        if(l > h) return -1;
        int m = (l + h)/2;

        if(arr[m] == m) return m;

        else if(arr[m] > m) {
            l = m + 1;
            return magicIndex(arr, l, h);
        }
        else {
            h = m - 1;
            return magicIndex(arr, l, h);
        }
    }


    public static void recursiveMulti(int a, int b){
        //int orRes = a | b;
        System.out.println(a << 1);
//        int lshift = orRes << 1;
//        System.out.println((orRes | lshift) << 1);
    }

    public static void binarySearchMatrixDriver(int[][] arr, int x){
        int col = arr[0].length;
        int row = arr.length;
        int i = 0;
        System.out.println(binarySearchMatrix(arr,x,i,col));
    }

    public static Pair binarySearchMatrix(int[][] arr, int x, int i, int col){
        if(x > arr[i][col-1]) {
            System.out.println("max val in row: " + arr[i][col-1]);
            i++;
            binarySearchMatrix(arr, x, i, col);
        }

        else if(x < arr[i][col-1]) {
            System.out.println("Value should be in this row");
            int l = 0, h = col - 1;
            while (l <= h) {

                int m = (l + h) / 2;

                System.out.println("l: " + l);
                System.out.println("h: " + h);
                System.out.println("m: " + m);

                if (arr[i][m] == x) {
                    System.out.println("Value found at : (" + i + "," + m + ")");
                    return new Pair<>(i, m);
                } else if (arr[i][m] > x) {
                   h = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
        }

        else {
            return new Pair<>(i, col-1);
        }

        return new Pair<>(-1,-1);
    }


//    public static void smallestDifference(int[] a,int[] b){
//        Arrays.sort(a);
//        Arrays.sort(b);
//
//        int min2 = b[0];
//        int res = 0;
//
//        int pos = binarySearch(a,min2);
//        System.out.println("pos: " + pos);
//        int n = a.length , m = b.length;
//
//        if(pos == n) res = Math.max(a[pos - 1] - b[0], res);
//        else if(pos == 0) res = Math.max(a[pos] - b[0], res);
//        else {
//            int i = pos, j = 0;
//
//            while(b[j] < a[i]) {
//                while (i < n) {
//                    res = Math.min(res, a[i++] - b[j]);
//                }
//                i = pos;
//                j++;
//            }
//        }
//
//        System.out.println(res);
//    }

    public static int binarySearch(Integer[] arr, int x){
        // returning l depending on use case
        // Here the exact position of x in arr is needed

        // now returning x depending on use case
        // Here the element itself is required

        int l = 0, n = arr.length, h = n - 1;
        while (l <= h) {
            int m = (l + h)/2;
            if(arr[m] == x) return arr[m];
            else if(arr[m] > x) h = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    public static int additionWithoutArithmetics(int a, int b){

        int sum = a ^ b;
        int carry = a & b;

        System.out.println("sum: " + sum);
        System.out.println("carry : " + carry);

        if(carry == 0) return sum;
        return additionWithoutArithmetics(sum, carry << 1);

    }



    public static void minDiffBeautyWorker(int[] arr, int[] q){
        HashMap<Integer, List<Integer>> elementPosMap = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if(!elementPosMap.containsKey(arr[i])){
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                elementPosMap.put(arr[i], pos);
            }
            else{
                elementPosMap.get(arr[i]).add(i);
            }
        }

        System.out.println(elementPosMap);


        for (int query:q) {
            minDiffBeautyResult(elementPosMap, query);
        }
    }


    public static void minDiffBeautyResult(HashMap<Integer, List<Integer>> map, int q) {
        if (!map.containsKey(q)) {
            System.out.println(-1);
        }
        else {

            List<Integer> list = map.get(q);
            int min = list.get(0);
            if(list.size() > 1) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < list.size() - 1; i++) {
                    min = Math.min(min, list.get(i + 1) - list.get(i));
                }
            }
            System.out.println(min);
        }

    }

//    public static void missingElements(int[] arr){
//        int n = arr.length;
//
//        int lastE = arr[n - 1];
//
//        for (int i = 1; i < lastE; i++) {
//
//            if(i == binarySearch(arr,i)) {
//                System.out.print(i + " ");
//            }
//        }
//
//    }


    public static void robTheHouses(int[] arr, int n){
        int[] carr = new int[2*n];
        int carrN = carr.length;

        int j = 0;


        for (int i = 0; i < carrN - 1; i++) {
            if(j == arr.length) j = 0;
            carr[i] = arr[j++];
        }

        Arrays.stream(carr).forEach(e -> System.out.print(e + " "));
        System.out.println();

        int ans = 0, sum = 0;
        for (int i = 0; i < carrN; i++) {
            sum += carr[i];
            //if(sum < 0) sum = 0;
            if(ans < sum) ans = sum;
        }

        System.out.println(ans);
    }


    public static void matrixRotation(int[][] arr){
        int m = arr[0].length;
        int n = arr.length;

        System.out.println("m: " + m);
        System.out.println("n: " + n);

        int rounds = m/2,  carryForward = 0;
        int c = 0, i= 0, j = m - 1;

        while(c < rounds){
            int start_i = i, start_j = j;

            // First Down
            while(i <= n - c - 2) {
               carryForward = slide(carryForward == 0 ? arr[i][j] : carryForward, arr[i+1][j], i+1, j, arr);
               i++;
            }


            printMatrix(arr);

            // Second Left
            while(j - c - 1 >= 0) {
                carryForward = slide(carryForward, arr[i][j - 1], i, j-1, arr);
                j--;
            }

            j = c;
            // Third Up
            while(i - c - 1>= 0) {
                carryForward = slide(carryForward, arr[i-1][j], i-1,j, arr);
                i--;
            }

            i = c;
            // Fourth Right
            while(j <= m - c - 2){
                carryForward = slide(carryForward, arr[i][j + 1], i, j +1, arr);
                j++;
            }

            c++;
            i++;
            j--;

            System.out.println("i: " + i);
            System.out.println("j: " + j);

            System.out.println("carryForward:" + carryForward);
            printMatrix(arr);
        }

        arr[i][j+1] = carryForward;

        printMatrix(arr);
    }

    // Put the first element in second's place
    public static int slide(int ele1, int ele2, int ele2Row, int ele2Col, int[][] arr){
        arr[ele2Row][ele2Col] = ele1;

        return ele2;
    }

    public static void printMatrix(int[][] arr){
        for (int[] a: arr) {
            for (int x: a) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static List<Integer> kMaxEntries(int[] arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(arr[i],1, Integer::sum);
        }

        int max = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        ArrayList<Integer>[] arr1 = (ArrayList<Integer>[]) new ArrayList[max + 1];

        //ArrayList<Integer[]> arr1 = new ArrayList<Integer[]>();

        for (int i = 1; i <= max ; i++) {
            arr1[i] = new ArrayList<Integer>();
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            int count = e.getValue();
            int number = e.getKey();
            arr1[count].add(number);
        }

        Arrays.stream(arr1).forEach(e -> System.out.print(e + " "));

        System.out.println();

        List<Integer> result = new ArrayList<>();

        for (int j = max; j >= 0; j--) {
            if(arr1[j].size() > 0) {
                for (int a:arr1[j]) {
                    result.add(a);

                    if(result.size() >= k) return result;
                }
            }
        }

        return result;

    }

    public static void count1s(int n){
        int c = 0;
        while(n > 0) {
            if(n % 10 == 1) c++;
            n = n/10;
        }
        System.out.println(c);
    }

    public static int containerWithMostWater(int[] height){
        int ans = 1, n = height.length;
        int max1 = height[0];
        int max2 = 2;
        int j = n - 1;
        for(int i=1;i<n && j>=0;i++) {
            if(height[i] >= max1) {

                max1 = height[i];
                if(height[j] < max1) max2 = Math.max(max2,height[j]);
                ans = Math.max(ans, Math.min(max2,max1) * (j-i));
            }
            j--;
            System.out.println("max1: " + max1);
            System.out.println("max2: " + max2);

        }


        return ans;
    }

    public static void plusOne(int[] arr){

        int[] res = new int[arr.length + 1];
        StringBuilder number = new StringBuilder();

        for (int a: arr) {
            number.append(a);
        }

        int n = Integer.parseInt(number.toString()) + 1;
        String ans = String.valueOf(n);

        System.out.println(ans);

        for (int i = 0; i < ans.length(); i++) {
            res[i] = Integer.valueOf(ans.split("")[i]);
        }

       Arrays.stream(Arrays.copyOfRange(res,0,ans.length())).forEach(e-> System.out.print(e));

    }

    public static void reArrange(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            if(arr[i] != -1) temp[arr[i]] = 1;
        }

        for (int i=0; i< temp.length;i++) {
            if(temp[i]==1) System.out.print(i + " ");
            else System.out.print(-1 + " ");
        }
    }



    public static void leftRotation(int[] arr, int d){
        int n = arr.length;
        int[] res;



        while (d-- > 0) {
            int temp = arr[0];

            for (int i = 1; i < n; i++) {
                arr[i-1] = arr[i];
            }

            arr[n-1] = temp;
        }

        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));

//        int j = n;
//
//        res = Arrays.copyOf(arr,n+d);
//        for (int i = 0; i < d; i++) {
//            res[j] = arr[i];
//            j++;
//        }
//
//        for (int i = d; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }
    }

    public static void sparseArrays(String[] strings, String[] queries){
        HashMap<String,Integer> map = new HashMap<>();
        for (String str: strings) {
           map.put(str, map.getOrDefault(str,0) + 1);
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (String q: queries) {
            if(map.containsKey(q)) res[i] = map.get(q);
            i++;
        }

        Arrays.stream(res).forEach(e-> System.out.print(e + " "));
    }

    public static void arrayManipulation(int n, int[][] queries){
        long[] arr = new long[n];


        int colLen = queries[0].length;
        int rowLen = queries.length;

        System.out.println("row[i]: " + rowLen);
        System.out.println("col :" + colLen);


        for (int i = 0; i < rowLen; i++) {
            int start_idx = queries[i][0] - 1;
            int end_idx = queries[i][1];
            int value = queries[i][2];

            arr[start_idx] += value;
            if(end_idx < n) arr[end_idx] -= value;

        }

        System.out.println(Arrays.stream(arr).max().getAsLong());

    }

    public static void reversePrint(List<LinkedListNode> head){
        Stack<Integer> stack = new Stack<>();

        for (LinkedListNode e: head) {
            stack.push(e.data);
        }
        while(!stack.empty()) System.out.println(stack.pop());

    }

    public static String balancedBrackets(String s) {
        if(s.length() % 2 != 0) return "NO";

        Stack<String> stack = new Stack<>();

        int i, n = s.length();
        for (i = 0; i < n; i++) {
            if(s.substring(i, i+1).equals("(") || s.substring(i, i+1).equals("{")
            || s.substring(i, i+1).equals("[")) {
                stack.push(s.substring(i, i+1));
            }

            else{
                if(stack.empty()) return "NO";

                String value = stack.peek();
                if (value.equals("(")) {
                    if(!s.substring(i, i+1).equals(")")) break;
                }
                else if(value.equals("{")) {
                    if(!s.substring(i, i+1).equals("}")) break;
                }
                else {
                    if(!s.substring(i, i+1).equals("]")) break;
                }
                stack.pop();
            }
        }

        if(stack.empty() && i==n) return "YES";
        return "NO";
    }


    public static int equalStacks(int[] a, int[] b, int[] c){
        int sum1 = a[0], sum2 = b[0], sum3 = c[0];
        int max = 0, c1 =0, c2 =0, c3 = 0;

        int n1 = a.length, n2 = b.length, n3 = c.length;

        int minLen = Math.min(Math.min(n1, n2),n3);

        int it1 = 1, it2 = 1, it3 = 1;
        int steps1 = 0, steps2 = 0, steps3 = 0;

        while(it1 != minLen || it2 != minLen || it3 != minLen) {
            if(sum1 == sum2 && sum2 == sum3) return sum1;

            max = Math.max(sum1, Math.max(sum2, sum3));
            steps1 = max - sum1;
            steps2 = max- sum2;
            steps3 = max - sum3;

            while(c1 < steps1 && c2 < steps2 && c3 < steps3) {

                if(sum1 != sum3 && it1 < minLen){
                    sum1 += a[it1++];
                    c1++;
                }

                if(sum2 != sum1 && it2 < minLen) {
                    sum2 += b[it2++];
                    c2++;
                }

                if(sum3 != sum1 && sum3 != sum2 && it3 < minLen) {
                    sum3 += c[it3++];
                    c3++;
                }
            }
            c1 = 0;
            c2 = 0;
            c3 = 0;

        }
            return -1;
    }


    public static void textEditor(String[] queries){
        Stack<String> textStack = new Stack<>();
        StringBuilder s = new StringBuilder();
        textStack.push(s.toString());

        for (String q:queries) {
            if(q.charAt(0) == '1') {
                s.append(q.substring(2));
                textStack.push(s.toString());
            }
            else if(q.charAt(0) == '2') {
                int n = textStack.peek().length();
                int start = Integer.parseInt(q.substring(2));
                textStack.push(s.delete(n-start, n + 1).toString());
            }
            else if(q.charAt(0) == '3') {
                int index = Integer.parseInt(q.substring(2));
                System.out.println(s.charAt(index-1));
            }
            else {
                textStack.pop();
                s = new StringBuilder(textStack.peek());
            }
        }

    }

    public static void poisonousPlants(int[] arr){
        int n = arr.length,c =0;
        Stack<Integer> plant = new Stack<>();
        HashMap<Integer,Integer> plantDayMap = new HashMap<>();

        List<Integer> list = Arrays.stream(arr).boxed().collect(toList());

        plant.push(arr[0]);
        plantDayMap.put(arr[0], 0);

        while(plantDayMap.values().stream().anyMatch(e -> e ==0)) {
            for (int i = 0; i < n - 1; i++) {
                if (list.get(i + 1) < list.get(i)) {
                    if (list.get(i + 1) < plant.peek()) {
                        plant.push(list.get(i + 1));
                        plantDayMap.put(list.get(i + 1), 0);
                    } else {
                        plantDayMap.put(list.get(i + 1), i + 1 - list.indexOf(plant.peek()));
                    }
                }
                else{
                    plantDayMap.put(list.get(i+1), 1);
                    list.remove(i+1);
                }
            }
            c++;
            System.out.println(plant);
            System.out.println(plantDayMap);
        }
        System.out.println(plant);

        System.out.println(c);
    }

    public static void waiter(int[] number, int q) {
        Stack<Integer> A0 = new Stack<>();
        A0.addAll(Arrays.stream(number).boxed().collect(toList()));

        Stack<Integer> B = new Stack<>();
        Stack<Integer> A1 = new Stack<>();

        int i = 1;
        List<Integer> primes = new ArrayList<>();

        while (q-- > 0){
           if(A0.pop() % 0 == 0){

           }
        }
    }

    public static List<Integer> getPrimes(int q){
        // get all primes till n
        List<Integer> res = new ArrayList<>();



return res;
    }


    public static void queue2Staks(String[] queries){
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        for (String q: queries) {

            if(q.charAt(0) == '1') {
                stackA.push(Integer.valueOf(q.substring(2)));
            }

            else if (q.charAt(0) == '2') {
                if(stackB.isEmpty()) {
                    while (!stackA.empty()) {
                        stackB.push(stackA.pop());
                    }
                }
                if (!stackB.isEmpty()){
                    stackB.pop();
                }

            }

            else {
                if(stackB.isEmpty()) {
                    while (!stackA.isEmpty()) {
                        stackB.push(stackA.pop());
                    }
                }

                System.out.println(stackB.peek());
                }
            }
        }


        public static void diagonalDiff(List<List<Integer>> list){
        int sum1 = 0,sum2 = 0;
        int i = 0 ,j = 0;
        int n = list.size();
        while (i<n&& j<n) {
            sum1 += list.get(i).get(j);
            i++;
            j++;
        }

        i = 0;
        j = n-1;
        while(i<n && j >= 0) {
            sum2 +=list.get(i).get(j);
            i++;
            j--;
        }
            System.out.println("sum1 :"  + sum1);
            System.out.println("sum2:" + sum2);
            System.out.println(Math.abs(sum1-sum2));
        }
        
        
        public static void cellComplete(int[] arr, int days){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();


        int start = arr[1];
        int end = arr[n-2];

        for (int j = 1; j < n-1; j++) {
                res.add(arr[j-1] ^ arr[j+1]);
        }

        res.add(0,start);
        res.add(n-1 ,end);

        days = days - 1;
        List<Integer>subres = new ArrayList<>();

        for (int i = 0; i < days; i++) {
               subres = res.subList(0,res.size()-3);

                for (int j = 1; j < subres.size() - 1; j++) {
                     int prev = res.get(j-1);
                    res.add(prev ^ res.get(j+1));
                }

                res.add(start);
                res.add(end-1);
        }

        res.forEach(e -> System.out.print(e + " "));
    }


    public static void gcdOfArray(int[] arr){
        int ans = getGCD(arr[0], arr[1]);
        int n = arr.length;

        for (int i = 2; i < n; i++) {
            ans = getGCD(arr[i], ans);
        }

        System.out.println(ans);
    }

    public static int getGCD(int a,int b){
        if(b == 0) return a;
        return getGCD(b,a%b);
    }

    public static void leaderBoard(int[] scores, int[] alice){
        Set<Integer> mySet  = new HashSet<>();
        mySet = Arrays.stream(scores).boxed().collect(Collectors.toSet());

        Integer[] cp = mySet.toArray(new Integer[]{});

        Arrays.sort(cp , Collections.reverseOrder());

        for (int i = 0; i < alice.length; i++) {
            int rank = binarySearchReverse(cp,alice[i]);
            System.out.println(rank);
        }
    }


    public static int binarySearchReverse(Integer[] arr, int x){
        int n =arr.length, l = 0 ,h = n -1;
        //Arrays.stream(arr).forEach(e-> System.out.print (e+ " "));
        while(l<=h) {
            int m = (l + h)/2;
            if(arr[m] == x) return m + 1;
            else if(arr[m] > x) l = m + 1;
            else h = m - 1;
        }

        return l+1;
    }
    
    public static void encryption(String s){
        s = s.replaceAll(" ", "");
        int n = s.length(), k = 0;

        int row = (int) Math.ceil(Math.sqrt(n));
        int col = (int) Math.ceil(Math.sqrt(n));

//        System.out.println("row: " + row);
//        System.out.println("col: " + col);

        String[][] arr = new String[row][col];


        for (int i = 0; i < row && k < n; i++) {
            for (int j = 0; j < col && k < n; j++) {
//                System.out.println("i: " + i);
//                System.out.println("j:" + j);
                arr[i][j] = s.substring(k,k+1);
                k++;
            }
        }


        StringBuilder res = new StringBuilder();

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row ; i++) {
                res.append((arr[i][j] == null) ? "" : arr[i][j]);
            }

            res.append(" ");
        }

        System.out.println(res);
    }
    
    public static void biggerIsGreater(){
        char[] charArr = s.toCharArray();

        Arrays.sort(new char[][]{charArr}, Collections.reverseOrder());

        String desc = new String(charArr);

        int n = s.length();
        for (int i = n-1; i > 0; i--) {
            if(!checkValue(s, s.charAt(i), s.charAt(i-1), desc)) {
                swap(s.charAt(i), s.charAt(i-1));
                String remStr = getCorrectOrder(s.substring(1));
                System.out.println(s + remStr);
                return;
            }
        }

        System.out.println("no answer");
    }

    public static boolean checkValue(String original, char a, char b, String order){
        boolean initOrder = original.indexOf(a) > original.indexOf(b);
        boolean currOrder = order.indexOf(a) > order.indexOf(b);

        return (initOrder == currOrder);
    }

    public static String getCorrectOrder(String str){
        Arrays.sort(str.toCharArray());
        return new String(str.toCharArray());
    }

    public static void swap(char a, char b){
        char temp = b;
        b = a;
        a = temp;
    }

    public static void searchAGrid(String[] a1, String[] a2){
     boolean isFound = false;
     int i = 0;
     List<Integer> positionsList = new ArrayList<>();
        for (String subarr1: a1) {
            if (i == a2.length) break;

            String str = subarr1;
            //str = str.substring(0, str.length() - 1);

            System.out.println(str);

            String s2 = a2[i];

            //s2 = s2.substring(1, s2.length() - 1);

            System.out.println(s2);

            if(str.contains(s2)) {
                System.out.println("matching row: " + i);
                positionsList.add(str.indexOf(s2.charAt(0)));
                positionsList.add(str.indexOf(s2.charAt(s2.length() - 1)));

                int index = str.indexOf(s2);

                System.out.println("start: " + index);

                System.out.println(positionsList.get(0));

                if(positionsList.get(0) != index) break;
                isFound = true;
                i++;
            }
            else {
                if(isFound) isFound = false;
                if(i != 0) break;
            }
        }

        System.out.println(isFound && i == a2.length ? "YES": "NO");
    }
    
    public static void absolutePermutation(int n, int k){
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        list.add(-1);
        list.addAll(IntStream.rangeClosed(1,n).boxed().collect(toList()));

        list.forEach(e-> System.out.print(e + " "));

        for (int i = 1; i < list.size(); i++) {
            if(list.contains(i+k)) {
               res.add(i+k);
            }
        }


        res.forEach(e-> System.out.print(e + " "));
    }

    public static void amazonHelpSection(String helpText, List<String> exclude){
        String regex = "[\\d+]";

        helpText = helpText.toLowerCase().replaceAll(regex, " ");

        String symbolRegex = "[\\W+]";

        helpText = helpText.toLowerCase().replaceAll(symbolRegex, " ");

        System.out.println(helpText);

        HashMap<String, Integer> map = new HashMap<>();

        String[] arr = helpText.split(" ");

        for (String s:arr) {
            if(!exclude.contains(s)) map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int maxValue = map.values().stream().max(Comparator.naturalOrder()).get();

        List<String> ans = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxValue) ans.add(entry.getKey());
        }

        ans.forEach(e-> System.out.print(e + " "));
    }

    public static void amazonLogFiles(List<String> logLines){
        List<String> list = new ArrayList<>();

        System.out.println(logLines);

        for (String s: logLines) {
            String str = s.substring(s.indexOf(" ") + 1);
            //System.out.println("str at the beginning: " + str.charAt(0));
            if(Character.isDigit(str.charAt(0))) {
                list.add(s);
                System.out.println("list when first char is digit: " + list);
            }
            else {
                String front = list.get(0).substring(list.get(0).indexOf(" ") + 1);
                System.out.println("front: " + front);
                if(Character.isDigit(front.charAt(0))) {
                    list.add(0, s);
                    System.out.println("list when first ele iof list is digit: " + list);
                }
                // front is >
                else if(front.compareToIgnoreCase(str) < 0) {
                    System.out.println("front: " + front);
                    System.out.println("str: "  + str);
                    list.add(list.indexOf(list.get(0)) + 1, s);
                    System.out.println("list when present string is > incoming: " + list);
                }
                // str is >
                else {
                    System.out.println("s : " + s);
                    System.out.println("front: " + front);
                    list.add(list.indexOf(list.get(0)), s);
                    System.out.println("list when incoming > string at 0 index" + list);
                }
            }
        }

        list.forEach(e -> System.out.print(e + " "));
    }
    
    public static void rosesInAShop(int[] arr){
        int n = arr.length, i = 0, j = 1, c =0;
        List<Integer> list = new ArrayList<>();
        while(j < n) {
            if(arr[i] < arr[j]) {
                list.add(arr[i]);
            }
            else {
                if(c==1) {
                    list.add(arr[i]);
                    break;
                }
                else c++;
            }
            i = j;
            j = j +1;
        }

       list.add(arr[j-1]);
        System.out.println(list);
    }

    public static boolean canWin(int leap, int[] game){
        int i = 0 , n = game.length;

        while(i<n){
            if(i + leap >= n) return true;
            if(game[i + leap] == 0) i += leap;

            while(i<n-1 && game[i+1] != 1) i++;
            if(i==n-1) return true;

            if(game[i+leap] == 1) {
                    if(i > 0 && game[i-1] == 0) i = i - 1;
                    else return false;
            }

            else i = i + leap;

        }

        return true;
    }
    
    
    
//    public static void almostSorted(int[] arr){
//        int[] copy = Arrays.copyOf(arr, arr.length);
//        int[] copy2 = Arrays.copyOf(arr, arr.length);
//        Arrays.sort(copy);
//
//        if(isSorted(arr, copy)) System.out.println("yes");
//        else {
//            int i = 0, j = 1;
//            while(arr[i] < arr[j]) {
//                i = j;
//                j++;
//            }
//
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//
//            if(isSorted(arr, copy)) {
//                System.out.println("yes");
//                System.out.println("swap " + (i + 1) + " " + (j + 1));
//                return;
//            }
//
//            arr = copy2;
//
//            int n = arr.length;
//            for (int k = 0; k < n; k++) {
//                if(arr[k] != copy[k]) i = k;
//                if(i == k) {
//                    while (k < n - 1 && arr[k] != copy[k] && arr[k] > arr[k+1]) k++;
//                    j = k;
//                    break;
//                }
//            }
//
//            int l = i, r = j;
//            System.out.println("i: " + i);
//            System.out.println("j: " + j);
//
//            printArray(arr);
//            while(l<r) {
//                temp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = temp;
//                l++;
//                r--;
//            }
//
//            //printArray(arr);
//
//            if(isSorted(arr, copy)) {
//                System.out.println("yes");
//                System.out.println("reverse " + (i + 1) + " " + (j + 1));
//            }
//            else {
//                System.out.println("no");
//            }
//        }
//    }
    
    public static boolean isSorted(int[] arr, int[] copy){
    return (Arrays.equals(arr, copy));
    }

    public static boolean isSorted(int[] arr, boolean isAsc){
        int n = arr.length;

        if(isAsc) {
            for (int i = 0; i < n - 1; i++) {

                if (arr[i] > arr[i + 1]) return false;

            }
        }

        else {
            for (int i = 0; i < n - 1; i++) {

                if (arr[i] < arr[i + 1]) return false;

            }
        }

        return true;
    }

    public static void countSort(List<List<String>> arr){
        HashMap<Integer, List<String>> integerListHashMap = new HashMap<>();
        int n = arr.size();

        System.out.println("n: " + n);

        for (int i = 0; i < n; i++) {
            Integer key = Integer.parseInt(arr.get(i).get(0));
            String value = arr.get(i).get(1);

            if(integerListHashMap.containsKey(key)) {
                List<String> valueList = integerListHashMap.get(key);

                valueList.add((i<n/2) ? "-" : value);
                integerListHashMap.put(key, valueList);
            }

            else{
                List<String> valueList = new ArrayList<>();
                valueList.add( (i<n/2) ? "-" : value);
                integerListHashMap.put(key, valueList);
            }

        }


        System.out.println(integerListHashMap);

        StringBuilder sb = new StringBuilder();

        integerListHashMap.values().forEach(e -> e.forEach(s -> sb.append(s).append(" ")));

//        for (List<String> l : integerListHashMap.values()) {
//            for (String s:l) {
//                sb.append(s);
//                sb.append(" ");
//            }
//        }

        System.out.println(sb);
    }
    
    public static void fraudulentActivity(int[] e, int d){
        int n = e.length;
        int j = 0, ans = 0;

        int[] copy = Arrays.copyOf(e, e.length);
        Arrays.sort(copy);

        List<Integer> expenseList = Arrays.stream(e).boxed().collect(toList());
        int diff = 0;

        for (int i = n-1; i >= 0 && diff >= 0; i--) {
            int index = expenseList.indexOf(copy[i]);
            System.out.println("copy[i]: " + copy[i]);
            System.out.println("index: " + index);

            if(index >= d) {
                int median = getMedian(expenseList.subList(index-d, index).
                        toArray(new Integer[]{}));
                System.out.println("median: " + median);
                diff = copy[i] - (2 * median);
                System.out.println("diff: " + diff);
                ans++;
            }
        }

        System.out.println(ans-1);
//        for (int i = d; i < n; i++) {
//            int[] sub = Arrays.copyOfRange(e, j++, i);
//            Arrays.stream(sub).forEach(a-> System.out.print(a + " "));
//            System.out.print("element: " + e[i]);
//
//            int median = getMedian(sub);
//            System.out.println(" median: " + median);
//            System.out.println();
//            if(e[i] >= (2 * median)) ans++;
//        }
//
//        System.out.println(ans);
    }

//    public static void lilysHomework(int[] arr){
//       HashMap<Integer, Integer> map = new HashMap<>();
//       int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            map.put(arr[i], i);
//        }
//
//        // Calculate sum if in asc order
//        int ascSum = 0;
//        Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            ascSum += Math.abs(map.get(arr[i]) - i);
//        }
//
//        System.out.println("ascending order: "+ ascSum);
//        int descSum = 0;
//        Arrays.sort(new int[][]{arr}, Collections.reverseOrder());
//        for (int i = 0; i < n; i++) {
//            descSum += Math.abs(map.get(arr[i]) - i);
//        }
//
//        System.out.println("descending order: " + descSum);
//        System.out.println(Math.min(ascSum, descSum));
//    }
//
    public static String sherlockString(String str){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(freqMap.containsKey(str.charAt(i))) {
                freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
            }
            else {
                freqMap.put(str.charAt(i), 1);
            }
        }

        System.out.println(freqMap);

        Integer[] values = freqMap.values().toArray(new Integer[]{});
        int diff = 0, sub = 0;
        for (int i = 0; i < values.length - 1; i++) {
            if(!values[i].equals(values[i + 1])) {
                if(diff > 3) break;
                else {
                    diff++;
                    sub = Math.abs(values[i]-values[i+1]);
                }
            }
        }

        System.out.println("sub: " + sub);
        System.out.println("diff: " + diff);

        if(sub == 1 && diff < 3) return "YES";
        return "NO";
    }


    public static int getMedian(Integer[] arr){
        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
        int median = 0, n = arr.length;
        Arrays.sort(arr);
        if(n%2 == 0) {
            median = arr[(int)Math.floor(n/2)] + arr[(int)Math.ceil(n/2)]/2;
        }
        else {
            median = arr[n/2];
        }
        return median;
    }


    public static void lilyHomework(int[] arr){
        int swap1 = 0, swap2 = 0 , n = arr.length;
//        int[] copy = Arrays.copyOf(arr, n);
//
//        for (int i = 0; i < n; i++) {
//            int min = arr[i];
//            int idx = 0;
//            for (int j = i+1; j < n; j++) {
//                if(arr[j] < min) {
//                    min = arr[j];
//                    idx = j;
//                }
//            }
//
//            if(min != arr[i]) {
//                int temp = min;
//                arr[idx] = arr[i];
//                arr[i] = temp;
//                swap1++;
//            }
//
//            if(isSorted(arr, true)) break;
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            int max = copy[i];
//            int idx = 0;
//            for (int j = i+1; j < n; j++) {
//                if(copy[j] > max) {
//                    max = copy[j];
//                    idx = j;
//                }
//            }
//
//            if(max != copy[i]) {
//                int temp = max;
//                copy[idx] = copy[i];
//                copy[i] = temp;
//                swap2++;
//            }
//            if(isSorted(copy, false)) break;
//        }
//
//        System.out.println("swap1: " + swap1);
//        System.out.println("swap2: " + swap2);

          HashMap<Integer, Integer> elementIndexAscMap = new HashMap<>();
          HashMap<Integer, Integer> elementIndexDescMap = new HashMap<>();

          int[] asc = Arrays.copyOf(arr, arr.length);
          int[] desc = Arrays.copyOf(arr, arr.length);

          Arrays.sort(asc);
          Arrays.sort(new int[][]{desc}, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            elementIndexAscMap.put(arr[i], i);
            elementIndexDescMap.put(arr[i],i);
        }

        System.out.println("elementIndexDescMap = " + elementIndexDescMap);

        for (int i = 0; i < n; i++) {
            if(arr[i] != asc[i]) {
                int tempIndex = elementIndexAscMap.get(asc[i]);
                elementIndexAscMap.put(asc[i], i);
                elementIndexAscMap.put(arr[i], tempIndex);
                swap1++;
            }
        }


        for (int i = 0; i < n; i++) {
            if(arr[i] != desc[i]) {
                int tempIndex = elementIndexDescMap.get(desc[i]);
                elementIndexDescMap.put(desc[i], i);
                elementIndexDescMap.put(arr[i], tempIndex);
                swap2++;
            }
        }

        System.out.println("asc order swap: " + (swap1-1));
        System.out.println("desc order swap: " + (swap2-1));

    }

    
    public static <T> void printArray(T[] arr){
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
    
    public static void tripToGoa(Integer[] arr, List<String> coldWarList){
        int n = arr.length , sum = 0;
        System.out.println("n: " + n);
        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
        int j = 0;
        coldWarList.forEach(e -> System.out.print(e + " "));
        List<String> processedString = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String a = String.valueOf(i);
            String b = String.valueOf(i+1);

            if(coldWarList.contains(a) && coldWarList.contains(b) &&
                    !processedString.contains(a) || !processedString.contains(b)) {
                sum += Math.max(arr[Integer.valueOf(coldWarList.get(j))],
                        arr[Integer.valueOf(coldWarList.get(j+1))]);

                processedString.add(a);
                processedString.add(b);
                j++;
            }

            else if(coldWarList.contains(a) && coldWarList.contains(b) &&
                    processedString.contains(a) || processedString.contains(b)) {

                sum = Math.max(sum, (processedString.contains(a) ?
                        arr[Integer.valueOf(coldWarList.get(j))] :
                        arr[Integer.valueOf(coldWarList.get(j+1))]));

                processedString.add(a);
                processedString.add(b);
                j++;
            }

            else sum += arr[i];

            System.out.println("sum: " + sum);
        }

        System.out.println("sum: " + sum);
    }

    public static void addString(String str){
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int i = 0; // Start of the window
        int res = 0;

        for (int j = 0; j < str.length(); j++) {
            // End of the window
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
            res = Math.max(res, j-i+1);
            lastIndex[str.charAt(j)] = j;
        }
        System.out.println("res: " + res);
    }
    
    public static void groupAnagrams(String s){
       HashMap<String, List<String>> sortMap = new HashMap<>();
       String regex = "[\\[\\]]";
       s = s.replaceAll(regex, "");

        System.out.println(s);
       String[] arr = s.split(",");

        for (String str: arr) {
            char[] charArr =  str.toCharArray();
            Arrays.sort(charArr);

            if(sortMap.containsKey(new String(charArr))) {
                List<String> val = sortMap.get(new String(charArr));
                val.add(str);
                sortMap.put(new String(charArr), val);
            }

            else {
                List<String> val = new ArrayList<>();
                val.add(str);
                sortMap.put(new String(charArr), val);
            }
        }

        System.out.println(sortMap);

        sortMap.values().forEach(Collections::sort);

        System.out.println(sortMap
                .values()
                .stream()
                .sorted(Comparator.comparing(List::size, Comparator.reverseOrder()))
                .collect(Collectors.toList()));
    }
    
    
    public static void getMinCDs(Integer n, Integer l, Integer c){
        int no_of_cds = 0;
        if(l >= c) {
            no_of_cds = -1;
        }
        if(n * (l+1) < c) {
            no_of_cds = 1;
            if(n % 7 == 0) no_of_cds++;
        }

        else {
            while (n > 0) {
                    n -= (c/(l+1));
                System.out.println("n = " + n);
                    no_of_cds++;
            }
        }

        if(c/(l+1) %7 ==0) no_of_cds++;

        System.out.println("no of cds: " + no_of_cds);
    }
    
    public static void nthDigit(int n){
        IntStream intStream = IntStream.rangeClosed(1, Integer.MAX_VALUE);
        intStream.forEach(e-> System.out.print("e = " + e));

        String str = intStream.toString();
        System.out.println("str = " + str);

        System.out.println("nth digit = " + str.charAt(n));
    }
    
    public static void victorWareHousing(String[] storageUnits, String[] relation){
        //printArray(relation);
        HashMap<String, String> unitRelationMap = new HashMap<>();
      int i = 0,max = 0;
      String uom = "";
      StringBuilder stringBuilder = new StringBuilder();
      HashMap<String, Integer> unitMatchingValueMap = new HashMap<>();

        for (int j = 0; j < relation.length - 1; j++) {
            unitRelationMap.put(relation[j], relation[j+1]);
        }

        System.out.println("unitRelationMap = " + unitRelationMap);

        for (int j = 1; j < relation.length; j+=2) {
            if(relation[j].charAt(relation[j].length() - 1) ==
                    relation[j+1].charAt(relation[j+1].length() - 1)) {
                 max = Math.max(Integer.valueOf(relation[j]), Integer.valueOf(relation[j+1]));
            }
        }

        for (String str: unitRelationMap.keySet()) {
            if(unitRelationMap.get(str).contains(String.valueOf(max))) {
                uom = str;
                break;
            }
        }

        for (String storage: unitRelationMap.keySet()) {
            int val = max/Integer.valueOf(unitRelationMap.get(storage).
                    substring(unitRelationMap.get(storage).indexOf(" "),
                            unitRelationMap.get(storage).lastIndexOf(" ")));

            unitMatchingValueMap.put(storage, val);
        }

        System.out.println("unitMatchingValueMap = " + unitMatchingValueMap);

        final Map<String, Integer> map = unitMatchingValueMap.entrySet()
                .stream()
                .sorted((Map.Entry.<String,Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry e: map.entrySet()) {
                stringBuilder.append(e.getKey()).append(e.getValue()).
                        append(e.getValue().toString().substring(e.getValue().toString().indexOf(" ")));
            }

        System.out.println("stringBuilder = " + stringBuilder);
        }

        public static void computerStorage(int[] storage, int[] from,
                                           int[] to, int threshold){
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[from.length];
        int count = 0;
        for (int i = 0; i < from.length; i++) {
                int idx = Math.max(from[i], to[i]);
                System.out.println("idx = " + idx);
                int otherIdx = Math.min(from[i], to[i]);
                System.out.println("otherIdx = " + otherIdx);

                if(!set.contains(idx) || !set.contains(otherIdx)) {

                    storage[idx] = storage[from[i]] + storage[to[i]];

                    storage[otherIdx] = Integer.MAX_VALUE;
                    set.add(idx);
                    set.add(otherIdx);

                    Arrays.stream(storage).forEach(e -> System.out.print("e: " + e));
                    System.out.println();

                    count = (int) Arrays.stream(storage).filter(e -> e <= threshold).count();
                    ans[i] = count;
                }
        }
    }


    public static void arrayQueries(int k, int[] type, int[] left, int[] right){
        int n = Integer.parseInt("0",k);
        System.out.println("n = " + n);
        StringBuilder stringBuilder = new StringBuilder();

        while(k-- > 0) stringBuilder.append(0);
        System.out.println("stringBuilder = " + stringBuilder);

        int c=0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < type.length; i++) {
            if(type[i] == 0) {
                //xor
                int typen = n;
                for (int j = left[i]; j <= right[i];j++) {
                    typen |= j;
                }
                
                n ^= typen;
                System.out.println("typen = " + typen);
                System.out.println("n = " + n);
            }
            
            else {
                //count 1s
                for (int j = left[i]; j <= right[i] ; j++) {
                    if(stringBuilder.charAt(j) == '1') c++;
                }
                list.add(c);
            }
        }

        System.out.println("list = " + list);
    }
}

