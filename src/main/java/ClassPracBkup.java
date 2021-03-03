import java.util.*;

public class ClassPracBkup implements Comparator<Employee> {
    static int preIndex = 0;

    public static void cards(int[] arr) {
        // get all primes till the max element in an arr
        // store the mod of prime and arr[i] and calculate sum
        // find min of all sum

        int max = Arrays.stream(arr).max().getAsInt();

        int[] prime = new int[max];
        int k = 0;
        for(int i=2;i<=max;i++) {
            for(int j=2;j<=Math.sqrt(i);j++) {
                if(j%i != 0) prime[k++] = i;
            }
        }

        int sum = 0, min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>(Comparator.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int p: prime) {
            for(int e:arr) {
                sum += (e%p);
            }
            map.put(p, sum);
        }

        int minVal = map.values().stream().min(Comparator.naturalOrder()).get();
        for(Integer key : map.keySet()) {
            if(map.get(key) == minVal) {
                System.out.println("key = " + key);
                return;
            }
        }
    }

    public static void sortedArrayToBST(int[] arr) {
        // binary search method
        // find mid
        // make a[mid] as the root
        // recur for left subtree as h=m-1 and
        // right subtree as l = m + 1

        int n = arr.length;
        sortedArrayToBSTUtil(arr, 0, n-1);
    }

    public static Node sortedArrayToBSTUtil(int[] arr, int l, int h) {
        if(l < 0 || h < 0 || h < l) return null;
        int m = l + (h-l)/2;
        Node node = new Node(arr[m]);
        node.left = sortedArrayToBSTUtil(arr, l, m-1);
        node.right = sortedArrayToBSTUtil(arr, m+1, h);

        return node;
    }

