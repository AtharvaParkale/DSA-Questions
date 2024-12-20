class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        
        int n=matrix.size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(i<j){
                    continue;
                }
                
                int swap=matrix[i][j];
                
                matrix[i][j]=matrix[j][i];
                
                matrix[j][i]=swap;
                
            }
        }
        
        for(int i=0;i<n;i++){
            reverse(matrix[i].begin(),matrix[i].end());
        }
    }
};