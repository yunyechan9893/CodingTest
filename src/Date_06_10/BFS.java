package Date_06_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    public static void main(String[] args) throws IOException {
        String input = "5\n"
            + "1 2\n"
            + "1 3\n"
            + "2 4\n"
            + "2 5\n";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] graph = new int[N + 1][N + 1];

        // 1 -> 3, 1 -> 2 -> 3 이렇게 중복할 수 있음
        // visited를 사용하면 3을 처음 한번만 순회함
        boolean[] visited = new boolean[N + 1];
        int start = 1;

        for (int i = 0; 4 > i; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        bfs(graph, visited, start);
    }

    public static void bfs (
        int[][] graph,
        boolean[] visited,
        int start
    ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 0; graph.length > i; i++) {
                if (graph[vertex][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
