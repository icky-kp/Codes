import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortWithExtraSpace {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);

        System.out.println("orginal queue : " + queue);
        Integer[] array = queue.toArray(new Integer[0]);
        Arrays.sort(array);
        Queue<Integer> sorteQueue = new LinkedList<>(Arrays.asList(array));
        System.out.println("Sorted queue " + sorteQueue);
    }
}
