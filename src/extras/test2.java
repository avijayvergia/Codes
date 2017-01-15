package extras;

import java.util.ArrayList;
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

    private void find(Node x){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x.data);
        queue.add(x);
        while (true) {
            int size = queue.size();
            if (size == 0) break;
            int sum = 0;
            while (size > 0) {
                Node node=queue.poll();
                if (node.left != null){
                    sum += node.left.data;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    sum += node.right.data;
                    queue.add(node.right);
                }
                size--;
            }
            System.out.println(sum);
            if(sum>0) list.add(sum);
        }
        int mul = 1;
        for (Integer a : list) {
            mul = mul * a;
        }
        System.out.println(mul);
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