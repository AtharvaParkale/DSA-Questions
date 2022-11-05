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
    
    ListNode * addLL(ListNode * l1,ListNode * l2){
        
        ListNode * temp1=l1;
        ListNode * temp2=l2;
        
        
        
        ListNode * dummy=new ListNode(-1);
        ListNode * newHead=dummy;
        ListNode * temp=newHead;
        
        int sum=0;
        
        while(l1!=NULL || l2!=NULL){
            
            int x=sum;
            sum=0;
            
            if(l1!=NULL){
                cout<<l1->val<<" ";
                x=x+l1->val;
            }else{
                cout<<" X ";
            }
            cout<<" - ";
            
            if(l2!=NULL){
                 cout<<l2->val<<" ";
                x=x+l2->val;
            }else{
                 cout<<" X ";
                x=x+0;
            }
            
            ListNode * n=new ListNode(x%10);
            temp->next=n;
            temp=temp->next;
            
            sum=x/10;
            
            
            
            cout<<endl;
            
            
            
            
            if(l1!=NULL){
                l1=l1->next;
            }
            if(l2!=NULL){
                l2=l2->next;
            }
        }
        
        cout<<"Sum - "<<sum<<endl;
        if(sum>0){
        temp->next=new ListNode(sum);
        }
        
        return newHead->next;
        
        
    }
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
//         ListNode* rev1=reverse(l1);
//         ListNode * rev2= reverse(l2);
        
//         ListNode * ans;
        
//         if(rev1->val>rev2->val){
//             ans=addLL(rev1,rev2);
//         }else{
//             ans= addLL(rev2,rev1);
//         }
        
        ListNode * ans;
        if(l1->val>l2->val){
            ans= addLL(l1,l2);
        }
        else{
            ans= addLL(l2,l1);
        }
        
        // ListNode * ans= addLL(l1,l2);
        
        return ans;
    }
};