package Timus_stage_2;
import java.util.Scanner;
public class timus08_1607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = in.nextInt();
        }
        int price = 0;
        if (arr[0] < arr[2]) {
            while (true) {
                if (arr[0] + arr[1] >= arr[2]) {
                    price = arr[2];
                    break;
                }
                arr[0] += arr[1];
                if (arr[2] - arr[3] <= arr[0]) {
                    price = arr[0];
                    break;
                }
                arr[2] -= arr[3];
            }
            System.out.println(price);
        }
        else System.out.println(arr[0]);
    }
}