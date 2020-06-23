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

            ClassPrac.sumOfDistinctElements(arr, n);
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

          ClassPrac.countOfSubarraysWithKPrime(arr,k);
        }

    }
    
    public static void inputAsTc2Strings() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String a = br.readLine();
            String b = br.readLine();

            ClassPrac.countOccurencesOfAnagrams(a, b);
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
