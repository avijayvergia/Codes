package CodeForces;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Random;

public class Code2_GB2016 {
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
            int t = scan.nextInt();
            int x;
            String dir;
            int hor = 0, ver = 0;
            for (int i = 0; i < t; i++) {
                x = scan.nextInt();
                dir = scan.next();
                switch (dir) {
                    case "South":
                        if (ver + x <= 20000) ver += x;
                        else {
                            out.println("NO");
                            return;
                        }
                        break;
                    case "North":
                        if (ver - x >= 0) ver -= x;
                        else {
                            out.println("NO");
                            return;
                        }
                        break;
                    case "West":
                        if(ver==0||ver==20000) {
                            out.println("NO");
                            return;
                        }
                        hor-=x;
                        break;
                    case "East":
                        if(ver==0||ver==20000) {
                            out.println("NO");
                            return;
                        }
                        hor+=x;
                        break;
                }
            }
            if(ver==0) out.println("YES");
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