/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var counter:Int = 0
    fun helper(root: TreeNode?,k: Int, ans:MutableList<Int>){
        if(root==null) return
        helper(root.left,k,ans)
        counter++
        if(counter == k) ans[0] = root.`val`
        helper(root.right,k,ans)

    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val ans = MutableList<Int>(1){0}
        counter =0
        helper(root,k,ans)

        return ans[0]
    }
}