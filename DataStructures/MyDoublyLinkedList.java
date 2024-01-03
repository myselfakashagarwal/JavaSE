public class MyDoublyLinkedList<T> {
    private static class Node<U> {
        U data;
        Node previous;
        Node next;
        Node(U data) {
            this.data = data;
            previous = null;
            next = null;
        }
    }

    private int size;
    private MyDoublyLinkedList.Node head;

    MyDoublyLinkedList() {
        size = 0;
        head = null;
    }

    public void addFirst(T data) {
        MyDoublyLinkedList.Node newNode = new MyDoublyLinkedList.Node(data);
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
        MyDoublyLinkedList.Node newNode = new MyDoublyLinkedList.Node(data);
        if (head == null) {
            head = newNode;
        } else {
            MyDoublyLinkedList.Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.previous = temp;
            temp.next = newNode;
        }
        size++;
    }

    public void addSpecific(int index, T data) {
        MyDoublyLinkedList.Node newNode = new MyDoublyLinkedList.Node(data);
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
            MyDoublyLinkedList.Node temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            newNode.next = temp.next;
            newNode.next.previous = newNode;
            newNode.previous = temp;
            temp.next = newNode;
        }
        size++;
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
        } else if (head.next.next == null) {
            head.next = null;
        } else {
            MyDoublyLinkedList.Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next.previous = null;
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
        } else if (size - 1 == index) {
            deleteLast();
            return;
        } else {
            MyDoublyLinkedList.Node temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            if (temp.next.next == null) {
                temp.next.previous = null;
                temp.next = null;
            } else {
                temp.next.previous = null;
                temp.next.next.previous = temp;
                temp.next = temp.next.next;
            }
        }
        size--;
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            MyDoublyLinkedList.Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("NULL" + '\n');
        }
    }

    public void displayBackward() {
        MyDoublyLinkedList.Node temp = head;
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
            System.out.print("NULL" + '\n');
            System.out.println("Size of linked list is ~ " + size);
        }
    }
}

class MyDoublyLinkedListMain {
    public static void main(String args[]) {
        MyDoublyLinkedList<String> dlist = new MyDoublyLinkedList<String>();
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