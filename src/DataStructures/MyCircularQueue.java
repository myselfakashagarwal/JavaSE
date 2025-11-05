package DataStructures;

public class MyCircularQueue<T> {
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
    
    public MyCircularQueue() {
        size = 0;
        rear = null;
        front = null;
    }
    
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
            rear.next = front;
            front.next = rear;
            rear.previous = front;
            front.previous = rear;
        } else {
            newNode.next = rear.next;
            newNode.previous = rear;
            rear.next = newNode;
            rear = newNode;
            rear.next.previous = newNode;
        }
        size++;
    }
    
    public T dequeue() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is empty");
            return null;
        }
        
        T data = front.data;
        if (front == rear && size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
            front.previous = rear;
        }
        size--;
        return data;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public T front() {
        if (front == null) {
            System.out.println("Error: Queue is empty");
            return null;
        }
        return front.data;
    }
    
    public T rear() {
        if (rear == null) {
            System.out.println("Error: Queue is empty");
            return null;
        }
        return rear.data;
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
        } else if (front == rear && size == 1) {
            System.out.println(front.data);
        } else {
            Node<T> temp = front;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front); 
            System.out.println();
        }
    }
}

class MyCircularQueueMain {
    public static void main(String[] args) {
        MyCircularQueue<String> queue = new MyCircularQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Size: " + queue.getSize());
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Front: " + queue.front());
        System.out.println("Rear: " + queue.rear());
        queue.display();
        queue.clear();
        System.out.println("After clear - Is empty: " + queue.isEmpty());
    }
}