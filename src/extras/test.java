package extras;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class test {
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
            int x, num, y;
            for (int i = 0; i < t; i++) {
                num = scan.nextInt();
                if (num < 38) out.println(num);
                else {
                    x = num / 10;
                    y = num % 10;
                    if (y != 0) {
                        if (y <= 5) x = x * 10 + 5;
                        else if (y > 5) x = x * 10 + 10;
                    }
                    else{
                        out.println(num);
                        continue;
                    }
                    if (x - num < 3) out.println(x);
                    else out.println(num);

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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}