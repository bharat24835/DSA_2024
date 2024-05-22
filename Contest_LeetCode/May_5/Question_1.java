package Contest_LeetCode.May_5;

public class Question_1 {
    public static void main(String[] args) {
        String s = "Ya$";
        System.out.println(call(s));
    }
    public static boolean call(String s){
        if(s.length()<3 )return false;
        boolean vowel = false;
        boolean consoant = false;
        for(int i = 0 ; i<s.length() ; i++ ){
            char item = s.charAt(i);
          if(isVowel(item)){
              vowel = true;
          } else if (!isVowel(item) && isConsonant(item)) {
              consoant  =true;
          }
          else if (isDigit(item)){
              continue;
          }
          else {
              return false;
          }


        }
        if(vowel && consoant) return true;
        return false;

    }
    public static boolean isVowel (char temp){
        if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') return true;
        if(temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') return true;

        return false;
    }
    public static boolean isConsonant(char item){
        if(item-'a'>=0 && item-'a' <= 25) return true;
        if(item-'A'>=0 && item-'A' <= 25) return true;

        return false;
    }
    public static boolean isDigit (char temp){
        if(temp -'0'>=0 && temp-'0'<=9 ) return true;
        return false;
    }
}
