class Solution {

    // Map: original node -> cloned node
    private val visited = HashMap<Node, Node>()

    private fun dfs(node: Node?): Node? {
        if (node == null) return null

        // If already cloned, return it
        if (visited.containsKey(node)) {
            return visited[node]
        }

        // Create clone of current node
        val clone = Node(node.`val`)
        visited[node] = clone

        // Clone all neighbors
        for (neighbor in node.neighbors) {
            clone.neighbors.add(dfs(neighbor))
        }

        return clone
    }

    fun cloneGraph(node: Node?): Node? {
        return dfs(node)
    }
}