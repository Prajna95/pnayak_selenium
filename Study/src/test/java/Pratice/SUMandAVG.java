package Pratice;

import java.util.Scanner;

public class SUMandAVG {
    public static void main(String[] args) {
        int sum = 0;
        int count = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the numbers");
        {
        for (int i = 1; i <= count; i++)
            System.out.print("number" + i + ":");
        int num = scanner.nextInt();
        sum += num;
    }
    double avg = (double) sum /count ;
        System.out.println("SUM is :" + sum);
        System.out.println("AVG is : " + avg);


    }
}
