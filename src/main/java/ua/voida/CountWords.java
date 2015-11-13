package ua.voida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CountWords {
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/usa/Projects/CountWord/words.txt"));
        String line, word = "";
        while ((line = bufferedReader.readLine()) != null) {
            for (Character item : line.toCharArray() ) {
                if ( Character.isLetter(item)) {
                    word += Character.toLowerCase(item);
                } else if (word.length() != 0){
                    mapPut(word);
                    word = "";
                }
            }
        }


        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int value = a.getKey().compareTo(b.getKey());
                if ( value == 0) {
                    return value;
                } else {
                    return b.getValue().compareTo(a.getValue());
                }
            }
        });
        for (Object i : list) {
            System.out.println(i);
        }
    }
    public static Map<String, Integer> mapPut (String e) {
        if ( map.containsKey(e)) {
            map.put(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
        return map;
    }
}
