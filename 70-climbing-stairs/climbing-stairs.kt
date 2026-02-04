class Solution {
    fun climbStairs(n: Int):Int{

        var prev = 1
        var prev2 = 1
        var curr = 0

        for(i in 2..n){
            curr = prev + prev2
            prev2= prev
            prev= curr
        }
        return prev
    }
}