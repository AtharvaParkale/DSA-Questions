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
    ListNode* rotateRight(ListNode* head, int k) {
        
        if(head==NULL || head->next==NULL || k==0){
            return head;
        }
        vector<ListNode *> arr;
        
        ListNode * temp=head;
        ListNode * newHead=head;
        
        while(temp!=NULL){
            
            arr.push_back(temp);
            
            temp=temp->next;
            
        }
        
        // cout<<"LL size : "<<arr.size()<<endl;
        
        int rot=k%arr.size();
        
        if(rot==0)return head;
        
        int cnt=1;
        
        
        
        for(int i=arr.size()-1;i>=0;i--){
            if(cnt==rot){
                
                newHead=arr[i];
                
                arr[i-1]->next=NULL;
                arr[arr.size()-1]->next=arr[0];
                
                break;
            }
            
            cnt++;
        }
        
        
        return newHead;
        
        
    }
};