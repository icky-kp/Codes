import java.util.*;

public class Test {

    private static int k;
    private static ArrayList<Integer> heap

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 2;
        int numElements = 5;
        for (int i = 0; i < numElements; i++) {
            int value = sc.nextInt();
            insert(value);
        }

        removeMax();
        getMax();
    }

    public static void insert(int value) {

    }
}
