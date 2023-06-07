package Timus_stage_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class timus08_1196 {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int p[];
        int z = Integer.parseInt(bi.readLine());
        p = new int[z];
        for (int i = 0; i < z; i++) {
            p[i] = Integer.parseInt(bi.readLine());
        }

        int x =Integer.parseInt(bi.readLine());
        int count = 0;
        for (int i = 0; i < x; i++) {
            if (Arrays.binarySearch(p,Integer.parseInt(bi.readLine())) >= 0)
                count++;
        }

        System.out.println(count);
    }
}