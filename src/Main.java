import lesson2.Tree;

public class Main {
    public static void main(String[] args) {
        lesson2();
    }

    private static void lesson2() {
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