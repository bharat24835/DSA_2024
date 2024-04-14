package Trees.Medium;

import java.util.*;

public class Path_In_ZigZag_Labelled_Binary_Tree {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(call(n));
        System.out.println(call1(n));
    }
    public static List<Integer>call1(int n){
        int temp = n;
        int level = 0;
        while(temp>=1){
            level++;
            temp=temp/2;
        }
        List<Integer>ans = new ArrayList<>();

        int num   = n ;
        int maxH= level;

        while(level >= 1){
            int min = (int) Math.pow(2,level-1);
            int max = (int) (Math.pow(2,level)-1);


            if(level%2 == 0){
                ans.add(0,num);
                int converted = (max - num) +min;
                num = converted/2;
            }
            else{
                ans.add(0,num);
                num = num/2;
            }
            level--;
        }
        return ans;


    }

    public static List<Integer> call(int n){
        List<Integer>ans = new ArrayList<>();
        int min_height = (int)(Math.log(n)/Math.log(2))+1;
        int max_node = (int) Math.pow(2,min_height);
        int[]temp  = new int[max_node+1];
        Arrays.fill(temp , -1);

       temp[0] = 1;
       int  i = 0;
       int level = 1;
       int flag = 0;
       int num = 2;
        while(num<= n ){
            if(flag%2 == 0 ){
                // Right to Left FIlling
                int max_nodes = (int)Math.pow(2,level);
                for(int count_i = i+max_nodes ; count_i> i && num <=n ; count_i--){
                    temp[count_i] = num++;
                }
                i = i+max_nodes;
            }
            else{
                // Left TO RIght Filling
                int max_nodes = (int)Math.pow(2,level);
                for(int x = i+1 ; x<=i+max_nodes && num<=n ; x++ ){
                    temp[x] = num++;
                }
                i = i+max_nodes;
            }
            flag++;
            level++;
        }

        System.out.println(Arrays.toString(temp));

        int index  = -1;
        for( i = 0 ; i<temp.length; i++){
            if(temp[i] == n) {
                index = i;
                break;
            }
        }

        while(temp[index] != -1 && index!= 0){
            ans.add(0,temp[index]);
            index = (index-1)/2;
        }
        ans.add(0,1);


        return ans;
    }

}
