import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Random;

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
            int u=scan.nextInt();
            int p=scan.nextInt();
            int b=scan.nextInt();
            int t=scan.nextInt();
            int total=u+p+b;
            PriorityQueue<Integer> usb=new PriorityQueue<>();
            PriorityQueue<Integer> ps=new PriorityQueue<>();
            int c;
            String what;
            for (int i = 0; i < t; i++) {
                c=scan.nextInt();
                what=scan.next();
                if(what.startsWith("U")){
                    usb.add(c);
                }
                else {
                    ps.add(c);
                }
            }
            long sum=0;
            while (!usb.isEmpty()){

                if(u==0){
                    break;
                }
                sum+=usb.poll();
                u--;
            }
            while (!ps.isEmpty()){

                if(p==0) break;
                sum+=ps.poll();
                p--;
            }
            usb.addAll(ps);
            while (!usb.isEmpty()){

                if(b==0){
                    break;
                }
                sum+=usb.poll();
                b--;
            }
            out.println(total-(u+b+p)+" "+sum);

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