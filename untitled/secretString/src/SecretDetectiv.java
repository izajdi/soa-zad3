import java.lang.String;
import java.util.*;

public class SecretDetectiv {
    public static String recoverSecret(char[][] triples) {
        Map<Character, Set<Character>> hmap = new HashMap<>();
        for (int i = 0; i < triples.length; i++) {                                //filling hashmap with sets of character after char
            for (int j = 0; j < triples[i].length - 1; j++) {
                if (!hmap.containsKey(triples[i][j])) {
                    Set<Character> hset = new HashSet<>();
                    int x = j + 1;
                    while (x != 3) {
                        hset.add(triples[i][x]);
                        x++;
                    }
                    hmap.put(triples[i][j], hset);
                } else {
                    for (int x = j + 1; x < 3; x++) {
                        hmap.get(triples[i][j]).add(triples[i][x]);
                    }
                }
            }
        }
        Set<Character> hset = hmap.keySet();
        Map<Character, Set<Character>> hmapp = new HashMap<>();
        for (Character i : hset) {
            for (Character j : hmap.get(i)) {
                if(hmap.containsKey(j)) {
                    Set<Character> temporarySet = new HashSet<>(hmap.get(i));
                    temporarySet.addAll(hmap.get(j));
                    hmapp.put(i, temporarySet);
                }
            }
        }
        Map<Character, Integer> hmap2 = new HashMap<>();
        for (Character i : hset) {
            hmap2.put(i, hmap.get(i).size());
        }
        char[] arr = new char[hmap2.size()];
        for (Character i : hset) {
            arr[hmap2.size() - hmap2.get(i)] = i;
        }
        String result = new String(arr);
        return result;
    }

    public static void main(String[] args) {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        System.out.println(recoverSecret(triplets));

    }
}