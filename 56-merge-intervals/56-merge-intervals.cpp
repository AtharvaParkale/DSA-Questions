class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        
        sort(intervals.begin(),intervals.end());
        
        int start,end;
        
        start=intervals[0][0];
        end=intervals[0][1];
        
        vector<int> v;
        
        v.push_back(start);
        v.push_back(end);
        
        ans.push_back(v);
        int k=0;
        
        for(int i=0;i<intervals.size();i++){
            
            if(intervals[i][0]>ans[k][1]){
                vector<int> l;
                l.push_back(intervals[i][0]);
                l.push_back(intervals[i][1]);
                ans.push_back(l);
                k++;
                continue;
            }
            int maxi=max(ans[k][1],intervals[i][1]);
            ans[k][1]=maxi;
        }
        
        return ans;
    }
};