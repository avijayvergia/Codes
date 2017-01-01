package CodeForces;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Random;

public class Code1_GB2016 {
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
            int que = scan.nextInt();
            int time = 240 - scan.nextInt();
            float ans = (float) (2 * time) / 5;
            if (ans == 0) {
                out.println(0);
                return;
            }
            int i = 1;
            while (i * (i + 1) <= ans) {
                i++;
            }
            ans = i - 1;
            if (ans > que) ans = que;
            out.println((int)ans);
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