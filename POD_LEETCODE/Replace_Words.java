package POD_LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class Replace_Words {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String ans = call(dictionary , sentence);
        System.out.println(ans);
    }
    public static String call(List<String>dictionary  , String sentence){
        String[]s1 = sentence.split(" ");

        int size = s1.length;
        String[] ans = new String[size];


        for(int i = 0 ; i<size ; i++){
            ans[i] = check( i , s1, dictionary);
        }

        return ans.toString();

    }
    public static String check(int i , String[]s1  , List<String>dictionary){

        return "";

    }
}
