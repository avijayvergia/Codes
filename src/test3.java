import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            int t=scan.nextInt();
            int[] a=new int[t];
            for (int i = 0; i < t; i++) {
                a[i]=scan.nextInt();
            }
            Arrays.sort(a);
            int count=0;
            int min=Integer.MAX_VALUE;
            int temp;
            for (int i = 1; i < t; i++) {
                temp=a[i]-a[i-1];
                if(temp<min) {
                    min=temp;
                    count=1;
                }
                else if(temp==min) count++;
            }
            out.println(min+" "+count);
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