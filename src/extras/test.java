package extras;

import java.math.BigInteger;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
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
