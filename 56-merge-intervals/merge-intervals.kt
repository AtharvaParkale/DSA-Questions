class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sortedInterval = intervals.sortedBy{it[0]}
        val ans:MutableList<IntArray> = mutableListOf()

        val queue = ArrayDeque<IntArray>()

        queue.addLast(intArrayOf(sortedInterval[0][0], sortedInterval[0][1]))

        var ptr:Int = 1
        while(ptr<sortedInterval.size){
            var topElem = queue.removeLast()

            if(topElem[1] < sortedInterval[ptr][0]){
                queue.addLast(topElem)
                queue.addLast(sortedInterval[ptr])
            }
            else{
                queue.addLast(intArrayOf(min(topElem[0],sortedInterval[ptr][0]),max(topElem[1],sortedInterval[ptr][1])))
            }

            ptr++
        }

        return queue.toTypedArray()
    }
}