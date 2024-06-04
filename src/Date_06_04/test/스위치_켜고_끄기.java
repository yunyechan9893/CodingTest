package Date_06_04.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
* 성별과 제공받은 숫자에 따라 스위치 온오프가 달라짐
* 1 - N : 스위치 개수 (0 <= N <= 100)
* 2 - M : 스위치의 각 상태 (ex) 1 0 1 0 ...)
* 3 - S : 학생 수 (S <= 100)
* 4 - MAN, C  : 남학생, 받은 수 (1 <= C <= N)
* 5 - Girl, C : 여학생, 받은 수 (1 <= C <= N)
*
* 남학생 : 받은 수의 배수인 스위치 변경
* 여학생 : 받은 수를 중심으로 좌우 대칭인 경우까지 찾아서 변경
*
* 스위치는 20개 단위로 한줄씩 출력
*
* 남학생의 배수 스위치 상태를 변경
* 여학생의 좌우 대칭 확인과 동시에 숫자 변경
* */
public class 스위치_켜고_끄기 {
    public static void main(String[] args) throws IOException {
        String input = "8\n"
            + "0 1 0 1 0 0 0 1\n"
            + "2\n"
            + "1 3\n"
            + "2 3";

        String input2 = "8\n"
            + "0 1 0 1 0 0 0 1\n"
            + "2\n"
            + "1 2\n"
            + "2 3";

        String input3 = "21\n"
            + "0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1\n"
            + "2\n"
            + "1 2\n"
            + "2 3";

        String input4 = "8\n"
            + "0 1 0 1 0 0 0 1\n"
            + "2\n"
            + "1 3\n"
            + "2 3";



        BufferedReader bufferedReader = new BufferedReader(new StringReader(input4));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        Integer[] M = new Integer[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; N > i; i++) {
            M[i] = Integer.valueOf(stringTokenizer.nextToken());
        }

        Integer S = Integer.valueOf(bufferedReader.readLine());

        Arrays.stream(M).forEach(System.out::print);
        System.out.println();

        for (int s=0; S > s; s++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            Integer sex = Integer.valueOf(stringTokenizer.nextToken());
            Integer count = Integer.valueOf(stringTokenizer.nextToken());

            if (sex==1) {
                for (int i = 1; N > i * count - 1; i++) {
                    M[i * count - 1] = M[i * count - 1] == 0 ? 1 : 0;
                }
            } else {
                M[count - 1] = M[count - 1] == 0 ? 1 : 0;
                int index = 1;
                while (
                    0 < count - index &&
                        N > count + index) {

                    if (M[count - 1 - index] != M[count - 1 + index]) {
                        break;
                    }

                    M[count - 1 - index] = M[count - 1 - index] == 0 ? 1 : 0;
                    M[count - 1 + index] = M[count - 1 + index] == 0 ? 1 : 0;
                    index ++;
                }
            }
        }


        Arrays.stream(M).forEach(System.out::print);
        System.out.println();
        // 테스트 완료 //

        Arrays.stream(M).forEach(System.out::print);
        System.out.println();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; M.length >= i; i++) {
            System.out.println(i);
            if (i % 20 == 0) {
                stringBuilder.append(M[i - 1]).append("\n");
            } else {
                stringBuilder.append(M[i - 1]).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
