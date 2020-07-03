import LeetCode.Problems;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TemplateClass {

    public static void inputAsTcNArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

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

            ClassPrac.minIndexedString(a, b);
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


    public static void inputAsTcString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String s = br.readLine();
            Problems.romanToInteger(s);
        }
    }
    
    public static void inputAsTcStringArr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] a = br.readLine().split(",");

        }
    }

    public static void main (String[] args) throws IOException
    {
        //code
        inputAsTcString();
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
