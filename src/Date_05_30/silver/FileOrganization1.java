package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileOrganization1 {
    public static void main(String[] args) throws Exception {
        String input = "8\n"
            + "sbrus.txt\n"
            + "spc.spc\n"
            + "acm.icpc\n"
            + "korea.icpc\n"
            + "sample.txt\n"
            + "hello.world\n"
            + "sogang.spc\n"
            + "example.txt";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < total; i++) {
            String extention = String.format(bufferedReader.readLine())
                .split("\\.")[1];

            if (map.containsKey(extention)) {
                int count = map.get(extention);
                map.replace(extention, ++count);
                continue;
            }

            map.put(extention, 1);
        }

        List<String> keyset = new ArrayList<>(map.keySet());
        Collections.sort(keyset);

        for (String key : keyset) {
            StringBuilder builder = new StringBuilder();
            builder.append(key);
            builder.append(" ");
            builder.append(map.get(key));
            builder.append("\n");

            System.out.print(builder);
        }
    }
}
