class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // create a graph
        val adj:MutableList<MutableList<Int>> = MutableList(numCourses){mutableListOf<Int>()}

        for(it in prerequisites){
            adj[it[1]].add(it[0])
        }

        // Indegree Array

        val indegree:MutableList<Int> = MutableList<Int>(numCourses){0}

        for(i in 0 until numCourses){
            for(it in adj[i]){
                indegree[it]++
            }
        }

        val queue = ArrayDeque<Int>()
    
        for(i in 0 until numCourses){
            if(indegree[i]==0){
                queue.add(i)
            }
        }

        val topo:MutableList<Int> = mutableListOf()

        while(!queue.isEmpty()){
            val node:Int = queue.removeFirst()
            topo.add(node)

            for(it in adj[node]){
                indegree[it]--
                if(indegree[it]==0) queue.addLast(it)
            }
        }

        if(topo.size == numCourses) return true

        return false
    }
}