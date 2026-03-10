class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val dist:MutableList<Int> = MutableList<Int>(n){Integer.MAX_VALUE}
        val adj:MutableList<MutableList<Pair<Int,Int>>> = MutableList(n){mutableListOf()}

        for(num in flights){
            adj[num[0]].add(Pair(num[1],num[2]))
        }

        val queue = ArrayDeque<Triple<Int,Int,Int>>()

        queue.addLast(Triple(src,0,k))

        while(!queue.isEmpty()){
            val top = queue.removeFirst()

            val currNode = top.first //0
            val currDist = top.second //0
            val currK = top.third //0

            for(neighbour in adj[currNode]){
                val totDist = currDist + neighbour.second

                if(totDist<=dist[neighbour.first] && currK>=0){
                    queue.add(Triple(neighbour.first,totDist,currK-1))
                    dist[neighbour.first] =totDist
                }
            }


        }

        if(dist[dst] == Integer.MAX_VALUE) return -1
        return dist[dst]
    }
}