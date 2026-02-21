class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i:Int =0
        var j:Int = numbers.size-1

        while(i<j){
            val sum :Int = numbers[i] + numbers[j]

            if(sum==target) return intArrayOf(i+1,j+1)
            else if(sum<target) i++
            else j--
        }

        return intArrayOf()

    }
}