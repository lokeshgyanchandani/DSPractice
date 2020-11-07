package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class DictionaryMatch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "e b ab abc abdc";
        String[] words = s.split(" ");
        Arrays.sort(words, new Comparator<String>() {

            public int compare(String S1, String S2) {
                // TODO Auto-generated method stub
                return S1.length() - S2.length();
            }
        });
        for (String word : words)
            System.out.println(word);

        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        int Maxlen = 0;
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                String currentWord = word.substring(0, i) + word.substring(i + 1);
                if (hmap.containsKey(currentWord)) {
                    max = Math.max(max, (int) hmap.get(currentWord) + 1);
                }
                Maxlen = Math.max(Maxlen, max);

            }
            hmap.put(word, max);
        }
        System.out.println(Maxlen + 1);
    }
}