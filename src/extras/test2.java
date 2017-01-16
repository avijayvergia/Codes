package extras;

public class test2 {

    private int[] next;
    private int[] prev;

    private test2(int maxSize) {
        next = new int[maxSize + 1];
        prev = new int[maxSize + 1];
    }

    private void insert(int x) {
        prev[x] = 0;
        next[x] = next[0];
        prev[next[x]] = x;
        next[prev[x]] = x;
    }

    private void remove(int x) {
        next[prev[x]] = next[x];
        prev[next[x]] = prev[x];
    }

    // Usage example
    public static void main(String[] args) {
        int n = 10;
        test2 list = new test2(n);
        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }
        list.remove(1);
        list.remove(10);
        list.remove(5);
        for (int i = list.next[0]; i != 0; i = list.next[i]) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}