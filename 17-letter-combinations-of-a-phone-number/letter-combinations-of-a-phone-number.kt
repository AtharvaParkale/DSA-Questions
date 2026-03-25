class Solution {
    var ans:MutableList<String> = mutableListOf()
    var n: Int =0

    val mp: MutableMap<Int, String> = mutableMapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "wxyz",
    )

    fun rec(digits:String, str:String, idx:Int){
        if(idx>=n){
            ans.add(str)
            return
        }

        val digit:Int = digits[idx].digitToInt()
        val len:Int = if(digit==7 || digit==9) 3 else 2

        for(i in 0 .. len){

            val newString: String = str + (mp?.get(digit)?.get(i) ?: 'x')
            rec(digits,newString,idx+1)
        }

        return
    }

    fun letterCombinations(digits: String): List<String> {
        ans = mutableListOf()
        n = digits.length

        rec(digits,"",0)


        return ans
    }
}