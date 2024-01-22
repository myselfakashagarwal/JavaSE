public class MyStack<T> {
    private static class Node<U> {
        U data;
        Node next;
        Node(U data) {
            this.data = data;
            this.next = null;
        }
    }

    private MyStack.Node top;
    private int size;

    MyStack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        MyStack.Node newNode = new MyStack.Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Error: Underflow");
            return;
        } else {
            top = top.next;
        }
        size--;
    }

    public Node peek() {
        if (top == null) {
            System.out.println("Error: Stack is empty");
            return null;
        }
        return top;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            MyStack.Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(" ");
        }
    }
}

class MyStackMain {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack();
        stack.push("1");
        stack.pop();
        stack.push("3");
        stack.push("4");
        stack.push("9");
        stack.isEmpty();
        stack.clear();
        stack.getSize();
        stack.isEmpty();
        stack.display();
    }
}
