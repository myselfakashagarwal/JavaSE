public class MyDoubleEndedQueue<T> {
    private static class Node<U> {
        U data;
        Node next;
        Node previous;
        Node(U data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }
    
    private MyDoubleEndedQueue.Node front,rear;
    int size;
    
    MyDoubleEndedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueueFront(T data) {
        MyDoubleEndedQueue.Node newNode = new Node(data); 
        if(front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front.next;
            front.previous = newNode;
            front = newNode;
        }
        size++;
    }
    
    public void enqueueRear(T data) {
        MyDoubleEndedQueue.Node newNode = new Node(data);
        if(front == null && rear == null && size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = rear.next;
            newNode.previous = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public void dequeueFront() {
        if(front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is Empty");
            return;
        } else if(size == 1 && front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.previous.next = null;
            front.previous = null;
        }
        size--;
    }
    
    public void dequeueRear() {
        if(front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is Empty");
            return;
        } else if(size == 1 && front == rear) {
            front = null;
            rear = null;
        } else {
            rear.previous.next = null;
            rear = rear.previous;
        }  
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public MyDoubleEndedQueue.Node front() {
        return front;
    }
    
    public MyDoubleEndedQueue.Node rear() {
        return rear;
    }
    
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void display() {
        MyDoubleEndedQueue.Node temp = front;
        while(temp!= null) {
            System.out.println(temp.data + " ");
        }
        System.out.println("\n");
    }
}

class MyDoubleEndedQueueMain {
    public static void main(String[] args) {
        MyDoubleEndedQueue<String> queue = new MyDoubleEndedQueue<String>();
        queue.enqueueFront("0");
        queue.enqueueFront("-1");
        queue.enqueueRear("1");
        queue.display();
        queue.getSize();
        queue.isEmpty();
        queue.rear();
        queue.front();
        queue.clear();
    }
}
