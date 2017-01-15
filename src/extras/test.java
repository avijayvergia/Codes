package extras;

public class test {
    private int[] b;

    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    private void solve() {
        int[] a = {5, 2, 3, 6, 7};
        b = new int[]{9, 2, 8, 4, 5};
        System.out.println(find(a, 0, 0));
    }

    private int find(int[] a, int index, int d) {
        if (index == 4) {
            int x = 0;
            for (int i = 0; i < 5; i++) {
                x = x + a[5 - i - 1] * (int) Math.pow(10, i);
            }
            return x;
        }
        int r_max = find(a, index + 1, d);
        for (int i = d; i < 5; i++) {
            r_max = Math.max(r_max, find(swap(a, i, index), index + 1, i + 1));
        }
        return r_max;
    }

    private int[] swap(int[] a, int i, int index) {
        int[] x = a.clone();
        x[index] = b[i];
        return x;
    }

}


