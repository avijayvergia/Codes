import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class test3 {
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
            Vector<Point> v = new Vector<>();
            v.add(new Point(2, 3));
            v.add(new Point(2, 4));
            out.println(v);
            out.println();
            out.println(doGraham(v));
        }

        Point doGraham(Vector<Point> p) {
            int i, j, min, M;
            Point t;
            min = 0;
            for (i = 1; i < p.size(); ++i) {
                if (p.get(i).y < p.get(min).y) {
                   min=i;
                   min=0;
                }
            }
            for (i = 0; i < p.size(); ++i) {
                if ((p.get(i).y == p.get(min).y) && p.get(i).x > p.get(min).x) {
                    min = i;
                }
            }
            return p.get(min);
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