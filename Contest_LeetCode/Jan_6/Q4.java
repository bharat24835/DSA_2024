package Contest_LeetCode.Jan_6;

import java.util.List;

public class Q4 {
    public static List<Long>list;
    public static void main(String[] args) {
        String s = "17";
        long start = 1;
        long finish = 971;
        int limit = 9;

        System.out.println(call(start,finish,limit,s));
        //System.out.println(list);
    }
    public static long call(long start, long finish , int limit , String s){
        long suffix  =Long.parseLong(s);
        long sdigit = (long) Math.log10(suffix) + 1 ;
        long fdigit = (long) Math.log10(finish) + 1 ;

        // base condition
//        if(start > suffix || finish < suffix) return 0;

        if(sdigit == limit ) return 1;
        System.out.println(sdigit);
        System.out.println(suffix);
        long count = 0 ;
        if(start < suffix && suffix< finish) count++;
        long min = Math.min( limit- sdigit  , fdigit - sdigit );
       int prev =  0;
        for(long i = 1; i <=min ;i++ ){

            for(int k = 1 ; k<=9 ; k++){
                long temp = (long) (k*(Math.pow(10 , sdigit + i -1)) + suffix);
                if(temp > start && temp < finish) {
                    count++;
                    System.out.println(temp);
                }
            }

        }
        return count;
    }
}
