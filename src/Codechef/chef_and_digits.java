package Codechef;

import java.io.*;
import java.util.StringTokenizer;

class chef_and_digits {
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
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }
            int max = 0, count1, count2;
            for (int i = 0; i < n - 1; i++) {
                count1 = 0;
                count2 = 0;
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(a[i] - a[j]) <= 1) {
                        if (a[i] <= a[j]) count1++;
                        else if (a[i] >= a[j]) count2++;
                    }
                }
                if (count1 < count2) count1 = count2;
                if (max < count1) max = count1;
            }
            out.println(max + 1);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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