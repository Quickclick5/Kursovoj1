package Timus_stage_2;

import java.util.Scanner;
public class timus08_2025 {
    static int One(int n, int q) {
        int[] a = new int [q];
        int m = n % q;
        int t = n / q;
        for (int i = 0; i < m; i ++) {
            a[i] = t + 1;
        }
        for (int i = m; i < q; i ++) {
            a[i] = t;
        }
        int x = 0;
        for (int i = 0; i < q - 1; i ++) {
            for (int j = i + 1; j < q; j ++) {
                x += a[i] * a[j];
            }
        }
        return x;
    }

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int t, n, q;
        t = in.nextInt();
        int[] x = new int [t];
        for (int i = 0; i < t; i ++) {
            q = in.nextInt();
            n = in.nextInt();
            x[i] = One(q, n);
        }
        in.close();
        for (int i = 0; i < t; i ++) {
            System.out.println(x[i]);
        }
    }
}
