package DataStructures;

public class MyPriorityQueue<T> {
    private static class Node<U> {
        U data;
        int priority;
        Node<U> next;
        Node<U> previous;

        Node(U data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
            this.previous = null;
        }
    }

    private Node<T> front, rear;
    private int size;

    public MyPriorityQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data, int priority) {
        Node<T> newNode = new Node<>(data, priority);
        if (front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            Node<T> temp = front;
            while (temp != null && priority <= temp.priority) {
                temp = temp.next;
            }
            if (temp == null) {
                rear.next = newNode;
                newNode.previous = rear;
                rear = newNode;
            } else {
                newNode.next = temp;
                newNode.previous = temp.previous;
                if (temp.previous != null) {
                    temp.previous.next = newNode;
                } else {
                    front = newNode;
                }
                temp.previous = newNode;
            }
        }
        size++;
    }

    public void dequeue() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is empty");
            return;
        } else if (front == rear && size == 1) {
            front = null;
            rear = null;
        } else {
            rear.previous.next = null;
            rear = rear.previous;
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> front() {
        return front;
    }

    public Node<T> rear() {
        return rear;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public void display() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        Node<T> temp = front;
        while (temp != null) {
            System.out.println(temp.data + "(" + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class MyPriorityQueueMain {
    public static void main(String[] args) {
        MyPriorityQueue<String> queue = new MyPriorityQueue<>();
        queue.enqueue("1", 1);
        queue.enqueue("2", 2);
        queue.enqueue("0", 0);
        queue.display();
        queue.getSize();
        queue.isEmpty();
        queue.dequeue();
        queue.clear();
    }
}
