/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    
        val dummyNode  = ListNode(-1)
        var temp = dummyNode

        var h1:ListNode? = l1
        var h2:ListNode? = l2
       

        var carry = 0
        while(h1!=null || h2!=null){
            val val1 = if(h1==null) 0 else h1.`val`
            val val2 = if(h2==null) 0 else h2.`val`

            val currVal = val1 + val2 + carry

            carry = currVal/10

            val newNode = ListNode(currVal%10)

            temp.next =  newNode
            temp = temp.next

            if(h1!=null) h1=h1.next
            if(h2!=null) h2=h2.next
        }

        temp.next = if(carry!=0) ListNode(carry) else null

        return dummyNode.next
    }
}