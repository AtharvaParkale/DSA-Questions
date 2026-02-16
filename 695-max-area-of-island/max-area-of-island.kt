class Solution {

    private val dx:List<Int> = listOf(-1,0,1,0)
    private val dy:List<Int> = listOf(0,1,0,-1)


    fun bfs(grid: Array<IntArray>, vis:MutableList<MutableList<Int>>, i:Int,j:Int):Int{
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.addLast(Pair(i,j))


        vis[i][j] =1

        var count:Int = 0

        val m:Int = grid.size
        val n:Int = grid[0].size

        while(!queue.isEmpty()){
            val top = queue.removeFirst()
            val left = top.first
            val right = top.second
            
            count++

            for(k in 0 until 4){
                val x = left + dx[k] 
                val y = right + dy[k]

                if(x>=0 && x<m && y>=0 && y<n && vis[x][y]==-1 && grid[x][y]==1){
                    queue.add(Pair(x,y))
                    vis[x][y] = 1
                } 
            }
        }

        return count
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var ans:Int = 0

        val m:Int = grid.size
        val n:Int = grid[0].size

        val vis:MutableList<MutableList<Int>> = MutableList(m){MutableList<Int>(n){-1}}


        for(i in 0 until m){
            for(j in 0 until n){
                if(grid[i][j]==1 && vis[i][j]==-1){
                    val ctr = bfs(grid,vis,i,j)
                    ans  = max(ans,ctr)
                }
            }
        }

        return ans
    }
}