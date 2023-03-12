package lesson2;

public class Node<T> {
    private T value;
    private Color color;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T value) {
        this(value, Color.BLACK);
    }

    public Node(T value, Color color) {
        this.value = value;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public T getValue() {
        return this.value;
    }
}
