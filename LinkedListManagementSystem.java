import java.util.Scanner;

/**
 * Singly Linked List Implementation
 */
class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // 1. Insert at Beginning - O(1)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at the beginning.");
    }

    // 2. Insert at End - O(n) without tail pointer
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " as the head node.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Inserted " + data + " at the end.");
    }

    // 3. Insert at Position (1-based index) - O(n)
    public void insertAtPosition(int position, int data) {
        int count = countNodes();
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position! Valid position range is 1 to " + (count + 1));
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + position + ".");
    }

    // 4. Insert After a Node (First matching target value)
    public void insertAfterValue(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value " + target + " not found in the list.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " after node with value " + target + ".");
    }

    // 5. Insert Before a Node (First matching target value)
    public void insertBeforeValue(int target, int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value " + target + " not found in the list.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " before node with value " + target + ".");
    }

    // 6. Delete from Beginning - O(1)
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int removedData = head.data;
        head = head.next;
        System.out.println("Deleted node with value " + removedData + " from beginning.");
    }

    // 7. Delete from End - O(n)
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted last node with value " + head.data + ".");
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted node with value " + temp.next.data + " from end.");
        temp.next = null;
    }

    // 8. Delete from Position (1-based index)
    public void deleteFromPosition(int position) {
        int count = countNodes();
        if (head == null || position < 1 || position > count) {
            System.out.println("Invalid position! Valid position range is 1 to " + count);
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        int removedData = temp.next.data;
        temp.next = temp.next.next;
        System.out.println("Deleted node with value " + removedData + " from position " + position + ".");
    }

    // 9. Delete by Value (First occurrence)
    public void deleteByValue(int target) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == target) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value " + target + " not found in the list.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Deleted node with value " + target + ".");
    }

    // 10. Search - O(n)
    public void search(int target) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Value " + target + " found at position " + pos + ".");
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Value " + target + " not found in the list.");
    }

    // 11. Update
    public void update(int target, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                temp.data = newValue;
                System.out.println("Updated value " + target + " to " + newValue + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value " + target + " not found.");
    }

    // 12. Display - O(n)
    public void display() {
        if (head == null) {
            System.out.println("List is empty (NULL)");
            return;
        }
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("NULL");
        System.out.println("Singly Linked List: " + sb.toString());
    }

    // 13. Count Nodes - O(n)
    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 14. Find Maximum - O(n)
    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum value: " + max);
    }

    // 15. Find Minimum - O(n)
    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum value: " + min);
    }

    // 16. Find Middle Element (Slow/Fast Reference Strategy) - O(n)
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Element: " + slow.data + " (Note: For even length, second middle is selected)");
    }

    // 17. Reverse List - O(n) time, O(1) auxiliary space
    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("List reversed successfully.");
            return;
        }
        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
        System.out.println("List reversed successfully.");
    }

    // 18. Sort (Bubble Sort by Swapping Data) - O(n^2)
    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("List is sorted.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted in ascending order.");
    }

    // 19. Remove Duplicates - O(n^2)
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            System.out.println("Duplicates removed.");
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicates removed successfully.");
    }
}

/**
 * Doubly Linked List Implementation
 */
