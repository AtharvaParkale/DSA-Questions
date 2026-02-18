

class Solution {

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        // Build adjacency list
        val adj = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }

        for (edge in times) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            adj[u].add(Pair(v, w))
        }

        // Distance array
        val dist = IntArray(n + 1) { Int.MAX_VALUE }

        // Min heap (distance, node)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        dist[k] = 0
        pq.add(Pair(0, k))

        while (pq.isNotEmpty()) {

            val (currentDist, node) = pq.poll()

            // Skip outdated entries
            if (currentDist > dist[node]) continue

            for ((neighbor, weight) in adj[node]) {

                val newDist = currentDist + weight

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist
                    pq.add(Pair(newDist, neighbor))
                }
            }
        }

        var maxTime = 0

        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE) return -1
            maxTime = maxOf(maxTime, dist[i])
        }

        return maxTime
    }
}