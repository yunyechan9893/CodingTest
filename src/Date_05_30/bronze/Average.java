package Date_05_30.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;

//public class Average {
//    public static void main(String[] args) throws Exception {
//        String input = "3\n"
//            + "40 80 60";
//
//        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int average = Integer.parseInt(bufferedReader.readLine());
//        StringTokenizer scoreTokens = new StringTokenizer(bufferedReader.readLine());
//
//        List<Float> scores = new ArrayList<>(average);
//
//        for (int i = 0; average > i; i++) {
//            scores.add(
//                Float.parseFloat(
//                    scoreTokens.nextToken()));
//        }
//
//        Float maximum = Collections.max(scores);
//        AtomicReference<Float> totalScore = new AtomicReference<>(0f);
//        scores.stream()
//            .forEach(score -> totalScore.updateAndGet(v -> v + score / maximum * 100));
//
//        System.out.println(totalScore.get() /  average);
//    }
//}

//public class Average {
//    public static void main(String[] args) throws Exception {
//        String input = "3\n"
//            + "40 80 60";
//
//        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int average = Integer.parseInt(bufferedReader.readLine());
//        StringTokenizer scoreTokens = new StringTokenizer(bufferedReader.readLine());
//
//        Float[] scores = new Float[average];
//
//        for (int i = 0; average > i; i++) {
//            scores[i] = Float.parseFloat(scoreTokens.nextToken());
//        }
//
//        float maximumScore = max(scores);
//
//        Float totalScore = 0f;
//        for (int i = 0; i < average; i++){
//            totalScore += scores[i] / maximumScore * 100;
//        }
//
//        System.out.println(totalScore / average);
//    }
//
//    private static Float max(Float[] scores) {
//
//        Float max = 0f;
//
//        for (int i = 0; i < scores.length; i++){
//            if (scores[i] > max) {
//                max = scores[i];
//            }
//        }
//
//        return max;
//    }
//}

public class Average {
    public static void main(String[] args) throws Exception {
        String input = "3\n"
            + "40 80 60";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int average = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer scoreTokens = new StringTokenizer(bufferedReader.readLine());

        int totalScore = 0;
        int max = 0;

        for (int i = 0; average > i; i++) {
            int score = Integer.parseInt(scoreTokens.nextToken());
            totalScore += score;

            if (score > max) {
                max = score;
            }
        }

        System.out.println( 100.0 * totalScore / max / average  );
    }
}
