package HackerRank;

import java.io.*;
import java.util.*;

public class unexpected_problem {
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
            int x=scan.nextInt();
            PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.naturalOrder());
            int num;
            for (int i = 0; i < x; i++) {
                num=scan.nextInt();
                if(!queue.contains(num)) queue.add(num);
            }

            int size=queue.size();
            int[] a=new int[size];
            for(int i=0;i<size;i++){
                a[i]= queue.poll();
            }

            for (int anA : a) out.print(anA + " ");
            out.println();

            x=scan.nextInt();
            int index;
            for (int i = 0; i < x; i++) {
                index=Arrays.binarySearch(a,scan.nextInt());
                if(index<0) index=-(index+1);
                else index++;
                out.print(index+" ");
                out.println(size-index+1);
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