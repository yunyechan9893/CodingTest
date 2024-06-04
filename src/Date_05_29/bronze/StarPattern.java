package Date_05_29.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 열 개수 만큼 For문을 사용해 생성
* 행 개수 만큼 For문을 사용해 생성
* 별이 몇 번째 부터 찍히는지 파악
* if문으로 별 찍기
*
* 최적화 연습을 위해 아래 링크를 참조했다.
* https://nahwasa.com/entry/%EC%9E%90%EB%B0%94%EB%A1%9C-%EB%B0%B1%EC%A4%80-%ED%92%80-%EB%95%8C%EC%9D%98-%ED%8C%81-%EB%B0%8F-%EC%A3%BC%EC%9D%98%EC%A0%90-boj-java
* */
public class StarPattern {
    private static final String SPACE = " ";
    private static final String STAR = "*";
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int row = 1; row <= n; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            int startStarPosition = n - row;

            for (int column = 1; column <= n; column++){
                if (column > startStarPosition) {
                    stringBuilder.append(STAR);
                    continue;
                }

                stringBuilder.append(SPACE);
            }

            System.out.println(stringBuilder);
        }
    }
}