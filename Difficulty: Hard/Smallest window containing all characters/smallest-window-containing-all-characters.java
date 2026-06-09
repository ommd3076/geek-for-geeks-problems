class Solution {
    public String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        
        int[] need = new int[26];
        int[] have = new int[26];
        
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        
        int required = 0;
        for (int count : need) {
            if (count > 0) required++;
        }
        
        int left = 0, right = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            int idx = c - 'a';
            have[idx]++;
            
            if (need[idx] > 0 && have[idx] == need[idx]) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }
                
                char leftChar = s.charAt(left);
                int leftIdx = leftChar - 'a';
                have[leftIdx]--;
                if (need[leftIdx] > 0 && have[leftIdx] < need[leftIdx]) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}