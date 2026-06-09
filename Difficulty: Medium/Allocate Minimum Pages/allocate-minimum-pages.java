public class Solution {
    // Driver calls: sln.findPages(arr, k)
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] arr, int k, int maxPages) {
        int count = 1;
        int currentSum = 0;
        for (int pages : arr) {
            if (pages > maxPages) return false;
            if (currentSum + pages > maxPages) {
                count++;
                currentSum = pages;
                if (count > k) return false;
            } else {
                currentSum += pages;
            }
        }
        return true;
    }
}