package Date_05_29.silver;


import java.io.BufferedReader;
import java.io.StringReader;

/*
*      (1,1) / (1,2),(2,1) / (3,1),(2,2),(1,3) / (1,4),(2,3),(3,2),(4,1)
* 순서 : 1번, 2번, 3번, 4번, 5번
* 합  : 2, 3, 4, 5
* 합  : 짝수 : 역방향, 홀수 : 정방향
* 합 = n(n+1)/2-1 = (n^2+n)/2
* 분자 원리 :
* 분모 원리 :
* */
public class FindAFraction {
    public static void main(String[] args) throws Exception {
        String input = "6";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int cursor = Integer.parseInt(bufferedReader.readLine());

        int postion = findPositionByCursor(cursor);

        int endPosition = postion * (postion + 1) / 2;

        StringBuilder stringBuilder = new StringBuilder();
        if (postion % 2 == 0) {
            int resultY = endPosition - cursor + 1;
            int resultX = postion - resultY + 1;

            stringBuilder.append(resultX);
            stringBuilder.append("/");
            stringBuilder.append(resultY);
        } else {
            int resultX = endPosition - cursor + 1;
            int resultY = postion - resultX + 1;

            stringBuilder.append(resultX);
            stringBuilder.append("/");
            stringBuilder.append(resultY);
        }

        System.out.println(stringBuilder);
    }

    private static int findPositionByCursor( int cursor ) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (cursor <= i * ( i + 1) / 2) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }
}


/*
* 1 -> 1
* 2 -> 2
* 3 -> 2
* 4 -> 3
* 5 -> 3
* 6 -> 3
*
* n(n+1)/2 >= 10 , n = 5
* n(n+1)/2 >= 1 , n = 1
* n(n+1)/2 >= 2 , n = 2
* */