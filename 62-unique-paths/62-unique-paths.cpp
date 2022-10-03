class Solution {
public:
    
    int f(int i,int j,int m,int n,int **& arr){
        
        if(i==m-1 && j==n-1){
            return 1;
        }
        
        if(arr[i][j]!=-1){
            return arr[i][j];
        }
        
        int a=0;
        if(j+1<n){
            a=f(i,j+1,m,n,arr);
        }
        
        int b=0;
        if(i+1<m){
            b=f(i+1,j,m,n,arr);
        }
        
        arr[i][j]=a+b;
        
        return a+b;
    }
    int uniquePaths(int m, int n) {
        int **arr=new int*[m];
        
        for(int i=0;i<m;i++){
            arr[i]=new int[n];
            
            for(int j=0;j<n;j++){
                arr[i][j]=-1;
            }
        }
        
        // for(int i=0;i<m)
        
        return f(0,0,m,n,arr);
    }
};