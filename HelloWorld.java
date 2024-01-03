import java.util.Scanner;
class HelloWorld {
  public void printMessege() {
    System.out.println("HelloWorld");
  }
}
class HelloWorldMain {
  public static void main(String[] args) {
    HelloWorld instance  = new HelloWorld();
    instance.printMessege();
  }
}
