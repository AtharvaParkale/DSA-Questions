class Solution {

    fun recursion(stones: IntArray,i:Int, jump:Int,dp: Array<Array<Boolean?>>):Boolean{
        if(i>=stones.size) return false
        if(i== stones.size -1) return true

        if (dp[i][jump] != null) return dp[i][jump]!!

        var jumpList:List<Int> = listOf(1)

        if(i!=0){
            jumpList = listOf(jump-1,jump,jump+1)
        }

        var ans = false
        for(j in jumpList){
            val num = stones[i] + j
            if(j<=0 || num<stones[i+1]) {
                continue
            }
            for(k in i+1 .. stones.size -1){
                if(num == stones[k]){
                    ans = ans || recursion(stones, k, j,dp)
                }
            }
            
        }

        dp[i][jump] = ans
        return ans
    }

    fun canCross(stones: IntArray): Boolean {
        val n = stones.size
        val dp = Array(n) { Array<Boolean?>(n + 1) { null } }
        return recursion(stones,0,1,dp)
    }
}