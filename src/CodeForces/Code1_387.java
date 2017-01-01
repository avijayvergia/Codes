package CodeForces;

import java.io.*;
import java.util.*;

public class Code1_387 {
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
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i = 2; i <= n/2; i++) {
                if(n%i==0) map.put(Math.abs(i-(n/i)),i);
            }
            map.put(n-1,1);
            Optional<Integer> ans=map.keySet().stream().min(Comparator.naturalOrder());

            int a=map.get(ans.get());
            int b=n/a;
            if(a>b) out.println(b+" "+a);
            else out.println(a+" "+b);
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