class DoublyLinkedList {
    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private DNode head;
    private DNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // 1. Insert at Beginning
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at the beginning.");
    }

    // 2. Insert at End
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    // 3. Insert at Position
    public void insertAtPosition(int position, int data) {
        int count = countNodes();
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position! Valid range is 1 to " + (count + 1));
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        if (position == count + 1) {
            insertAtEnd(data);
            return;
        }
        DNode newNode = new DNode(data);
        DNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + position + ".");
    }

    // 4. Insert After a Node
    public void insertAfterValue(int target, int data) {
        DNode temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value " + target + " not found.");
            return;
        }
        if (temp == tail) {
            insertAtEnd(data);
            return;
        }
        DNode newNode = new DNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Inserted " + data + " after " + target + ".");
    }

    // 5. Insert Before a Node
    public void insertBeforeValue(int target, int data) {
        DNode temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value " + target + " not found.");
            return;
        }
        if (temp == head) {
            insertAtBeginning(data);
            return;
        }
        DNode newNode = new DNode(data);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
        System.out.println("Inserted " + data + " before " + target + ".");
    }

    // 6. Delete from Beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int removedData = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Deleted node with value " + removedData + " from beginning.");
    }

    // 7. Delete from End
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        int removedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Deleted node with value " + removedData + " from end.");
    }

    // 8. Delete from Position
    public void deleteFromPosition(int position) {
        int count = countNodes();
        if (head == null || position < 1 || position > count) {
            System.out.println("Invalid position! Valid range is 1 to " + count);
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        if (position == count) {
            deleteFromEnd();
            return;
        }
        DNode temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted node with value " + temp.data + " from position " + position + ".");
    }

    // 9. Delete by Value
    public void deleteByValue(int target) {
        DNode temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value " + target + " not found.");
            return;
        }
        if (temp == head) {
            deleteFromBeginning();
            return;
        }
        if (temp == tail) {
            deleteFromEnd();
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted node with value " + target + ".");
    }

    // 10. Search
    public void search(int target) {
        DNode temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Value " + target + " found at position " + pos + ".");
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Value " + target + " not found.");
    }

    // 11. Update
    public void update(int target, int newValue) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == target) {
                temp.data = newValue;
                System.out.println("Updated value " + target + " to " + newValue + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value " + target + " not found.");
    }

    // 12. Display Forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty (NULL)");
            return;
        }
        DNode temp = head;
        StringBuilder sb = new StringBuilder("NULL <-> ");
        while (temp != null) {
            sb.append(temp.data).append(" <-> ");
            temp = temp.next;
        }
        sb.append("NULL");
        System.out.println("Forward DLL: " + sb.toString());
    }

    // 13. Display Backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty (NULL)");
            return;
        }
        DNode temp = tail;
        StringBuilder sb = new StringBuilder("NULL <-> ");
        while (temp != null) {
            sb.append(temp.data).append(" <-> ");
            temp = temp.prev;
        }
        sb.append("NULL");
        System.out.println("Backward DLL: " + sb.toString());
    }

    // 14. Count Nodes
    public int countNodes() {
        int count = 0;
        DNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 15. Find Maximum
    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        DNode temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum value: " + max);
    }

    // 16. Find Minimum
    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        DNode temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum value: " + min);
    }

    // 17. Find Middle Element
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode slow = head;
        DNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Element: " + slow.data);
    }

    // 18. Reverse List
    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("List reversed successfully.");
            return;
        }
        DNode current = head;
        DNode temp = null;
        tail = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
        System.out.println("List reversed successfully.");
    }

    // 19. Sort (Bubble Sort by Data Swap)
    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("List sorted.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted in ascending order.");
    }

    // 20. Remove Duplicates
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            System.out.println("Duplicates removed.");
            return;
        }
        DNode current = head;
        while (current != null) {
            DNode runner = current.next;
            while (runner != null) {
                DNode nextNode = runner.next;
                if (runner.data == current.data) {
                    if (runner == tail) {
                        tail = runner.prev;
                        tail.next = null;
                    } else {
                        runner.prev.next = runner.next;
                        runner.next.prev = runner.prev;
                    }
                }
                runner = nextNode;
            }
            current = current.next;
        }
        System.out.println("Duplicates removed successfully.");
    }
}

/**
 * Main Application Menu Driver
 */
