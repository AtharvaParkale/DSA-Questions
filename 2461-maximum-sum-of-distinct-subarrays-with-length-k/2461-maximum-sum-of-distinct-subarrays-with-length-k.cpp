class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        int n=nums.size();
        long long sum=0,maxo=0;
        
        unordered_map<int,int> check;
        for(int i=0;i<k-1;i++){
            sum+=nums[i];
            check[nums[i]]++;
        }
        
        for(int i=k-1;i<n;i++){
            
            check[nums[i]]++;
            
            sum+=nums[i];
            
            if(check.size()==k){
                maxo=max(maxo,sum);
            }
            
            
            //This will completely remove decrese the freq of first elem of sub array
            if(check[nums[i-k+1]]==1){
                check.erase(nums[i-k+1]);
            }else{
                check[nums[i-k+1]]--;
            }
            
            sum-=nums[i-k+1];
        }
        
        return maxo;
    }
};