import DataStructures.MyCircularQueue;

public class Main {
    public static void main(String[] args) {
        // Using MyStack from the JAR
        MyCircularQueue<Integer> queue = new MyCircularQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.display();  // Should print: 20 30
    }
}