/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root== null) return null
        if(root.`val`==p?.`val` ?:0 || root.`val`==q?.`val`?:0 ) return root 

        val left = lowestCommonAncestor(root.left,p,q)
        val right = lowestCommonAncestor(root.right,p,q)

        if(left != null && right != null) return root
        if(left ==null && right != null) return right
        if(left !=null && right == null) return left

        return null   
    }
}