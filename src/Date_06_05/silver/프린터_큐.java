package Date_06_05.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프린터_큐 {
    private static StringTokenizer stringTokenizer;
    private static PriorityQueue<Item> queue;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        String input = "3\n"
            + "1 0\n"
            + "5\n"
            + "4 2\n"
            + "1 2 3 4\n"
            + "6 0\n"
            + "1 1 9 1 1 1";

        String input2 = "3\n"
            + "7 2\n" // 4번째 출력
            + "5 1 2 1 1 2 3\n"
            + "6 2\n" // 4출력
            + "1 2 3 4 4 4\n"
            + "8 0\n" // 6 출력
            + "1 1 9 1 1 1 0 0";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input2));


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        stringBuilder = new StringBuilder();
        for (int i = 0; N > i; i++) {
            queue = new PriorityQueue<>(new Item());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int O = Integer.parseInt(stringTokenizer.nextToken());

            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = M - 1; j >= 0; j--) {

                if (j == O) {
                    queue.add(new Item(Integer.parseInt(strings[j]), M - j - 1));
                    continue;
                }

                queue.add(new Item(Integer.parseInt(strings[j]), M - j - 1));
            }

            int count = 0;
            while (queue.peek() != null) {
                count++;
                var a = queue.poll();

                if (a.order == O) {
                    stringBuilder.append(count).append("\n");
                    break;
                }
            }
        }

        System.out.println(stringBuilder);
    }

    static class Item implements Comparator<Item> {

        private int priority;
        private int order;

        public Item() {

        }

        public Item(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }


        @Override
        public int compare(Item item1, Item item2) {
            if (item1.priority == item2.priority) {
                return  item2.order - item1.order;
            }

            return item2.priority - item1.priority;
        }
    }
}
