package Date_05_29.bronze;

import java.io.BufferedReader;
import java.io.StringReader;

public class StarPattern3 {
    private static final String STAR = "*";
    private static final String SPACE = " ";
    public static void main(String[] args) throws Exception {
        String input = "5";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int halfRowCount = Integer.parseInt(bufferedReader.readLine());


        for (int x = -halfRowCount + 1; x < halfRowCount; x++ ) {
            StringBuilder stringBuilder = new StringBuilder();
            int starCount = halfRowCount - Math.abs(x);
            int spaceCount = halfRowCount - starCount;
            setStar(starCount, spaceCount, stringBuilder);

            System.out.print(stringBuilder);
            System.out.println(stringBuilder.reverse());
        }
    }

    public static void setStar(int starCount, int spaceCount, StringBuilder stringBuilder) {
        int allCount = starCount + spaceCount;

        for (int i = 0; i < allCount; i++) {
            if (i < starCount) {
                stringBuilder.append(STAR);
                continue;
            }

            stringBuilder.append(SPACE);
        }
    }
}
