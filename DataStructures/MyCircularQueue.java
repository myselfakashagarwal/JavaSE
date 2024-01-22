public class MyCircularQueue<T> {
    private static class Node<U> {
        U data;
        Node next;
        Node previous;
        Node(U data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    
    private MyCircularQueue.Node front, rear;
    private int size;
    
    MyCircularQueue() {
        size = 0;
        rear = null;
        front = null;
    }
    
    public void enqueue(T data) {
        MyCircularQueue.Node newNode  = new MyCircularQueue.Node(data);
        if(front  == null && rear == null && size == 0) {
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
    
    public void dequeue() {
        if(front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is empty");
        } else if(front == rear && size == 1) {
            front  = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
            front.previous =rear;
        }
        size--;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public MyCircularQueue.Node front() {
        return front;
    }
    
    public MyCircularQueue.Node rear() {
        return rear;
    }
    
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void display() {
        if(front == null && rear == null && size == 0) {
            System.out.println("Queue is empty");
            return;
        } else if(front == rear && size == 1) {
            System.out.println(front.data);
        } else {
            MyCircularQueue.Node temp = front;
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
        MyCircularQueue<String> queue = new MyCircularQueue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.getSize();
        queue.isEmpty();
        queue.display();
        queue.clear();
    }
}
