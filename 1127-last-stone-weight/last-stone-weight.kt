class Solution {
    fun addDigit(arr: MutableList<Int>, value:Int ){

        var i = 0

        while(i <= arr.size-1){
            if(value>=arr[i] ){
                arr.add(i,value)
                break
            }
            i++
        }

        if(i>arr.size-1){
            arr.add(value)
        }
    }
    fun lastStoneWeight(stones: IntArray): Int {
        val arr = stones.sortedDescending().toIntArray()
        val mutableList: MutableList<Int> = arr.toMutableList()

        var len = mutableList.size

        println(mutableList)

        while(mutableList.size>1){
            val first = mutableList.removeAt(0)
            val second = mutableList.removeAt(0)

            val newDigit = first- second

            addDigit(mutableList,newDigit)

        }
        println(mutableList)
        return mutableList[0]
    }
}