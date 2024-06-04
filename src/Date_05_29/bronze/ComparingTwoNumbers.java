package Date_05_29.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 공백으로 Split하여 A와 B를 나눔
* 형변환
* if문 사용하여 비교
* */
public class ComparingTwoNumbers {
    private static final String GREATER_THAN = ">";
    private static final String LESS_THAN = "<";
    private static final String EQULE = "==";
    public static void main(String[] args) throws Exception {

//        String inputData = "10 5"; // 예: 3과 5를 비교하는 경우
//        BufferedReader bufferedReader = new BufferedReader(new StringReader(inputData));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        if (A > B) {
            System.out.println(GREATER_THAN);
        } else if (A < B) {
            System.out.println(LESS_THAN);
        } else {
            System.out.println(EQULE);
        }
    }
}
