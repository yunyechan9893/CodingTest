package Date_06_03_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        String input = "1\n"
            + "15\n"
            + "OOIOIOIOIIOIIOI";

        String input2 = "2\n"
            + "13\n"
            + "OOIOIOIOIIOII";


        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        String IO = "IO";
        String I = "I";

        String IOI = IO.repeat(N) + I;

        int IOILength = IOI.length();

        int count = 0;
        int index = 0;
        boolean flag = false;
        int rollbackIndex = 0;
        while (M >= index + IOILength) {
            if (!flag && 'O' == S.charAt(index)){
                index++;
            } else if (!flag && 'I' == S.charAt(index)) {
                flag = true;
                index++;
            } else {
                System.out.println(index);
                if (IOILength == rollbackIndex + 1) {
                    count ++;
                    flag = false;
                    index -= rollbackIndex;
                    rollbackIndex = 0;
                } else if (S.charAt(index) == IOI.charAt(rollbackIndex + 1)) {
                    index++;
                    rollbackIndex ++;
                } else {
                    index -= rollbackIndex;
                    rollbackIndex = 0;
                }
            }
        }

        System.out.println(count);
    }
}
