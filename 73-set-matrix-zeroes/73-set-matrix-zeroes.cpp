class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        
        unordered_map<int,int> mRow;
        unordered_map<int,int> mCol;
        
        int n=matrix.size();
        int m=matrix[0].size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(matrix[i][j]==0){
                   mRow[i]=1;
                   mCol[j]=1;
               }
            }
        }
        
        for(int i=0;i<n;i++){
           
            for(int j=0;j<m;j++){
                if(mRow[i]==1){
                    matrix[i][j]=0;
                }
                if(mCol[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
};