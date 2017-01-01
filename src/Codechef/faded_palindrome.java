package Codechef;

import java.io.*;
import java.util.StringTokenizer;

class faded_palindrome {
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
            char[] a;
            String x;
            int length;
            int alt;
            boolean flag=false;
            for (int i = 0; i < t; i++) {
                x=scan.next();length=x.length();
                a=new char[length];
                isFlag(out, a, x, length, flag);
            }
        }

        private void isFlag(PrintWriter out, char[] a, String x, int length, boolean flag) {
            int alt;
            for(int j = 0; j<=(length-1)/2; j++){
                a[j]=x.charAt(j);
                alt=length-1-j;
                a[alt]=x.charAt(alt);
                if(a[j]=='.'||a[alt]=='.') {
                    if(a[j]=='.'&&a[alt]=='.') a[j]=a[alt]='a';
                    else if(a[j]=='.') a[j]=a[alt];
                    else a[alt]=a[j];
                }
                else if(a[j]!=a[alt]){
                    flag=true;
                    out.println(-1);
                    break;
                }
            }
            if(!flag){
                out.println(String.valueOf(a));
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