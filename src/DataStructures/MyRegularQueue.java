package DataStructures;

public class MyRegularQueue<T> {
    private static class Node<U> {
        U data;
        Node<U> next;
        Node<U> previous;

        Node(U data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node<T> front, rear;
    private int size;

    public MyRegularQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.previous = rear;
            rear = newNode;
        }
        size++;
    }

    public void dequeue() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is empty");
            return;
        } else if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            if (front != null) {
                front.previous = null; // maintain previous link
            }
        }
        size--;
    }

    public Node<T> front() {
        return front;
    }

    public Node<T> rear() {
        return rear;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class MyRegularQueueMain {
    public static void main(String[] args) {
        MyRegularQueue<String> queue = new MyRegularQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.getSize();
        queue.front();
        queue.clear();
    }
}
