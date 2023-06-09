package lesson4;

/*
Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У краной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку,
благодаря которой все критерии выше станут валидными. Для балансировки существует 3 операции – левый малый поворот,
правый малый поворот и смена цвета.
 */
public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public boolean add(T value) {
        if (root == null) {
            // create new tree
            root = new Node<>(value, Color.BLACK);
            return true;
        }

        // append node
        boolean result = addNode(root, value);
        root = rebalance(root);
        root.setColor(Color.BLACK);
        return result;
    }

    private boolean addNode(Node<T> node, T value) {
        if (node.getValue() == value) {
            return false;
        }

        if (node.getValue().compareTo(value) > 0) {
            // fill left node
            if (node.getLeftNode() != null) {
                boolean result = addNode(node.getLeftNode(), value);
                node.setLeftNode(rebalance(node.getLeftNode()));
                return result;
            }

            Node<T> leftNode = new Node<>(value, Color.RED);
            node.setLeftNode(leftNode);
            return true;
        }

        // fill right node
        if (node.getRightNode() != null) {
            boolean result = addNode(node.getRightNode(), value);
            node.setRightNode(node.getRightNode());
            return result;
        }

        Node<T> rightNode = new Node<>(value, Color.RED);
        node.setRightNode(rightNode);
        return true;
    }

    private Node<T> rebalance(Node<T> node) {
        Node<T> result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.getRightNode() != null && result.getRightNode().getColor() == Color.RED &&
                    (result.getLeftNode() == null || result.getLeftNode().getColor() == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }

            if (result.getLeftNode() != null && result.getLeftNode().getColor() == Color.RED
                    && result.getLeftNode().getLeftNode() != null && result.getLeftNode().getLeftNode().getColor() == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }

            if (result.getLeftNode() != null && result.getLeftNode().getColor() == Color.RED
                    && result.getRightNode() != null && result.getRightNode().getColor() == Color.RED) {
                needRebalance = true;
                swapColor(result);
            }

        } while(needRebalance);

        return result;
    }

    private Node<T> rightSwap(Node<T> node) {
        Node<T> rightChild = node.getRightNode();
        Node<T> betweenChild = rightChild.getLeftNode();
        rightChild.setLeftNode(node);
        node.setRightNode(betweenChild);
        rightChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return rightChild;
    }

    private Node<T> leftSwap(Node<T> node) {
        Node<T> leftChild = node.getLeftNode();
        Node<T> betweenChild = leftChild.getRightNode();
        leftChild.setRightNode(node);
        node.setLeftNode(betweenChild);
        leftChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return leftChild;
    }

    private void swapColor(Node<T> node) {
        node.getRightNode().setColor(Color.BLACK);
        node.getLeftNode().setColor(Color.BLACK);
        node.setColor(Color.RED);
    }
}
