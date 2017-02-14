import java.io.*;
import java.util.*;

public class test1 {
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
            String home=scan.next();
            ArrayList<String> set=new ArrayList<>();
            String[] dep=new String[t];
            String[] arr=new String[t];
            String[] temp;
            for (int i = 0; i < t; i++) {
                temp=scan.next().split("->");
                dep[i]=temp[0];
                arr[i]=temp[1];
            }
            for (int i = 0; i < t; i++) {
                if(dep[i].equals(home)) set.add(arr[i]);
            }
            for (int i = 0; i < t; i++) {
                if(!dep[i].equals(home)) set.remove(dep[i]);
            }

            if(set.isEmpty()) out.println("home");
            else out.println("contest");
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

        public long nextLong(){return Long.parseLong(next());}
    }
}