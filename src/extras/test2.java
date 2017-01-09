package extras;

import java.math.BigInteger;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Task solver = new Task();
        solver.solve();

    }

    static class Task {

        void solve() {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();
            BigInteger x, y;
            for (int i = 0; i < t; i++) {
                x = scanner.nextBigInteger();
                y = scanner.nextBigInteger();
                System.out.println(x.add(y));
            }
        }
    }
}