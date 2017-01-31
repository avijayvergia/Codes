import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Random;

public class test2 {
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
            int[] b = new int[n];
            int t = scan.nextInt();
            int x, y;
            x = scan.nextInt();
            int s1 = 0;

            boolean flag=false;

            for (int i = 1; i < n; i++) {
                y = scan.nextInt();
                s1 += y - x;
                a[i - 1] = y - x;
                x = y;
            }

            if(s1==0&&x<=t) flag=true;

            a[n - 1] = t - s1;
            Arrays.sort(a);
            x = scan.nextInt();
            int s2 = 0;
            for (int i = 1; i < n; i++) {
                y = scan.nextInt();
                s2 += y - x;
                b[i - 1] = y - x;
                x = y;
            }
            b[n - 1] = t - s2;
            Arrays.sort(b);

            for (int i = 0; i < n; i++) {
                out.print(a[i]);
            }
            out.println();
            for (int i = 0; i < n; i++) {
                out.print(b[i]);
            }
            out.println();
            if(flag&&s2==0&&x<=t) {
                out.println("YES");
                return;
            }

            if (Arrays.equals(a, b)) out.println("YES");
            else out.println("NO");


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