    public static void excelSheetColumnTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n>0) {
            int val = (65 + --n%26);
            System.out.println("val: " + val);
            sb.append((char)val);

            n = n/26;
        }
        System.out.println("sb="+sb.reverse().toString());
    }

    public static int trailingZeros(int n) {
        // TODO Auto-generated method stub
        // number of trailing zeros in any number is
        // sum of n/5+ n/25+n/125+n/625+n/3125
        // as multiplication of previous numbers with 5 will lead
        //to a 0

        int n1 = n/5;
        int n2 = n/25;
        int n3 = n/125;
        int n4 = n/625;
        int n5 = n/3125;

        return n1 + n2 + n3 + n4 + n5;
    }

    public static boolean isIsomorphic(String s1, String s2) {
        // traverse through the strings
        // if s1.indexOf s1's charat{i} != s2.indexof s2's charat{i}, return false
        // else return true;

//    	int n = s1.length();
//
//    	for(int i=0;i<n;i++) {
//    		if(s1.indexOf(s1.charAt(i)) != s2.indexOf(s2.charAt(i))) return false;
//    	}
//    	return true;

        // convert strings to char arr
        // create a map of char vs char
        // i.e char that is currently present vs char that will replace the existing one
        // if a char is not present in map's key and value, then add that to map
        // if map.get(char) == null,meaning unequal length strings
        // or if map.get(char) != b[i], meaning a previous mapping exists, return false

        char[] a = s1.toCharArray(), b = s2.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(a[i]) && !map.containsValue(b[i])) map.put(a[i], b[i]);
            if(map.get(a[i]) == null || map.get(a[i]) != b[i]) return false;
        }
        return true;
    }

    public static int[] twoSum(int[] arr, int k) {
        // create a map of ele vs idx
        // check if map contains k - arr[i] and i != map's value

        int n = arr.length;
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(k-arr[i]) && i != map.get(k - arr[i])) {
                res[0] = i;
                res[1] = map.get(k-arr[i]);
                break;
            }
        }
        return res;
    }

    public static boolean isBalanced(Node root) {
        // get left height of binary tree
        // get right height of binary tree
        // check left - right <= 1

        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) return true;

        return false;
    }

    public static int height(Node root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

    public static void bestTimeToBuyAndSellStock(int[] arr) {
        // update min price if a price is < min price
        // update max profit with max of itself and current price - min price

        int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minPrice  = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }

        System.out.println("ans: " + maxProfit);

    }

    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n1 = s1.length(), n2 = s2.length();
        if(n1 != n2) return false;
        for(int i=0;i<n1;i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        System.out.println("map1: " + map1);
        System.out.println("map2: " + map2);

        return map1.equals(map2);
    }

    public static void productExceptSelf(int[] arr) {
        // create an array to store product of all elements on left side for an index
        // create an array to store product of all elements on right side for an index
        // for left most element, we start with 1 and multiply L[i-1] with arr[i-1]
        // for right most element, we start in reverse
        //with 1 and multiply R[i+1] with arr[i+1]
        // finally, multiply both these arrays

        int n = arr.length;
        int[] L = new int[n];
        //int[] R = new int[n];
        int[] res = new int[n];

        res[0] = 1;
        for(int i=1;i<n;i++) {
            res[i] = res[i-1] * arr[i-1];
        }

        int R = 1;
        for(int i=n-1;i>=0;i--) {
            res[i] = res[i] * R;
            R *= arr[i];
        }

        Utils.printIntArray(res);
    }


    public static boolean areIsomorphic(String s1, String s2) {
        // if s1's index of s1's charAt is not equal to s2's index of
        // s2's charAt, return false

        int n = s1.length();
        for(int i=0;i<n;i++) {
            if(s1.indexOf(s1.charAt(i)) != s2.indexOf(s2.charAt(i))) return false;
        }

        return true;
    }

    public static boolean isValidParentheses(String s) {
        // if s.charAt(i) is opening braces, push it
        // if s.charAt(i) is closing braces, check if it matches, if yes pop, else return false
        // after poppin', check if stack is not empty, if yes return false, else return true

        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                if(!isAMatch(stack.peek(), s.charAt(i))) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static int kadaneAlgorithm(int[] arr) {
        // sum will be running sum of arr
        // if sum > ans, update ans
        // if sum < 0, make sum = 0, meaning reset the sum, in the hope of next number > 0
        // if yes then great else current value becomes the ans

        int n = arr.length;
        int sum = 0, ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(sum > ans) ans = sum;
            if(sum < 0) sum = 0;
        }

        return ans;
    }
    public static boolean isAMatch(Character a, Character b) {
        if(a == '(' && b == ')') return true;
        else if(a == '{' && b == '}') return true;
        else if (a == '[' && b == ']') return true;
        return false;
    }

    public static void mergeIntervals(int[][] arr) {
        // check if a sublist's last element is greater than next sublist's first element,
        // if yes, then create a new list by adding sublist's first element & next's last element
        // if no, then get current sublist
        // add the sublist to the res list

        List<List<Integer>> res = new ArrayList<>();

        int n = arr.length;
        int m = arr[0].length;

        for(int i=0;i<n-1;i++) {
            List<Integer> list =new ArrayList<>();
            if(arr[i][1] >= arr[i+1][0]) {
                // merging is possible
                list.add(arr[i][0]);
                list.add(arr[i+1][1]);
                i=i+1;
            }
            else {
                list.add(arr[i][0]);
                list.add(arr[i][1]);
            }

            res.add(list);
        }

        if(res.get(res.size()-1).get(1) != arr[n-1][1]) res.add(Arrays.asList(arr[n-1][0], arr[n-1][1]));

        System.out.println("res: " + res);

        int[][] resa = new int[n-1][2];
        int i = 0, j = 0;

        for(List<Integer> a: res) {
            j=0;
            for(Integer c: a) {
                resa[i][j] = c;
                j++;
            }
            i++;
        }

        Utils.printInt2DArray(resa);
    }

    public static void groupAnagrams(String[] str) {
        // 2 strs are anagrams if and only if their sorted o/p is equal
        // create a map of key as sorted string
        // and value as list of strings in the given arr such that when sorted, it's equal to key
        //

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: str) {
            char[] sarr = s.toCharArray();
            Arrays.sort(sarr);

            String key = String.valueOf(sarr);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(s);
            System.out.println("map: "  + map);
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        System.out.println(map.values());
    }


    public static void maxProduct(int[] arr) {
        // store the running product of the arr in p
        // update p with arr[i]
        // update ans with p if p > ans
        // if p < 0, reduce p to 1 again, in hope of next bigger product
        // count the number of -ve's, if odd reduce p to 1
        // else nothing

        int n = arr.length;
        int p = 1, ans = Integer.MIN_VALUE;
        int countOfNegatives = 0;

        for(int i=0;i<n;i++) {
            if(arr[i] < 0) countOfNegatives++;
        }

        for(int i=0;i<n;i++) {
            p *= arr[i];
            if(p > ans) ans = p;
            if(p < 0 && (countOfNegatives%2) != 0) {
                System.out.println("entered reseting");
                p = 1;
                countOfNegatives--;
            }
        }

        System.out.println("ans: " + ans);
    }

    public static int searchInASortedRotatedArray(int[] arr, int k, int l, int h) {
        // search for an element in a sorted rotated array
        // in a sorted rotated array, at some index
        // the order of the elements will decrease instead of increasing
        // will call that index as pivot
        // we can find the pivot index by simply searching for the decreasing order
        // then divide the array in 2 parts, from 0 to pivot-1 and pivot to n-1
        // and binary search in 2 arrays as these will be sorted
        // time complexity: O(n)

//    	int n = arr.length;
//
//    	int pivot = -1, ans = -1;
//
//    	for(int i=0;i<n-1;i++) {
//    		if(arr[i] > arr[i+1]) pivot = i+1;
//    	}
//
//    	System.out.println("pivot: " + pivot);
//    	if(pivot == -1) ans = binarySearch(arr, k, 0, n-1);
//    	else {
//    		ans = binarySearch(arr, k, 0, pivot-1);
//    		if(ans == -1)
//    			ans = binarySearch(arr, k, pivot, n-1);
//    	}
//
//    	System.out.println(ans);

        // we can do better than O(n)
        // check if first subarray, i.e arr[l..m] is sorted
        // if yes, then check if key is in between l and m
        // 	if yes, recur for left subarray
        // 	else recur for right subarray
        // else check for key in between m and h
        // if first subarray is not sorted, then arr[m..h] must be sorted
        // check if key is in between m and h
        // if yes, check for key in right subarray
        // else check for key in left subarray
        // time complexity: O(logn)

        if(l > h) return -1;
        int m = (l+h)/2;
        if(arr[m] == k) return m;

        if(arr[l] <= arr[m]) {
            // first subarray is sorted
            if(k >= arr[l] && k <= arr[m]) return searchInASortedRotatedArray(arr, k, l, m-1);
            return searchInASortedRotatedArray(arr, k, m+1, h);
        }

        // second subarray is sorted
        if(k >= arr[m] && k <= arr[h])
            return searchInASortedRotatedArray(arr, k, m+1, h);

        return searchInASortedRotatedArray(arr, k, l, m-1);
    }

    public static int binarySearch(int[] arr, int k, int l, int h) {
        if(l < h) {
            int m = (l+h)/2;
            if(arr[m] == k) return m;
            else if(arr[m] > k) return binarySearch(arr, k, l, m-1);
            return binarySearch(arr, k, m+1, h);
        }
        else return -1;
    }

    public static int maxArea(int[] arr) {
        // given an arr of heights, find the max area of the rectangle
        // max area formed here is by comparing 2 heights, getting the min of it
        // multiplied by the distance between them as the width
        // time complexity: O(n2)

//    	int n = arr.length;
//    	int maxArea = 0;
//
//    	for(int i=0;i<n;i++) {
//    		for(int j=i+1;j<n;j++) {
//    			maxArea = Math.max(maxArea, Math.min(arr[i], arr[j]) * (j-i));
//    		}
//    	}
//
//    	return maxArea

        // we can do better than O(n2)
        // 2 pointer approach, keep one, l, at left and other, r, at right
        // update maxArea with max of itself and min(l,r) * j-i
        // where j and i are indices indicating the distance between them
        // maxArea = max(maxArea, min(l,r) * (j-i))
        // since j-i is always going to decrease whether we move l or r
        // maxArea is dependent on min(l,r)
        // so if l < r, then l++ else r--
        // time complexity: O(n)

        int n = arr.length;
        int maxArea = 0;

        int l = 0, r = n - 1;

        while(l < r) {
            maxArea = Math.max(maxArea, Math.min(arr[l], arr[r]) * (r-l));
            if(arr[l] < arr[r]) l++;
            else r--;
        }

        return maxArea;
    }

    public static void longestSubstringWithoutRepeatingChars(String str) {
        // maintain a set of unvisited chars
        // if set does not contain str.charAt(i), add to set
        // else
        //  if set's index of str.charAt(i) == 0, remove the char At 0 and add str.charAt(i)
        // 	else update ans with max of itself and set size and clear the set
        // return max of ans and set size 'cause in case of last stmt executed was if part

        int n = str.length();
        StringBuffer sb = new StringBuffer();
        int ans = 0;

        for(int i=0;i<n;i++) {
            if(sb.indexOf(String.valueOf(str.charAt(i))) == -1) sb.append(str.charAt(i));
            else {
                if (sb.indexOf(String.valueOf(str.charAt(i))) == 0) {
                    sb.deleteCharAt(0);
                }

                else {
                    ans = Math.max(ans, sb.length());

                    sb.delete(0, 1 + sb.indexOf(String.valueOf(str.charAt(i))));
                }

                sb.append(str.charAt(i));
            }
        }

        System.out.println(Math.max(ans, sb.length()));
    }

    public static void minWindow(String s, String t) {
        // idea is start from minimum
        // that is start by taking out substrings of length t from s
        // if any of s substrings of length t is equal to t, ans is that substring
        // store the res in ans, init it with empty, init it as 0
        // while it < n, take len as it + t.length()
        // take substring from s of len
        // create a map of that's substring's char vs freq
        // create a map of t's char vs freq
        // if that substring's keys list contains t's keys, res = that substring and break
        // out of for loop, update it

        int n = s.length();
        String res = "";
        int it = 0;

        boolean isFound = false;

        List<Character> list = new ArrayList<>();

        for(int i=0;i<t.length();i++) {
            list.add(t.charAt(i));
        }

        while(it < n) {
            int len = t.length() + it;

            for(int i=0;i<n-len+1;i++) {
                String sub = s.substring(i, i+len);
                HashMap<Character, Integer> map = new HashMap<>();

                for(int j=0;j<sub.length();j++)
                    map.put(sub.charAt(j), map.getOrDefault(sub.charAt(j), 0) + 1);

                System.out.println("map keyset: " + map.keySet());
                if(map.keySet().containsAll(list))
                {
                    res = sub;
                    isFound = true;
                    break;
                }

            }

            if(isFound) break;
            it++;
        }

        System.out.println("res: " + res);
    }

    public static int numberOfIslands(char[][] grid) {

        // dfs traversal
        // run a loop i = 0 to n
        // run inner loop j = 0 to n
        // if an element is 1, do dfs with i and j and  update count
        // in dfs function, check for boundary conditions and return
        // set arr[i][j] as visited or 0
        // check for row above and below
        // check for col above and below

        int count = 0;

        int len = grid.length;
        if(len == 0) return count;

        int n = grid.length, m = grid[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i , j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j <0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j]!= '1') return;
        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public static void numberOfPalindromicSubstrings(String str) {
        // check for substrings of length > 1
        // to check if a substring is palindrome,
        // add the string's 0 to n/2th part to stack
        // from n/2 to n, check if stack.pop is matching to it
        // if yes, update count

        int n = str.length();
        int ans = n;
        int it = 2;

        if(n > 1) {
            while(it <= n) {
                for(int i=0;i<n-it+1;i++) {
                    String sub = str.substring(i, i+it);
                    System.out.println("substring: " + sub);
                    if(isPalindrome(sub)) ans++;
                }
                it++;
            }
        }

        System.out.println("ans: " + ans);
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n/2;i++) {
            stack.add(s.charAt(i));
        }


        int i;
        i = (n%2 == 0) ? n/2 :  (n/2)+1;
        for(;i<n;i++) {
            if(stack.pop() != s.charAt(i)) return false;
        }

        return true;
    }

    public static void sortByFreq(int[] arr) {
        // create a map of arr elements vs the freq
        // compare them by max values
        // compare them by min key

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new
                LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        ArrayList<Integer> res = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e: list) {
            int v = e.getValue();
            while(v > 0) {
                res.add(e.getKey());
                v--;
            }
        }

        System.out.println("map: " + map);
        System.out.println("res: " + res);
    }

    public static void connectNodesAtSameLevel(ClassPrac.RightNode node) {
        // do a level order traversal
        // push a null element to mark the end of a level
        // traverse while q is not empty, poll an element
        // if the polled element is not empty, set it's next right ptr to q's peek
        // and add left and right child
        // else if q is not empty, add null to mark the end of level

        Queue<ClassPrac.RightNode> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        while(!q.isEmpty()) {

            ClassPrac.RightNode tmp = q.peek();
            q.remove();

            if(tmp != null) {
                tmp.nextRight = q.peek();

                if(tmp.left != null) q.add(tmp.left);
                if(tmp.right != null) q.add(tmp.right);
            }

            else if(!q.isEmpty()) {
                q.add(null);
            }
        }
    }


    public static void findStockBuyAndSellDays(int[] arr) {
        // whenever min price changes, print the index of min price and max price

        int n = arr.length;
        int minPrice = arr[0], maxPrice = arr[1];

        int j = 1;

        for(int i=0;i<n && j<n ;i++) {
            if(arr[j++] > maxPrice) maxPrice = arr[i];
            if(arr[i] < minPrice) {
                minPrice = arr[i];
                System.out.println("buy day: " + i + " sell day: " + j);
            }
        }
    }

    public static int patternSearching(String text, String pat) {
        // let pat's length be l
        // take substrings of size l in text
        // if a substring equals pat, return 1 else 0

        int n = text.length();
        int len = pat.length();

        for(int i=0;i<n-len+1;i++) {
            String sub = text.substring(i, i+len);
            if(sub.equals(pat)) return 1;
        }

        return 0;
    }

    public static void sortEmployees(Employee[] arr, int n) {

        Arrays.sort(arr, new ClassPracBkup());
    }

    public static void removeDuplicatesFromArray(int[] arr) {
        // maintain another array visited to mark an element's presence
        // traverse the given array to find max element
        // create visited arr of max+1 size
        // traverse the given array and make visited[ele] = -1
        // traverse the visited array and if ele is -1, print the index

        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] visited = new int[max+1];

        for(int i=0;i<n;i++) {
            int ele = arr[i];
            if(visited[ele] != -1) visited[ele] = -1;
        }

        for(int i=0;i< visited.length;i++) {
            if(visited[i] == -1) {
                System.out.print(i + " ");
            }
        }
    }

    public static int getCount(Node node, int bud) {
        // get an arr consisting of cost of visiting the nodes
        // while bud - arr element is >= 0, update count and deduct budget from arr element
        // traverse the tree
        // if root == null, return
        // if root.left == null && root.right == null, add level to the list
        // recur for left and add level
        // recur for right and add level

        List<Integer> list = new ArrayList<>();
        getCountOfLeafNodes(list, 0, node);
        int count = 0;

        for(Integer e : list) {
            if (bud - e >= 0) {
                count++;
                bud -= e;
            }
        }

        return count;
    }

    public static void getCountOfLeafNodes(List<Integer> list, int level, Node node) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(level);
        }
        getCountOfLeafNodes(list, level+1, node.left);
        getCountOfLeafNodes(list, level+1, node.right);
    }

    public static void kmp(String txt, String pat) {
        // compute LPS array which tells us the index of next char in the pat to be matched instead of whole window
        // in compute LPS array, init len = 0, as length of longest prefix
        // if pat[i] == pat[len], len++, lps[i] = len, i++,
        // else if there's a mismatch, check if len == 0
        //  if no, update len with lps[len-1], if yes, len = 0, lps[i] = 0, i++
        // similarly do while traversing the txt, maintain 2 ptrs i and j for txt and pat
        // while i < txt length, match pat(j) and txt(i), if equal, i++ and j++
        // if j == M, meaning the first index of occurence is j - i
        // else if there's a mismatch, check if j ! = 0, if yes, j = lps[j-1] else j = 0, i++

        int N = txt.length(), M = pat.length();

        int[] lps = new int[M];

        computeLPSArray(lps, M, pat);

        int i = 0, j = 0;

        while(i < N) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if(j==M) {
                // print the index
                System.out.println("i = " + (i-j));
                j = lps[j-1];
            }

            // mismatch
            else if(i < N && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
    }

    public static void computeLPSArray(int[] lps, int M, String pat) {
        int len  = 0;
        int i = 1;
        lps[0] = 0;

        while(i < M) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            else {
                // mismatch
                if(len != 0) {
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void convertArrayToBinaryTree(String str) {
        // convert the string to int arr
        // for every root at index i, left child is 2*i + 1
        // right child is 2*i + 2

        String[] strArr = str.split(" ");

        int[] arr = new int[strArr.length];

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Tree tree = new Tree();

        convertArrayToBinaryTree(arr, 0, tree.root);
    }

    public static Node convertArrayToBinaryTree(int[] arr, int level, Node root) {
        // create a new node
        // add it value as arr[i]
        // make it root
        // it's left child is left recursive call
        // it's right child is right recursive call

        if(level < arr.length) {
            Node tmp = new Node(arr[level]);
            if(tmp.data == -1) {
                tmp = null;
                return tmp;
            }

            root = tmp;

            root.left = convertArrayToBinaryTree(arr, 2*level+1, root.left);
            root.right = convertArrayToBinaryTree(arr, 2*level+2, root.right);
        }

        return root;
    }

    public static Node constructTreeFromInOrderAndPreOrder(int[] pre, int[] in, int start, int end) {
        // take elements one by one from preorder
        // find's it's index in inorder
        // if start == end, return node
        // from start to index-1 is the left subtree
        // from index+1 to end is the right subtree

        if(start > end) return null;

        Node tmp = new Node(pre[preIndex++]);

        if(start == end) return tmp;

        int idx = searchInInOrder(in, tmp.data, start, end);

        tmp.left = constructTreeFromInOrderAndPreOrder(pre, in, start, idx - 1);
        tmp.right = constructTreeFromInOrderAndPreOrder(pre, in, idx + 1, end);

        return tmp;
    }

    public static int searchInInOrder(int[] arr, int k, int start, int end) {
        int i;
        for(i=start;i<=end;i++) {
            if(arr[i] == k) return i;
        }

        return i;
    }

    public static void topKFrequent(int[] arr, int k) {
        // create a heap - priority q on basis of frequency
        // most frequent element at the top
        // get the top of the heap k times
        // create a map of ele vs freq
        // create a priority q, create a lambda function with 2 params, comparing them by value
        // if value is  equal, compare keys
        // else compare values
        // traverse through the map's entryset and add it to q
        // for i =0 to k, poll the q and add it to the res array

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("map = " + map);

        PriorityQueue<Map.Entry<Integer,Integer>> freqHeap = new PriorityQueue<>((a,b) ->
                a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(), a.getKey())
                        : Integer.compare(b.getValue(), a.getValue()));

        for(Map.Entry<Integer,Integer> e: map.entrySet()) {
            freqHeap.offer(e);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] =  freqHeap.poll().getKey();
        }

        Utils.printIntArray(res);
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        // TODO Auto-generated method stub
        if(o1.salary != o2.salary) return o1.salary - o2.salary;

        return o1.name.compareTo(o2.name);
    }


    static void levelOrderTraversalI(Node root) {
        // use null to mark a level as visited
        // init by adding root and null
        // traverse till q is not empty
        // init a list here as when a level changes a new list has to be created
        // while q's peek is not null,
        // poll the q and store it in tmp
        // add the tmp's data into list
        // check for non null left and right child and add it to q
        // outside of while loop, poll the null marker
        // check if q is not empty, if yes, then add null marker
        // add the list to res

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            while(q.peek() != null) {
                Node tmp = q.poll();
                list.add(tmp.data);

                if(tmp.left != null) q.add(tmp.left);
                if(tmp.right != null) q.add(tmp.right);
            }

            q.poll();
            if(!q.isEmpty()) q.add(null);
            res.add(list);

            System.out.println("res = " + res);
        }

        System.out.println("res = " + res);
    }

    HashMap<Integer, Set<Integer>> adj = new HashMap<>();
    Set<Integer> exploring = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int num, int[][] pre){
        // adj matrix creation
        for (int i = 0; i < num; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int i = 0; i < pre.length; i++) {
            adj.get(pre[i][1]).add(pre[i][0]);
        }

        // traverse through the no of courses
        // if a course has not been visited, check if cycle is present with that course
        // if cycle is present, return false as we cannot finish

        for (int i = 0; i < num; i++) {
            if(!visited.contains(i)) {
                boolean hasCycle = detectCycle(i);

                if(hasCycle) return false;
            }
        }
        return true;
    }

    public boolean detectCycle(int i){
        // if this node is present in visited return false
        // if this node is present in exploring return true

        if(visited.contains(i)) return false;

        if(exploring.contains(i)) return true;

        exploring.add(i);

        // for every edge of this vertex, check if it was visited
        // if not, recur for that edge
        // if recursion returns true, return that there's a cycle

        for (int e: adj.get(i)) {
            if(!visited.contains(e)) {
                boolean hasCycle = detectCycle(e);
                if(hasCycle) return true;
            }
        }

        // if we reach here, meaning that vertex is done exploring
        // remove from exploring add it to visited and return false
        exploring.remove(i);
        visited.add(i);
        return false;
    }

    static int count = 0;
    public static int minDepth(Node root) {
        // min depth is no of nodes including root to the nearest leaf node
        // if a node is leaf, return 1
        // if left subtree is null, return 1 + minDepth(root.right)
        // if right subtree is null, return 1 + minDepth(root.left)
        // return 1 + min(minDepth(root.left), minDepth(root.right))

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void numberOfPaths(int m , int n) {
        // for the 1st row, set it as 1 as you can only take right to reach there
        // for the 1st col, set it as 1 as you can only take down to reach there
        // for the rest, either you'll reach there by it's immediate left taking right or immediate up taking down

        int[][] arr = new int[m+1][n+1];

        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
    }

    public static void smallerOnLeft(int[] arr) {
        // start from i = 1, if a[i-1] < a[i], print a[i-1] else -1

        int n = arr.length;
        int min = Integer.MAX_VALUE, lastAns = 0;

        for (int i = 0; i < n; i++) {
            if(i == 0) System.out.print(-1 + " ");
            else {
                if(arr[i-1] < arr[i]) {
                    lastAns = arr[i-1];
                    min = Math.min(min, lastAns);
                    System.out.print(arr[i-1] + " ");
                }
                else {
//                    if(min < arr[i]) System.out.print(min +  " ");
//                    else System.out.print(-1 + " ");
                    System.out.print(min < arr[i] ? min : lastAns);
                }
            }

            System.out.println("min = " + min);
        }
    }

    public static void diffOfValuesAndIndexes(int[] arr) {
        // calculate max of a[i]-a[j] + i-j

        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                ans = Math.max(ans, Math.abs(arr[i]-arr[j]) +  Math.abs(i-j));
            }
        }

        System.out.println("ans = " + ans);
    }

    public static void reArrange(long[] arr, int n) {
        // take this example: a[0] = 4, a[4] = 3
        // a[0] = a[0] + a[a[0]] * n
        // a[0] = (a[0]/n)%n

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + arr[(int)arr[i]] * n;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i]/n) % n;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public static void minSwapsToSort(int[] arr) {
        // copy the arr into another arr
        // sort that arr
        // traverse the arr, if arr[i] != aux[i], count++


        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            if(min_idx != i) {
                int tmp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = tmp;
                count++;
            }

            Utils.printIntArray(arr);
        }

        System.out.println("count = " + count);
    }

    public static int maximumAreaHistogram(int[] arr) {
        // given an arr of heights and width as 1, find max area covered
        // for every element, find nsl and nsr indexes
        // store nsl and nsr indexes in left and right arr
        // to find the width, do r[i] - l[i] - 1
        // to find area, do width[i] * arr[i]
        // find max from area

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
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                if(stack.isEmpty()) left[i] = -1;
                else left[i] = stack.peek();
            }

            stack.push(i);
        }

        System.out.println("NSL indexes array");
        Utils.printIntArray(left);

        stack.clear();

        for (int i = n-1; i >= 0; i--) {
            if(stack.isEmpty()) right[i] = n;
            else if(arr[stack.peek()] < arr[i]) right[i] = stack.peek();
            else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

                if(stack.isEmpty()) right[i] = n;
                else right[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println("NSR indexes array");
        Utils.printIntArray(right);

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
        }

        System.out.println("width indexes array");
        Utils.printIntArray(width);

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, width[i] * arr[i]);
        }

        System.out.println("ans = " + ans);

        return ans;
    }

    public static void maxAreaRectangleInBinaryMatrix(int[][] arr) {
        // given a binary matrix, find out the max area formed by a rectangle
        // convert the given 2d array into 1d array
        // for those 1d array return MAH
        // return max of MAH
        // for converting the given 2d array, check if arr[i][j] is 0 or not,
        // if it's 0, meaning bottom of building is not present, so put 0
        // in the resultant 1d array
        // else increment value of the res

        int n = arr.length;
        int m = arr[0].length;
        int ans = 0;

        int[] res = new int[m];

        for (int j = 0; j < m; j++) {
            res[j] = arr[0][j];
        }

        Utils.printIntArray(res);

        ans = maximumAreaHistogram(res);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) res[j] = 0;
                else res[j] += 1;
            }

            Utils.printIntArray(res);

            ans = Math.max(ans, maximumAreaHistogram(res));
        }

        System.out.println("ans = " + ans);
    }

    public static void rainWaterTrapping(int[] arr) {
        // given an array of heights of building, when it rains, calculate area of water trapped
        // for every arr[i], find the max on left side of array and max on right side of array
        // to find water bound, find min of these 2
        // to find the actual height of water stored above the building, water bound - height of building
        // as width is 1, area is simply all heights, do a sum of all actual heights

        // create an arr maxL to find max on left side, init maxL[0] with arr[0]
        // for i = 1 to n, maxL[i] = max of maxL[i-1] and arr[i]
        // create an arr maxR to find max on right side, init maxR[n-1] with arr[n-1]
        // for i = n-2 to 0, maxR[i] = max of maxR[i+1] and arr[i]
        // create an arr water bound, bound[i] = min of maxL[i] and maxR[i]
        // create an arr stored, stored[i] = bound[i] - arr[i]
        // do a sum of all elements of stored

        int n = arr.length;

        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int[] bound = new int[n];
        int stored = 0;

        maxL[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i-1], arr[i]);
        }

        Utils.printIntArray("maxL array", maxL);

        maxR[n-1] = arr[n-1];

        for (int i = n-2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i+1], arr[i]);
        }

        Utils.printIntArray("maxR array", maxR);

        for (int i = 0; i < n; i++) {
            bound[i] = Math.min(maxL[i], maxR[i]);
        }

        Utils.printIntArray("bound array" , bound);

        for (int i = 0; i < n; i++) {
            stored += bound[i] - arr[i];
        }

        System.out.println("stored = " + stored);
    }

    public static void countingElementsIn2Arrays(int[] arr1, int[] arr2, int m, int n) {
        // sort the arr2
        // do binary search for each element on arr1 in arr2
        // in binary search, if arr[m] > x, h = m - 1
        // else returnIndex = m, l = m + 1

        Arrays.sort(arr2);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int index = binarySearchGetCountOfSmallerOrEqualTo(arr2, arr1[i]);
            res.add(index+1);
        }

        System.out.println("res = " + res);
    }

    public static int binarySearchGetCountOfSmallerOrEqualTo(int[] arr, int key) {
        int n = arr.length;

        int l = 0, h = n-1, idx = -1;

        while(l<=h) {
            int m = (l+h)/2;
            if(arr[m] > key) h = m - 1;
            else {
                idx = m;
                l = m + 1;
            }
        }

        return idx;
    }

    public static void numberOfSubArraysWithSumAsK(int[] arr, int k) {
        // given an array and a value k, find number of subarrays having sum as k
        // use prefix sum method
        // store sum of every element in sum
        // if sum == k, count++
        // create a hashmap to store sum vs count
        // if map contains k - arr[i], update count with map's value
        // else do map.put(sum, count)

        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == k) count++;
            if(map.containsKey(sum - k)) count += map.get(sum - k);
            else map.put(sum, map.getOrDefault(sum, 0) + 1);

            System.out.println("map = " + map);
        }

        System.out.println("count = " + count);
    }

    public static void coinPiles(int[] arr, int k) {
        // given an array of coins, determine min no. of coins to be removed so that abs
        // diff between any 2 array elements is at most k

        // brute force, for i = 0 to n
        // for j = 0 to n, if i & j are not equal
        // check if abs diff of arr[i] - arr[j] > k, update count by arr[i]-arr[j]-k
        // we can sort the array
        // l = 0, h = n-1,
        // while arr[h] - arr[l] > k, update count by arr[h]-arr[l]-k
        // h--

        // we can also remove an entire pile by removing all coins
        // so to do that, do binarysearch of arr[h] - k
        // it returns idx of that element in arr
        // from i =0 to idx, remove the entire pile
        // i.e take another var, removed += arr[i]
        // return min of removed and count

        int n = arr.length;

        Arrays.sort(arr);

        int l = 0, h = n - 1, count = 0;

        while (arr[h] - arr[l] > k) {
            count += arr[h] - arr[l] - k;
            h--;
        }

        h = n - 1;

        int idx = binarySearch(arr, arr[h] - k);
        System.out.println("idx = " + idx);

        int removed = 0;

        for (int i = 0; i < idx; i++) {
            removed += arr[i];
        }

        System.out.println("removed = " + removed);
        System.out.println("count = " + count);

        System.out.println("ans = " + Math.min(removed, count));
    }

    public static int binarySearch(int[] arr, int k) {
        // given an array and key k, find it's index in arr
        // even if k is not present, return that index had it been present

        int n = arr.length;

        int l = 0, h = n - 1;

        while (l < h) {
            int m = (l+h)/2;
            if(arr[m] == k) return m;
            else if(arr[m] < k) l = m + 1;
            else h = m - 1;
        }

        return l;
    }

    public static void frequencySort(int[] arr) {
        // sort the array on basis of frequency of elements
        // create a hashmap of ele vs freq
        // create a max heap with custom comparator that will sort on frequency
        // in descending order
        // poll the heap and print value key times

        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<ClassPrac.Pair> maxHeap = new PriorityQueue<>(new ClassPrac.FreqPairDescendingComp());

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> e: map.entrySet()) {
            maxHeap.add(new ClassPrac.Pair(e.getValue(), e.getKey()));
        }

        maxHeap.forEach(e -> System.out.print("key: " + e.getKey() + " value: " + e.getValue()));
        System.out.println();

        while (maxHeap.size() > 0) {
            ClassPrac.Pair pair = maxHeap.poll();
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
        PriorityQueue<ClassPrac.DistancePair> maxHeap = new PriorityQueue<>(k, new ClassPrac.DistanceComparator());

        for (int i = 0; i < n; i++) {
            int distance = (int) Math.sqrt(arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1]);
            System.out.println("arr[" + i + "]" + "[0]" + arr[i][0]);
            System.out.println("arr[" + i + "]" + "[1]" + arr[i][1]);

            ClassPrac.Pair coordinates = new ClassPrac.Pair(arr[i][0], arr[i][1]);

            ClassPrac.DistancePair distancePair = new ClassPrac.DistancePair(distance, coordinates);
            maxHeap.add(distancePair);

            if(maxHeap.size() > k) maxHeap.poll();

            maxHeap.forEach(e-> System.out.println("key = " + e.getCoordinates().getKey() + " value = " + e.getCoordinates().getValue() + " distance = " + e.getDistance()));
        }


        while (maxHeap.size() > 0) {
            ClassPrac.DistancePair res = maxHeap.poll();
            System.out.println(res.getCoordinates().getKey() + " " + res.getCoordinates().getValue());
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

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int i = 0, j = 0, count = map.keySet().size(), ans = 0;
        int n = s1.length(), k= s2.length();

        while (j < n) {
            // calculation
            char temp = s1.charAt(j);
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);
            }

            if(map.get(temp) == 0) count--;

            // sliding window

            if(j - i + 1 < k) j++;

            else if(j - i + 1 == k) {
                if(count == 0) ans++;

                // slide

                if(map.containsKey(s1.charAt(i))) {
                    map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
                    if(map.get(s1.charAt(i)) == 1) count++;
                }

                i++;
                j++;
            }
        }

        System.out.println("ans = " + ans);
    }


}



class Employee {
    int salary;
    String name;

    public void setSalary(int a)
    {
        this.salary=a;
    }
    public void setName(String s)
    {
        this.name=s;
    }
}

