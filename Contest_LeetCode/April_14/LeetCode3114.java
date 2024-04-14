package Contest_LeetCode.April_14;

public class LeetCode3114 {
    public static void main(String[] args) {
        String s ="?1:?6";
        System.out.println(call(s));
    }
    public static String call(String s){
        String []temp = s.split(":");
        String temp_hr = temp[0];
        String temp_min = temp[1];
        String  hr = "";
        String min = "";

        // for hr string
        if(temp_hr.charAt(0) == '?'){
            if(temp_hr.charAt(1) == '?'){
                hr="11";
            }
            else if (temp_hr.charAt(1) != '0' && temp_hr.charAt(1) != '1')
                hr="0"+temp_hr.charAt(1);
            else hr="1"+temp_hr.charAt(1);
        }
        else if (temp_hr.charAt(0) == '0'){
            if(temp_hr.charAt(1) == '?')
                hr = "09";
            else hr = temp_hr;
        } else if (temp_hr.charAt(0) == '1') {
            if(temp_hr.charAt(1) == '?')
                hr = "11";
            else hr = temp_hr;
        }


        // for min string
        if(temp_min.charAt(0) == '?'){
           if(temp_min.charAt(1) == '?')
               min = "59";
           else min = "5"+temp_min.charAt(1);
        }
        else{
            if(temp_min.charAt(1) == '?')
                min = temp_min.charAt(0)+"9";
            else min = temp_min;
        }

        return hr+":"+min;
    }
}
