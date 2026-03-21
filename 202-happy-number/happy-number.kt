class Solution {
    fun pow(n:Int):Int{
        return n*n
    }

    fun isHappy(n: Int): Boolean {
        var sum = 0
        var num =n

        val mp: MutableMap<Int,Int> = mutableMapOf()

        while(num !=0){
            sum = sum + pow(num%10)
            num = num/10
            

            if(num == 0){
               if(sum ==1 ) return true

               if(mp.containsKey(sum)){
                return false
               }
               else{
                mp[sum] = 1
                num = sum
                sum =0
               }
            }
        
        }
        return false
    }
}