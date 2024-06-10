package Date_06_10.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 특정_거리의_도시_찾기 {
    private static TreeSet results;
    public static void main(String[] args) throws IOException {
        String input = "4 4 2 1\n"
            + "1 2\n"
            + "1 3\n"
            + "2 3\n"
            + "2 4";

        String input2 = "4 3 2 1\n"
            + "1 2\n"
            + "1 3\n"
            + "1 4";

        String input3 = "4 4 1 1\n"
            + "1 2\n"
            + "1 3\n"
            + "2 3\n"
            + "2 4";

        results = new TreeSet();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input2));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLineToken = new StringTokenizer(bufferedReader.readLine());
        // 도시 개수
        int N = Integer.parseInt(firstLineToken.nextToken());

        // 도로의 개수
        int M = Integer.parseInt(firstLineToken.nextToken());

        // 거리 정보
        int K = Integer.parseInt(firstLineToken.nextToken());

        // 출발 도시 정보
        int X = Integer.parseInt(firstLineToken.nextToken());

        List<Integer>[] graphy = new ArrayList[N + 1];

        for (int i = 0; N >= i; i++) {
            graphy[i] = new ArrayList<>();
        }

        for (int i = 0; M > i; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graphy[x].add(y);
        }

        bfs(graphy, X, N, K-1);

        if (results.isEmpty()){
            System.out.println(-1);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        results.forEach(result -> {
            stringBuilder.append(result).append("\n");
        });

        System.out.println(stringBuilder);
    }

    private static void bfs(
        List<Integer>[] graphy,
        int starting,
        int N,
        int K
    ) {
        int[] distants = new int[N+1];
        Arrays.fill(distants, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(starting);
        distants[starting] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int y :graphy[vertex]) {
                int distant = distants[vertex];

                if (K < distant) {
                    return;
                }

                queue.offer(y);
                distants[y] = distant + 1;

                if (distant == K) {
                    results.add(y);
                }
            }
        }
    }
}