public class LinkedListManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SinglyLinkedList sll = new SinglyLinkedList();
    private static final DoublyLinkedList dll = new DoublyLinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("    LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    singlyLinkedListMenu();
                    break;
                case 2:
                    doublyLinkedListMenu();
                    break;
                case 3:
                    compareLinkedLists();
                    break;
                case 4:
                    System.out.println("Exiting Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 4.");
            }
        }
    }

    private static void singlyLinkedListMenu() {
        while (true) {
            System.out.println("\n------------------------------------------");
            System.out.println("   Operation on Singly Linked List");
            System.out.println("------------------------------------------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit to Main Menu");
            System.out.print("Enter the choice: ");

            int choice = readInt();
            int val, pos, target;
            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    sll.insertAtBeginning(readInt());
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    sll.insertAtEnd(readInt());
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    pos = readInt();
                    System.out.print("Enter data to insert: ");
                    val = readInt();
                    sll.insertAtPosition(pos, val);
                    break;
                case 4:
                    System.out.print("Enter target value: ");
                    target = readInt();
                    System.out.print("Enter data to insert: ");
                    val = readInt();
                    sll.insertAfterValue(target, val);
                    break;
                case 5:
                    System.out.print("Enter target value: ");
                    target = readInt();
                    System.out.print("Enter data to insert: ");
                    val = readInt();
                    sll.insertBeforeValue(target, val);
                    break;
                case 6:
                    sll.deleteFromBeginning();
                    break;
                case 7:
                    sll.deleteFromEnd();
                    break;
                case 8:
                    System.out.print("Enter position to delete: ");
                    sll.deleteFromPosition(readInt());
                    break;
                case 9:
                    System.out.print("Enter value to delete: ");
                    sll.deleteByValue(readInt());
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    sll.search(readInt());
                    break;
                case 11:
                    System.out.print("Enter target value to update: ");
                    target = readInt();
                    System.out.print("Enter new value: ");
                    val = readInt();
                    sll.update(target, val);
                    break;
                case 12:
                    sll.display();
                    break;
                case 13:
                    System.out.println("Total Nodes: " + sll.countNodes());
                    break;
                case 14:
                    sll.findMaximum();
                    break;
                case 15:
                    sll.findMinimum();
                    break;
                case 16:
                    sll.findMiddle();
                    break;
                case 17:
                    sll.reverse();
                    break;
                case 18:
                    sll.sort();
                    break;
                case 19:
                    sll.removeDuplicates();
                    break;
                case 20:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void doublyLinkedListMenu() {
        while (true) {
            System.out.println("\n------------------------------------------");
            System.out.println("   Operation on Doubly Linked List");
            System.out.println("------------------------------------------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit to Main Menu");
            System.out.print("Enter the choice: ");

            int choice = readInt();
            int val, pos, target;
            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    dll.insertAtBeginning(readInt());
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    dll.insertAtEnd(readInt());
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    pos = readInt();
                    System.out.print("Enter data: ");
                    val = readInt();
                    dll.insertAtPosition(pos, val);
                    break;
                case 4:
                    System.out.print("Enter target: ");
                    target = readInt();
                    System.out.print("Enter data: ");
                    val = readInt();
                    dll.insertAfterValue(target, val);
                    break;
                case 5:
                    System.out.print("Enter target: ");
                    target = readInt();
                    System.out.print("Enter data: ");
                    val = readInt();
                    dll.insertBeforeValue(target, val);
                    break;
                case 6:
                    dll.deleteFromBeginning();
                    break;
                case 7:
                    dll.deleteFromEnd();
                    break;
                case 8:
                    System.out.print("Enter position: ");
                    dll.deleteFromPosition(readInt());
                    break;
                case 9:
                    System.out.print("Enter value: ");
                    dll.deleteByValue(readInt());
                    break;
                case 10:
                    System.out.print("Enter search value: ");
                    dll.search(readInt());
                    break;
                case 11:
                    System.out.print("Enter target: ");
                    target = readInt();
                    System.out.print("Enter new value: ");
                    val = readInt();
                    dll.update(target, val);
                    break;
                case 12:
                    dll.displayForward();
                    break;
                case 13:
                    dll.displayBackward();
                    break;
                case 14:
                    System.out.println("Total Nodes: " + dll.countNodes());
                    break;
                case 15:
                    dll.findMaximum();
                    break;
                case 16:
                    dll.findMinimum();
                    break;
                case 17:
                    dll.findMiddle();
                    break;
                case 18:
                    dll.reverse();
                    break;
                case 19:
                    dll.sort();
                    break;
                case 20:
                    dll.removeDuplicates();
                    break;
                case 21:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void compareLinkedLists() {
        System.out.println("\n-----------------------------------------------------------------------------------------");
        System.out.println("                          SINGLY vs DOUBLY LINKED LIST COMPARISON");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-25s | %-30s | %-30s%n", "Feature", "Singly Linked List (SLL)", "Doubly Linked List (DLL)");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-25s | %-30s | %-30s%n", "Pointers per Node", "1 (`next`)", "2 (`prev` & `next`)");
        System.out.printf("%-25s | %-30s | %-30s%n", "Memory Overhead", "Lower (1 reference per node)", "Higher (2 references per node)");
        System.out.printf("%-25s | %-30s | %-30s%n", "Traversal Direction", "Forward only", "Bi-directional (Forward & Backward)");
        System.out.printf("%-25s | %-30s | %-30s%n", "Delete End Complexity", "O(n) - requires traversal", "O(1) - with `tail` & `prev` reference");
        System.out.printf("%-25s | %-30s | %-30s%n", "Insert Before Node", "O(n) - needs previous pointer", "O(1) - given target node reference");
        System.out.printf("%-25s | %-30s | %-30s%n", "Implementation Complexity", "Simpler link maintenance", "More complex reference rewiring");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}