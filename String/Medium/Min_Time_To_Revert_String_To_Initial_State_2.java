package String.Medium;

public class Min_Time_To_Revert_String_To_Initial_State_2 {
    public static void main(String[] args) {
        String s = "abcbabcd";
        int  k = 2;
        System.out.println(call(s,k));
    }
    public static int call(String s, int k){
        int[]LPS  = new int[s.length()];
        makeLPS(s, LPS);

        int n  = s.length();
        int temp = LPS[n-1];
        int count = (int) Math.ceil(n/k);
       while(temp >0 && (n-temp)%k != 0){
           temp = LPS[temp-1];
       }
       if((n-temp)%k == 0 )return (n- temp)/k;
       return (int) Math.ceil(n / (double) k);
    }
    public static void makeLPS(String s, int[]LPS){
        LPS[0] = 0;
        int i = 1;
        int length = 0;
        while(i <s.length()){
            if(s.charAt(i) == s.charAt(length)){
                length++;
                LPS[i] = length;
                i++;
            }
            else {
                if(length!= 0 ){
                    length = LPS[length-1];
                }
                else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }
}
