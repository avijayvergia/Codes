package CodeForces;

import java.io.*;
import java.util.*;

public class Code3_390 {
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
        public void solve(InputReader pto, PrintWriter out) {
            Scanner scan=new Scanner(System.in);
            int t = scan.nextInt();
            for (int i = 0; i < t; i++) {
                int people = scan.nextInt();
                ArrayList<String> list = new ArrayList<>();
                for (int i1 = 0; i1 < people; i1++) {
                    list.add(scan.next());
                }
                HashMap<Integer, ArrayList<String>> map = new HashMap<>();
                int chat = scan.nextInt();
                for (int j = 0; j < chat; j++) {
                    ArrayList<String> ab=new ArrayList<>(list);
                    map.put(j, ab);
                }
                String[] x;
                ArrayList<String> temp=new ArrayList<>();

                scan.nextLine();
                for (int j = 0; j < chat; j++) {
                    String a=scan.nextLine();
                    x =a.split(" ");
                    String username = x[0].substring(0, x[0].length() - 1);
                    temp.add(a.substring(x[0].length()));
                    if (list.contains(username)) {
                        map.get(j).clear();
                        map.get(j).add(username);
                        if (j - 1 >= 0) map.get(j - 1).remove(username);
                        if (j + 1 < chat) map.get(j + 1).remove(username);
                    }
                    else {
                        String temp2;
                        for (int k = 1; k < x.length; k++) {
                            if (map.get(j).contains(x[k])) map.get(j).remove(x[k]);
                            temp2=x[k].substring(0,x[k].length()-1);
                            if (map.get(j).contains(temp2)) map.get(j).remove(temp2);
                        }
                        if (map.get(j).size() == 0) {
                            out.println("IMPOSSIBLE");
                            return;
                        }
                        if (map.get(j).size() == 1) {
                            if (j - 1 >= 0) map.get(j - 1).remove(map.get(j).get(0));
                            if (j + 1 < chat) map.get(j + 1).remove(map.get(j).get(0));
                        }
                    }
                }

                for (ArrayList<String> strings : map.values()) {
                    if(strings.size()!=1) {
                        out.println("IMPOSSIBLE");
                        return;
                    }
                }
                int count=0;
                for (ArrayList<String> strings : map.values()) {
                    out.print(strings.get(0)+":");
                    out.println(temp.get(count));
                    count++;
                }
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