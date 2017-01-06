package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class Code2_390 {
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
            int[][] a = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    a[i][j] = scan.nextInt();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (a[i][j] == '.') {
                        a[i][j] = 'x';
                        if (Arrays.toString(a[i]).contains("xxx")) {
                            out.println("YES");
                            return;
                        }
                        StringBuilder string1 = new StringBuilder();
                        for (int k = 0; k < 4; k++) {
                            string1.append(a[k][j]);
                        }
                        if (string1.toString().contains("xxx")) {
                            out.println("YES");
                            return;
                        }
                        StringBuilder string2 = new StringBuilder();
                        string2.append(a[i - 2][j + 2]);
                        string2.append(a[i - 1][j + 1]);
                        string2.append(a[i][j]);
                        string2.append(a[i + 1][j - 1]);
                        string2.append(a[i + 2][j - 2]);
                        if(string2.toString().contains("xxx")){
                            out.println("YES");
                            return;
                        }

                        StringBuilder string3 = new StringBuilder();
                        string3.append(a[i - 2][j - 2]);
                        string3.append(a[i - 1][j - 1]);
                        string3.append(a[i][j]);
                        string3.append(a[i + 1][j + 1]);
                        string3.append(a[i + 2][j + 2]);
                        if(string3.toString().contains("xxx")){
                            out.println("YES");
                            return;
                        }

                        a[i][j]='.';
                    }
                }
            }
            out.println("NO");
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