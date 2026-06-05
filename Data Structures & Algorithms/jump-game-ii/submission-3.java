

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return minJumps(0, nums, dp);
    }

    private int minJumps(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minSteps = Integer.MAX_VALUE;
        int maxIndex = Math.min(i + nums[i], nums.length - 1);

        for (int j = i + 1; j <= maxIndex; j++) {
            int jumpsFromNext = minJumps(j, nums, dp);

            if (jumpsFromNext != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, 1 + jumpsFromNext);
            }
        }

        dp[i] = minSteps;
        return dp[i];
    }
}