//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int f(int ind,int W,int wt[],int val[],int n,vector<vector<int>> &dp){
        
        if(W<=0){
            return 0;
        }
        
        if(ind==n){
            return 0;
        }
        
        if(dp[ind][W]!=-1){
            return dp[ind][W];
        }
        
        int nW = W-wt[ind];
        
        int take=0;
        
        if(nW>=0){
            take=val[ind]+f(ind+1,nW,wt,val,n,dp);
        }
        int notTake=f(ind+1,W,wt,val,n,dp);
        dp[ind][W] = max(take,notTake);
        return max(take,notTake);
        
    }
    
    int knapSack(int W, int wt[], int val[], int n) 
    { 
       // Your code here
      int ind = 0;
       
      vector<vector<int>> dp(n,vector<int>(W+1,-1));
      
    //   for(int i=0;i<n;i++){
    //       dp[i][0]=0;
    //   }
      return f(ind,W,wt,val,n,dp);
    
    
       
       
    } 
};

//{ Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}
// } Driver Code Ends