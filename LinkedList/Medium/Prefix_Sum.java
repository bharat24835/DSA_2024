package LinkedList.Medium;

import LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Prefix_Sum {
    public static void main(String[] args) {
        ListNode root  = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(-3);
        root.next.next.next.next = new ListNode(4);

        print(call(root));


    }
    public static ListNode call(ListNode head){
        // this temp node is used to handle edge case that , if whole starting from Head (sum eqauls to )
        ListNode temp = new ListNode(0);
        temp.next  = head;

        int sum = 0;

        Map<Integer , ListNode> map = new HashMap<>();


        for(ListNode current = temp ; current!= null ; current = current.next){
            sum+=current.val;

            if(map.containsKey(sum)){

                // beech wale nodes delete karne hoonge
                ListNode prev = map.get(sum);
                ListNode toRemove = prev.next;

                int p = sum +  (toRemove!= null ? toRemove.val : 0);

                while(p!= sum){
                    map.remove(p);
                    toRemove = toRemove.next;
                    p+= (toRemove != null ? toRemove.val : 0);
                }
                prev.next = current.next;
            }
            else{
                map.put(sum , current);
            }
        }
        return temp.next;

    }
    public static void print(ListNode head){
        ListNode temp = head;

        while(temp!= null){
            System.out.print(temp.val + " : ");
            temp = temp.next;
        }
    }
}
