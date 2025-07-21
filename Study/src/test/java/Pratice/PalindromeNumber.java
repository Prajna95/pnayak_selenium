package Pratice;

public class PalindromeNumber {
    public static void main(String[] args) {
     int num = 121;
     int original =num;
     int rev =0;

     while (num >0)
     {
         int value = num % 10;
         rev =rev *10 + value ;
         num = num /10;

     }
     if (original==rev)
         System.out.println(original + "is a palindrome number");
     else
         System.out.println(original + " is not a palindrome number");
    }
}
