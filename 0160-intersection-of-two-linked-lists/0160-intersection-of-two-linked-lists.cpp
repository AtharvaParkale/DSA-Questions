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
    int len(ListNode * head){
        
        ListNode * temp = head;
        int x=0;
        
        while(temp!=NULL){
            x++;
            temp=temp->next;
        }
        
        return x;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        if(headA==NULL || headB==NULL){
            return NULL;
        }
        
        ListNode * temp1 = headA;
        ListNode * temp2= headB;
        
        int len1=len(headA);
        int len2=len(headB);
        
        cout<<len1<<endl;
        cout<<len2<<endl;
        
        if(len1>len2){
            int move=len1-len2;
            while(move!=0){
                headA=headA->next;
                move--;
            }
        }else{
            
            int move=len2-len1;
            
            while(move!=0){
                headB=headB->next;
                move--;
            }
        }
        
        temp1=headA;
        temp2=headB;
        
        while(temp1!=NULL || temp2!=NULL){
            if(temp1==temp2){
                return temp1;
            }
            temp1=temp1->next;
            temp2=temp2->next;
        }
        cout<<headA->val<<endl;
        cout<<headB->val<<endl;
        
        return NULL;
        
    }
};