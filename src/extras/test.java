package extras;

public class test {

    Node root;

    public static void main(String[] args) {
        test tree = new test();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.find(4, 5).data);
    }

    static class Node {
        Node left, right;
        int data;

        Node(int x) {
            this.data = x;
            left = null;
            right = null;
        }
    }

    private Node find(int a, int b) {
        return find(root, a, b);
    }

    private Node find(Node x, int a, int b) {
        if (x == null) return null;
        if (x.data == a || x.data == b) return x;
        Node left_lca = find(x.left, a, b);
        Node right_lca = find(x.right, a, b);
        if (left_lca != null && right_lca != null) return x;
        return left_lca != null ? left_lca : right_lca;
    }

}


