package String.Algo;

import java.util.ArrayList;
import java.util.List;

public class Robin {
    public static void main(String[] args) {
        String a  = "bce";
        String b = "abcdabce";

        List<String> list = new ArrayList<>();
        list.add("bce");
        int s  = a.length();
        int i = 0;
        int  j  =0;
        int []t  = new int[2];
        String temp  = "";
        while( j < b.length()){
            temp += b.charAt(j);
            if(j-i+1 == s){
                if(list.contains(temp)){
                    t[0] = i;
                    t[1] = j;
                    break;
                }
                temp  =temp.substring(1);
                i++;
            }
            j++;
        }

        System.out.println("Starting Index is : " + t[0] + " Ending index is : " + t[1]);

    }
}
