import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!mapStoT.containsKey(s.charAt(i)) && !mapTtoS.containsKey(t.charAt(i))) {
                mapStoT.put(s.charAt(i), t.charAt(i));
                mapTtoS.put(t.charAt(i), s.charAt(i));
            } else if (mapStoT.get(s.charAt(i)) != t.charAt(i) || mapTtoS.get(t.charAt(i)) != s.charAt(i)) return false;
        }
        return true;
    }
}
