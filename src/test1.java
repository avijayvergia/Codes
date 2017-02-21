import java.io.*;
import java.util.StringTokenizer;

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

        int[] arr=new int[100001];
        public void solve(InputReader scan, PrintWriter out) {
            int t=scan.nextInt();
            int a,b;
            for (int i = 0; i < t; i++) {
                a=scan.nextInt();
                b=scan.nextInt();
                int ans=0;
                for (int j = a; j <= b;j++) {
                    if(j%2!=0) ans^=j;
                    else ans^=find(j);
                }
                out.println(ans);
            }
        }

        int find(int x){
            if(arr[x]!=0) return arr[x];
            if(x%2!=0) arr[x]=x;
            else arr[x]=find(x/2);
            return arr[x];
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