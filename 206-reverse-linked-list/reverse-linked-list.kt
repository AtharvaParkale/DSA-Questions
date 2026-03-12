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
    fun reverseList(head: ListNode?): ListNode? {
        var prev:ListNode? = null

        var temp:ListNode? = head

        while(temp !=null){
            var nxt = temp.next
            temp.next = prev
            prev= temp
            temp =nxt
        }

        return prev
    }
}