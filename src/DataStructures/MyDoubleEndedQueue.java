package DataStructures;

public class MyDoubleEndedQueue<T> {
    private static class Node<U> {
        U data;
        Node<U> next;
        Node<U> previous;
        
        Node(U data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }
    
    private Node<T> front, rear;
    private int size;
    
    public MyDoubleEndedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueueFront(T data) {
        Node<T> newNode = new Node<>(data); 
        if (front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.previous = newNode;
            front = newNode;
        }
        size++;
    }
    
    public void enqueueRear(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.previous = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public T dequeueFront() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is Empty");
            return null;
        }
        
        T data = front.data;
        if (size == 1 && front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.previous = null;
        }
        size--;
        return data;
    }
    
    public T dequeueRear() {
        if (front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is Empty");
            return null;
        }
        
        T data = rear.data;
        if (size == 1 && front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.previous;
            rear.next = null;
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
        if (front == null) {
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

class MyDoubleEndedQueueMain {
    public static void main(String[] args) {
        MyDoubleEndedQueue<String> queue = new MyDoubleEndedQueue<>();
        queue.enqueueFront("0");
        queue.enqueueFront("-1");
        queue.enqueueRear("1");
        queue.enqueueRear("2");
        System.out.println("Queue contents:");
        queue.display();
        System.out.println("Size: " + queue.getSize());
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Front: " + queue.front());
        System.out.println("Rear: " + queue.rear());
        System.out.println("Dequeue front: " + queue.dequeueFront());
        System.out.println("Dequeue rear: " + queue.dequeueRear());
        System.out.println("After dequeues:");
        queue.display();
        queue.clear();
        System.out.println("After clear - Is empty: " + queue.isEmpty());
    }
}