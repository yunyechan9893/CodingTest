package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.TreeSet;

public class PersonInCompany2 {

    public static void main(String[] args) throws Exception {
        String input = "4\n"
            + "Baha enter\n"
            + "Askar enter\n"
            + "Baha leave\n"
            + "Artem enter";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int logCount = Integer.parseInt(bufferedReader.readLine());

        TreeSet<String> personLog = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < logCount; i++) {
            String[] personLogs = bufferedReader.readLine().split(" ");
            String person = personLogs[0];
            String checkOut = personLogs[1];

            if (checkOut.equals("enter")) {
                personLog.add(person);
            } else {
                personLog.remove(person);
            }
        }



        personLog.forEach(System.out::println);
    }
}

