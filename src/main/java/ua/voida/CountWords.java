package ua.voida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CountWords {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/usa/Projects/CountWords/words.txt"));
        Map<String, Integer> map = new HashMap<>();
        String line, word = "";
        List<String> stringList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            for (Character item : line.toCharArray() ) {
                if ( Character.isLetter(item)) {
                    word += Character.toLowerCase(item);
                } else if (word.length() != 0){
                    stringList.add(word);
                    word = "";
                }
            }
        }
        for (String e : stringList) {
            if ( map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });
        System.out.println(stringList.size());
        for (Map.Entry item : map.entrySet()) {
            System.out.println(item.getKey() + "   " + item.getValue());
        }
    }
}
