package HackerRank;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class HacckonaciMatrix {
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
        char[][] array = new char[55][55];
        int count1, count2;

        BigInteger[] a = new BigInteger[3500];


        BigInteger fun(int n) {
            if (a[n].intValue() != 0) return a[n];
            a[n] = fun(n - 1).add(BigInteger.valueOf(2)
                    .multiply(fun(n - 2))
                    .add(BigInteger.valueOf(3).multiply(fun(n - 3))));
            return a[n];
        }

        public void solve(InputReader scan, PrintWriter out) {
            HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 6, 7, 8, 13, 14, 15, 20, 21, 22, 27, 28, 29, 34, 35, 36, 41, 42, 43, 48, 49, 50, 55));
            Arrays.fill(a, BigInteger.ZERO);
            a[1] = BigInteger.ONE;
            a[2] = BigInteger.valueOf(2);
            a[3] = BigInteger.valueOf(3);
            fun(3000);

           /* for (int i = 1; i <= 55; i++) {
                for (int j = 1; j <= 55; j++) {
                    if (set.contains(i * j)) {
                        array[i - 1][j - 1] = '_';
                        out.print('_' + " ");
                    } else {
                        array[i - 1][j - 1] = 'x';
                        out.print('*' + " ");
                    }
                }
                out.println();
            }*/

            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if ((a[(int) Math.pow(i * j, 2)].mod(BigInteger.valueOf(2))).intValue()== 0) {
                        array[i - 1][j - 1] = 'x';
                        out.print('x' + " ");
                    } else {
                        array[i - 1][j - 1] = '_';
                        out.print('_' + " ");
                    }
                }
                out.println();
            }

            out.println();
            for (int i = 1; i <= 50; i++) {
                char[][] two = new char[i][i];
                for (int j = 0; j < i; j++) {
                    for (int k = 0; k < i; k++) {
                        two[j][k] = array[j][k];
                    }
                }


                out.print(i + " x " + i + " ");
                rotate1(two);
                out.print("270 : " + count1 + " ");
                out.print("180 : " + count2 + " ");
                out.print("90 : " + count1 + " ");
                out.println();
               /* out.print(i + " x " + i + " ");
                rotate(two);
                out.print("270 : " + compare(array, two,i) + " ");
                rotate(two);
                out.print("180 : " + compare(array, two,i) + " ");
                rotate(two);
                out.print("90 : " + compare(array, two,i) + " ");
                out.println();*/
            }
        }

        void rotate(char[][] x) {
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
        }

        void rotate1(char[][] x) {
            int len = x.length;
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

        int compare(char[][] one, char[][] two, int n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (one[i][j] != two[i][j]) count++;
                }
            }
            return count;
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