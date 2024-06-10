package Date_06_10.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {

    public static void main(String[] args) throws IOException {
        String input = "7\n"
            + "6\n"
            + "1 2\n"
            + "2 3\n"
            + "1 5\n"
            + "5 2\n"
            + "5 6\n"
            + "4 7";

        String input2 = "2\n"
            + "1\n"
            + "2 1";

        String input3 = "4\n"
            + "3\n"
            + "1 2\n"
            + "4 3\n"
            + "2 3";
        String input4 = "";
        String input5 = "";
        String input6 = "";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input3));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int starting = 1;

        int[][] graphy = new int[N+1][N+1];

        for (int i = 0; M > i; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graphy[x][y] = 1;
            graphy[y][x] = 1;
        }

        int count = bfs(graphy, starting, N);

        System.out.println(count);
    }

    private static int bfs(
        int[][] graphy,
        int starting,
        int N
    ) {
        int count = 0;
        boolean[] visiting = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(starting);
        visiting[starting] = true;

        while (queue.peek()!=null) {
            int vertex = queue.poll();

            for (int i = 0; N >= i;  i++) {
                if (graphy[vertex][i] == 1 && !visiting[i]) {
                    queue.offer(i);
                    visiting[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
