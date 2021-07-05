import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int n = arr.length;

        int[] maxUpTo = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int valOrZero = Math.max(0, val);
            
            int max1 = get(maxUpTo, i - 1);
            int max2 = get(maxUpTo, i - 2);
            
            int temp = max1 + valOrZero;
            maxUpTo[i] = Math.max(max1, max2 + valOrZero);
        }
        return maxUpTo[n -1];
    }
    
    private static int get(int[] values, int index) {
        if (index < 0) {
            return 0;
        } else {
            return values[index];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}