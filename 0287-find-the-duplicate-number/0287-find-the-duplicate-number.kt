class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var curr:Int = nums[0]
        
        while(true){
            println("Current : ${curr}")
            println("Nums -> curr : ${nums[curr]}")
            println("")
            if(nums[curr] == -1){
                return curr
            }
            else{
                val elem = nums[curr]
                nums[curr] = -1
                curr = elem
            }
        }

        println("")

        return -1
    }
}