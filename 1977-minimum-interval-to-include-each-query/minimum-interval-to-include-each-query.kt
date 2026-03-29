

class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {

        intervals.sortBy { it[0] }

        val sortedQueries = queries.mapIndexed { i, q -> Pair(q, i) }.sortedBy { it.first }

        val result = IntArray(queries.size)
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }) // (size, end)

        var i = 0

        for ((q, index) in sortedQueries) {

            // Add intervals whose start <= query
            while (i < intervals.size && intervals[i][0] <= q) {
                val start = intervals[i][0]
                val end = intervals[i][1]
                val size = end - start + 1
                minHeap.add(Pair(size, end))
                i++
            }

            // Remove intervals that cannot cover query
            while (minHeap.isNotEmpty() && minHeap.peek().second < q) {
                minHeap.poll()
            }

            result[index] = if (minHeap.isEmpty()) -1 else minHeap.peek().first
        }

        return result
    }
}