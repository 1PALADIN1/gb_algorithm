package lesson3;

public class List {
    private Node head;
    private Node tail;

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
    }

    public void add(int value, Node node) {
        Node next = node.getNext();
        Node newNode = new Node(value);
        node.setNext(newNode);
        newNode.setPrevious(node);

        if (next == null) {
            tail = newNode;
            return;
        }

        next.setPrevious(newNode);
        newNode.setNext(next);
    }

    public void delete(Node node) {
        Node previous = node.getPrevious();
        Node next = node.getNext();

        if (previous == null) {
            next.setPrevious(null);
            head = next;
        } else {
            if (next == null) {
                previous.setNext(null);
                tail = previous;
            } else {
                previous.setNext(next);
                next.setPrevious(previous);
            }
        }
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    public void revert() {
        Node current = head;
        while (current != null) {
            Node next = current.getNext();
            Node previous = current.getPrevious();
            current.setNext(previous);
            current.setPrevious(next);
            if (previous == null) {
                tail = current;
            }
            if (next == null) {
                head = current;
            }

            current = next;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }

        System.out.println();
    }
}
