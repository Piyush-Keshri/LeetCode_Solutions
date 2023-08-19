import java.util.Arrays;

public class Solution {
    public boolean possible(int[] nums, int mid, int k) {
        long windowSum = 0;
        long totalSum = 0;

        for (int i = 0; i < mid; ++i) {
            windowSum += nums[i];
        }

        totalSum = 1L * nums[mid - 1] * mid;

        if (totalSum - windowSum <= k) {
            return true;
        }

        int j = 0;
        for (int i = mid; i < nums.length; ++i) {
            windowSum -= nums[j];
            windowSum += nums[i];
            totalSum = 1L * nums[i] * mid;

            if (totalSum - windowSum <= k) {
                return true;
            }
            j++;
        }

        return false;
    }

    public int maxFrequency(int[] nums, int k) {
        int l = 1;
        int h = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (possible(nums, mid, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }
}
