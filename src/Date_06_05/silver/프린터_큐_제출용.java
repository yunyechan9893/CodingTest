package Date_06_05.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프린터_큐_제출용 {

    private static StringTokenizer stringTokenizer;
    private static PriorityQueue<Item> queue;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        stringBuilder = new StringBuilder();
        for (int i = 0; N > i; i++) {
            queue = new PriorityQueue<>(new Item());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int O = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; M > j; j++) {

                if (j == O) {
                    queue.add(new Item(Integer.parseInt(stringTokenizer.nextToken()), true));
                    continue;
                }

                queue.add(new Item(Integer.parseInt(stringTokenizer.nextToken()), false));
            }

            int count = 0;
            while (queue.peek() != null) {
                count++;
                var a = queue.poll();

                if (a.target) {
                    stringBuilder.append(count).append("\n");
                    break;
                }
            }
        }

        System.out.println(stringBuilder);
    }

    static class Item implements Comparator<Item> {

        private int priority;
        private boolean target;

        public Item() {

        }

        public Item(int priority, boolean target) {
            this.priority = priority;
            this.target = target;
        }


        @Override
        public int compare(Item item1, Item item2) {
            if (item1.priority == item2.priority) {

                if (item1.target) {
                    return -1;
                }

                return 0;
            }

            return item2.priority - item1.priority;
        }
    }
}


