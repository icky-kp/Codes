import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "banana");
        hashmap.put(2, "apple");
        hashmap.put(0,"watermelon");

        TreeMap<Integer, String> treemap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : hashmap.entrySet()) {
            treemap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(treemap);
    }
}
