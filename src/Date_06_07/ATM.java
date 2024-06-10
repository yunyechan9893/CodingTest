package Date_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.PriorityQueue;

public class ATM {
    private static PriorityQueue<Integer> priorityQueue;
    public static void main(String[] args) throws IOException {
        String input = "5\n"
            + "3 1 4 3 2";

        String input2 = "5\n"
            + "1 2 3 4 5";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input2));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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
