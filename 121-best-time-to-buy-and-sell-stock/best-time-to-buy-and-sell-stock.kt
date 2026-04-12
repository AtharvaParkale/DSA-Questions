class Solution {
    fun maxProfit(prices: IntArray): Int {
        var ans:Int = 0
        var currSum = 0
        var ptr:Int =0

        for(i in 0 .. prices.size -1){
            currSum = prices[i]-prices[ptr]

            ans = max(currSum,ans)

            if(currSum<0){
                ptr = i
                currSum =0
            }
        }
        return ans
    }
}