package Date_06_10.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 특정_거리의_도시_찾기_제출용 {

    private static TreeSet results;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        results = new TreeSet();

        StringTokenizer firstLineToken = new StringTokenizer(bufferedReader.readLine());
        // 도시 개수
        int N = Integer.parseInt(firstLineToken.nextToken());

        // 도로의 개수
        int M = Integer.parseInt(firstLineToken.nextToken());

        // 거리 정보
        int K = Integer.parseInt(firstLineToken.nextToken());

        // 출발 도시 정보
        int X = Integer.parseInt(firstLineToken.nextToken());

        int[][] graphy = new int[N + 1][N + 1];
        boolean[] visiting = new boolean[N + 1];

        for (int i = 0; M > i; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graphy[x][y] = 1;
            graphy[y][x] = 1;
        }

        bfs(graphy, visiting, X, K);
        StringBuilder stringBuilder = new StringBuilder();
        results.forEach(result -> stringBuilder.append(result).append("\n"));
        System.out.println(stringBuilder);
    }

    private static void bfs(
        int[][] graphy,
        boolean[] visiting,
        int starting,
        int K
    ) {

        int curDepth = 0;
        Queue<Integer> queue = new LinkedList();

        queue.offer(starting);
        queue.offer(-1); // -1이 나오면 depth를 1증가시켜줌
        curDepth++;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (vertex == -1) {
                if (curDepth == K) {
                    return;
                }

                curDepth++;
                queue.offer(-1);
                continue;
            }

            for (int i = 0; graphy.length > i; i++) {

                if (graphy[vertex][i] == 1 && !visiting[i]) { // 방문
                    queue.offer(i);
                    visiting[i] = true;

                    if (curDepth == K) {
                        results.add(i);
                    }
                } else if (graphy[vertex][i] == 1 && visiting[i]) { // graphy가 1인데, visiting이 True면 K보다 최단 경로 존재
                    results.remove(i); // 결과값에서 삭제
                }
            }
        }
    }
}