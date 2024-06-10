package Date_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ATM_제출용 {

    private static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        priorityQueue = new PriorityQueue<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] Pi = bufferedReader.readLine().split(" ");

        for (int i = 0; N > i; i++) {
            priorityQueue.add(Integer.valueOf(Pi[i]));
        }

        int curNumber = 0;
        int result = 0;
        while (priorityQueue.peek() != null) {
            curNumber += priorityQueue.poll();
            result += curNumber;
        }

        System.out.println(result);
    }
}
