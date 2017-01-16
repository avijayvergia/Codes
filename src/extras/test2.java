package extras;

import java.util.Arrays;

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

    private int[] a=new int[4];
    private int count;
    public void findSum() {
        count=0;
        head=find(head);
        count=0;
        find2(head2);
        a[3]=carry;
        System.out.println(Arrays.toString(a));
    }

    private int carry=0;
    public Node find2(Node x) {
        if(x==null) return null;
        x.next=find2(x.next);
        a[count]=(a[count]+x.data+carry)%10;
        carry=(a[count]+x.data+carry)/10;
        count++;
        return x;
    }

    public Node find(Node x) {
        if(x==null) return null;
        x.next=find(x.next);
        a[count]=x.data;
        count++;
        return x;
    }

    private void solve() {
        insert(1);
        insert(2);
        insert(3);

        insert2(5);
        insert2(9);
        insert2(3);
        findSum();
    }


}