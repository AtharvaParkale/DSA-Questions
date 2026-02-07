class Solution {
    fun countSubstrings(s: String): Int {
        var ans:Int = 0

        var res = ""

        for (i in s.indices) {
            for (j in i until s.length) {
                var l = i
                var r = j
                while (l < r && s[l] == s[r]) {
                    l++
                    r--
                }

                if (l >= r ) {
                    ans = ans+1
                }
            }
        }

        return ans
    }
}