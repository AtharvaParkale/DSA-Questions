class Solution {

    lateinit var mem: Array<Array<Int>>

    fun solve(i: Int, j: Int, s: String, p: String): Boolean {

        if (j == p.length) return i == s.length

        if (mem[i][j] != -1) return mem[i][j] == 1

        var firstMatch = false
        if (i < s.length && (s[i] == p[j] || p[j] == '.')) {
            firstMatch = true
        }

        val ans: Boolean

        if (j + 1 < p.length && p[j + 1] == '*') {
            val notTake = solve(i, j + 2, s, p)
            val take = firstMatch && solve(i + 1, j, s, p)
            ans = notTake || take
        } else {
            ans = firstMatch && solve(i + 1, j + 1, s, p)
        }

        mem[i][j] = if (ans) 1 else 0
        return ans
    }

    fun isMatch(s: String, p: String): Boolean {

        mem = Array(s.length + 1) { Array(p.length + 1) { -1 } }

        return solve(0, 0, s, p)
    }
}