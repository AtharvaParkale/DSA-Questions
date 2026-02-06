class Solution {

    fun rob(nums: IntArray): Int {
        var next1 = 0
        var next2 = 0

        for (i in nums.size - 1 downTo 0) {
            val curr = maxOf(nums[i] + next2, next1)
            next2 = next1
            next1 = curr
        }

        return next1
    }
}