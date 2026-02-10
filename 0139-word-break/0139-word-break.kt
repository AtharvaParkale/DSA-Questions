class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val set = wordDict.toHashSet()   // faster lookup O(1)

        val dp= MutableList<Boolean?>(s.length){null} 

        // start solving from index 0
        return helper(s, 0, set,dp)
    }

    fun helper(s: String, start: Int, set: Set<String>,dp:MutableList<Boolean?>): Boolean {

        // ✅ base case
        // if we consumed full string -> success
        if (start == s.length) return true

        if(dp[start]!=null) return dp[start]!!

        // try every possible cut from current index
        for (end in start + 1..s.length) {

            // take substring from start → end
            val sub = s.substring(start, end)

            // if substring exists in dictionary
            // AND remaining string also breakable
            if (set.contains(sub) && helper(s, end, set,dp)) {
                dp[start] = false
                return true
            }
        }

        // if no split works
        dp[start] = false
        return false
    }
}