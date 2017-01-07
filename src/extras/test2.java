package extras;

import java.io.*;
import java.util.*;

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

        HashMap<Integer, Integer> map;

        void solve(InputReader scan, PrintWriter out) {

            int n=scan.nextInt();
            map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                map.put(i, 0);
            }
            getPrime(n);
            int max=0;
            int ans=0;
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                if(max<=x.getValue()){
                    max=x.getValue();
                    ans=x.getKey();
                }
            }
            out.print(ans);
        }


        public void getPrime(int n){
            for (int j = 2; j <=n; j++) {
                if (isPrime(j)) {
                    int x;
                    int l = j;
                    while (l > 0) {
                        x = l % 10;
                        map.put(x, map.get(x) + 1);
                        l = l / 10;
                    }
                }
            }
        }

        public boolean isPrime(int m){
            for (int i = 2; i <= Math.sqrt(m); i++) {
                if (m % i == 0)
                    return false;
            }
            return true;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}