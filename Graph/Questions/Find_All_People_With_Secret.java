package Graph.Questions;

import java.util.*;

public class Find_All_People_With_Secret {
    public static void main(String[] args) {
        int n = 4;
        int [][] meetings=  {{3,1,3}, {1,2,2}, {0,3,3}};
        int firstPerson = 3;
       // System.out.println(call(n,meetings,firstPerson));
        System.out.println(call1(n,meetings,firstPerson));
        System.out.println(call3(n,meetings,firstPerson));


    }
    public static List<Integer>call3(int n , int[][]meetings, int firPerson){
        List<Integer>ans = new ArrayList<>();
        int[]timeT0_knows_Secret = new int[n];
        Arrays.fill(timeT0_knows_Secret, Integer.MAX_VALUE);
        timeT0_knows_Secret[0] = 0;
        timeT0_knows_Secret[firPerson] = 0;

        // first of all we need to make adjecy list
        List<List<Pair>>adj = new ArrayList<>();
        // Pair(Person , time)
        for(int i = 0 ; i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<meetings.length; i++){
            int p1 =meetings[i][0];
            int p2 =meetings[i][1];
            int time =meetings[i][2];
            adj.get(p1).add(new Pair(p2, time));
            adj.get(p2).add(new Pair(p1, time));
        }
        // Pair of Priority Queue  :- (time , person)
        PriorityQueue<Pair>pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a - o2.a;
            }
        });
        // at time 0 , Only FirstPerson and 0th person knows the secreat
        pq.offer(new Pair(0,0));
        pq.offer(new Pair(0,firPerson));
        while (!pq.isEmpty()){
            Pair temp = pq.poll();
            int meet_time = temp.a;
            int person = temp.b;

            for(Pair temp2  : adj.get(person)){
                // temp2 (person , time)
                int nbr = temp2.a;
                int nbr_meet_time = temp2.b;

                if(meet_time <= nbr_meet_time && timeT0_knows_Secret[nbr] > nbr_meet_time){
                    pq.offer(new Pair(nbr_meet_time,nbr));
                    timeT0_knows_Secret[nbr]  = nbr_meet_time;
                }
            }
        }
        for(int i = 0 ; i<n; i++){
            if(timeT0_knows_Secret[i] != Integer.MAX_VALUE)ans.add(i);
        }
        return ans;
    }

    public static List<Integer> call(int n , int[][]meetings, int firPerson){
        List<Integer>ans  = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firPerson);
        ans.add(0);
        ans.add(firPerson);

        PriorityQueue<Tuple>pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.time - o2.time;
            }
        });
        for(int i = 0 ; i<meetings.length; i++){
            pq.add((new Tuple(meetings[i][0] , meetings[i][1] , meetings[i][2])));
        }

        // BFS
        while(!pq.isEmpty()){
            Tuple temp = pq.poll();
            int p1 = temp.p1;
            int p2 = temp.p2;
            int time = temp.time;
            if(!set.contains(p1) && !set.contains(p2)) continue;

            // insertion operaiont
            if(set.contains(p1) && !set.contains(p2)){
                set.add(p2);
                ans.add(p2);
            }
            else if(set.contains(p2) && !set.contains(p1)){
                set.add(p1);
                ans.add(p1);
            }
        }



     //   System.out.println(pq.peek().time);
        return ans;
    }

    public static List<Integer>call1(int n , int[][]meetings, int firPerson){
        List<Integer>ans = new ArrayList<>();

        TreeMap<Integer, List<Pair>>treeMap = new TreeMap<>();
        for(int i = 0 ; i<meetings.length; i++){
            int p1  = meetings[i][0];
            int p2  = meetings[i][1];
            int time  = meetings[i][2];


            List<Pair>temp = treeMap.containsKey(time)==true ? treeMap.get(time) : new ArrayList<>();
            temp.add(new Pair(p1,p2));
            treeMap.put(time,temp);
//            if(treeMap.containsKey(time)){
//                List<Integer>temp = treeMap.get(time);
//                temp.add(p1);
//                temp.add(p2);
//                treeMap.put(time,temp);
//            }
//            else{
//                List<Integer>temp = new ArrayList<>();
//                temp.add(p1);
//                temp.add(p2);
//                treeMap.put(time,temp);
//            }
            }
            boolean []knows_Secret  = new boolean[n];
            knows_Secret[0] = true;
            knows_Secret[firPerson] = true;

            for(int key : treeMap.keySet()){
                int time = key;
                List<Pair>temp = treeMap.get(key);
                List<List<Integer>>list = new ArrayList<>();
                for(int i =0 ; i<n ; i++){
                    list.add(new ArrayList<>());
                }
                Queue< Integer> q  = new LinkedList<>() ;
                Set<Integer>set = new HashSet<>();

                for(Pair item: temp){
                    list.get(item.a).add(item.b );
                    list.get(item.b).add(item.a );

                    if(knows_Secret[item.a] == true && !set.contains(item.a) ){
                        q.offer(item.a);
                        set.add(item.a);
                    }
                    if(knows_Secret[item.b] && !set.contains(item.b)){
                        q.offer(item.b);
                        set.add(item.b);
                    }

            }

                // now let spread the news
                while(!q.isEmpty()){
                    int person = q.poll();

                    for(int nbr : list.get(person)){
                        if(knows_Secret[nbr] == false){
                            knows_Secret[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }
            }

            for(int i = 0 ; i<n ; i++){
                if(knows_Secret[i] == true)ans.add(i);
            }
            return ans;

    }
    public static class Pair{
        int a;
        int b;
        Pair(int x, int y){
            this.a =x;
            this.b = y;
        }
    }
    public static class Tuple{
        int p1;
        int p2;
        int time;
        Tuple(int a, int b, int c){
            this.p1 = a;
            this.p2 = b;
            this.time = c;
        }
    }
}
