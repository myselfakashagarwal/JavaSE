public class MyCircularSinglyLinkedList<T> {
    private static class Node<U> {
        U data;
        Node next;
        Node(U data) {
            this.data = data;
            this.next = null;
        }
    }

    private MyCircularSinglyLinkedList.Node head;
    private int size;

    MyCircularSinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        MyCircularSinglyLinkedList.Node newNode = new MyCircularSinglyLinkedList.Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            MyCircularSinglyLinkedList.Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        MyCircularSinglyLinkedList.Node newNode = new MyCircularSinglyLinkedList.Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            MyCircularSinglyLinkedList.Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void addSpecific(int index, T data) {
        if (index < 0 || index > size) {
            System.out.println("Error: Invalid index");
            return;
        } else if(index == 0) {
            addFirst(data);
            return;
        } else if(index == size) {
            addLast(data);
            return;
        } else {
            MyCircularSinglyLinkedList.Node newNode = new MyCircularSinglyLinkedList.Node(data);
            MyCircularSinglyLinkedList.Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
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
            if (size == 1) {
                head = null;
            } else {
                MyCircularSinglyLinkedList.Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }   
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return;
        } else {
            if (size == 1) {
                head = null;
            } else {
                MyCircularSinglyLinkedList.Node temp = head;
                while (temp.next.next != head) {
                    temp = temp.next;
                }
                temp.next = head;
            }   
        }
        size--;
    }

    public void deleteSpecific(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Invalid index");
            return;
        } else if(index == 0) {
            deleteFirst();
            return;
        } else {
            MyCircularSinglyLinkedList.Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;   
        }
        size--;
    }

    public void display() {
        MyCircularSinglyLinkedList.Node temp = head;
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
}

class MyCircularSinglyLinkedListMain {
    public static void main(String[] args) {
        MyCircularSinglyLinkedList<String> list = new MyCircularSinglyLinkedList<String>();
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
        list.display();
    }
}