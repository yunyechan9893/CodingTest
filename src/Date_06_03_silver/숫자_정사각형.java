package Date_06_03_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.StringTokenizer;


public class 숫자_정사각형 {
    public static void main(String[] args) throws IOException {
        String input = "2 4\n"
            + "1255\n"
            + "3455";

        String input2 = "11 10\n"
            + "9785409507\n"
            + "2055103694\n"
            + "0861396761\n"
            + "3073207669\n"
            + "1233049493\n"
            + "2300248968\n"
            + "9769239548\n"
            + "7984130001\n"
            + "1670020095\n"
            + "8894239889\n"
            + "4053971072";

        String input3 = "2 2\n"
            + "12\n"
            + "34";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input3));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int columnCount = Integer.parseInt(stringTokenizer.nextToken());
        int rowCount = Integer.parseInt(stringTokenizer.nextToken());

        String[] coloumns = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            coloumns[i] = bufferedReader.readLine();
        }

        int minValue = Math.min(columnCount, rowCount);
        int result = 1;
        for (int scale = minValue; scale > 1; scale--) {
            for (int columnPosition = 0; columnCount - scale >= columnPosition; columnPosition++) {
                for (int rowPosition = 0; rowCount - scale >= rowPosition; rowPosition++) {
                    Character startNumber = coloumns[columnPosition].charAt(rowPosition);
                    if (
                        coloumns[columnPosition].charAt(rowPosition + scale - 1) == startNumber
                        && coloumns[columnPosition + scale - 1].charAt(rowPosition) == startNumber
                        && coloumns[columnPosition + scale - 1].charAt(rowPosition + scale - 1) == startNumber
                    ) {
                        System.out.println(scale * scale);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
