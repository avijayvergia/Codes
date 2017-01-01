package Codechef;

import java.io.*;
import java.util.*;

public class chef_and_calculations {
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
            scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            String s = scan.next();
            if (s.charAt(a - 1) == s.charAt(b - 1)) {
                out.println(0);
            } else {
                TreeSet<Integer> tree1 = new TreeSet<>();
                TreeSet<Integer> tree2 = new TreeSet<>();

                tree1.add(b);
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == s.charAt(a - 1)) {
                        tree1.add(i + 1);
                    }
                    else{
                        tree2.add(i+1);
                    }
                }
                int lower;
                try{
                    lower=tree1.lower(b);
                    lower=Math.abs(lower-tree2.ceiling(lower));
                }
                catch (NullPointerException e){
                    lower=0;
                }
                int higher;
                try{
                    higher = tree1.higher(b);
                    higher=Math.abs(higher-tree2.floor(higher));
                }
                catch (NullPointerException e){
                    higher=0;
                }
                if (lower != 0 && higher != 0) {
                    out.println(Math.min(higher,lower));
                } else if (lower == 0) {
                    out.println(higher);
                } else out.println(lower);
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