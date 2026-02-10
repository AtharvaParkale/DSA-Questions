class Solution {

 fun canPartition(nums: IntArray): Boolean {

    val totalSum = nums.sum()
    if (totalSum % 2 != 0) return false

    val target = totalSum / 2
    val dp = BooleanArray(target + 1)

    dp[0] = true

    for (num in nums) {
        for (s in target downTo num) {
            dp[s] = dp[s] || dp[s - num]
        }
    }

    return dp[target]
}
}