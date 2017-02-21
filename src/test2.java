import java.io.*;
import java.util.StringTokenizer;

public class test2 {
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
            int t=scan.nextInt();
            int[] a=new int[t];
            for (int i = 0; i < t; i++) {
                a[i]=scan.nextInt();
            }
            int n=t/2;
            out.println(minSwaps(n,a));

        }

        void updateindex(int index[], int a, int ai, int b, int bi) {
            index[a] = ai;
            index[b] = bi;
        }

        void swap(int[] arr, int i, int i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
        }

        int minSwaps(int n, int arr[])
        {
            int[] index=new int[2*n + 1]; // To store indices of array elements

            // Store index of each element in array index
            for (int i = 1; i <= 2*n; i++)
                index[arr[i]] = i;

            // Call the recursive function
            return minSwapsUtil(arr, index, 1, 2*n);
        }

        int minSwapsUtil(int arr[], int index[], int i, int n) {
            // If all pairs procesed so no swapping needed return 0
            if (i > n) return 0;

            // If current pair is valid so DO NOT DISTURB this pair
            // and move ahead.
            if (arr[i] == arr[i + 1])
                return minSwapsUtil(arr, index, i + 2, n);

            // If we reach here, then arr[i] and arr[i+1] don't form a pair

            // Swap pair of arr[i] with arr[i+1] and recursively compute
            // minimum swap required if this move is made.
            int one = arr[i + 1];
            int indextwo = i + 1;
            int indexone = index[arr[i]];
            int two = arr[index[arr[i]]];
            swap(arr, arr[i + 1], arr[indexone]);
            updateindex(index, one, indexone, two, indextwo);
            int a = minSwapsUtil(arr, index, i + 2, n);

            // Backtrack to previous configuration. Also restore the
            // previous indices, of one and two
            swap(arr, arr[i + 1], arr[indexone]);
            updateindex(index, one, indextwo, two, indexone);
            one = arr[i];
            indexone = index[arr[i + 1]];

            // Now swap arr[i] with pair of arr[i+1] and recursively
            // compute minimum swaps required for the subproblem
            // after this move
            two = arr[index[arr[i + 1]]];
            indextwo = i;
            swap(arr, arr[i], arr[indexone]);
            updateindex(index, one, indexone, two, indextwo);
            int b = minSwapsUtil(arr, index, i + 2, n);

            // Backtrack to previous configuration.  Also restore
            // the previous indices, of one and two
            swap(arr, arr[i], arr[indexone]);
            updateindex(index, one, indextwo, two, indexone);

            // Return minimum of two cases
            return 1 + Math.min(a, b);
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