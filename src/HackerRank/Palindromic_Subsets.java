package HackerRank;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Palindromic_Subsets {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {

        int[] nulla, temp;
        int MOD = 100000007;
        int N = 1 << 17;
        int[] prefix,suffix,odd,even;

        int[] pow2 = new int[N];

        public void solve(InputReader scan, PrintWriter out) {
            nulla = new int[26];
            Arrays.fill(nulla,0);
            temp = new int[26];
            int n = scan.nextInt();
            int t = scan.nextInt();
            char[] a = new char[n];

            pow2[0] = 1;
            for (int i = 1; i < N; i++)
                pow2[i] = (pow2[i - 1] << 1) % MOD;

            prefix = new int[26];
            suffix = new int[26];
            odd = new int[26];
            even = new int[26];

            String string = scan.next();
            for (int i = 0; i < n; i++) {
                a[i] = string.charAt(i);
            }
            int[][] segment = createSegmentTree(a);
            int lazy[] = new int[segment.length];
            int type;
            for (int i = 0; i < t; i++) {
                type = scan.nextInt();
                if (type == 2) {
                    out.println(RangeQuery(segment, lazy, scan.nextInt(), scan.nextInt(), a.length));
                } else {
                    updateSegmentTreeRangeLazy(a, segment, lazy, scan.nextInt(), scan.nextInt(), scan.nextInt()%26);
                }
            }
        }

        int[][] createSegmentTree(char input[]) {
            int height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
            int segmentTree[][] = new int[(int) (Math.pow(2, height + 1) - 1)][26];
            constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
            return segmentTree;
        }

        private void constructMinSegmentTree(int segmentTree[][], char input[], int low, int high, int pos) {
            if (low == high) {
                segmentTree[pos][input[low] - 'a'] = 1;
                return;
            }
            int mid = (low + high) / 2;
            constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
            constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = merge(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
        }

        /**
         * Updates given range by given delta lazily
         */
        public void updateSegmentTreeRangeLazy(char input[], int segmentTree[][], int lazy[], int startRange, int endRange, int delta) {
            updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange, delta, 0, input.length - 1, 0);
        }

        private void updateSegmentTreeRangeLazy(int segmentTree[][],
                                                int lazy[], int startRange, int endRange,
                                                int delta, int low, int high, int pos) {
            if (low > high) {
                return;
            }
            //make sure all propagation is done at pos. If not update tree
            //at pos and mark its children for lazy propagation.
            if (lazy[pos] != 0) {
                rotate(segmentTree[pos], lazy[pos]);
                if (low != high) { //not a leaf node
                    lazy[2 * pos + 1] = (lazy[2 * pos + 1]+lazy[pos])%26;
                    lazy[2 * pos + 2] = (lazy[2 * pos + 2]+lazy[pos])%26;
                }
                lazy[pos] = 0;
            }

            //no overlap condition
            if (startRange > high || endRange < low) {
                return;
            }

            //total overlap condition
            if (startRange <= low && endRange >= high) {
                rotate(segmentTree[pos], delta);
                if (low != high) {
                    lazy[2 * pos + 1] = (lazy[2 * pos + 1]+delta%26);
                    lazy[2 * pos + 2] = (lazy[2 * pos + 2]+delta%26);
                }
                return;
            }

            //otherwise partial overlap so look both left and right.
            int mid = (low + high) / 2;
            updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange,
                    delta, low, mid, 2 * pos + 1);
            updateSegmentTreeRangeLazy(segmentTree, lazy, startRange, endRange,
                    delta, mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = merge(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
        }

        /**
         * Queries given range lazily
         */
        long RangeQuery(int segmentTree[][], int lazy[], int qlow, int qhigh, int len) {
            int[] x = RangeQuery(segmentTree, lazy, qlow, qhigh, 0, len - 1, 0);
            return count_them(x);
        }

        private int[] RangeQuery(int segmentTree[][], int lazy[], int qlow, int qhigh,
                                 int low, int high, int pos) {
            if (low > high) {
                return nulla;
            }

            //make sure all propagation is done at pos. If not update tree
            //at pos and mark its children for lazy propagation.
            if (lazy[pos] != 0) {
                rotate(segmentTree[pos], lazy[pos]);
                if (low != high) { //not a leaf node
                    lazy[2 * pos + 1] = (lazy[2 * pos + 1]+lazy[pos])%26;
                    lazy[2 * pos + 2] = (lazy[2 * pos + 2]+lazy[pos])%26;
                }
                lazy[pos] = 0;
            }

            //no overlap
            if (qlow > high || qhigh < low) {
                return nulla;
            }

            //total overlap
            if (qlow <= low && qhigh >= high) {
                return segmentTree[pos];
            }

            //partial overlap
            int mid = (low + high) / 2;
            return merge(RangeQuery(segmentTree, lazy, qlow, qhigh, low, mid, 2 * pos + 1),
                    RangeQuery(segmentTree, lazy, qlow, qhigh, mid + 1, high, 2 * pos + 2));
        }



        long count_them(int[] a) {
            int i;
            long ans = 1;
            long curr;
            for (i = 0; i < 26; i++) {
                if (a[i] == 0) {
                    odd[i] = 0;
                    even[i] = 1;
                } else {
                    odd[i] = pow2[a[i] - 1];
                    even[i] = pow2[a[i] - 1];
                }
            }
            prefix[0] = even[0];
            for (i = 1; i < 26; i++) prefix[i] = (prefix[i - 1] * even[i]) % MOD;
            suffix[25] = even[25];
            for (i = 24; i >= 0; i--) suffix[i] = (suffix[i + 1] * even[i]) % MOD;
            for (i = 0; i < 26; i++) ans = (ans * even[i]) % MOD;
            for (i = 0; i < 26; i++) {
                curr = ((long) ((i == 0) ? 1 : prefix[i - 1]) * ((i == 25) ? 1 : suffix[i + 1])) % MOD;
                curr = (curr * odd[i]) % MOD;
                ans = (ans + curr) % MOD;
            }
            return (ans - 1 + MOD) % MOD;
        }

        private int[] merge(int[] a, int[] b) {
            int[] temp = new int[26];
            for (int i = 0; i < 26; i++) {
                temp[i] = a[i] + b[i];
            }
            return temp;
        }


        void rotate(int[] a, int pos) {
            int[] temp = new int[26];
            for (int i = 0; i < 26; i++) {
                temp[(i + pos) % 26] = a[i];
            }
            System.arraycopy(temp, 0, a, 0, 26);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}