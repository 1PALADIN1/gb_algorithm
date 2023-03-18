package lesson3;

public class Node {
    private int value;
    private Node next;
    private Node previous;

    public Node(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }
}
