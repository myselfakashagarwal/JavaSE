package DataStructures;

public class MySet<T> {
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

    public MySet() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        if (isEmpty() || !contains(data)) {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void remove(T data) {
        if (isEmpty() || !contains(data)) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(data)) {
                    temp.next = temp.next.next;
                    size--;
                    break; // remove only one occurrence
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Set is empty");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return (size == 0 && head == null);
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}

class MySetMain {
    public static void main(String[] args) {
        MySet<String> set = new MySet<>();
        set.isEmpty();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");
        set.add("3");
        set.display();
        set.getSize();
        set.contains("3");
        set.contains("4");
        set.remove("3");
        set.getSize();
        set.display();
    }
}
