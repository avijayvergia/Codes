package extras;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class test {
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
            int w=scan.nextInt();
            int c=scan.nextInt();
            int count=0;
            ArrayList<Integer> list=new ArrayList<>();
            for (int i = 0; i < c; i++) {
                int a=scan.nextInt();
                int item=scan.nextInt();
                for (int j = 0; j < a; j++) {
                    list.add(count,item);
                    count++;
                }
            }
            int[] wei=new int[list.size()];
            int[] val=new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                val[i]=list.get(i);
            }
            Arrays.fill(wei,1);
            out.println(bottomUpDP(val,wei,w));
        }

        public int bottomUpDP(int val[], int wt[], int W){
            int K[][] = new int[val.length+1][W+1];
            for(int i=0; i <= val.length; i++){
                for(int j=0; j <= W; j++){
                    if(i == 0 || j == 0){
                        K[i][j] = 0;
                        continue;
                    }
                    if(j - wt[i-1] >= 0){
                        K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                    }else{
                        K[i][j] = K[i-1][j];
                    }
                }
            }
            return K[val.length][W];
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
        public long nextLong(){
            return Long.parseLong(next());
        }
    }
}