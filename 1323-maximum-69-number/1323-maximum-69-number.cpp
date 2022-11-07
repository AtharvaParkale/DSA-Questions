class Solution {
public:
    int maximum69Number (int num) {
        int ans=0;
        
        vector<int> v;
        
        int temp=num;
        
        while(temp!=0){
            v.push_back(temp%10);
            temp=temp/10;
        }
        
        for(int i=v.size()-1;i>=0;i--){
            if(v[i]==6){
                v[i]=9;
                
                break;
            }
        }
        
       
        
        for(int i=v.size()-1;i>=0;i--){
            
            long long x=pow(10,i);
            
            ans=v[i]*x+ans;
            
        }
        
        cout<<v.size();
        
        return ans;
    }
};