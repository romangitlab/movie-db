package helpers;

import java.util.Random;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class Helper {
    public static void sleepFor(int time){
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String randomData() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }

    public static Integer getRandomNumber(Integer number) {
        return new Random().nextInt(number);
    }
}
