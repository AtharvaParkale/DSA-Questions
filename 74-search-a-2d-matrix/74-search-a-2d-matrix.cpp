class Solution {
public:
    int binarySearch(vector<int> arr,int start,int end,int target){
        int mid=(start+end)/2;
        
        if(arr[mid]==target){
            return target;
        }
        
        if(start>=end){
            return -1;
        }
        
        
        
        int ans;
        
        if(target<=arr[mid]){
            ans=binarySearch(arr,start,mid,target);
        }
        
        if(target>arr[mid]){
            ans=binarySearch(arr,mid+1,end,target);
        }
        
        return ans;
        
        
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        
        int n=matrix.size();
        int m=matrix[0].size();
        
        for(int i=0;i<n;i++){
            int check= binarySearch(matrix[i],0,m-1,target);
            
            cout<<check<<endl;
            
            if(check==target){
                return true;
            }
            
        }
        
        
        return false;
        
    }
};