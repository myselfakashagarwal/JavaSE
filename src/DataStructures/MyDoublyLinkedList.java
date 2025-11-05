package DataStructures;

public class MyDoublyLinkedList<T> {
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

    public MyDoublyLinkedList() {
        size = 0;
        head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.previous = null;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.previous = temp;
            temp.next = newNode;
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
        } else if (head.next == null) {
            head = null;
        } else {
            head.next.previous = null;
            head = head.next;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.previous.next = null;
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
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
            System.out.println("Size of linked list is ~ " + size);
        }
    }

    public void displayBackward() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.previous;
            }
            System.out.println("NULL");
            System.out.println("Size of linked list is ~ " + size);
        }
    }
}

class MyDoublyLinkedListMain {
    public static void main(String args[]) {
        MyDoublyLinkedList<String> dlist = new MyDoublyLinkedList<>();
        dlist.addLast("1");
        dlist.addFirst("0");
        dlist.addSpecific(2, "2");
        dlist.deleteSpecific(0);
        dlist.addSpecific(0, "0");
        dlist.addSpecific(3, "4");
        dlist.addSpecific(3, "3");
        dlist.addLast("6");
        dlist.addLast("7");
        dlist.addSpecific(5, "x");
        dlist.deleteSpecific(5);
        dlist.addSpecific(5, "5");
        dlist.addSpecific(8, "9");
        dlist.addSpecific(8, "8");
        dlist.deleteSpecific(0);
        dlist.addSpecific(0, "0");
        dlist.deleteSpecific(1);
        dlist.addSpecific(1, "1");
        dlist.deleteSpecific(9);
        dlist.displayForward();
        dlist.displayBackward();
    }
}