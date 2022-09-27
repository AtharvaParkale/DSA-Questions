class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if(n==0){
            return;
        }
        
        vector<int> ans;
        int i=0;
        int j=0;
        
        while(i<m && j<n){
            
            if(nums1[i]<=nums2[j]){
                ans.push_back(nums1[i]);
                i++;
            }
            
            if(nums1[i]>nums2[j]){
                ans.push_back(nums2[j]);
                j++;
            }
        }
        
        while(i<m){
            ans.push_back(nums1[i]);
            i++;
        }
        while(j<n){
            ans.push_back(nums2[j]);
            j++;
        }
        
        for(int l=0;l<nums1.size();l++){
            nums1[l]=ans[l];
        }
    }
};