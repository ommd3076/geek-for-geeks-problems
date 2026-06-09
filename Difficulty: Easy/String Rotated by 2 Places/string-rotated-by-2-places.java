class Solution {
    public static boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        if (n < 2) return s1.equals(s2);
        
        // Left rotation by 2
        String leftRot = s1.substring(2) + s1.substring(0, 2);
        // Right rotation by 2
        String rightRot = s1.substring(n - 2) + s1.substring(0, n - 2);
        
        return s2.equals(leftRot) || s2.equals(rightRot);
    }
}