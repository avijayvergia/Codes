package CodeForces;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Random;

public class Code2_388 {
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
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int x3 = scan.nextInt();
            int y3 = scan.nextInt();

            int ansX1 = x1 + x2 - x3;
            int ansY1 = y1 + y2 - y3;
            int ansX2 = x1 + x3 - x2;
            int ansY2 = y1 + y3 - y2;
            int ansX3 = x2 + x3 - x1;
            int ansY3 = x2 + x3 - x1;

            String one = String.valueOf(ansX1) + " " + String.valueOf(ansY1);
            String two = String.valueOf(ansX2) + " " + String.valueOf(ansY2);
            String three = String.valueOf(ansX3) + " " + String.valueOf(ansY3);

            HashSet<String> set=new HashSet<>();
            set.add(one);set.add(two);set.add(three);
            out.println(set.size());
            for (String s : set) {
                out.println(s);
            }

        }


        int cross(int[] A, int[] B, int[] C){
            int[] AB = new int[2];
            int[] AC = new int[2];
            AB[0] = B[0]-A[0];
            AB[1] = B[1]-A[1];
            AC[0] = C[0]-A[0];
            AC[1] = C[1]-A[1];
            int cross = AB[0] * AC[1] - AB[1] * AC[0];
            return cross;
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