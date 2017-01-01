package CodeForces;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Random;

public class Code3_388 {
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
            String x = scan.next();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int[] a = new int[n + 1];
            map.put(1, new ArrayList<>());
            map.put(2, new ArrayList<>());

            for (int i = 0; i < n; i++) {
                if (x.charAt(i) == 'D') {
                    map.get(1).add(i + 1);
                    a[i + 1] = 1;
                } else {
                    map.get(2).add(i + 1);
                    a[i + 1] = 2;
                }
            }

            int i=1;
            while(true){
                if (a[i] == 1) {
                    int index = map.get(2).remove(0);
                    a[index] = 0;
                    if (map.get(2).size() == 0) {
                        out.println('D');
                        return;
                    }
                } else if(a[i]==2) {
                    int index = map.get(1).remove(0);
                    a[index] = 0;
                    if (map.get(1).size() == 0) {
                        out.println("R");
                        return;
                    }
                }
                i=(i+1)%(n+1);
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