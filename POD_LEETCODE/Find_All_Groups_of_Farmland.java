package POD_LEETCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Find_All_Groups_of_Farmland {
    public static void main(String[] args) {
        int[][]a = { {1,1} ,{1,1}};

        int[][]ans  = call(a);
        for(int  i = 0 ; i<ans.length ; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][]call(int[][]a) {
        int n = a.length;
        int m = a[0].length;
        int[][] visited = new int[a.length][a[0].length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && visited[i][j] == 0) {
                    call2(i, j, a, visited, ans);
                }
            }
        }
        System.out.println(ans);
        int[][]temp = new int[ans.size()][4];
        for(int i = 0 ; i<ans.size() ; i++){
            for(int j = 0 ; j<4 ; j++){
                temp[i][j] = ans.get(i).get(j);
            }
        }
        return temp;
    }
    public static void call2(int i , int j , int[][]a, int[][]visited , ArrayList<ArrayList<Integer>>ans){
        int ti = i;
        int tj = j;
        int di = i;
        int dj = j;
        Queue<Pair>q = new LinkedList<>();
        visited[i][j] = 1;
        q.add(new Pair( i, j));

        while(!q.isEmpty()){
            Pair temp = q.poll();

            int x = temp.i;
            int y = temp.j;
            if(x >= di){
                di = x;
                dj = Math.max(dj , y);

            }

            // pusiing all 4 sides
            int[]dx = {1,0,-1,0};
            int[]dy = {0,-1,0,1};
            for(int p = 0 ; p<4 ; p++){
                int dxi = x + dx[p];
                int dyj = y + dy[p];

                if(dxi < a.length && dxi>=0 && dyj >=0 && dyj< a[0].length && a[dxi][dyj] == 1 && visited[dxi][dyj] == 0){
                    visited[dxi][dyj] = 1;
                    q.offer(new Pair(dxi , dyj));
                }
            }
        }
        ans.add(new ArrayList<>());
        ans.get(ans.size()-1).add(ti);
        ans.get(ans.size()-1).add(tj);
        ans.get(ans.size()-1).add(di);
        ans.get(ans.size()-1).add(dj);


    }
    public static class Pair{
        int i ;
        int j ;

        Pair(int a, int b){
            this.i = a;
            this.j = b;
        }
    }
}
