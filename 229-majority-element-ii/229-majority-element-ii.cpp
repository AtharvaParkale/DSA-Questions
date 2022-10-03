class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> ans;
        int num1=-1;
        int num2=-1;
        int c1=0;
        int c2=0;
        
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]==num1){
                c1++;
            }
            else if(nums[i]==num2){
                c2++;
            }
            else if(c1==0){
                num1=nums[i];
                c1=1;
            }
            else if(c2==0){
                num2=nums[i];
                c2=1;
            }
            else{
                c1--;
                c2--;
            }
        }
        
        int check=floor(nums.size()/3);
        
        int a=0;
        int b=0;
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]==num1){
                a++;
            }
            
            if(nums[i]==num2){
                b++;
            }
        }
        
        
        
        
        
        if(a>check && num1!=num2){
            ans.push_back(num1);
        }
        
        if(b>check && num1!=num2){
            ans.push_back(num2);
        }
        
        if(num1==num2 && a>check){
            ans.push_back(num1);
        }
        
        return ans;
    }
};