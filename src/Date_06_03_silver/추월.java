package Date_06_03_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 추월 {
    public static void main(String[] args) throws IOException {
        String input = "5\n"
            + "ZG508OK\n"
            + "PU305A\n"
            + "RI604B\n"
            + "ZG206A\n"
            + "ZG232ZF\n"
            + "PU305A\n"
            + "ZG232ZF\n"
            + "ZG206A\n"
            + "ZG508OK\n"
            + "RI604B";

        String input2 = "5\n"
            + "ZG206A\n"
            + "PU234Q\n"
            + "OS945CK\n"
            + "ZG431SN\n"
            + "ZG5962J\n"
            + "ZG5962J\n"
            + "OS945CK\n"
            + "ZG206A\n"
            + "PU234Q\n"
            + "ZG431SN";

        String input3 = "4\n"
            + "ZG431SN\n"
            + "ZG5080K\n"
            + "ST123D\n"
            + "ZG206A\n"
            + "ZG206A\n"
            + "ZG431SN\n"
            + "ZG5080K\n"
            + "ST123D";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input3));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int carCount = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> carNumber = new HashMap<>();

        for (int i = 0; carCount > i; i++) {
            carNumber.put(bufferedReader.readLine(), i);
        }

        Integer[] order = new Integer[carCount];
        for (int i = 0; carCount > i; i++) {
            order[i] = carNumber.get(bufferedReader.readLine());
        }

        int count = 0;
        for (int i = 0; order.length - 1 > i; i++ ) {
            for (int j = i + 1; order.length > j; j++) {
                if (order[i] >  order[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
