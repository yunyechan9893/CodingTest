package Date_06_03_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class 참외밭 {
    public static void main(String[] args) throws IOException {
        String input = "7\n"
            + "4 50\n"
            + "2 160\n"
            + "3 30\n"
            + "1 60\n"
            + "3 20\n"
            + "1 100";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int averageFruit = Integer.parseInt(bufferedReader.readLine());

        Queue<Map<Integer, Integer>> queue = new LinkedList<>();

        boolean 북쪽 = false;
        boolean 남쪽 = false;
        boolean 동쪽 = false;
        boolean 서쪽 = false;



        for (int i = 0; i < 6; i++) {
            StringTokenizer stringBuilder = new StringTokenizer(bufferedReader.readLine());

            int direction = Integer.parseInt(stringBuilder.nextToken());
            int meter = Integer.parseInt(stringBuilder.nextToken());

            queue.add(Map.of(direction, meter));
        }


    }
}
