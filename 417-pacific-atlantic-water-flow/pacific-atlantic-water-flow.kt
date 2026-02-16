class Solution {
    private var m = 0;
    private var n = 0;
    private val dx = listOf(-1,0,1,0)
    private val dy = listOf(0,1,0,-1)

    fun dfs(heights: Array<IntArray>,mt:MutableList<MutableList<Int>>,i:Int,j:Int){
        if(i<0 || i>=m || j<0 || j>=n ){
            return
        }

        mt[i][j] = 1


        for(k in 0 until 4){
            val x= i + dx[k]
            val y= j + dy[k]

            if(x>=0 && x<m && y>=0 && y<n && heights[x][y]>=heights[i][j] && mt[x][y]!=1){
                dfs(heights, mt, x,y)
            }
        }

        return 
    }

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
   m = heights.size
        n = heights[0].size

        val pacific = MutableList(m) { MutableList(n) { 0 } }
        val atlantic = MutableList(m) { MutableList(n) { 0 } }
        val ans = mutableListOf<List<Int>>()

        // Pacific: top row + left column
        for (j in 0 until n) dfs(heights, pacific, 0, j)
        for (i in 0 until m) dfs(heights, pacific, i, 0)

        // Atlantic: bottom row + right column
        for (j in 0 until n) dfs(heights, atlantic, m - 1, j)
        for (i in 0 until m) dfs(heights, atlantic, i, n - 1)

        // Intersection
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