package Date_05_29.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CreditCalculator {

    private static final String PASS = "P";
    public static void main(String[] args) throws Exception {
        String input = "ObjectOrientedProgramming1 3.0 A+\n"
            + "IntroductiontoComputerEngineering 3.0 A+\n"
            + "ObjectOrientedProgramming2 3.0 A0\n"
            + "CreativeComputerEngineeringDesign 3.0 A+\n"
            + "AssemblyLanguage 3.0 A+\n"
            + "InternetProgramming 3.0 B0\n"
            + "ApplicationProgramminginJava 3.0 A0\n"
            + "SystemProgramming 3.0 B0\n"
            + "OperatingSystem 3.0 B0\n"
            + "WirelessCommunicationsandNetworking 3.0 C+\n"
            + "LogicCircuits 3.0 B0\n"
            + "DataStructure 4.0 A+\n"
            + "MicroprocessorApplication 3.0 B+\n"
            + "EmbeddedSoftware 3.0 C0\n"
            + "ComputerSecurity 3.0 D+\n"
            + "Database 3.0 C+\n"
            + "Algorithm 3.0 B0\n"
            + "CapstoneDesigninCSE 3.0 B+\n"
            + "CompilerDesign 3.0 D0\n"
            + "ProblemSolving 4.0 P";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Float totalScore = 0f;
        Float subjectScore = 0f;

        for (String line : bufferedReader.lines().collect(Collectors.toList())) {
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            stringTokenizer.nextToken();

            float cradit = Float.parseFloat(stringTokenizer.nextToken());
            String grade = stringTokenizer.nextToken();

            if (grade.equals(PASS)) {
                continue;
            }

            float gradeScore = convertToGrade(grade);

            totalScore += cradit;
            subjectScore += cradit*gradeScore;
        }

        System.out.println(subjectScore / totalScore);
    }

    private static float convertToGrade(String grade) {
        switch (grade) {
            case "A+" :
                return 4.5f;
            case "A0" :
                return 4.0f;
            case "B+" :
                return 3.5f;
            case "B0" :
                return 3.0f;
            case "C+" :
                return 2.5f;
            case "C0" :
                return 2.0f;
            case "D+" :
                return 1.5f;
            case "D0" :
                return 1.0f;
            default:
                return 0.0f;
        }
    }
}