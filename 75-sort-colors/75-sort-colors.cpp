class Solution {
public:
    void sortColors(vector<int>& nums) {
        unordered_map<int,int> m;
        
        int n=nums.size();
        
        for(int i=0;i<n;i++){
            m[nums[i]]=m[nums[i]]+1;
        }
        
        
        // while(m[2]!)
        
        int hook=0;
        
        while(hook!=n){
            if(m[0]!=0){
                nums[hook]=0;
                m[0]=m[0]-1;
                hook++;
            }
            else if(m[1]!=0){
                nums[hook]=1;
                m[1]=m[1]-1;
                hook++;
            }
            else{
                nums[hook]=2;
                m[2]=m[2]-1;
                hook++;
                 }
         }
    }
};