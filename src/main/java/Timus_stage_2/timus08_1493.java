package Timus_stage_2;

import java.util.Scanner;

public class timus08_1493 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = a + 1;
        int c = a - 1;
        int firstP = b / 1000;
        int secondP = b % 1000;
        int firstM = c / 1000;
        int secondM = c % 1000;
        int firstPResult = firstP % 10 + firstP / 100 + (firstP / 10 % 10);
        int secondPResult = secondP % 10 + secondP / 100 + (secondP / 10 % 10);
        int firstMResult = firstM % 10 + firstM / 100 + (firstM / 10 % 10);
        int secondMResult = secondM % 10 + secondM / 100 + (secondM / 10 % 10);
        if (Math.abs(firstPResult-secondPResult) == 0 || Math.abs(firstMResult - secondMResult) == 0) {
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}