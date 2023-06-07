package Timus_stage_2;

import java.util.Scanner;
public class timus08_2018 {
    public static int m = 1000000007;
    public static void main(String[] args) {
        int q[] = new int[50001];
        int w[] = new int[50001];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        q[0] = 1;
        w[0] = 1;
        q[1] = 1;
        w[1] = 1;
        for (int i = 2; i <= N; i++) {
            int sum = 0;
            for (int k = 1; k <= a  && i - k >= 0; k++) {
                sum += w[i - k] % m;
                sum %= m;
            }
            q[i] = sum;
            sum = 0;
            for (int k = 1; k <= b && i - k >= 0; k++) {
                sum += q[i - k] % m;
                sum %= m;
            }
            w[i] = sum;
        }
        System.out.println((q[N] + w[N]) % m);
    }
}