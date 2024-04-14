package Practise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class temp {
    public static void main(String[] args) {
        String[]s = {"3" , "6" ,"7" , "11" , "13", "2" ,"99" , "23"};
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
               if(a.length() != b.length()) return a.length() - b.length();
               else{
//                   int i = 0 ;
//                   while(i < a.length()){
//                       if(a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
//                       else i++;
//                   }
                   return a.compareTo(b);
               }

            }
        });
        for(int i = 0 ; i<s.length ; i++){
            pq.add(s[i]);
        }
        while(!pq.isEmpty()){
            String temp   = pq.poll();
            System.out.println(temp);
        }
    }
}
