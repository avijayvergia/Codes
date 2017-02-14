import java.io.*;
import java.util.LinkedList;
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

            String x = scan.next();
            LinkedList<Character> set = new LinkedList<>();
            for (int i = 0; i < x.length(); i++) {
                if (!set.contains(x.charAt(i))) set.add(x.charAt(i));
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < set.size(); i++) {
                str.append((char) ('a' + i));
            }
            for(int i=0;i<set.size();i++){
                if(set.get(i)!=str.charAt(i)) {
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");

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