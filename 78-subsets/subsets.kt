class Solution {
    fun helper(nums:IntArray,i:Int, temp:MutableList<Int>,ans:MutableList<MutableList<Int>>){
        if(i>=nums.size){
            ans.add(temp)
            return 
        }

        val dummy = temp.toMutableList()
        temp.add(nums[i])
        helper(nums,i+1,temp,ans)
        helper(nums,i+1,dummy,ans)
    }
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans:MutableList<MutableList<Int>> = mutableListOf()
        helper(nums,0,mutableListOf(),ans)
        return ans
    }
}