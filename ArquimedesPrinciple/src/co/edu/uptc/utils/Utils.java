package co.edu.uptc.utils;

import static java.lang.Thread.sleep;

public class Utils {

    public static void sleepP(long miliSecond){
        try{
            sleep(miliSecond);
        }catch (InterruptedException e){
            System.out.println("Sleep: " + e);
        }

    }

}
