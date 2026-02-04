class Solution {
    fun climbStairs(n: Int):Int{
        val dp = MutableList(n + 1) { -1 }

        val ans:Int = helper(n,dp)
        return ans
    }

    fun helper(n: Int, dp:MutableList<Int>): Int {
        if(n==0) return 1
        if(n<0) return 0

        if(dp[n]!=-1) return dp[n]

        val a:Int = helper(n-1,dp)
        val b:Int = helper(n-2,dp)

        dp[n] = a+b

        return dp[n]
    }
}