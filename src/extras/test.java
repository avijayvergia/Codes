package extras;

public class test {
    public static void main(String[] args) {
        test tree = new test();
        tree.solve();
    }

    private Node head=null;
    private Node curr=null;

    public void solve() {
        Node root = new Node(6);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.left.left.left = new Node(2);
        root.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(12);
        traverse(root);
        print(head);
    }

    private void print(Node root) {
        curr=root;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }

    private Node traverse(Node x) {
        if(x==null) return null;
        if(x.left==null&&x.right==null){
            if(head==null){
                head=x;
                curr=head;
            }
            else{
                curr.right=x;
                curr=x;
            }
            return null;
        }
        x.left=traverse(x.left);
        x.right=traverse(x.right);
        return x;
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
}


