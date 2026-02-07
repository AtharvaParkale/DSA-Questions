class Solution {
    lateinit var dp: IntArray

    fun helper(s: String, i: Int): Int {
        if (i == s.length) return 1
        if (s[i] == '0') return 0
        if (dp[i] != -1) return dp[i]

        var count = helper(s, i + 1)

        if (i + 1 < s.length) {
            val num = (s[i] - '0') * 10 + (s[i + 1] - '0')
            if (num in 10..26) {
                count += helper(s, i + 2)
            }
        }

        dp[i] = count
        return count
    }

    fun numDecodings(s: String): Int {
        dp = IntArray(s.length) { -1 }
        return helper(s, 0)
    }
}