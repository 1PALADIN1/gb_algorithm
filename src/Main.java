import lesson3.List;
import lesson4.Tree;

public class Main {
    public static void main(String[] args) {
//        lesson3();
        lesson4();
    }

    private static void lesson3() {
        List list = new List();
        list.add(12);
        list.add(21);
        list.add(-12);
        list.add(202);
        list.add(121);
        list.add(-212);
        list.add(1212);
        list.print();

        list.revert();
        list.print();
    }

    private static void lesson4() {
        Tree<Integer> integerTree = new Tree<>();
        int[] values = new int[] {
                12, 1, 200, 90, 10, 45, 45, 42
        };

        for (int i = 0; i < values.length; i++) {
            boolean result = integerTree.add(values[i]);
            if (result) {
                System.out.println(values[i] + " - successfully added!");
            } else {
                System.out.println(values[i] + " - already exists...");
            }
        }
    }
}