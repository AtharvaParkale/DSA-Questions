class Solution {
    fun romanToInt(s: String): Int {
        val map: MutableMap<Char,Int> = mutableMapOf()

        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000

        var prev = 0

        var ans =0

        var i:Int = 0
        var j:Int = i+1

        while(i<s.length && j< s.length){
            val val1 = map[s[i]]?:0
            val val2 = map[s[j]]?:0

            if(val1>=val2){
                ans = ans + val1
                i++
                j++
            }
            else{
                ans = ans + (val2 -val1)
                i = i+2
                j= i+1
            }
        }

        if(i<s.length){
            val num = map[s[i]] ?: 0
            ans = ans + num
    
        }

        return ans
    }
}