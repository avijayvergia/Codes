package CodeForces;

import java.io.*;
import java.util.*;

public class Code2_387 {
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
            if (n % 4 != 0) {
                out.println("===");
                return;
            }
            String string = scan.next();

            HashMap<Character, Integer> map = new HashMap<>();
            map.put('C', 0);
            map.put('G', 0);
            map.put('T', 0);
            map.put('A', 0);
            int val = n / 4;
            Character c;
            int que = 0;
            for (int i = 0; i < string.length(); i++) {
                c = string.charAt(i);
                if (c == '?') que++;
                else
                    map.put(c, map.get(c) + 1);
            }
            Queue<Character> queue = new LinkedList<>();
            int a;
            boolean change=false;
            for (Map.Entry<Character, Integer> x : map.entrySet()) {
                if (que < 0&&change || x.getValue()>val) {
                    out.println("===");
                    return;
                }
                if (x.getValue() < val) {
                    a = x.getValue();
                    for(int j=0;j<val-a;j++){
                        queue.add(x.getKey());
                    }
                    que -= val - a;
                    change=true;
                }
            }
            for (int i = 0; i < n; i++) {
                if (string.charAt(i) == '?') out.print(queue.poll());
                else out.print(string.charAt(i));
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