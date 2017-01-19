package extras;

class test {
    public static void main(String[] args) {
        test test = new test();
        test.solve();
    }

    private void solve() {
        int[] a = {5, 8, 59, -4, 7, 0, 9};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void sort(int[] a) {
        int num;
        for (int i = 1; i < a.length; i++) {
            num = a[i];
            int j;
            for ( j = i-1; j>=0&&a[j]>num; j--) {
                    a[j+1]=a[j];
            }
            a[j + 1] = num;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}