package CodeForces;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class segment {
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
            int start = scan.nextInt();
            int end = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int k = scan.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            set.add(start);
            set.add(end);

            if (set.ceiling(x) == null || set.floor(y) == null) {
                out.println(0);
                return;
            }
            int suc = set.ceiling(x);
            int pre = set.floor(y);
            int ans;
            if (pre == suc) {
                if (pre == start) {
                    ans = y - start;
                } else ans = end - x;
            } else {
                ans = y - x;
            }
            if(ans>(end-start)){
                ans=end-start;
                if(k>=start&&k<=end) --ans;
            }
            else if (k >= x && k <= y) {
                --ans;
            }
            out.println(++ans);
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