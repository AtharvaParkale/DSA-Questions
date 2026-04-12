class Solution {

    val dx = listOf(-1, 0,1,0)
    val dy = listOf(0,1,0,-1)
    fun helper(board:Array<CharArray>,word: String,i:Int,j:Int,ptr:Int):Boolean{
        // Base
        if(ptr >=word.length) return true
        val m = board.size
        val n = board[0].size
        if(i>=m || j>=n || i<0 || j<0 || board[i][j] == '$'){
            return false
        }
        // Recursion

        if(word[ptr] !=board[i][j]) return false

        val temp =  board[i][j]
        board[i][j] = '$'
        for(k in 0 .. 3){
            val x = dx[k] + i
            val y = dy[k] +j

            if(helper(board,word,x,y,ptr+1)){
                return true
            }
        }

        board[i][j] = temp

        return false

    }

    fun exist(board: Array<CharArray>, word: String): Boolean {

        val m :Int = board.size
        val n:Int = board[0].size

        for(i in 0 .. m-1){
            for(j in 0 .. n-1){
                if(board[i][j] == word[0] ){
                    val ans = helper(board,word,i,j,0)
                    if(ans== true) return true
                }
            }
        }
        return false
    }
}