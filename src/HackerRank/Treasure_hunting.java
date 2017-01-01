package HackerRank;

import java.io.*;
import java.util.*;

public class Treasure_hunting {
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
        char[][] array,two;
        int count1, count2,count3;

        public void solve(InputReader scan,PrintWriter out) {
            HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 6, 7, 8, 13, 14, 15, 20, 21, 22, 27, 28, 29, 34, 35, 36, 41, 42, 43, 48, 49, 50, 55));
            int n = scan.nextInt();
            array = new char[n][n];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (set.contains(i * j)) {
                        array[i - 1][j - 1] = '_';
                    } else {
                        array[i - 1][j - 1] = 'x';
                    }
                }
            }
            /*find(array, n);*/





            two=array.clone();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(two[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();

            two=rotate(two);
            count1=compare(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(two[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("count: "+count1);
            System.out.println();
            two=rotate(two);
            count2=compare(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(two[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("count: "+count2);
            System.out.println();
            two=rotate(two);
            count3=compare(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(two[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("count: "+count3);
            System.out.println();

            int t = scan.nextInt();
            int angle;
            for (int i = 0; i < t; i++) {
                angle = scan.nextInt() % 360;
                if (angle == 270) out.println(count1);
                else if (angle == 180) out.println(count2);
                else if (angle == 90) out.println(count3);
                else out.println(0);
            }
        }


        char[][] rotate(char[][] x) {
            int len = x.length;
            for (int i = 0; i < len / 2; i++) {
                for (int j = i; j < len - i - 1; j++) {
                    char temp = x[i][j];
                    x[i][j] = x[j][len - 1 - i];
                    x[j][len - 1 - i] = x[len - 1 - i][len - 1 - j];
                    x[len - 1 - i][len - 1 - j] = x[len - 1 - j][i];
                    x[len - 1 - j][i] = temp;
                }
            }
            return x;
        }

        int compare(int n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] != two[i][j]) count++;
                }
            }
            return count;
        }

        void find(char[][] x, int len) {
            count1 = 0;
            count2 = 0;
            for (int i = 0; i < len / 2; i++) {
                for (int j = i; j < len - i - 1; j++) {
                    if (x[i][j] != x[j][len - 1 - i]) count1++;
                    if (x[j][len - 1 - i] != x[len - 1 - i][len - 1 - j]) count1++;
                    if (x[len - 1 - i][len - 1 - j] != x[len - 1 - j][i]) count1++;
                    if (x[len - 1 - j][i] != x[i][j]) count1++;

                    if (x[i][j] != x[len - 1 - i][len - 1 - j]) count2 += 2;
                    if (x[j][len - 1 - i] != x[len - 1 - j][i]) count2 += 2;
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