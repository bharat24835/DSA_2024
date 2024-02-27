package Sliding_Window;

public class Fruit_IN_Basket {
    public static void main(String[] args) {
        int []a = {1,1,2,2,3,3,3,1,3};

        System.out.println(call(a));
    }
    public static int call(int[]a){
        int ans  =  0;
        int box1 = 0;
        int count1 = 0;
        int box2 = 0;
        int count2= 0;

        int i = 0 ;
        int j = 0;


        while(j < a.length){
            if(count1 == 0){
                box1 = a[j];
                count1++;
            }
            else if (a[j] == box1) {
                count1++;
            }
            else if(count2 == 0){
                box2 = a[j];
                count2++;
            }
            else if(a[j] == box2){
            count2++;
            }
            else{
                // we encounter a new fruit type

                ans = Math.max(ans, count1+count2);

                // now we need to shrink the window

                while(count1 !=0 && count2!=0){
                    if(a[i] == box1){
                        count1--;
                    }
                    if(a[i] == box2){
                        count2--;
                    }
                    i++;
                }

                if(count1 == 0){
                    box1 = a[j];
                    count1++;
                }
                if(count2 == 0){
                    box2 = a[j];
                    count2++;
                }


            }

            ans = Math.max(ans, count1+count2);
            j++;

        }
        return ans;
    }
}
