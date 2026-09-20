package B;

public class PatientDiagnosticHistory {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for (int i = 0; i < right - left; i++) {
            Node next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int left = 2;
        int right = 4;
        head = reverseBetween(head, left, right);
        printList(head);
    }
}
