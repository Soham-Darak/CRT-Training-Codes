import java.util.HashMap;

public class NumberOfCharInStringUsingHashMap {

    public static void main(String[] args) {

        String str = "engineering";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        System.out.println("Character count in the string \"" + str + "\":");
        for (char key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
