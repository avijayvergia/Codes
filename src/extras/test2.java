package extras;

import java.util.ArrayList;
import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        test2 tes = new test2();
        tes.solve();
    }

    private ArrayList<String> list;

    private void perm(char[] a, int i, int n) {
        if (i == n) {
            list.add(Arrays.toString(a));
            return;
        }
        for (int j = i; j <= n; j++) {
            swap(a, i, j);
            perm(a, i + 1, n);
            swap(a, i, j);
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void solve() {
        char[] a = {'d', 'r', 'r'};
        list = new ArrayList<>();
        int[][] mat={{1,-3,0},{-2,1,-1}};
        perm(a, 0, 2);
        int max=0;
        int x=0,y=0;
        for (String s : list) {
            int sum=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='d') x++;
                else y++;
                sum+=mat[x][y];
            }
            max=Math.max(max,sum+mat[0][0]);
        }
        System.out.println(max);

    }


}