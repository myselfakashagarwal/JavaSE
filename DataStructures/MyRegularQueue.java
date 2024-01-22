public class MyRegularQueue<T> {
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
    
    private MyRegularQueue.Node front, rear;
    private int size;
    
    MyRegularQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueue(T data) {
        MyRegularQueue.Node newNode = new MyRegularQueue.Node(data);
        if(front == null && rear == null && size == 0) {
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
        if(front == null && rear == null && size == 0) {
            System.out.println("Error: Queue is empty");
            return;
        } else if(size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        size--;
    }
    
    public MyRegularQueue.Node front() {
        return front;
    }
    
    public MyRegularQueue.Node rear() {
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
        MyRegularQueue.Node temp = front;
        if(front == null && rear == null && size == 0) {
            System.out.println("Queue is empty");
            return;
        } else if(size == 1) {
            System.out.println(front.data);
        } else {
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(" " + '\n');
        }
    }
}

class MyRegularQueueMain {
    public static void main(String args) {
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
