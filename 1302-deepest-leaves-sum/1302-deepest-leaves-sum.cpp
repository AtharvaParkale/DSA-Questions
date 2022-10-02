/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int deepestLeavesSum(TreeNode* root) {
        if(root->left==NULL && root->right==NULL){
            return root->val;
        }
        queue<TreeNode* > q;
        vector<TreeNode *> v;
        
        q.push(root);
        q.push(NULL);
        
        while(q.size()!=0){
            TreeNode * front=q.front();
            q.pop();
            
            v.push_back(front);
            
            
            if(front==NULL){
                if(q.size()==0){
                    break;
                }
                
                q.push(NULL);
                // cout<<"Break"<<endl;
                
            }
            else{
                cout<<front->val<<" ";
                
                if(front->left!=NULL){
                    q.push(front->left);
                }
                if(front->right!=NULL){
                    q.push(front->right);
                }
            }
        }
        
        // cout<<v.size()<<endl;
        
        // for(int i=0;i<v.size();i++){
        //     if(v[i]==NULL){
        //         cout<<"-1"<<" ";
        //     }
        //     else{
        //         cout<<v[i]->val<<" ";
        //     }
        // }
        
        int sum=0;
        
        int start=v.size()-2;
        
        while(v[start]!=NULL){
            sum=sum+v[start]->val;
            start--;
        }
        
        
        return sum;
    }
};