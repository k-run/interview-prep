import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TemplateClass {

    public static void inputAsTcNArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(str[j]);
                //stack.push(arr[j]);
            }
            ClassPrac.singleNumberII(arr);
        }
    }
    
    public static void inputAsTcNKArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

        }

    }
    
    public static void inputAsTc2Strings() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String a = br.readLine();
            String b = br.readLine();

            //ArrayList<String> list = new ArrayList<>(Utils.getListFromStringArray(a.split(" ")));
            //ClassPrac.findLargestWordInADict(a.split(","), b);
            ClassPrac.findLargestWordInDictionary(a.split(" "), b);
        }
    }
    
    public static void inputAsTcMatrixPoints() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] rc = (br.readLine().split(" "));
            int row = Integer.parseInt(rc[0]);

            int col = Integer.parseInt(rc[1]);

            int[][] arr = new int[row][col];

            String[] data = br.readLine().split(" ");

            int l = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    int arrItem = Integer.parseInt(data[l++]);
                    arr[j][k] = arrItem;
                }

            }

            String[] points = br.readLine().split(" ");

            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);

            Point a = new Point(x1, y1);
            Point b = new Point(x2, y2);
            
        }
    }
    
    public static void inputAsTcN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

        }
    }
    
    public static void inputAsTcKArrays() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

                ClassPrac.maxValueAfterMRange(n,k);
            }

        }


    public static void inputAsTcStrings() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String a = br.readLine();

        }
    }

    public static void inputAsListOfList() throws IOException {

    }

    public static void  inputAsTcNMultiDArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            String[] str = br.readLine().split(" ");
            int[][] a = new int[n][m];

            int idx = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = Integer.parseInt(str[idx++]);
                }
            }

//            String[] startEnd = br.readLine().split(" ");
//            int x1 = Integer.parseInt(startEnd[0]);
//            int y1 = Integer.parseInt(startEnd[1]);
//
//            int x2 = Integer.parseInt(startEnd[2]);
//            int y2 = Integer.parseInt(startEnd[3]);
//
//           MyPoint myPoint = new MyPoint(x1, y1);
//           MyPoint myPoint1 = new MyPoint(x2, y2);
//           ClassPrac.additionOfSubMatrix(a, myPoint, myPoint1);

//            int[][] arr = new int[n][m];
//            List<List<String>> lists = new ArrayList<>();
//
//            for (int j = 0; j < n; j++) {
//                String[] s = br.readLine().split(" ");
//                lists.add(Utils.getListFromStringArray(s));
//            }
//
//            //System.out.println("lists = " + lists);
//
//
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    arr[j][k] = Integer.parseInt(lists.get(j).get(k));
//                }
//            }


        }
    }

    public static void inputAsTcNKList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

            //ClassPrac.threeWayPartitioning(list, n, k);
        }

    }

    public static void inputAsTcNListAB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            String[] nk = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(nk[j]));
            }

            String[] ab = br.readLine().split(" ");

            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            //List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

            //ClassPrac.threeWayPartitioning(list, a, b);
        }

    }

    public static void inputAsTcList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] a = br.readLine().split(" ");
            List<String> list = new ArrayList<>(Arrays.asList(a));

            List<Integer> arr = new ArrayList<>();
            System.out.println("list = " + list);

            for (String s: list) {
                arr.add(Integer.parseInt(s));
            }

        }
    }

    public static void inputAsTcNMultiArrays() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] nm = br.readLine().split(" ");
            int m = Integer.parseInt(nm[0]);
            int n = Integer.parseInt(nm[1]);

            int[] arr1 = new int[m];
            int[] arr2 = new int[n];

            String[] str1 = br.readLine().split(" ");
            String[] str2 = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr1[j] = Integer.parseInt(str1[j]);
            }

            for (int j = 0; j < n; j++) {
                arr2[j] = Integer.parseInt(str2[j]);
            }

            String res = ClassPrac.arraySubsetOfAnotherArray(arr1, arr2);

            System.out.println("res = " + res);
        }
    }

    public static void main (String[] args) throws IOException
    {
        //code
      inputAsTcNArray();
    }

    public static void maxAfterMIncrementsDriver(BufferedReader br, int n, int m) throws IOException {
        // increment all values from a to b by k
        // after all operations return max
        int[] arr = new int[n];
        while(m-- > 0) {
            String[] abk = br.readLine().split(" ");
            int a = Integer.parseInt(abk[0]);
            int b = Integer.parseInt(abk[1]);
            int k = Integer.parseInt(abk[2]);

            for (int i = a; i <= b ; i++) {
                arr[i] += k;
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);

    }


}
