package Pratice;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int  num = 153; //370,371
        int originalnum = num ;
        int result =0;

        while (num >0) {
            int value = num % 10;
            result = result + (value * value * value);
            num = num / 10;

        }
        if (originalnum == result)
            System.out.println(originalnum + "is an armstrongnumber");
        else
            System.out.println(originalnum + " is not an armstrongnumber");
    }
}
