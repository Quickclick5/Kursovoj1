package Timus_stage_2;

import java.util.Scanner;
public class timus08_1924 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean flag = false;
        for (int i = 2;i < n; i+=2) {
            flag = !flag;
        }

        if (flag) System.out.println("black");
        else System.out.println("grimy");
    }
}