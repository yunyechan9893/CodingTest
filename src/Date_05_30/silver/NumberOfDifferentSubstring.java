package Date_05_30.silver;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

/*
* 5개
* 1 = 5
* 2 = 4
* 3 = 3
* 4 = 2
* 5 = 1
* cursor값, 몇개 뜯어야하는지, 값을 저장할 해쉬맵
*/

public class NumberOfDifferentSubstring {
    public static void main(String[] args) throws Exception {
        String input = "ababc";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String S = bufferedReader.readLine();
        int SLength = S.length();

        Set set = new HashSet();

        for (int cursorCount = 1; cursorCount <= SLength; cursorCount++) {
            for (int cursor = 0; cursor + cursorCount <= SLength; cursor++) {
                set.add(S.substring(cursor, cursor + cursorCount));
            }
        }

        System.out.println(set.size());
    }
}
