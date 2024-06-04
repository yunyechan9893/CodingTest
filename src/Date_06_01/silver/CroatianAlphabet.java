package Date_06_01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/*
 *
 * 인풋값을 크로아티 알파벳 indexOf로 탐색
 * 발견 시 문자열 삭제
 * 크로아티 알파벳 제거한 문자열 length 개수 세기
 * */
public class CroatianAlphabet {

    public static void main(String[] args) throws IOException {
        String input = "ljes=njakjgwgjwpjgwrjgwjrogjrwo8gjwrgxdgsd";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] charictor = bufferedReader.readLine().split("");
        int count = 0;

        int i = 0;
        while (i < charictor.length) {
            if (charictor[i].equals("c") ) {
                if (charictor.length > i + 1 && charictor[i + 1].equals("=") || charictor[i + 1].equals("-")){
                    i += 2;
                    count++;
                    continue;
                }
            }

            if (charictor[i].equals("d")) {
                if (charictor.length > i + 2 && charictor[i + 1].equals("z") && charictor[i + 2].equals("=")) {
                    i += 3;
                    count++;
                    continue;
                } else if (charictor.length > i + 1 && charictor[i + 1].equals("-")) {
                    i += 2;
                    count++;
                    continue;
                }
            }

            if (charictor[i].equals("l")) {
                if (charictor.length > i + 1 && charictor[i + 1].equals("j")){
                    i += 2;
                    count++;
                    continue;
                }
            }

            if (charictor[i].equals("n")) {
                if (charictor.length > i + 1 && charictor[i + 1].equals("j")){
                    i += 2;
                    count++;
                    continue;
                }
            }

            if (charictor[i].equals("s")) {
                if (charictor.length > i + 1 && charictor[i + 1].equals("=")){
                    i += 2;
                    count++;
                    continue;
                }
            }

            if (charictor[i].equals("z")) {
                if (charictor.length > i + 1 && charictor[i + 1].equals("=")){
                    i += 2;
                    count++;
                    continue;
                }
            }

            i++;
            count++;
        }

        System.out.println(count);
    }
}
