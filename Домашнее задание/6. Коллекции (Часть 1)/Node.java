public class Node {
    
    Object item;
    Node next;
    Node prev;

    public Node() {}
    
    public Node(Node prev, Object item, Node next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}