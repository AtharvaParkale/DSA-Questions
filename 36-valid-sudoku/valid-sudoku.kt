class Solution {

    private var rows:MutableMap<Int,Boolean> = mutableMapOf()
    private var cols:MutableMap<Int,Boolean> = mutableMapOf()
    private var boxes:MutableMap<Int,Boolean> = mutableMapOf()

    fun getBoxId(i:Int,j:Int):Pair<Int,List<Int>>{

        if(i in 0..2 && j in 0..2) return  Pair(1, listOf(0,2,0,2))
        if(i in 0..2 && j in 3..5) return Pair(2, listOf(0,2,3,5))
        if(i in 0..2 && j in 6..8) return Pair(3, listOf(0,2,6,8))

        if(i in 3..5 && j in 0..2) return Pair(4, listOf(3,5,0,2))
        if(i in 3..5 && j in 3..5)return Pair(5, listOf(3,5,3,5))
        if(i in 3..5 && j in 6..8)return Pair(6, listOf(3,5,6,8))

        if(i in 6..8 && j in 0..2)return Pair(7, listOf(6,8,0,2))
        if(i in 6..8 && j in 3..5)return Pair(8, listOf(6,8,3,5))
        if(i in 6..8 && j in 6..8)return Pair(9, listOf(6,8,6,8))

        return Pair(-1, listOf())
    }

    fun checkRow(row:Int,board: Array<CharArray>):Boolean{
        if(rows.containsKey(row)){
            if(rows[row]==true){
                return true
            }
            else{
                return false
            }
        }

        val vis:MutableList<Int> = MutableList<Int>(9){-1}

        for(k in 0 .. 8){
            if(board[row][k] == '.') continue
            val currValue = board[row][k].digitToInt() - 1
            if(vis[currValue]==0){
                rows[row]=false
                return false
            }
            else{
                vis[currValue] = 0
            }
        }
        rows[row]=true
        return true
    }


    fun checkCol(col:Int,board: Array<CharArray>):Boolean{
        if(cols.containsKey(col)){
            if(cols[col]==true){
                return true
            }
            else{
                return false
            }
        }

        val vis:MutableList<Int> = MutableList<Int>(9){-1}

        for(k in 0 .. 8){
            if(board[k][col] == '.') continue
            val currValue = board[k][col].digitToInt() - 1
            if(vis[currValue]==0){
                cols[col]=false
                return false
            }
            else{
                vis[currValue] = 0
            }
        }
        cols[col]=true
        return true
    }

    fun checkBox(i:Int,j:Int,board: Array<CharArray>):Boolean{

        val boxId = getBoxId(i,j)

        if(boxes.containsKey(boxId.first)){
            if(boxes[boxId.first]==true){
                return true
            }
            else{
                return false
            }
        }

        val visited  = MutableList<Int>(9){-1}

        for(p in boxId.second[0] .. boxId.second[1]){
            for(q in boxId.second[2] .. boxId.second[3]){
                if(board[p][q] == '.') continue
                val currValue = board[p][q].digitToInt() - 1

                if(visited[currValue]==0){
                    boxes[boxId.first]=false
                    return false
                }
                else{
                    visited[currValue] = 0
                }
            }
        }

        boxes[boxId.first]=true
        return true
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        rows = mutableMapOf()
        cols = mutableMapOf()
        boxes = mutableMapOf()

        for(i in 0 until 9){
            for(j in 0 until 9){
                if(board[i][j]!='.'){
                    val isValidRow = checkRow(i,board)
                    val isValidCol = checkCol(j,board)
                    val isValidBox = checkBox(i,j,board)

                    if(!isValidRow || !isValidCol || !isValidBox) return false
                }
            }
        }

        return true
    }
}