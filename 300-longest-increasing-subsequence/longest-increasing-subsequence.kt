class Solution {

    fun lengthOfLIS(nums: IntArray): Int {

        val n = nums.size

        // dp[i][prevIndex+1]
        // i → current index
        // prevIndex → last taken element index (-1 allowed)
        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }

        // base already 0
        // dp[n][*] = 0

        // fill from bottom → top
        for (i in n - 1 downTo 0) {

            // prevIndex can be -1 to i-1
            for (prevIndex in i - 1 downTo -1) {

                // skip current
                val notTake = dp[i + 1][prevIndex + 1]

                var take = 0

                // take if increasing
                if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
                    take = 1 + dp[i + 1][i + 1]
                }

                dp[i][prevIndex + 1] = maxOf(take, notTake)
            }
        }

        // start from i=0, prev=-1
        return dp[0][0]
    }
}