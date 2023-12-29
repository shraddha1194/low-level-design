package fundamentals.generics.worksheet_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node implements Iterable<Integer>{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(this);
    }

    class NodeIterator implements Iterator<Integer> {
        Node current;

        public NodeIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            Integer data = current.data;
            current = current.next;
            return data;
        }
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Node n1 = new Node(1, null);
//        Node n2 = new Node(2, null);
//        Node n3 = new Node(3, null);
//        Node n4 = new Node(4, null);
//        Node n5 = new Node(5, null);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//
//        Iterator itr = new Node.NodeIterator(n1);
//
//    }
//}
