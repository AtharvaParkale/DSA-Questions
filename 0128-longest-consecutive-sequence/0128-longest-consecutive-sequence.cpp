class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,int> m;
        int ans=0;
        
        for(int i=0;i<nums.size();i++){
            m[nums[i]]=m[nums[i]]+1;
        }
        
        for(int i=0;i<nums.size();i++){
            
            if(m[nums[i]-1]>0){
                continue;
            }
            
            int count=0;
            
            cout<<nums[i]<<" ";
            
            int x=nums[i];
            
            while(m[x]!=0){
                if(m[x]>0){
                    count++;
                }
                x++;
            }
            
            if(count>ans){
                ans=count;
            }
        }
        
        return ans;
    }
};