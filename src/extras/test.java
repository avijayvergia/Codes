package extras;

import java.io.*;
import java.util.*;

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
        int row, count = 0;
        int[] r = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] c = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[][] a;

        public void solve(InputReader scan, PrintWriter out) {
            row = scan.nextInt();
            a = new int[row][row];
            int ob = scan.nextInt();
            int l = scan.nextInt() - 1;
            int m = scan.nextInt() - 1;
            a[l][m] = 1;
            int x, y;
            for (int i = 0; i < ob; i++) {
                x = scan.nextInt() - 1;
                y = scan.nextInt() - 1;
                a[x][y] = -1;
            }
            for (int i = 0; i < 8; i++) {
                find(i, l, m);
            }
            out.println(count);
        }

        int locX, locY;
        private void find(int i, int posX, int posY) {
            locX = posX + r[i];
            locY = posY + c[i];
            if (isValid(locX, locY) && a[locX][locY] != -1) {
                count++;
                find(i, locX, locY);
            }
        }

        boolean isValid(int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < row;
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