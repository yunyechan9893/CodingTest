package Date_06_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hashing_제출용 {

    private static final int DECIMAL = 31;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(bufferedReader.readLine());

        BigInteger result = new BigInteger("0");

        String S = bufferedReader.readLine();
        for (int i = 0; L > i; i++) {
            result = result.add(BigInteger.valueOf(S.charAt(i) - 96).multiply(BigInteger.valueOf(DECIMAL).pow(i)));

        }

        System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
    }
}