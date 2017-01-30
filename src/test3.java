import java.io.*;
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
            String a=scan.next();
            String b=scan.next();
            out.println(lcsDynamic(a.toCharArray(),b.toCharArray()));
        }

        public String lcsDynamic(char str1[], char str2[]) {
            int temp[][] = new int[str1.length + 1][str2.length + 1];
            int max = 0;
            StringBuilder x=new StringBuilder();
            for (int i = 1; i < temp.length; i++)
                for (int j = 1; j < temp[i].length; j++) {
                    if (str1[i - 1] == str2[j - 1]) temp[i][j] = temp[i - 1][j - 1] + 1;
                    else temp[i][j] = temp[i][j - 1];
                    if (temp[i][j] > max) {
                        x.append(str1[i]);
                        max = temp[i][j];
                    }
                }
            return x.toString();
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