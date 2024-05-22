package Graph.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class   Sum_Of_Dist_In_Treee {
    public static void main(String[] args) {
        int n = 6;
        int[][]edges = {{0,1} , {0,2} ,{2,3} ,{2,4}, {2,5}};
        int[]ans = call( n , edges);
        System.out.println(Arrays.toString(ans));
    }
    public static int[]call(int n , int[][]edges){
        // first of all we want to creat adj list
        List<List<Integer>>adj = new ArrayList<>();

        // declare arrys to store count node of subtree and result array for root node
        int[]count = new int[n];
        Arrays.fill(count , 1);
        int[]ans = new int[n];

        for(int i = 0 ;i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i<edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

       int temp =  dfs_1(0 ,-1 ,0 ,  n , adj , count , ans);
        dfs_2(adj , 0 , -1 , count , ans, n);
        return ans;


    }
    public static void dfs_2(List<List<Integer>>adj , int node , int parent , int[]count  , int[]ans, int n){
        for(int child : adj.get(node)){
            if(child != parent){
                ans[child] = ans[node] - count[child] + (n- count[child]);
                dfs_2(adj , child , node, count , ans , n);
            }
        }
    }
    public static int  dfs_1(int node , int parent ,int distance,   int n , List<List<Integer>>adj , int[]count , int[]ans){
      int total_count = 1;
      ans[0]+=distance;

        for(int nbr : adj.get(node)){
             if(nbr != parent){

                 total_count += dfs_1(nbr , node, distance+1  ,n, adj , count , ans);
            }
        }
        count[node] = total_count;
        return total_count;

    }

}
