class Solution {
fun canAddQueen(grid: MutableList<MutableList<Int>>, i: Int, j: Int): Boolean {

    val n = grid.size

    // Check row
    for (col in 0 until n) {
        if (grid[i][col] == 1) return false
    }

    // Check column
    for (row in 0 until n) {
        if (grid[row][j] == 1) return false
    }

    // Check top-left diagonal
    var r = i
    var c = j
    while (r >= 0 && c >= 0) {
        if (grid[r][c] == 1) return false
        r--
        c--
    }

    // Check top-right diagonal
    r = i
    c = j
    while (r >= 0 && c < n) {
        if (grid[r][c] == 1) return false
        r--
        c++
    }

    // Check bottom-left diagonal
    r = i
    c = j
    while (r < n && c >= 0) {
        if (grid[r][c] == 1) return false
        r++
        c--
    }

    // Check bottom-right diagonal
    r = i
    c = j
    while (r < n && c < n) {
        if (grid[r][c] == 1) return false
        r++
        c++
    }

    return true
}

    fun recursion(i:Int, grid:MutableList<MutableList<Int>>,count:Int,ans:MutableList<MutableList<String>>){
        if(count==0 ){

            val mtList:MutableList<String> =  mutableListOf()

            for(p in 0 until grid.size){
                var ansStr:String = ""
                for(q in 0 until grid.size){

                    if(grid[p][q]==0){
                        ansStr = ansStr + '.'
                    }
                    else{
                        ansStr = ansStr + 'Q'
                    }
                }

                mtList.add(ansStr)
            }

            ans.add(mtList)

            return
        }

        if(i>=grid.size) return 

        for(j in 0 until grid.size){
            val canAdd:Boolean = canAddQueen(grid,i,j)

            if(canAdd){
                grid[i][j] = 1
                recursion(i+1,grid,count-1,ans)
                grid[i][j] = 0
            }
        } 

        return
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val grid = MutableList(n){MutableList<Int>(n){0}}
        val ans:MutableList<MutableList<String>> = mutableListOf()
        recursion(0,grid,n,ans)

        val result: List<List<String>> = ans.map { it.toList() }

        return result
    }
}