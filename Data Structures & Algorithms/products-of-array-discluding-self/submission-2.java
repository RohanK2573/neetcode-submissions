class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int zeroCount = 0;
        int product = 1;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if (zeroCount > 1) {
            return ans; // all 0s
        }

        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                ans[i] = nums[i] == 0 ? product : 0;
            } else {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}