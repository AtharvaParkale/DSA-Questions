//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
    private:
    void bfs(vector<vector<int>>& grid,int x,int y,vector<vector<int>> &visited
    ,vector<pair<int,int>> &v){
        
        int n=grid.size(), m=grid[0].size();
        
        vector<int> dx{-1,0,1,0} ,dy{0,1,0,-1};
        
        queue<pair<int,int>> q;
        visited[x][y]=1;
        q.push({x,y});
        
        while(!q.empty()){
            
        int x1=q.front().first, y1=q.front().second;
        q.pop();
        
        v.push_back({x1-x,y1-y});
        
        for(int i=0;i<4;i++){
            int x2,y2;
            x2=x1+dx[i];
            y2=y1+dy[i];
            if(x2>=n||y2>=m||x2<0||y2<0) 
            continue;
            
            if(grid[x2][y2]==1 && !visited[x2][y2]){
                 visited[x2][y2]=1;
                 q.push({x2,y2});
            }
        }
        }
    }
    public:
    int countDistinctIslands(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        
        vector<vector<int>>vis(n,vector<int>(m,0));
        
        set<vector<pair<int,int>>>dstIsland;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    vector<pair<int,int>> tmp;
                    
                    bfs(grid,i,j,vis,tmp);
                    
                    dstIsland.insert(tmp);
                }
            }
        }
        
        return dstIsland.size();
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid(n, vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        cout << obj.countDistinctIslands(grid) << endl;
    }
}
// } Driver Code Ends