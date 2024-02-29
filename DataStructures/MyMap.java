public class MyMap<K,V> {
    private static class Node<K,V> {
        K key;
        V value;
        Node next;
        Node(K key,V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private MyMap.Node head;
    private int size;

    MyMap() {
        head = null;
        size = 0;
    }

    public void put(K key,V value) {
        if (isEmpty()) {
            head = new MyMap.Node(key,value);
        } else {
            if (containsKey(key)) {
               System.out.println("Error: Key is present already");
               return;
            } else {
                MyMap.Node newNode = new MyMap.Node(key,value);
                newNode.next = head;
                head = newNode;
            }
        }
        size++;
    }

    public void remove(K key) {
        if (containsKey(key)) {
            if (head.key.equals(key)) {
                head = head.next;
            } else {
                MyMap.Node temp = head;
                while (temp.next != null) {
                    if (temp.next.key.equals(key)) {
                        temp.next = temp.next.next;
                    } else {
                        temp = temp.next;
                    } 
                }
            }
        } else {
            return;
        }
        size--;
    }

    public void replace(K key, V value) {
        MyMap.Node node = getNode(key);
        if(node == null) {
            System.out.println("Error: Key is not present");
        } else {
            node.value = value;
        }
    }
 
    private MyMap.Node getNode(K key) {
        if (! isEmpty()) {
            MyMap.Node temp = head;
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp;
                }
            temp = temp.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return (getNode(key) != null);
    } 

    public boolean containsValue(V value) {
        if( ! isEmpty()) {
            MyMap.Node temp = head;
            while(temp != null) {
                if(temp.value.equals(value)) {
                    return true;
                }
            temp = temp.next;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (head == null && size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object get(K key) {
        MyMap.Node node = getNode(key);
        if(node == null) {
            return null;
        } else {
            return node.value;
        } 
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Error: Map is empty");
        } else {
            MyMap.Node temp = head;
            while(temp != null) {
                System.out.print( "("+temp.key+","+temp.value+")"+ " ");
                temp = temp.next;
            }
            System.out.println(" ");
        }
    }
}
class MyMapMain {
    public static void main(String[] args) {
        MyMap<String,String> map = new MyMap<String,String>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.display();
        map.replace("1","numero");
        map.display();
        map.remove("1");
        map.display();
        map.remove("3");
        map.display();
        map.remove("2");
        map.display();
        map.put("boom","explosion");
        System.out.println(map.get("boom"));
    }
}
