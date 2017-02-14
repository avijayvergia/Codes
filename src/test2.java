import java.io.*;
import java.util.StringTokenizer;

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
        public void solve(InputReader scan, PrintWriter out) {
            int n = scan.nextInt();
            Node[] a = new Node[n];
            for (int i = 0; i < n; i++) {
                a[i]=new Node();
                a[i].gene = scan.next();
            }
            for (int i = 0; i < n; i++) {
                a[i].value = scan.nextInt();
            }
            int t = scan.nextInt();
            int start, end;
            String d;
            int sum;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < t; i++) {
                sum = 0;
                start = scan.nextInt();
                end = scan.nextInt();
                d = scan.next();
                for (int j = start; j <= end; j++) {
                    sum += findOccur(a[j].gene, d) * a[j].value;
                }
                if (sum < min) min = sum;
                if (sum > max) max = sum;
            }
            out.println(min + " " + max);
        }

        class Node {
            int value;
            String gene;
        }

        int findOccur(String findStr, String str) {
            int count = 0;
            int len = findStr.length();
            for (int i = 0; i <= str.length() - len; i++) {
                if(len==1){
                    if(str.charAt(i)==findStr.charAt(0)) count++;
                }
                else{
                    if (str.substring(i, i + len).equals(findStr)) count++;
                }
            }
            return count;
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