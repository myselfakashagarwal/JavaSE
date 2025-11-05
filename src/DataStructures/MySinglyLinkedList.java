package DataStructures;

public class MySinglyLinkedList<T> {
    private static class Node<U> {
        U data;
        Node<U> next;

        Node(U data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public MySinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
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
            temp.next = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return;
        } else {
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
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
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
        } else {
            Node<T> temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        size--;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + "  ->  ");
                temp = temp.next;
            }
            System.out.println("NULL");
            System.out.println("Size of linked list is ~ " + size);
        }
    }
}

class MySinglyLinkedListMain {
    public static void main(String[] args) {
        MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
        list.addFirst("0");
        list.addSpecific(1, "1");
        list.addLast("2");
        list.addSpecific(3, "3");
        list.addLast("4");
        list.deleteFirst();
        list.deleteLast();
        list.deleteSpecific(1);
        list.deleteSpecific(0);
        list.deleteSpecific(5);
        list.display();
    }
}
