package Date_05_31.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 입력순서
* a0 a1
* c
* n0
* */

public class AlgorithmClass_SymptoticNotation1 {
    public static void main(String[] args) throws IOException {
        String input1 = "7 7\n"
            + "8\n"
            + "1";

        String input2 = "7 7\n"
            + "8\n"
            + "10";

        String input3 = "-1 7\n"
            + "8\n"
            + "1";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input3));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a1 = Integer.parseInt(stringTokenizer.nextToken());
        int a0 = Integer.parseInt(stringTokenizer.nextToken());

        int c = Integer.parseInt(bufferedReader.readLine());
        int n0 = Integer.parseInt(bufferedReader.readLine());

        for (int n = n0; n <= 100; n++) {
            System.out.println(n * ( c - a1 ));
            if (n * ( c - a1 ) < a0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
