package Date_05_29.bronze;


import java.io.BufferedReader;
import java.io.StringReader;

/*
* 행이 증가할수록
*     n + 1개의 row 가 생김
*     별의 개수가 2n-1개 생김
*     공백이 row - 2n-1개 생김
*
* 5라는 숫자가 주어질 시
* 첫 행
*     row 개수 = 5
*     별의 개수 2 - 1 = 1
*     공백의 개수 5 - 1 = 4
* 두번째 행
*     row 개수 = 6
*     별의 개수 4 - 1 = 3
*     공백의 개수 6 - 3 = 3
* */
public class StarPattern2 {
    private static final String SPACE = " ";
    private static final String STAR = "*";
    public static void main(String[] args) throws Exception{
        String input = "5";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        for (int x = 1; x <= number; x++) {
            StringBuilder stringBuilder = new StringBuilder();

            int rowCount = number + x - 1;
            int starCount = 2 * x - 1;
            int spaceCount = rowCount - starCount;

            for (int i = 0; i < spaceCount; i++) {
                stringBuilder.append(SPACE);
            }

            for (int i = 0; i < starCount; i++) {
                stringBuilder.append(STAR);
            }

            System.out.println(stringBuilder);
        }
    }
}