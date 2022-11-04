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
    ListNode * f(ListNode * head,ListNode * prev,ListNode* & ans){
        
        if(head==NULL){
            // cout<<prev->val<<endl;
            ans=prev;
            return head ;
        }
    
        ListNode * k=f(head->next,head,ans);
        head->next=prev;
        // cout<<endl;
        return k;
    }
    
    ListNode* reverseList(ListNode* head) {
        
        ListNode * prev=NULL;
        ListNode * ans=NULL;
        
        ListNode * temp=f(head,prev,ans);
    
        return ans;
        
    }
};