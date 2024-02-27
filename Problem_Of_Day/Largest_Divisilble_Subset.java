package Problem_Of_Day;

import java.util.ArrayList;
import java.util.List;

public class Largest_Divisilble_Subset {
    public static List<Integer>ans;
    public static void main(String[] args) {
        int[]a = {1,2,3,4,8};
        ans = new ArrayList<>();
        System.out.println(call(a));

    }
    public static List<Integer> call(int[]a){
        List<Integer>temp = new ArrayList<>();
        call1( 0 , temp, a);
        return ans;
    }
    public static void call1(int i , List<Integer>temp , int[]a){
        if(i == a.length){
            if(temp.size() > ans.size()){
                ans =new ArrayList<>(temp);
            }
            return;
        }

        // for particular index we have 2 option
        // takeit(with some checks) or ignore


        // take it
        boolean chk = false;
        if(check(a[i], temp)){
            chk = true;
            temp.add(a[i]);
            call1(i+1, temp,a);
        }

        // ignore it
        if(chk){
            temp.remove(temp.size()-1);
            chk = false;
        }
        call1(i+1, temp, a);

        return;
    }
    public static boolean check(int num1, List<Integer>temp){
        if(temp.size() == 0)return true;

        for(int num2 :temp ){
            if(num1%num2 != 0 &&  num2%num1 != 0){
                return false;
            }
        }
        return true;
    }
}
