import java.io.*;
import java.util.*;

public class test1 {
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
            long n = scan.nextLong();
            int k = scan.nextInt();
            TreeSet<Long> set=new TreeSet<>();
            for (int i = (int) (Math.sqrt(n) + 1); i > 0; i--) {
                if (n % i == 0) {
                    if (!set.contains((long)i)) set.add((long) i);
                    if (!set.contains(n / i)) set.add(n / i);
                }
            }
            long a = -1;
            if(k>set.size()) {
                out.println(-1);
                return;
            }
            for (Long aSet : set) {
                if(k==0) break;
                else {
                    a=aSet;
                    k--;
                }
            }
            out.println(a);
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

        public long nextLong(){return Long.parseLong(next());}
    }
}