package extras;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    private int[][] array;

    public void solve() {
        int val[] = new int[]{60, 100, 120,221};
        int wt[] = new int[]{10, 20, 30,50};
        int W = 50;
        array = new int[5][51];
        for(int i=0;i<4;i++){
            Arrays.fill(array[i], -1);
        }

        System.out.println(knapsack(wt, val, W, 0));

    }

    private int knapsack(int[] wt, int[] val, int w, int i) {

        if (w == 0 || i == 4) return 0;
        if (array[i][w] != -1) return array[i][w];
        if (wt[i] > w) return knapsack(wt, val, w, i + 1);
        array[i][w] = Math.max(val[i] + knapsack(wt, val, w - wt[i], i + 1), knapsack(wt, val, w, i + 1));
        return array[i][w];
    }

}


