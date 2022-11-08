/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode * reverse(ListNode * head){
        
        ListNode * temp=head;
        ListNode * curr=temp;
        ListNode * ptr=NULL;
        
        while(temp!=NULL){
            temp=temp->next;
            curr->next=ptr;
            ptr=curr;
            curr=temp;
        }
        
        return ptr;
    }

   
    bool isPalindrome(ListNode* head) {
        
        ListNode * slow= head;
        ListNode * fast= head;
        
        while(fast->next!=NULL && fast->next->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        
        ListNode *rev=reverse(slow->next);
        slow->next=rev;
        slow=slow->next;
        ListNode * dummy=head;
        
        while(slow!=NULL){
            if(slow->val!=dummy->val){
                return false;
            }
            slow=slow->next;
            dummy=dummy->next;
        }
        
        return true;
    }
};