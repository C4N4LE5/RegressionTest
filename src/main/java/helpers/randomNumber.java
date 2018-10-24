package helpers;

import java.util.Random;

/**
 * Created by kcwl112 on 19/06/2017.
 */
public class randomNumber {

    public static final String randomString = randomNumber.randomNumberReal();

    public randomNumber() {

    }

    public static String randomNumberReal() {
        Random random = new Random();

        int intRandom = random.nextInt(500);

        String numberToString = Integer.toString(intRandom);

        System.out.println("Numero Aleatorio: " + numberToString);

        return numberToString;
    }
}
