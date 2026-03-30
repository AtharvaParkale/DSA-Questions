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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1==null && list2 == null) return null
        if(list1==null) return list2
        if(list2==null) return list1

        var dummy:ListNode? = ListNode(-1)

        var ptr1:ListNode? =null
        var ptr2:ListNode? =null
        var temp:ListNode? = dummy

        if(list1.`val`<=list2.`val`){
            ptr1 = list1
            ptr2 = list2
        }  else{
            ptr1 = list2
            ptr2 = list1
        }

        while(ptr1!=null && ptr2!=null){

            val val1 = ptr1?.`val` ?: 0
            val val2 = ptr2?.`val` ?: 0

            if(val1<=val2){
                temp?.next= ptr1
                temp = temp?.next
                ptr1 = ptr1?.next
            }
            else{
                temp?.next= ptr2
                temp = temp?.next
                ptr2 = ptr2?.next
            }
        }

        if(ptr1!=null){
            temp?.next = ptr1
        }
        else if(ptr2!=null){
            temp?.next = ptr2
        }

        return dummy?.next
    }
}