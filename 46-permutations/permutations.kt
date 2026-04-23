class Solution {
    fun helper(
        nums:IntArray,
        ds:MutableList<Int>,
        vis:MutableList<Int>,
        ans:MutableList<MutableList<Int>>,
        idx:Int
    ){
        if(ds.size == nums.size){
            ans.add(ArrayList(ds))
            return
        }

        for(k in 0 .. vis.size -1){
            if(vis[k]==-1){
                ds.add(nums[k])
                vis[k] =1
                helper(nums,ds,vis,ans,idx)
                ds.removeLast()
                vis[k] =-1
            }
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        var ans:MutableList<MutableList<Int>> = mutableListOf()
        val ds:MutableList<Int> = mutableListOf()
        val vis:MutableList<Int> = MutableList<Int>(nums.size){-1}

        helper(nums,ds,vis,ans,0)

        return ans
    }
}