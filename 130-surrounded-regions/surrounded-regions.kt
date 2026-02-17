class Solution {
    private var m:Int = 0
    private var n:Int = 0

    val dx = listOf(-1,0,1,0)
    val dy = listOf(0,1,0,-1)


    fun dfs(board: Array<CharArray>,i:Int,j:Int,vis:MutableList<MutableList<Int>>){
        if(vis[i][j]==1) return

        vis[i][j] = 1

        for(k in 0 until 4){
            val x = i + dx[k]
            val y = j + dy[k]

            if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='O' && vis[x][y]==0){
                dfs(board,x,y,vis)
            }
        }
        return
    }

    fun solve(board: Array<CharArray>): Unit {
        m = board.size
        n = board[0].size

        val vis = MutableList(m){MutableList<Int>(n){0}}

        //Top
        for(i in 0 until n ){
            if(board[0][i]=='O' && vis[0][i]==0){
                dfs(board,0,i,vis)
            }
        }

        // Bottom
        for(i in 0 until n ){
            if(board[m-1][i]=='O' && vis[m-1][i]==0){
                dfs(board,m-1,i,vis)
            }
        }


        // Left
        for(i in 0 until m ){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(board,i,0,vis)
            }
        }


        // Right
        for(i in 0 until m ){
            if(board[i][n-1]=='O' && vis[i][n-1]==0){
                dfs(board,i,n-1,vis)
            }
        }

        for(i in 0 until m){
            for(j in 0 until n){

                if(vis[i][j]==0){
                    board[i][j] = 'X'
                }
               
            }
        }

         for(i in 0 until m){
            for(j in 0 until n){
                print("${vis[i][j]} ")
               
            }
            println()
        }

    }
}