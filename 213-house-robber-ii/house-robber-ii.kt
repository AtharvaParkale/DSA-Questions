class Solution {

    fun helper(nums: IntArray, start: Int, end: Int): Int {
        var next1 = 0
        var next2 = 0

        for (i in end downTo start) {
            val curr = maxOf(nums[i] + next2, next1)
            next2 = next1
            next1 = curr
        }

        return next1
    }

    fun rob(nums: IntArray): Int {
        val n = nums.size

        if (n == 1) return nums[0]

        val case1 = helper(nums, 0, n - 2)  
        val case2 = helper(nums, 1, n - 1)   

        return maxOf(case1, case2)
    }
}