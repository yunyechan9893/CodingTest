package Date_06_04.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 출력
* 흰돌 승리 2, 검은돌 승리 1
*
* 가로 검사, 세로 검사, 대각선 검사를 통해 알아냄
*
* */
public class 오목_제출용 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer[][] data = new Integer[19][19];
        for (int i = 0; 19 > i; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; 19 > j; j++){
                data[i][j] = Integer.valueOf(stringTokenizer.nextToken());
            }
        }


        int rock = 0;
        for (int i = 0; data.length > i; i++) {
            for (int j = 0; data[0].length > j; j++){
                //가로 검사
                rock = data[i][j];

                if (rock == 0) {
                    continue;
                } else {
                    if (
                        data[0].length > j + 4 &&
                        data[i][j + 1] == rock &&
                        data[i][j + 2] == rock &&
                        data[i][j + 3] == rock &&
                        data[i][j + 4] == rock &&
                        ((data[0].length > j + 5) || data[i][j + 5] != rock)
                    ) { //가로
                        System.out.println("가로");
                        System.out.println(rock + "\n" + (i+1) + " " + (j+1));
                        return;
                    } else if (
                        data[0].length > i + 4 &&
                        data[i + 1][j] == rock &&
                        data[i + 2][j] == rock &&
                        data[i + 3][j] == rock &&
                        data[i + 4][j] == rock &&
                        ((data.length > i + 5) || data[i][j + 5] != rock)
                    ) { //세로
                        System.out.println("세로");
                        System.out.println(rock + "\n" + (i+1) + " " + (j+1));
                        return;
                    } else if (
                        data[0].length > i + 4 && data.length > j + 4 &&
                        data[i + 1][j + 1] == rock &&
                        data[i + 2][j + 2] == rock &&
                        data[i + 3][j + 3] == rock &&
                        data[i + 4][j + 4] == rock &&
                        ((data.length > i + 5) && data[0].length <= i + 5 || data[i + 5][j + 5] != rock)
                    ) { //대각선
                        System.out.println("대각선\\");
                        System.out.println(rock + "\n" + (i+1) + " " + (j+1));
                        return;
                    } else if (
                        0 <= i + 4 && 0 <= j - 4 &&
                        data[i + 1][j - 1] == rock &&
                        data[i + 2][j - 2] == rock &&
                        data[i + 3][j - 3] == rock &&
                        data[i + 4][j - 4] == rock &&
                        ((data.length > i + 5 && 0 <= j - 5) || data[i + 5][j - 5] != rock)
                    ) { //대각선
                        System.out.println("대각선/");
                        System.out.println(rock + "\n" + (i+1) + " " + (j+1));
                        return;
                    }
                }
            }
        }

        System.out.println("대각선/");
        System.out.println(0);

    }
}
