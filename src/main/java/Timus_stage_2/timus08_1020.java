package Timus_stage_2;

import java.util.Scanner;
import static java.lang.Math.*;

public class timus08_1020 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        double b = s.nextDouble();
        double x[] = new double[a + 1];
        double y[] = new double[a + 1];
        for (int i = 0; i < a; i++) {
            x[i] = s.nextDouble();
            y[i] = s.nextDouble();
        }
        x[a] = x[0];
        y[a] = y[0];
        double length = 0;
        for (int i = 0; i < a; i++) {
            length += sqrt(pow(x[i + 1] - x[i], 2) + pow(y[i + 1] - y[i], 2));
        }

        System.out.printf("%.2f", length + 2*PI*b);
        s.close();
    }
}