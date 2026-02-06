class Solution {
    fun helper(nums:IntArray, i:Int,dp:MutableList<Int>):Int{
        if(i>=nums.size) return 0

        if(dp[i] !=-1) return dp[i]

        val sum1 = nums[i] + helper(nums,i+2,dp)
        val sum2 = helper(nums,i+1,dp)

        dp[i] = max(sum1,sum2)

        return dp[i]
    }

    fun rob(nums: IntArray): Int {
        val dp:MutableList<Int> = MutableList<Int>(nums.size+1){-1}
    
        return helper(nums,0,dp)
    }
}