package extras;

import java.io.*;
import java.util.Stack;
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
        void solve(InputReader scan, PrintWriter out) {
            int n = scan.nextInt();
            int num, result=0;
            int[] a=new int[n+1];
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            for (int i = 1; i <= n; i++) {
                num=scan.nextInt();
                a[i]=num;
                if(num>0) stack.push(i);
                else{
                    int pop=a[stack.pop()];
                    if(pop==-num){
                        result=Math.max(result,i- stack.peek());
                    }
                    else stack.push(i);
                }
            }
            out.println(result);
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