package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class Code2_389 {
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
            String a = scan.next();
            String b = scan.next();
            int[] array = new int[26];
            Arrays.fill(array, -1);

            if (a.length() != b.length()) {
                out.println(-1);
                return;
            }

            int a1, a2;
            for (int i = 0; i < a.length(); i++) {
                a1 = a.charAt(i) - 'a';
                a2 = b.charAt(i) - 'a';
                if (array[a1] == -1 && array[a2] == -1) {
                    array[a1] = a2;
                    array[a2] = a1;
                } else if (array[a1] != a2) {
                    out.println(-1);
                    return;
                }
            }

            int[] x = new int[26];

            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (array[i] != i&&array[i]!=-1) {
                    count++;
                }
            }
            out.println(count/2);
            for (int i = 0; i < 26; i++) {
                if (array[i] != i&&array[i]!=-1) {
                    if(x[i]==0){
                        out.println((char)(i+97)+" "+(char)(array[i]+97));
                        x[i]=-1;x[array[i]]=-1;
                    }
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