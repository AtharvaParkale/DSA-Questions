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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode * d = new ListNode(-1);
        d->next=head;
        
        ListNode * f= d;
        ListNode * s = d;
        
        int cnt=0;
        
        while(cnt!=n){
            cnt++;
            f=f->next;
        }
        
        if(f->next==NULL){
            d->next=d->next->next;
            return d->next;
        }
        
        while(f->next!=NULL){
            f=f->next;
            s=s->next;
        }
        s->next=s->next->next;
        
        cout<<f->val<<endl;
        
        
        return head;
    }
};