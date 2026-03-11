class Solution {
    fun reverse(x: Int): Int {

        var n =0
        var currNum = x

        while(currNum!=0){
            currNum = currNum/10
            n++
        }

        currNum = x

        var ans :Long = 0
        val len :Int = n

        // println(n)

        while(currNum!=0){
            val lastDigit = currNum%10

            if(lastDigit==0 && len==n ){
                n--
                currNum = currNum/10
                continue
            }

            val base:Double = 10.0

            ans = ans + lastDigit * (base.pow(n-1)).toLong()
            n--
            currNum = currNum/10
        }

        if(ans <=Integer.MAX_VALUE.toLong() && ans>=Integer.MIN_VALUE.toLong()){
            return ans.toInt()
        }

        return 0
    }
}