class Solution {

    fun generate(numRows: Int): List<List<Int>> {

        val mat = MutableList(numRows) { MutableList<Int>(numRows) { 0 } }

        for (i in 0 until numRows) {

            mat[i][0] = 1

            mat[i][i] = 1

        }

        for (i in 1 until numRows) {

            for (j in 1 until i) {

                mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j]

            }

        }

        return mat.mapIndexed { i, row -> row.subList(0, i + 1) }

    }

}