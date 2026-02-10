class Solution {
    fun helper(nums:IntArray, i:Int,prev:Int,dp:MutableList<MutableList<Int>>):Int{
        if(i>=nums.size) return 0
        if(dp[i][prev+1] !=-1) return dp[i][prev+1]

        val notTake = 0 + helper(nums,i+1,prev,dp)
        var take = 0
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1 + helper(nums,i+1,i,dp)
        }

        dp[i][prev+1] = max(take,notTake)
        return max(take,notTake)
    }
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = MutableList(n){MutableList<Int>(n+1){-1}}
        return helper(nums,0,-1,dp)
    }
}