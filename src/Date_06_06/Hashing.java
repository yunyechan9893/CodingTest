package Date_06_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Hashing {

    private static final int DECIMAL = 31;

    public static void main(String[] args) throws IOException {
        String input = "5\n"
            + "abcde";
        String input2 = "3\n"
            + "zzz";
        String input3 = "1\n"
            + "i";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));

        int L = Integer.parseInt(bufferedReader.readLine());

        BigInteger result = new BigInteger("0");

        String S = bufferedReader.readLine();
        for (int i = 0; L > i; i++) {
            result = result.add(BigInteger.valueOf(S.charAt(i) - 96).multiply(BigInteger.valueOf(DECIMAL).pow(i)));

        }

        System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
    }
}