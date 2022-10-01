class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        if(nums.size()==1){
            return 1;
        }
        int ans=-1;
        int n=nums.size();
        int cond=n/2;
        
        sort(nums.begin(),nums.end());
        
        
        int check=1;
        
        for(int i=0;i<n-1;i++){
           if(nums[i]==nums[i+1])
           {
               check++;
               
               if(check>cond)
               {
                ans=nums[i];
                return ans;
               }
               
               continue;
           }
           
            check=1;
            
        }
        
        
        return ans;
        
    }
};