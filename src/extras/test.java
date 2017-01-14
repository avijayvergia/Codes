package extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    private void solve() {
        ArrayList<Integer> b=new ArrayList<>();
        b.add(45);b.add(59);b.add(9);b.add(589);
        b.sort((x, y) -> {
            String X = String.valueOf(x);
            String Y = String.valueOf(y);
            String XY = X + Y;
            String YX = Y + X;
            System.out.print(XY+" ");
            System.out.println(YX);
            return YX.compareTo(XY);
        });
        System.out.println(b);
    }

}


