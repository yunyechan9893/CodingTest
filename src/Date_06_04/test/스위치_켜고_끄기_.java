package Date_06_04.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 성별과 제공받은 숫자에 따라 스위치 온오프가 달라짐
 * 1 - N : 스위치 개수 (0 <= N <= 100)
 * 2 - M : 스위치의 각 상태 (ex) 1 0 1 0 ...)
 * 3 - S : 학생 수 (S <= 100)
 * 4 - MAN, C  : 남학생, 받은 수 (1 <= C <= N)
 * 5 - Girl, C : 여학생, 받은 수 (1 <= C <= N)
 *
 * 남학생 : 받은 수의 배수인 스위치 변경
 * 여학생 : 받은 수를 중심으로 좌우 대칭인 경우까지 찾아서 변경
 *
 * 스위치는 20개 단위로 한줄씩 출력
 *
 * 남학생의 배수 스위치 상태를 변경
 * 여학생의 좌우 대칭 확인과 동시에 숫자 변경
 * */
public class  스위치_켜고_끄기_ {
    private static int totalOperations;
    private static int totalSwitches;


    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] inputArray;

        totalSwitches = Integer.parseInt(bufferedReader.readLine());
        int[] switchStates = new int[totalSwitches + 1];
        inputArray = bufferedReader.readLine().split(" ");
        for (int i = 0; i < totalSwitches; i++) {
            switchStates[i + 1] = Integer.parseInt(inputArray[i]);
        }

        totalOperations = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < totalOperations; i++) {
            inputArray = bufferedReader.readLine().split(" ");
            int sex = Integer.parseInt(inputArray[0]);
            int switchNumber = Integer.parseInt(inputArray[1]);

            if (sex == 1) {
                toggleSwitchesByMale(switchStates, switchNumber);
            } else {
                toggleSwitchesByFemale(switchStates, switchNumber);
            }
        }

        for (int i = 1; i <= totalSwitches; i++) {
            output.append(switchStates[i]).append(" ");
            if (i % 20 == 0) {
                output.append("\n");
            }
        }

        System.out.println(output.toString().trim());
        bufferedReader.close();
    }

    private static void toggleSwitchesByMale(int[] switches, int switchNumber) {
        for (int i = switchNumber; i <= totalSwitches; i += switchNumber) {
            switches[i] = switches[i] == 0 ? 1 : 0;
        }
    }

    private static void toggleSwitchesByFemale(int[] switches, int switchNumber) {
        switches[switchNumber] = switches[switchNumber] == 0 ? 1 : 0;
        for (int i = 1; i < totalSwitches; i++) {
            if (switchNumber - i < 1 || switchNumber + i > totalSwitches) {
                break;
            }
            if (switches[switchNumber - i] == switches[switchNumber + i]) {
                switches[switchNumber - i] = switches[switchNumber - i] == 0 ? 1 : 0;
                switches[switchNumber + i] = switches[switchNumber + i] == 0 ? 1 : 0;;
            } else {
                break;
            }
        }
    }
}