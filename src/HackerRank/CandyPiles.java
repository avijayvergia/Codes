package HackerRank;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class CandyPiles {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader scan, PrintWriter out) {
            int t = scan.nextInt();
            int[] a = new int[t];
            for (int i = 0; i < t; i++) {
                a[i] = scan.nextInt();
            }
            Arrays.sort(a);
            int min = a[0];
            int count = count(a, min, a.length);
            a[0]=a[0]*2;
            Arrays.sort(a);
            int ans=a[0];
            count=count-last(a,0,a.length-1,ans,a.length)+t-2;
            out.println(ans+" "+count);
        }

        int count(int arr[], int x, int n) {
            int i; // index of first occurrence of x in arr[0..n-1]
            int j; // index of last occurrence of x in arr[0..n-1]

  /* get the index of first occurrence of x */
            i = first(arr, 0, n - 1, x, n);

  /* If x doesn't exist in arr[] then return -1 */
            if (i == -1)
                return i;

  /* Else get the index of last occurrence of x. Note that we
      are only looking in the subarray after first occurrence */
            j = last(arr, i, n - 1, x, n);

  /* return count */
            return j - i + 1;
        }

        /* if x is present in arr[] then returns the index of FIRST occurrence
           of x in arr[0..n-1], otherwise returns -1 */
        int first(int arr[], int low, int high, int x, int n) {
            if (high >= low) {
                int mid = (low + high) / 2;  /*low + (high - low)/2;*/
                if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                    return mid;
                else if (x > arr[mid])
                    return first(arr, (mid + 1), high, x, n);
                else
                    return first(arr, low, (mid - 1), x, n);
            }
            return -1;
        }


        /* if x is present in arr[] then returns the index of LAST occurrence
           of x in arr[0..n-1], otherwise returns -1 */
        int last(int arr[], int low, int high, int x, int n) {
            if (high >= low) {
                int mid = (low + high) / 2;  /*low + (high - low)/2;*/
                if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                    return mid;
                else if (x < arr[mid])
                    return last(arr, low, (mid - 1), x, n);
                else
                    return last(arr, (mid + 1), high, x, n);
            }
            return -1;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}