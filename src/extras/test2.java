package extras;

public class test2 {
    public static void main(String[] args) {
        test2 tes = new test2();
        tes.solve();
    }

    private Node head = null;

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

    private void reverse(){
        Node curr=head;
        Node prev=null,next;

       while (curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       head=prev;

    }

    private void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void solve() {
        insert(1);
        insert(2);
        insert(3);
        traverse();
        reverse();
        traverse();
    }


}