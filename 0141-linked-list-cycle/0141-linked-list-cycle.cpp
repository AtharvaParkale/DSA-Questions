/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL || head->next==NULL){
            return false;
        }
        ListNode * ptr1=head;
        ListNode * ptr2=head->next;
        
        while(ptr2->next!=NULL && ptr2->next->next!=NULL){
            
            ptr1=ptr1->next;
            ptr2=ptr2->next->next;
            
            if(ptr1==ptr2){
                return true;
            }
        }
        
        return false;
    }
};