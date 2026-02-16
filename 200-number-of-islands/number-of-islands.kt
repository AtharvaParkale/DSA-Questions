class Solution {

    val dx:List<Int> = listOf(-1,0,1,0)
    val dy:List<Int> = listOf(0,1,0,-1)

    var m:Int = 0
    var n:Int = 0

    var vis = MutableList(m){MutableList<Int>(n){-1}}

    fun dfs(grid: Array<CharArray>, i:Int,j:Int){

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0' || vis[i][j] !=-1){
            return
        }

        vis[i][j] =1

        for(p in 0 until 4){
            val x = i + dx[p]
            val y = j + dy[p]
            dfs(grid,x,y)
        }
        return 
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var ans = 0

        m = grid.size
        n = grid[0].size

        vis = MutableList(m){MutableList<Int>(n){-1}}


        for(i in 0 until m){
            for(j in 0 until n){
                if(grid[i][j]=='1' && vis[i][j]==-1){
                    dfs(grid,i, j)
                    ans++
                }
            }
        }

        return ans
    }
}