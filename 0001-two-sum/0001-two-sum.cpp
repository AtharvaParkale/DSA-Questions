class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        vector<int> dummy;
        
        for(int i=0;i<nums.size();i++){
            dummy.push_back(nums[i]);
        }
        
        sort(dummy.begin(),dummy.end());
        
        int i=0;
        int j=dummy.size()-1;
        
        int a=0;
        int b=0;
        
        while(i<j){
            if(dummy[i]+dummy[j]==target){
                a=dummy[i];
                b=dummy[j];
                break;
            }
            else if(dummy[i]+dummy[j]>target){
                j--;
            }
            else{
                i++;
            }
            // cout<<"hi";
        }
        
        cout<<a<<" "<<b;
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]==a){
                ans.push_back(i);
            }
            else if(nums[i]==b){
                ans.push_back(i);
            }
        }
        return ans;
    }
};