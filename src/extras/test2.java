package extras;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class test2 {
    public static void main(String[] args) {
        test2 tes = new test2();
        tes.solve();

    }

    class Node {
        Node left, right;
        int data;

        Node(int x) {
            this.data = x;
            left = null;
            right = null;
        }
    }

    private void find(Node x) {
        Queue<HashMap<Node, Integer>> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(x, 0);
        queue.add(map);
        Node a;
        int level;
        while (!queue.isEmpty()) {
            map=queue.poll();

        }
    }

    private void solve() {
        Node root = new Node(6);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        find(root);
    }


}