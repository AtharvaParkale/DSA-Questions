class Solution {
    fun helper(cost:IntArray, i:Int, n:Int,dp:MutableList<Int>):Int{
        if(i>=n) return 0

        if(dp[i]!=-1) return dp[i]

        val sum1 = helper(cost, i+1,n,dp)
        val sum2 = helper(cost, i+2,n,dp)

        dp[i] = cost[i] + min(sum1,sum2)
        return dp[i]
    }
    fun minCostClimbingStairs(cost: IntArray): Int {
        var ans:Int = Integer.MAX_VALUE

        for(i in 0 .. 1){
            val dp:MutableList<Int> = MutableList<Int>(cost.size+1){-1}
            val minCost = helper(cost,i,cost.size, dp)
            ans = min(minCost,ans)
        }
        return ans  
    }
}