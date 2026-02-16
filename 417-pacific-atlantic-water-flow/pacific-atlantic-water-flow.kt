class Solution {

    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private var m = 0
    private var n = 0

    private fun dfs(
        heights: Array<IntArray>,
        vis: Array<IntArray>,
        i: Int,
        j: Int
    ) {
        if (vis[i][j] == 1) return
        vis[i][j] = 1

        for (k in 0 until 4) {
            val x = i + dx[k]
            val y = j + dy[k]

            if (
                x in 0 until m &&
                y in 0 until n &&
                heights[x][y] >= heights[i][j]
            ) {
                dfs(heights, vis, x, y)
            }
        }
    }

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        m = heights.size
        n = heights[0].size

        val pacific = Array(m) { IntArray(n) }
        val atlantic = Array(m) { IntArray(n) }
        val ans = mutableListOf<List<Int>>()

        // Pacific Ocean
        for (j in 0 until n) dfs(heights, pacific, 0, j)
        for (i in 0 until m) dfs(heights, pacific, i, 0)

        // Atlantic Ocean
        for (j in 0 until n) dfs(heights, atlantic, m - 1, j)
        for (i in 0 until m) dfs(heights, atlantic, i, n - 1)

        // Cells reachable from both
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(listOf(i, j))
                }
            }
        }

        return ans
    }
}