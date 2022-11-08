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
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        ListNode * temp=head;
        ListNode * dummy=new ListNode(-1);
        int cnt=1;
        
        dummy->next=head;
        
        ListNode * prev=dummy;
        ListNode * joiningPtr=prev->next;
        ListNode * joinToPtr;
        
        while(temp!=NULL){
            
            if(cnt==k){
                joinToPtr=temp->next;
                temp->next=NULL;
                
                ListNode * rev =reverse(prev->next);
                prev->next=rev;
                joiningPtr->next=joinToPtr;
                
                cnt=1;
                prev=joiningPtr;
                joiningPtr=prev->next;
                
                temp=joinToPtr;
        
            }
            else{
                cnt++;
                temp=temp->next;
            }
            
           
        }
        
        
        return dummy->next;
        
    }
};