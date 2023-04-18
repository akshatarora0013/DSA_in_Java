package Hashing.Code.CustomHashMap;

public class HashMapMain {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(4);

        map.put("abc", 5);
        map.put("xyz", 3);
        map.put("def", 9);

        map.displayMap();
        System.out.println("------------------------");

        map.put("var", 99999);
        map.displayMap();
        System.out.println("------------------------");

        map.put("abc", 8);
        map.displayMap();
        System.out.println("------------------------");

        System.out.println(map.get("abc"));
        System.out.println("------------------------");

        map.remove("xyz");
        map.displayMap();
    }
}
