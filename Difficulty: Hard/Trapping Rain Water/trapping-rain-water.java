class Solution {
    public int maxWater(int[] arr) {
        int l = 0, r = arr.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (l < r) {
            if (arr[l] < arr[r]) {
                if (arr[l] >= leftMax) leftMax = arr[l];
                else water += leftMax - arr[l];
                l++;
            } else {
                if (arr[r] >= rightMax) rightMax = arr[r];
                else water += rightMax - arr[r];
                r--;
            }
        }
        return water;
    }
}