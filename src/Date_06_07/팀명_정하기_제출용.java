package Date_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 팀명_정하기_제출용 {
    private static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> score = new TreeMap(Collections.reverseOrder());
        Set<Integer> year = new TreeSet();

        String 문자열 = bufferedReader.readLine();
        int index = 0;
        while (문자열 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(문자열);

            int P = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken().substring(2, 4));
            String S = stringTokenizer.nextToken().substring(0,1);

            score.put(P, S);
            year.add(Y);

            index++;
            문자열 = bufferedReader.readLine();
        }


        stringBuilder = new StringBuilder();

        year.stream().forEach(y -> stringBuilder.append(y.intValue()));
        stringBuilder.append("\n");
        for (Entry<Integer, String> entry : score.entrySet()) {
            stringBuilder.append(entry.getValue());
        }

        System.out.println(stringBuilder);
    }
}
