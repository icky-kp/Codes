public class LoopDetection {
    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    Node head;

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void detectLoop() {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop found");
                return;
            }
        }
        System.out.println("Loop not found");
    }

    // void printList() {
    //     Node current = head;
    //     System.out.print("Linked List: ");
    //     while (current != null) {
    //         System.out.print(current.data + " -> ");
    //         current = current.next;
    //     }
    //     System.out.println("null");
    // }

    public static void main(String[] args) {
        LoopDetection list = new LoopDetection();
        list.push(20);
        list.push(15);
        list.push(10);
        list.push(5);

        // Uncomment the next line to create a loop
        list.head.next.next.next.next = list.head;

        // list.printList(); // Print the linked list
        list.detectLoop(); // Detect if a loop exists
    }
}