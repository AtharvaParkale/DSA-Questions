class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int indOne;
        
        for(int i=nums.size()-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                indOne=i;
                break;
            }
        }
        
        int indTwo=nums.size()-1;
        cout<<"hi"<<endl;
        
        cout<<indOne<<endl;
        if(indOne>=0){
            
            
            cout<<"One"<<nums[indOne]<<endl;
            cout<<"Two"<<nums[indTwo]<<endl;
            for(int i=nums.size()-1;i>indOne;i--){
                if(nums[i]>nums[indOne])
                {
                    indTwo=i;
                    
                    cout<<"hi"<<endl;
                    break;
                }
            }
            
            swap(nums[indOne], nums[indTwo]);
            reverse(nums.begin()+indOne+1,nums.end());
        }
        else{
             cout<<"Hi"<<endl;
             reverse(nums.begin(),nums.end());
        }
        
    }
};