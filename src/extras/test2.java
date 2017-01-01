package extras;

import java.io.*;
import java.util.*;

public class test2 {
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

        void solve(InputReader scan, PrintWriter out) {
            Trie trie=new Trie();
        }

        class TrieNode {
            TrieNode[] arr;
            boolean isEnd;
            TrieNode() {
                this.arr = new TrieNode[26];
            }

        }

        public class Trie {
            private TrieNode root;
            Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int index = c - 'a';
                    if (p.arr[index] == null) {
                        TrieNode temp = new TrieNode();
                        p.arr[index] = temp;
                        p = temp;
                    } else {
                        p = p.arr[index];
                    }
                }
                p.isEnd = true;
            }

            public boolean search(String word) {
                TrieNode p = searchNode(word);
                if (p == null) {
                    return false;
                } else if (p.isEnd)
                    return true;
                return false;
            }

            public boolean startsWith(String prefix) {
                TrieNode p = searchNode(prefix);
                return p != null;
            }

            TrieNode searchNode(String s) {
                TrieNode p = root;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int index = c - 'a';
                    if (p.arr[index] != null) {
                        p = p.arr[index];
                    } else {
                        return null;
                    }
                }
                if (p == root)
                    return null;
                return p;
            }
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}