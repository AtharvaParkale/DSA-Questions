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
    
    int len(ListNode * head){
        
        int x=0;
        
        ListNode * temp = head;
        
        while(temp!=NULL){
            x++;
            temp=temp->next;
        }
        
        return x;
    }
   
    bool isPalindrome(ListNode* head) {
        
        if(head->next==NULL || head==NULL){
            return true;
        }
        
        ListNode * head1=head;
        ListNode * head2;
        ListNode * temp1;
        ListNode * temp2;
        ListNode * temp=head;
        
        int l=len(head);
        int t=1;

        while(t!=l/2){
            t++;
            temp=temp->next;
        }
        
        // cout<<temp->next->next->val;
        
        if(l%2==0){
            
            head2=temp->next;
            temp->next=NULL;
            
        }else{
            
            head2=temp->next->next;
            temp->next=NULL;
            
        }
        
        temp1=head1;
        temp2=reverse(head2);
        
        // cout<<temp1->next->val<<endl;
        // cout<<temp2->next->val<<endl;
        
        while(temp1!=NULL && temp2!=NULL){
            if(temp1->val!=temp2->val){
                return false;
            }
            
            temp1=temp1->next;
            temp2=temp2->next;
        }
        
        return true;
        
    }
};