package T001_100;

import java.util.HashMap;
import java.util.Map;

public class T3_lengthOfLongestSubstring {
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            res = Math.max(res, i - j);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}