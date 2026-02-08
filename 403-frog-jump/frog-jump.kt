class Solution {

    fun canCross(stones: IntArray): Boolean {
        val n = stones.size
        val dp = Array(n) { BooleanArray(n + 1) }
        dp[0][1] = true

        for (i in 0 until n) {
            for (jump in 1..n) {

                if (!dp[i][jump]) continue
                val jumpList =
                    if (i == 0) listOf(1)
                    else listOf(jump - 1, jump, jump + 1)

                for (j in jumpList) {
                    if (j <= 0) continue

                    val nextPos = stones[i] + j
                    for (k in i + 1 until n) {
                        if (stones[k] == nextPos) {
                            dp[k][j] = true
                        }
                    }
                }
            }
        }
        for (jump in 1..n) {
            if (dp[n - 1][jump]) return true
        }

        return false
    }
}