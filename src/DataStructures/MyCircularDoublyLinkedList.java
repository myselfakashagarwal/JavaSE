package DataStructures;

public class MyCircularDoublyLinkedList<T> {
    private static class Node<U> {
        U data;
        Node<U> previous;
        Node<U> next;
        
        Node(U data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public MyCircularDoublyLinkedList() {
        size = 0;
        head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.previous = head;
        } else {
            newNode.next = head;
            newNode.previous = head.previous;
            head.previous.next = newNode;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.previous = head;
        } else {
            newNode.previous = head.previous;
            newNode.next = head;
            head.previous.next = newNode;
            head.previous = newNode;
        }
        size++;
    }

    public void addSpecific(int index, T data) {
        if (index > size) {
            System.out.println("Error: Invalid index");
            return;
        } else if (index == size) {
            addLast(data);
            return;
        } else if (index == 0) {
            addFirst(data);
            return;
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            newNode.next = temp.next;
            newNode.next.previous = newNode;
            newNode.previous = temp;
            temp.next = newNode;
            size++;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return;
        } else if (head.next == head) {
            head = null;
        } else {
            head.next.previous = head.previous;
            head.previous.next = head.next;
            head = head.next;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return;
        } else if (head.next == head) {
            head = null;
        } else {
            head.previous = head.previous.previous;
            head.previous.next = head;
        }
        size--;
    }

    public void deleteSpecific(int index) {
        if (index >= size) {
            System.out.println("Error: Invalid index");
            return;
        } else if (index == 0) {
            deleteFirst();
            return;
        } else if (size - 1 == index) {
            deleteLast();
            return;
        } else {
            Node<T> temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void displayForward() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.print("... (Circular)" + '\n');
            System.out.println("Size of linked list is ~ " + size);
        }
    }

    public void displayBackward() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            do {
                temp = temp.previous;
            } while (temp.next != head);

            do {
                System.out.print(temp.data + " -> ");
                temp = temp.previous;
            } while (temp != head.previous);
            System.out.print("... (Circular)" + '\n');
            System.out.println("Size of linked list is ~ " + size);
        }
    }
}

class MyCircularDoublyLinkedListMain {
    public static void main(String args[]) {
        MyCircularDoublyLinkedList<String> list = new MyCircularDoublyLinkedList<>();
        list.addLast("1");
        list.addFirst("0");
        list.addSpecific(2, "2");
        list.deleteSpecific(0);
        list.addSpecific(0, "0");
        list.addSpecific(3, "4");
        list.addSpecific(3, "3");
        list.addLast("6");
        list.addLast("7");
        list.addSpecific(5, "x");
        list.deleteSpecific(5);
        list.addSpecific(5, "5");
        list.addSpecific(8, "9");
        list.addSpecific(8, "8");
        list.deleteSpecific(0);
        list.addSpecific(0, "0");
        list.deleteSpecific(1);
        list.addSpecific(1, "1");
        list.deleteSpecific(9);
        list.displayForward();
        list.displayBackward();
    }
}