package Pratice;

public class GreatestNumber {

    public static void main(String[] args) {
        int a = 90;
        int b = 70;
        int c = 50;
        int greatest;
        if (a>=b && a>=c )
        {
            greatest =a;
        } else if (b >=a && b >= c) {

            greatest = b;

        }
        else
        {
            greatest= c;
        }
        System.out.println(" The greatest number is : " + greatest);
    }

}
