class Solution {
    fun helper(nums: IntArray, i: Int, temp: MutableList<Int>, ans: MutableList<MutableList<Int>>) {

        ans.add(temp.toMutableList())

        for (k in i until nums.size) {
            temp.add(nums[k])
            helper(nums, k + 1, temp, ans)
            temp.removeLast()
        }
    }
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans:MutableList<MutableList<Int>> = mutableListOf()
        helper(nums,0,mutableListOf(),ans)
        return ans
    }
}