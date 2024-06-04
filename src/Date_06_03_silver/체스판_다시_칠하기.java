package Date_06_03_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;



public class 체스판_다시_칠하기 {
    private static int minCount = 0;
    public static void main(String[] args) throws IOException {
        String input = "10 13\n"
            + "BBBBBBBBWBWBW\n"
            + "BBBBBBBBBWBWB\n"
            + "BBBBBBBBWBWBW\n"
            + "BBBBBBBBBWBWB\n"
            + "BBBBBBBBWBWBW\n"
            + "BBBBBBBBBWBWB\n"
            + "BBBBBBBBWBWBW\n"
            + "BBBBBBBBBWBWB\n"
            + "WWWWWWWWWWBWB\n"
            + "WWWWWWWWWWBWB";

        String input2 = "8 8\n"
            + "WBWBWBWB\n"
            + "BWBWBWBW\n"
            + "WBWBWBWB\n"
            + "BWBBBWBW\n"
            + "WBWBWBWB\n"
            + "BWBWBWBW\n"
            + "WBWBWBWB\n"
            + "BWBWBWBW";

        String input3 = "9 23\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBB\n"
            + "BBBBBBBBBBBBBBBBBBBBBBW";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input3));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int columnSize = Integer.parseInt(stringTokenizer.nextToken());
        int rowSize = Integer.parseInt(stringTokenizer.nextToken());

        String[] chessBoard = new String[rowSize];
        for (int i = 0; i < columnSize; i++) {
            chessBoard[i] = bufferedReader.readLine();
        }

        int min = Integer.MAX_VALUE;
        for (int rowCursor = 0; rowCursor + 8 <= rowSize; rowCursor++) {
            for (int columnsCursor = 0; columnsCursor + 8 <= columnSize; columnsCursor++) {
                int result = getMin(chessBoard, rowCursor, columnsCursor);

                if(min > result){
                    min = result;
                }
            }
        }
        System.out.println(min);

        }

        private static int getMin(String[] chessBoard, int rowCursor, int columnsCursor) {
            String[] rowCase = {"WBWBWBWB", "BWBWBWBW"};
            int count = 0;


            for (int c = 0; c < 8; c++) {
                String row = chessBoard[c].substring(rowCursor, rowCursor + 8);

                for (int i = 0; i < row.length(); i++) {
                    if (row.charAt(i) != rowCase[c % 2].charAt(i)) {
                        count ++;
                    }
                }
            }

            return Math.min(count, 64-count);
        }
}
