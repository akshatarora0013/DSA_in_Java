package Hashing.Code;

import java.util.*;

public class InBuiltHashMap {
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        System.out.println(map);

        map.put("abc", 5);
        map.put("xyz", 3);
        map.put("def", 9);

        System.out.println(map);
        System.out.println("------------------------");

        map.put("abc", 8);
        System.out.println(map);
        System.out.println("------------------------");

        System.out.println(map.get("abc"));
        System.out.println("------------------------");

        map.remove("xyz");
        System.out.println(map);

    }
}
