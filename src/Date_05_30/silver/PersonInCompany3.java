package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PersonInCompany3 {

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
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String person = stringTokenizer.nextToken();
            String checkOut = stringTokenizer.nextToken();

            if (checkOut.equals("enter")) {
                personLog.add(person);
            } else {
                personLog.remove(person);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        personLog.forEach(s -> stringBuilder.append(s).append("\n"));

        System.out.println(stringBuilder);
    }
}

