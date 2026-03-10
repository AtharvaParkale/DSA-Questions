class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n:Int = nums.size
        val sum:Int = (n * (n+1))/2

        var arrSum = 0

        for(num in nums){
            arrSum = arrSum +num
        }

        return sum-arrSum
    }
}