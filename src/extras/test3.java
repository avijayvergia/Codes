package extras;

import java.util.Scanner;
import java.util.Stack;

class test3 {
    public static void main(String[] args) {

        Task solver = new Task();
        solver.solve();

    }

    static class Task {

        int MOD = 1000000007;
        int fr;

        void solve() {
            Scanner scanner=new Scanner(System.in);
            int t = scanner.nextInt();

            for (int i = 0; i < t; i++) {
                fr = 0;
                Stack<Integer> stack=new Stack<>();
                int x = scanner.nextInt();
                int count=0;
                while (x > 0) {
                    stack.push(x%10);
                    x = x / 10;
                    count++;
                }
                int[] a =new int[count];
                for(int j=0;j<count;j++){
                    a[j]=stack.pop();

                }
                printSubsequences(a, count);
                System.out.println(fr);
            }


        }

        void printSubsequences(int[] m, int n) {
            int opsize = (int) Math.pow(2, n);
            StringBuilder x=new StringBuilder();
            for (int counter = 1; counter < opsize; counter++) {
                for (int j = 0; j < n; j++) {
                    if ((counter & (1 << j)) != 0)
                        x.append(m[j]);
                }
                fr = (fr + Integer.parseInt(x.toString())) % MOD;
                x.delete(0,x.length());
            }
        }
    }
}