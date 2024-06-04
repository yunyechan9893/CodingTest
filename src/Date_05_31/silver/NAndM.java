package Date_05_31.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NAndM {
    private static Set result;
    public static void main(String[] args) throws IOException {
        String input = "6 3";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        result = new TreeSet();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 커서 개수 생성
        int[] cursors = new int[M];

        // 커서 포지션 할당
        for (int position = 0; position < cursors.length; position++) {
            cursors[position] = position;
        }

        System.out.println("curCursor (index, value): " + (M-1) + ", " + cursors[M-1] );
        System.out.print("curResult [");
        for (int i = 0; i < M; i++){
            System.out.print(cursors[i] + ", ");
        }
        System.out.println("]");
        nextCursor(N, M, cursors, cursors[M-2], cursors[M-1]);
    }

    private static void nextCursor(int N, int M, int[] cursors, int prvCursor, int curCursor) {
        cursors[curCursor]++;


        if (cursors[curCursor] < N - M + curCursor) {
            System.out.println("curCursor (index, value): " + curCursor + ", " + cursors[curCursor] );
            System.out.print("curResult [");
            for (int i = 0; i < M; i++){
                System.out.print(cursors[i] + ", ");
            }
            System.out.println("]");

            nextCursor(N, M, cursors, prvCursor, curCursor);
        } else if (cursors[curCursor] == N - M + curCursor) {

            if (prvCursor < 0) {
                return;
            }

            cursors[prvCursor]++;
            cursors[curCursor] = cursors[prvCursor];
            nextCursor(N, M, cursors, prvCursor, curCursor);
        } else {
            nextCursor(N, M, cursors, prvCursor - 1, prvCursor);
        }
    }
}
