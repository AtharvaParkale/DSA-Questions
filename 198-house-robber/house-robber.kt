class Solution {

    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp:MutableList<Int> = MutableList<Int>(n+2){0}

        for(i in n-1 downTo 0){
            dp[i] = max(nums[i] + dp[i+2],dp[i+1] )
        }

        return dp[0]
    }
}