package Date_06_10.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_제출용 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int starting = 1;

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

        int count = bfs(graphy, starting, N);

        System.out.println(count);
    }

    private static int bfs(
        List<Integer>[] graphy,
        int starting,
        int N
    ) {
        int count = 0;
        boolean[] visiting = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(starting);

        while (queue.peek()!=null) {
            int vertex = queue.poll();

            for (int y: graphy[vertex]) {
                if (!visiting[y]) {
                    queue.offer(y);
                    visiting[y] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
