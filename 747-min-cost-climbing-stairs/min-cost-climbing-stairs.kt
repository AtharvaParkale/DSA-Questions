class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var ans:Int = Integer.MAX_VALUE

        val n = cost.size
        val dp = IntArray(n + 2)

        for (i in n - 1 downTo 0) {
            dp[i] = cost[i] + minOf(dp[i + 1], dp[i + 2])
        }

        return minOf(dp[0], dp[1])
    }
}