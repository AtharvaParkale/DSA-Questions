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
        
        ListNode * ptr=NULL;
        ListNode * temp=head;
        ListNode * curr=temp;
        
        while(temp!=NULL){
            temp=temp->next;
            curr->next=ptr;
            ptr=curr;
            curr=temp;
        }
        
        return ptr;
        
    }
    
    ListNode * remove(ListNode * head,int n)
    {
        if(n==1){
            return head->next;
        }
        if(n==0){
            return head;
        }
        
        int cnt=0;
        
        ListNode * temp=head;
        ListNode * curr=temp;
        ListNode * ptr=new ListNode(-1);
        ListNode * ptrHead=ptr;
        ptr->next=head;
        
        while(temp!=NULL){
            cnt=cnt+1;
            
            if(cnt==n){
                temp=temp->next;
                ptr->next=temp;
                break;
            }
            
            temp=temp->next;
            ptr=ptr->next;
        
            
            
        }
        
        ptrHead->next=NULL;
        
        return head;
        
    }
    
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        
        ListNode * rev= reverse(head);
        
        ListNode * updatedHead= remove(rev,n);
        
        ListNode * ans=reverse(updatedHead);
        
        return ans;
    }
};