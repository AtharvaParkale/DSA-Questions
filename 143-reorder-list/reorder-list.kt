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
    fun reverseLL(head: ListNode?):ListNode?{
        var prev:ListNode? = null
        var temp:ListNode? = head
        var curr:ListNode? = temp

        while(temp!=null){
            curr = curr?.next
            temp?.next = prev
            prev=temp
            temp = curr
        }

        return prev
    }

    fun helper(l1: ListNode?, l2: ListNode?){
        var temp1 = l1
        var temp2 = l2

        var d1 = l1
        var d2 = l2


        while(d1!=null && d2!=null){
            d1 = temp1?.next
            temp1?.next = temp2
            d2 = temp2?.next
            temp2?.next = d1
            temp1 = d1
            temp2= d2
        }

    }

    fun reorderList(head: ListNode?): Unit {
        if(head==null) return

        val dummy = ListNode(-1)
        dummy.next = head

        var s = head
        var f = head

        while(f?.next?.next!=null && f?.next!=null){
            s=s?.next
            f=f?.next?.next
        }

        var newHead = s?.next
        
        s?.next = null

        var l1 = dummy?.next
        var l2 = reverseLL(newHead)

        helper(l1,l2)

    }
}