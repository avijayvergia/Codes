package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class Code3_387 {
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
            int servers = scan.nextInt();
            int test = scan.nextInt();
            int t, k, d;
            int temp;
            int[] a = new int[101001];
            Arrays.fill(a, servers);
            for (int i = 0; i < test; i++) {
                t = scan.nextInt();
                k = scan.nextInt();
                d = scan.nextInt();
                boolean has = true;
                for(int j=1;j<a.length;j++) {
                    out.print(a[j]+" ");
                }
                out.println();
                for (int j = t; j < (t + d); j++) {
                    temp = a[j] - k;
                    if (temp < 0) {
                        out.println(-1);
                        has = false;
                        break;
                    }
                }
                if(has){
                    for(int j=t;j<(t+d);j++){
                        a[j]=a[j]-k;
                    }
                    out.println((k*(k+1))/2);
                }
            }
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