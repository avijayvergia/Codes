package HackerRank;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Random;

public class ZeroMove_NIM {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    // Grundy Numbers

    static class Task {
        public void solve(InputReader scan, PrintWriter out) {
            int t = scan.nextInt();
            int noOfPiles;

            for (int i = 0; i < t; i++) {
                noOfPiles=scan.nextInt();
                int ans = 0;
                for (int j = 0; j < noOfPiles; j++) {
                    ans^=fun(scan.nextInt());
                }
                if(ans!=0) out.println('W');
                else out.println('L');
            }
        }

        int fun(int x){
            if(Integer.numberOfTrailingZeros(x)==0) return x+1;
            else return x-1;
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