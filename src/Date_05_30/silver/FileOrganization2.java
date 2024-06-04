package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FileOrganization2 {
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

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < total; i++) {
            String file = bufferedReader.readLine();
            int extentionPosition = file.indexOf(".");
            String extention = file.substring(extentionPosition + 1);

            if (map.containsKey(extention)) {
                int count = map.get(extention);
                map.replace(extention, ++count);
                continue;
            }

            map.put(extention, 1);
        }

        StringBuilder builder = new StringBuilder();
        for (Entry<String, Integer> keyValue : map.entrySet()) {
            builder.append(keyValue.getKey());
            builder.append(" ");
            builder.append(keyValue.getValue());
            builder.append("\n");
        }

        System.out.print(builder);
    }
}
