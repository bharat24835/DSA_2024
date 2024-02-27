package String.Medium;

import java.util.ArrayList;
import java.util.List;

public class Number_Of_Subarray_That_Match_A_Patter_1 {
    public static void main(String[] args) {
        int []a = {1,4,4,1,3,5,5,3};
        int []pattern =  {1,0,-1};
        System.out.println(call2(a, pattern));
        System.out.println(call3(a,pattern));
    }
    public static int call1(int[]a, int []p){
        int count = 0 ;

        for(int i = 0 ; i<a.length; i++){
            // check conditon
            if(i+p.length >= a.length ) continue;
            boolean flag = true;
            for(int j = i ; j<i+p.length && j<a.length ; j++){
                if(p[j-i] == 0 && a[j] == a[j+1]) continue;
                else if (p[j-i] == 1  && a[j] < a[j+1])  continue;
                else if (p[j-i] == -1 && a[j] > a[j+1]) continue;
                else{
                    flag = false;
                    break;
                }


            }
            if(flag == true)count++;
        }
        return count;
    }
    public static int call2(int[]a , int[]p){
        // Lets change denotions
        // -1 -> 0 (a[i] > a[i+1])
        //  0 -> 1 (a[i] = a[i+1])
        //  1 -> 2 (a[i] < a[i+1])
        StringBuilder pattern = new StringBuilder();
        for(int i = 0; i<p.length; i++){
            int item = p[i];
            pattern.append(item+1);
        }

        // String 1
        StringBuilder s1  = new StringBuilder();
        for(int i = 0 ; i<a.length-1; i++){
            if(a[i] == a[i+1]) s1.append(1);
            if(a[i]  > a[i+1]) s1.append(0);
            if(a[i] <  a[i+1]) s1.append(2);
        }

        return  call(s1.toString(), pattern.toString()).size();


    }
    public static List<Integer> call(String txt, String pattern){
        // first iniialise LPS Array
        int[]LPS = new int[pattern.length()];
        make_LPS(LPS,pattern);

        List<Integer>ans = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        while( i <txt.length()){
            if(txt.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == pattern.length()){
                // we found the String
                ans.add(i-j);
                j = LPS[j-1];
            }
            else if( i<txt.length() &&  pattern.charAt(j) != txt.charAt(i)){
                if(j != 0 ){
                    j = LPS[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return ans;
    }
    public static void make_LPS(int[]LPS, String pattern){
        LPS[0] = 0;
        int length = 0;
        int i =1 ;
        while(i < pattern.length()){

            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                LPS[i] = length;
                i++;
            }
            else {
                if(length!=0){
                    length = LPS[length-1];

                }
                else{
                    LPS[i] = 0;
                    length = 0;
                    i++;
                }
            }
        }
    }

    public static int call3(int[]a, int[]p){
        // Lets change denotions
        // -1 -> 0 (a[i] > a[i+1])
        //  0 -> 1 (a[i] = a[i+1])
        //  1 -> 2 (a[i] < a[i+1])
        StringBuilder pattern = new StringBuilder();
        for(int i = 0; i<p.length; i++){
            int item = p[i];
            pattern.append(item+1);
        }

        int i = 0 ;
        int j = 0;
        int count = 0 ;
        StringBuilder s=  new StringBuilder();

        while( j < a.length-1){
            if(a[j] == a[j+1]) s.append(1);
            else if(a[j]  > a[j+1]) s.append(0);
            else if(a[j] <  a[j+1]) s.append(2);

            if(s.length() == pattern.length()){
                if(s.toString().equals(pattern.toString())) count++;
                s.deleteCharAt(0);
                i++;
            }
            j++;

        }
        return count;
    }


}
