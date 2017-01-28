package extras;

import java.io.*;
import java.util.*;

public class test {
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
            String string = scan.next();
            Stack<Node> stack = new Stack<>();
            int mod;
            Node temp;
            for (int i = 0; i < string.length(); i++) {
                mod = string.charAt(i) - 'a' + 1;
                if (stack.size() != 0) {
                    temp = stack.peek();
                    if (mod == temp.c) {
                        stack.push(new Node(mod, temp.times + 1));
                    } else {
                        stack.push(new Node(mod, 1));
                    }
                } else {
                    stack.push(new Node(mod, 1));
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (Node node : stack) {
                set.add(node.c * node.times);
            }
            int t = scan.nextInt();
            int num;
            for (int i = 0; i < t; i++) {
                num = scan.nextInt();
                if (set.contains(num)) {
                    out.println("Yes");
                } else out.println("No");
            }
        }

        class Node {
            int c, times;

            public Node(int c, int times) {
                this.c = c;
                this.times = times;
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}