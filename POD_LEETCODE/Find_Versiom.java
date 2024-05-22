package POD_LEETCODE;

public class Find_Versiom {
    public static void main(String[] args) {
        String v1 = "0.1";
        String v2 = "1.1";
        System.out.println(compareVersion(v1 , v2));

    }
    public static int compareVersion(String vs1, String vs2) {
        String[]v1 = vs1.split("\\.", 0);
        String[]v2 = vs2.split("\\.", 0);

        int i = 0;
        int j = 0;

        while( i < v1.length && j < v2.length){

            int t1 = Integer.parseInt(v1[i]);
            int t2 = Integer.parseInt(v2[j]);
            i++;
            j++;

            if(t1 > t2) return 1;
            if(t2 > t1) return -1;

        }

        while(i < v1.length){
            if(Integer.parseInt(v1[i]) != 0) return 1;
        }
        while(j < v2.length){
            if(Integer.parseInt(v2[j]) != 0) return -1;
        }

        return 0;
    }
}
