package CodeForces;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Random;

public class Code1_388 {
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
            int n=scan.nextInt();
            int x;
            if(n%2==0) {
                x=n/2;
                out.println(x);
                for (int i = 0; i < x; i++) {
                    out.print(2+" ");
                }
                out.println();
            }
            else{
                x=(n-3)/2;
                out.println(x+1);
                for (int i = 0; i < x; i++) {
                    out.print(2+" ");
                }
                out.print(3);
                out.println();
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