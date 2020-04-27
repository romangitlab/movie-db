package helpers;

import static java.lang.Thread.sleep;

public class Helper {
    public static void sleepFor(int time){
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
