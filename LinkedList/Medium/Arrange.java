package LinkedList.Medium;

import LinkedList.ListNode;

import java.util.List;

public class Arrange {
    public static void main(String[] args) {
        ListNode head = new ListNode('a');
        head.next = new ListNode('b');
        head.next.next = new ListNode('a');
        head.next.next.next = new ListNode('b');
        head.next.next.next.next = new ListNode('e');
        head.next.next.next.next.next = new ListNode('e');
        head.next.next.next.next.next.next = new ListNode('d');
      //  head.next.next.next.next.next.next.next = new ListNode('h');
     //   head.next.next.next.next.next.next.next.next = new ListNode('i');
        print(head);
        System.out.println(" ");
       print(call(head));

    }
    public static ListNode call(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        ListNode vowelHead = null;
        ListNode vowel = null;
        ListNode consonantHead = null;
        ListNode consonant = null;

        while(temp != null){
                 char ch = (char)temp.val;
                 if(isVowel(ch)){
                     if(vowelHead == null){
                         vowelHead = temp;
                         vowel = temp;
                     }
                     else{
                         vowel.next = temp;
                         vowel  =temp;
                     }
                     if(prev!= null)
                     prev.next = temp.next == null ? null : temp.next;
                 }
                 else{
                     if(consonantHead == null){
                         consonantHead = temp;

                     }
                     prev = temp;
                 }
               //  prev= temp;
                 temp = temp.next;
        }
        if(vowelHead != null){
            vowel.next = consonantHead;
            return vowelHead;
        }
        else{
            return consonantHead;
        }
    }
    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')return true;
        return false;
    }
    public static void print(ListNode head){
        ListNode temp = head;

        while(temp!= null){
            System.out.print((char)temp.val+" -> " );
            temp = temp.next;
        }
        System.out.print("Null");
    }
}
