package extras;

public class test {
    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    public void solve(){
        int[] a={1,-5,4,8,-78,89,-89,70,10,10,-80};
        // MaxSum subarray

        int curr_max=0;
        int max_sum=0;
        for (int anA : a) {
            curr_max = Math.max(curr_max + anA, anA);
            max_sum = Math.max(curr_max, max_sum);
        }

        System.out.println(max_sum);

    }

}


