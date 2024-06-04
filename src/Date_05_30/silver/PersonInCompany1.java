package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonInCompany1 {

    public static void main(String[] args) throws Exception {
        String input = "4\n"
            + "Baha enter\n"
            + "Askar enter\n"
            + "Baha leave\n"
            + "Artem enter";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        int logCount = Integer.parseInt(bufferedReader.readLine());

        Map<String, Boolean> personLog = new HashMap<>();

        for (int i = 0; i < logCount; i++) {
            String[] personLogs = bufferedReader.readLine().split(" ");
            String person = personLogs[0];

            if (personLog.get(person) != null) {
                personLog.remove(person);
                continue;
            }

            personLog.put(person, true);
        }

        List<String> personList = personLog.entrySet().stream()
            .map(entry -> entry.getKey()).collect(Collectors.toList());

        Collections.sort(
            personList
            , Collections.reverseOrder());

        personList.forEach(System.out::println);
    }
}

