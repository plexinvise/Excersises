package com.company;

/**
 * Created by plexinvise on 12/23/17.
 */
public class Reverse {

    public synchronized static String reverseEverything (String textToReverse) {
        StringBuilder result = new StringBuilder("");
        String[] splittedString = textToReverse.split("");
        int characters = splittedString.length-1;
        while (characters >= 0) {
            result.append(splittedString[characters]);
            characters--;
            }
        return result.toString();
        }

}
