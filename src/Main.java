import lesson3.List;

public class Main {
    public static void main(String[] args) {
//        lesson3();
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
}