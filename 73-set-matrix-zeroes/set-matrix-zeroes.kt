class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m:Int = matrix.size
        val n:Int = matrix[0].size

        val colMat :MutableList<Int> = MutableList<Int>(m){-1}
        val rowMat :MutableList<Int> = MutableList<Int>(n){-1}

        for(i in 0 until m){
            for(j in 0 until n){
                val curr = matrix[i][j]
                if(curr == 0){
                    colMat[i] =0
                    rowMat[j] = 0
                }
            }
        }

        
        for(i in 0 until m){
            for(j in 0 until n){
                if(colMat[i]==0 || rowMat[j]==0){
                    matrix[i][j]=0
                }
            }
        }
    }
}