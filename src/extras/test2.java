package extras;

public class test2 {
    public static void main(String[] args) {
        test2 tes = new test2();
        tes.solve();
    }

    private Node head = null;
    private Node head2 = null;

    class Node {
        Node next;
        int data;

        Node(int x) {
            this.data = x;
            next = null;
        }
    }

    private void insert(int x) {

        if (head == null) {
            head = new Node(x);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(x);
        }
    }

    private void insert2(int x) {

        if (head2 == null) {
            head2 = new Node(x);
        } else {
            Node temp = head2;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(x);
        }
    }


    private void reverse() {
        Node curr = head;
        Node prev = null, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    private void traverse(Node x) {
        Node temp = x;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void findSum() {

    }



    private void solve() {
        insert(1);
        insert(2);
        insert(3);
        reverse();
        traverse(head);

        insert2(5);
        insert2(9);
        insert2(3);
        traverse(head2);
    }


}