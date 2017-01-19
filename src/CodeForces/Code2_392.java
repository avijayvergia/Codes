package CodeForces;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Code2_392 {
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

        HashMap<Character, Integer> map;
        HashSet<Character> set=new HashSet<>();
        char[] ori;
        char[] color = {'R', 'B', 'G', 'Y'};
        public void solve(InputReader scan, PrintWriter out) {
            map = new HashMap<>();
            map.put('R', 0);
            map.put('B', 0);
            map.put('G', 0);
            map.put('Y', 0);

            ori = scan.next().toCharArray();
            find(ori.clone(), 0);
            for (Integer integer : map.values()) {
                out.print(integer + " ");
            }
        }

        void find(char[] a, int n) {
            if (n == a.length) {
                if(isValid(a)){
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] != ori[i]) {
                            map.put(a[i], map.get(a[i]) + 1);
                        }
                    }
                }
                return;
            }
            if (a[n] == '!') {
                for (char c : color) {
                    a[n] = c;
                    find(a, n + 1);
                }
            }
            else find(a, n + 1);
        }


        private boolean isValid(char[] a) {
            for(int i=3;i<a.length;i++){
                for(int j=i;j<=i-3;j--){
                    set.add(a[j]);
                }
                if(set.size()!=4) return false;
                set.clear();
            }
            return true;
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