class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()

        for(it in nums){
            if(set.contains(it)){
                return true
            }
            else{
                set.add(it)
            }
        }

        return false
    }
}