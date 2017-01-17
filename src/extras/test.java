package extras;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    public void solve(){
        int[] a={1,-5,4,8,-78,89,90,70,10,10,-80};
        // Largest Increasing Subsequence

        int[] len=new int[a.length];
        Arrays.fill(len,1);

        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]&&len[i]<len[j]+1){
                    len[i]=len[j]+1;
                }
            }
        }

        int max=0;
        for(int i=0;i<a.length;i++){
            if(max<len[i]) max=len[i];
        }
        System.out.println(max);


    }

}


