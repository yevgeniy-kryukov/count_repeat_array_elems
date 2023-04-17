package count_repeat_array_elems;

import java.util.*;

public class Main {
    public static void run(final String[] arr) {
        // Counting dublicates
        Map<String, Integer> map1 = Arrays.stream(arr)
                .sorted()
                .collect(LinkedHashMap::new,
                        (map, key) -> map.merge(key, 1, Integer::sum),
                        LinkedHashMap::putAll);

        System.out.println("Dublicate elements:");
        map1.forEach((key, value) -> {
            if (value > 1) {
                System.out.printf(" Key: %s Value: %s \n", key, value);
            }
        });

        // Filter unique elements
        System.out.println("Unique elements:");
        map1.forEach((key, value) -> {
            if (value == 1) {
                System.out.printf(" Key: %s Value: %s \n", key, value);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        String[] arr = {"a1", "a2", "a3", "a1", "a3", "a10", "a1", "a55", "a55", "a55", "a23", "a23", "b1", "b1", "b1", "b1", "a11", "a12"};
        System.out.println(Arrays.toString(arr));
        Main.run(arr);
        System.out.println("--------------------------------------------");
        arr = new String[]{"a1", "a2", "a3"};
        System.out.println(Arrays.toString(arr));
        Main.run(arr);
    }
}