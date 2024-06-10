package Date_06_10.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업_제출용 {

    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        count = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer>[] graphy = new ArrayList[N + 1];

        for (int i = 0; N >= i; i++) {
            graphy[i] = new ArrayList<>();
        }

        for (int i = 0; M > i; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());

            graphy[Y].add(X);
        }

        int starting = Integer.parseInt(bufferedReader.readLine());

        bfs(graphy, starting, N);
        System.out.println(count);
    }

    private static void bfs(
        List<Integer>[] graphy,
        int starting,
        int N
    ) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(starting);
        visited[starting] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int y : graphy[vertex]) {
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                    count++;
                }
            }
        }
    }
}
